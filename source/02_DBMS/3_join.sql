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
    SELECT ENAME, SAL FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
    -- 탄탄EX2. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력
    SELECT ENAME, HIREDATE FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
    -- 탄탄EX3. 직급이 MANAGER인 사원의 이름, 부서명 출력
    SELECT ENAME, DNAME FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
    -- 탄탄EX4 COMM이 NULL이 아닌 사원의 이름, 급여, 부서번호, 근무지를 출력
    SELECT ENAME, SAL, E.DEPTNO, LOC FROM EMP E, DEPT D
        WHERE D.DEPTNO=E.DEPTNO AND COMM IS NOT NULL;
    -- EX. COMM이 NULL이고 SAL이 1200이상인 사원의 이름, 급여, 부서번호, 부서명
                         -- (부서명순, 급여큰순 정렬)
    SELECT ENAME, SAL, E.DEPTNO, DNAME FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200
        ORDER BY DNAME, SAL DESC;

-- ★ 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- 1행(직원정보)
SELECT * FROM SALGRADE; -- 5행(급여등급)
SELECT * FROM EMP, SALGRADE WHERE ENAME='SCOTT'; -- CROSS JOIN
SELECT * FROM EMP, SALGRADE 
    WHERE ENAME='SCOTT' AND SAL BETWEEN LOSAL AND HISAL;
SELECT * FROM EMP, SALGRADE
    WHERE ENAME='SCOTT' AND SAL>=LOSAL AND SAL<=HISAL;
    -- EX. 모든사원의 사번, 이름, 상사사번, 급여, 급여등급(1등급, 2등급...)
    SELECT EMPNO, ENAME, MGR, SAL, GRADE||'등급' GRADE
        FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL;
    -- 탄탄EX1. COMM이 NULL이 아닌 사원의 이름, 급여, 급여등급, 부서번호, 부서명, 근무지
    -- 탄탄EX2. 이름, 급여, 입사일, 급여등급(신입순)
    -- 탄탄EX3. 이름, 급여, 급여등급, 연봉, 부서명(부서명 정렬, 부서명 같으면 연봉순 정렬)
                                -- 연봉=(SAL+COMM)*12
    -- 탄탄EX4. 이름, 직책, 급여, 등급, 부서번호, 부서명(급여가 1000~3000사이. 
                                -- 정렬조건:부서번호순, 직책순, 급여큰순)
    -- 탄탄EX5. 이름, 급여, 등급, 입사일, 근무지(81년 입사한 직원만 등급 큰순)





