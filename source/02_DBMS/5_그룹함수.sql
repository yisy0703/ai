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
    





