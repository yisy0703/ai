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
    SELECT
        MIN(HIREDATE)||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999'))
                    ||'일째'  "FIRST",
        MAX(HIREDATE)||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999'))
                    ||'일째' "LAST"
      FROM EMP;
    -- 탄탄EX3. 결과) 80년12월17일최초입사:18,123일째  83년01년12일최근입사:16,123일째
    SELECT
        TO_CHAR(MIN(HIREDATE), 'RR"년"MM"월"DD"일최초입사"')
        ||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999'))
                    ||'일째'  "FIRST",
        TO_CHAR(MAX(HIREDATE), 'RR"년"MM"월"DD"일최근입사"')
        ||':'||TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999'))
                    ||'일째' "LAST"
      FROM EMP;
    -- 탄탄EX4. 10번부서 소속의 사원 중에 COMM을 받는 사원의 수(COUNT함수 사용)
    SELECT COUNT(*) FROM EMP WHERE DEPTNO=10 AND COMM>0; -- 추천
    SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10; -- COMM이 0인 행을 포함

-- ★ 2. GROUP BY 절 : 그룹함수를 쓰되, 어떤 컬럼 기준으로 그룹함수를 적용
    -- EX. 부서번호별 최대급여, 급여평균, 급여표준편차 (부서번호순 정렬)
    SELECT DEPTNO NO, MAX(SAL), AVG(SAL), STDDEV(SAL) 
        FROM EMP 
        GROUP BY DEPTNO -- GROUP BY 절은 필드의 별칭 사용 불가
        ORDER BY NO;    -- ORDER BY 절은 필드의 별칭 사용 가능
    -- 부서명별 최대급여, 평균급여 (평균급여순 정렬)
    SELECT DNAME, MAX(SAL), AVG(SAL) AVGSAL
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
        GROUP BY DNAME
        ORDER BY AVG(SAL);
        -- ORDER BY AVGSAL;
    -- SAL이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여
        -- (부서번호 순 정렬)
    SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)
        FROM EMP 
        WHERE SAL<5000
        GROUP BY DEPTNO
        ORDER BY DEPTNO;

-- ★ 3. HAVING 절 : 그룹함수의 결과를 제한할 때
    -- (필드의 조건을 사용하여 제한할 때는 WHERE절)
    -- EX.SAL이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여
        -- (급여평균이 1800이상만 출력하되 평균급여순 정렬)
    SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL) AVGSAL
        FROM EMP 
        WHERE SAL<5000         
        GROUP BY DEPTNO        -- GROUP BY 절에 필드 별칭 사용 불가
        HAVING AVG(SAL)>=1800  -- HAVING절에 필드 별칭 사용 불가
        ORDER BY AVGSAL;





