-- [V] 그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)
SELECT MAX(SAL) FROM EMP; 
SELECT ENAME, SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP); -- VI. 서브쿼리

-- ★ 1. 그룹함수들 실습
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
-- 모든 그룹함수는 NULL값을 제외하고 계산됨
SELECT AVG(COMM), SUM(COMM), COUNT(COMM) FROM EMP;
SELECT COUNT(*) FROM EMP; -- 테이블의 행수
    -- EX. SAL의 평균, 합, 최소값, 최대값, 분산, 표준편차, 갯수
            -- (평균, 분산, 표준편차는 소수점 한자리에서 반올림)
SELECT ROUND(AVG(SAL),1), SUM(SAL), MIN(SAL), MAX(SAL), 
        ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL), 1), COUNT(SAL)
    FROM EMP;
    -- EX. 그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두 가능
    SELECT 
        MIN(HIREDATE) "최초입사일", MAX(HIREDATE) "최근입사일",
        MIN(ENAME), COUNT(JOB)
        FROM EMP;
    -- 탄탄EX1. 입사한지 가장 오래된 사원의 입사일과 가장 최근에 입사일을 출력
    SELECT MIN(HIREDATE) FIRST, MAX(HIREDATE) LAST FROM EMP;
    -- 탄탄EX2. 결과)FIRST                LAST
    --              80/12/17:18,123일째  83/01/12:16,123일째
    -- 탄탄EX3. 결과) 80년12월17일최초입사:18,123일째  83년01년12일최근입사:16,123일째
    -- 탄탄EX4. 10번부서 소속의 사원 중에 COMM을 받는 사원의 수(COUNT함수 사용)
    









