-- [III] JOIN : 2개이상의 테이블을 연결하여 데이터를 검색하는 방법

SELECT * FROM EMP WHERE ENAME='SMITH'; -- 1행
SELECT * FROM DEPT; -- 4행
SELECT * FROM EMP, DEPT WHERE ENAME='SMITH'; -- CROSS JOIN : 4행(1*4)

-- ★ 1. EQUI JOIN(동등조인 = 공통필드값이 일치되는 조건만 JOIN)
SELECT * FROM EMP, DEPT WHERE ENAME='SMITH' AND EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT * 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- EX. 모든 사원의 사번, 이름, 직책, 상사사번, 부서번호, 부서이름, 근무지
    SELECT EMPNO, ENAME, JOB, MGR, E.DEPTNO, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO;
    -- EX. 급여가 2000이상인 직원에 대해, 이름, 직책, 급여, 부서명, 근무지
    SELECT ENAME, JOB, SAL, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;
    -- EX. 20번 부서 직원의 이름, 부서번호, 근무지 
    SELECT ENAME, D.DEPTNO, LOC FROM EMP E, DEPT D 
        WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO=20;
    -- EX. LOC이 CHICAGO인 사람의 이름, 업무, 급여, 부서번호
    SELECT ENAME, JOB, SAL, E.DEPTNO FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
    -- EX. 82년도 입사한 10번, 20번 부서 직원의 이름, 급여, 근무지 출력(급여순)
    SELECT ENAME, SAL, LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
            AND HIREDATE BETWEEN '82/01/01' AND '82/12/31'
            AND E.DEPTNO IN (10,20)
        ORDER BY SAL;
    SELECT ENAME, SAL, LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
            AND HIREDATE LIKE '82/__/__'
            AND E.DEPTNO IN (10,20)
        ORDER BY SAL;
    -- 탄탄EX1. NEW YORK에서 근무하는 사원의 이름과 급여를 출력
    -- 탄탄EX2. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력
    -- 탄탄EX3. 직급이 MANAGER인 사원의 이름, 부서명 출력
    -- 탄탄EX4 COMM이 NULL이 아닌 사원의 이름, 급여, 부서번호, 근무지를 출력
        




