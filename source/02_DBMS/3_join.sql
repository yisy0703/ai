-- [III] JOIN : 2개이상의 테이블을 연결하여 데이터를 검색하는 방법

SELECT * FROM EMP WHERE ENAME='SMITH'; -- 1행
SELECT * FROM DEPT; -- 4행
SELECT * FROM EMP, DEPT WHERE ENAME='SMITH'; -- CROSS JOIN : 4행(1*4)

-- ★ 1. EQUI JOIN(공통필드값이 일치되는 조건만 JOIN)


