-- [VI] Sub Query : 메인 query(SQL문) 안에 내포된 QUERY
-- ★ 1.서브쿼리 개념과 종류
SELECT MAX(SAL) FROM EMP; 
SELECT * FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP); -- VI. 서브쿼리
-- 서브쿼리 종류(1) 단일행 서브쿼리:서브쿼리 결과가 단일행 : =, >, >=, <, <=, !=
    -- ex. SCOTT고 동일한 부서번호에서 근무하는 사원의 이름과 급여
    SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 서브쿼리가 될 SQL문
    SELECT ENAME, SAL 
        FROM EMP
        WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');
-- 서브쿼리 종류(2) 다중행 서브쿼리 : 서브쿼리 결과가 2행이상 : IN, >ALL, ANY(SOME), EXISTS
    -- EX. SCOTT이나 KING과 동일한 부서번호에서 근무하는 사원의 정보
    SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT' OR ENAME='KING';
    SELECT DEPTNO FROM EMP WHERE ENAME IN ('SCOTT','KING'); -- 서브쿼리가 될 SQL문
    SELECT * FROM EMP
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT' OR ENAME='KING');
-- ★ 2. 단일행 서브쿼리 
    -- DEPT에 50번부서(DALLAS) INSERT, EMP에 50번근무 직원 INSERT
    INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
    SELECT * FROM DEPT;
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (1000, '홍길동', 50);
    SELECT * FROM EMP;
    -- EX1. SCOTT과 동일한 근무지에서 근무하는 사원의 정보
    SELECT LOC FROM DEPT D, EMP E
        WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT'; -- 서브쿼리
    SELECT E.* FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
            AND LOC=(SELECT LOC FROM DEPT D, EMP E
                        WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT')
            AND ENAME <> 'SCOTT';
    ROLLBACK;
    -- EX2. 최초입사일과 최초입사한 사람 이름
    SELECT MIN(HIREDATE) FROM EMP; -- 단일행 서브쿼리
    SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); -- 메인쿼리
    -- EX3. 최근입사일과 최근입사한 사람 이름
    SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    -- EX4. 최초입사일, 최초입사자이름, 최근입사일, 최근입사자이름
    SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME
        FROM EMP E1, EMP E2
        WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND
              E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    SELECT
        (SELECT MIN(HIREDATE) FROM EMP) FIRSTDAY,
        (SELECT ENAME FROM EMP 
                    WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP)) FIRSTMAN,
        (SELECT MAX(HIREDATE) FROM EMP) LASTDAY,
        (SELECT ENAME FROM EMP
                    WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP)) LASTMAN
    FROM DUAL;
    -- EX5. SCOTT과 같은 부서에 근무하는 사람들의 급여합 
    SELECT SUM(SAL) FROM EMP   
        WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');
    -- EX6. DALLAS에 근무하는 사원의 이름과 부서번호(서브쿼리, JOIN)
    SELECT ENAME, DEPTNO FROM EMP
        WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); -- 서브쿼리 이용
    SELECT ENAME, E.DEPTNO FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';-- EQUI JOIN 이용
    -- EX7. 'KING'이 직속상사인 사원의 이름과 급여(서브쿼리, JOIN)
    SELECT ENAME, SAL FROM EMP 
        WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING'); -- 서브쿼리 이용
    SELECT W.ENAME, W.SAL
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO AND M.ENAME='KING'; -- SELF JOIN 이용
    -- EX8. 평균급여 이하로 받는 사원의 이름, 급여를 출력   
    SELECT AVG(SAL) FROM EMP; -- 서브쿼리
    SELECT ENAME, SAL FROM EMP 
        WHERE SAL<=(SELECT AVG(SAL) FROM EMP); -- 메인쿼리
    -- EX9. 평균급여 이하로 받는 사원의 이름, 급여, 급여평균를 출력     
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) AVGSAL
        FROM EMP 
        WHERE SAL<=(SELECT AVG(SAL) FROM EMP); -- 메인쿼리    
    -- EX10. 사원이름, 급여, 평균급여와의 차이
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL) "DIFF"
        FROM EMP;
    -- 단일행 다중열 서브쿼리
    -- EX. SCOTT과 JOB도 같고, 부서번호도 같은 직원의 모든 필드 출력
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 서브쿼리
    SELECT * FROM EMP
        WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT');
        
-- ★ 총 연습문제 (1~13번 : 단일행서브쿼리)
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여

    
-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드

    
--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명

--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급

--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬

--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여

--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일

--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여

--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여

--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여

--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자

--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)

-- 23. 부서 평균 월급보다 월급이 높은 사원을 사번, 이름, 급여, 부서번호

-- 24. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여




