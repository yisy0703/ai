-- DAO에 쓸 QUERY
-- 1번기능과 2번 기능에서 입력가능한 직업명들
SELECT JNAME FROM JOB;
-- 1번 기능 : PNAME, JNAME, KOR, ENG, MAT를 입력받아 PERSON 테이블 INSERT
INSERT INTO PERSON
  VALUES (PERSON_PNO_SQ.NEXTVAL, 
-- 2번 기능 : JNAME을 입력받아 RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
              -- RANK는 SUM 내림차순으로 순위를 정합니다(hint. rownum과 inline이용)
              
-- 3번 기능 : RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력