-- [II] SELECT 문 - 조회

-- 1. SELECT 문장 작성법 (실행 : CTRL+ENTER / 블록잡고F9)
SHOW USER;
SELECT * FROM TAB; -- 현 계정이 갖고 있는 테이블들
SELECT * FROM EMP; -- EMP테이블의 모든 열(필드), 모든 행
SELECT * FROM DEPT; -- DEPT테이블의 모든 열, 모든 행
SELECT * FROM SALGRADE;
-- 날짜 표기법 셋팅(RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

-- 2. 특정 열만 출력
DESC EMP;
    -- EMP 테이블 구조
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- EMP테이블의 EMPNO, ENAME, SAL, JOB 필드만 모든 행
SELECT EMPNO, ENAME, COMM FROM EMP;
SELECT EMPNO AS "사 번", ENAME AS "이름", SAL AS "급여" FROM EMP; -- 필드명에 별칭을 사용
SELECT EMPNO "사 번", ENAME "이름", SAL  "급여" FROM EMP; -- 별칭에 as 생략 가능
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP; -- 별칭에 SPACE가 없는 경우 " 생략가능
SELECT EMPNO "NO", ENAME "NAME", SAL "SALARY" FROM EMP;

-- 3. 특정 행 출력 : WHERE 절(조건절) -- 비교연산자 : 같다(=), 다르다(!=, ^= <> ), < <= > >=
SELECT EMPNO 사번, ENAME 이름, SAL 급여 FROM EMP WHERE SAL=3000;
SELECT * FROM EMP WHERE SAL<>3000;
SELECT * FROM EMP WHERE SAL!=3000;
SELECT * FROM EMP WHERE SAL^=3000;
    -- 비교연산자는 숫자, 문자, 날짜형 모두 가능
    -- 'A' < 'AA' < 'AAA' < 'AAAA' < 'AAAB' <'B'<'a'
    -- EX1. 사원이름이 'A','B','C'로 시작하는 사원의 모든 필드
    SELECT * FROM EMP WHERE ENAME < 'D';
    -- EX2. 81년도 이전에 입사한 사원의 모든 필드
    SELECT * FROM EMP WHERE HIREDATE < '81/01/01' ;
    ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
    
-- 4. 조건절에 논리연산자 : AND, OR, NOT
    -- EX1. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드
    SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000; -- 2000 <= SAL <=3000
    
    -- EX2. 82년도에 입사한 사원의 모든 필드(82/01/01이상, 82/12/31이하)
    SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
    
    -- EX3. 연봉(SAL*12)이 2400이상인 직원의 ENAME, SAL, 연봉(ANNUALSAL)을 출력
    SELECT ENAME, SAL, SAL*12 "연봉" -- (3)
        FROM EMP             -- (1)
        WHERE SAL*12>=2400   -- (2)
        ORDER BY SAL*12;     -- (4)
    SELECT ENAME, SAL, SAL*12 "연봉" -- (3)
        FROM EMP             -- (1)
        WHERE SAL*12>=2400   -- (2)WHERE 절에는 필드의 별칭 사용 불가
        ORDER BY 연봉;     -- (4)ORDER BY절에는 필드의 별칭 사용 가능
    -- EX4. 10번부서(DEPTNO)이거나 JOB이 MANAGER인 직원의 모든 필드
    SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
    -- EX5. 10번 부서가 아닌 직원의 모든 필드
    SELECT * FROM EMP WHERE DEPTNO != 10;
    SELECT * FROM EMP WHERE NOT DEPTNO=10;

-- 5. 산술연산자(SELECT절, WHERE절, ORDER BY절)
SELECT EMPNO, ENAME, SAL, SAL*1.1 UPGRADESAL FROM EMP;
    -- EX. 모든 사원의 ENAME, SAL(급여), COMM(상여), 연봉(SAL*12 + COMM)을 출력
    SELECT ENAME, SAL, COMM, SAL*12+COMM 연봉 FROM EMP; -- 산술연산결과는 NULL을 포함하면 결과도 NULL
    -- NVL(널일수도있는값, 널이면대체할값) : 널일수도있는값과 널이면대체할값의 타입이 일치
    SELECT ENAME, SAL, NVL(COMM,0), SAL*12+NVL(COMM, 0) ANNUALSAL FROM EMP;
    -- MGR일 널이면 'CEO'라고 출력
    SELECT EMPNO, ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;

-- 6. 연결연산자(||)








