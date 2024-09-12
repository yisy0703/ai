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










