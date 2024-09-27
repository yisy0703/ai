-- [X] VIEW, IN-LINE VIEW, ★TOP-N★
-- 1. VIEW : 가상의 테이블 (1)단순뷰 (2)복합뷰
-- (1)단순뷰 : 하나의 테이블을 이용해서 만든 뷰(가상의 테이블은 물리공간과 데이터가 따로 없음)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP;
SELECT * FROM EMPv0;














