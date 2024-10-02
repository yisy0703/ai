-- DEPT DAO에 들어갈 QUERY
-- (1) 부서 정보들 가져오는 함수 : getDeptList
SELECT * FROM DEPT;
-- (2) deptno로 부서정보 가져오는 함수 : getDept(10)
SELECT * FROM DEPT WHERE DEPTNO=10;
-- (3) dname으로 부서정보 가져오는 함수 : getDept("sales")
SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('sales');
-- (4) insertDept
INSERT INTO DEPT VALUES (70, UPPER('cS'), UPPER('SILIM'));
-- (5) updateDept
UPDATE DEPT 
  SET DNAME=UPPER('marketing'),
      LOC = UPPER('kyungju')
  WHERE DEPTNO=60;
-- (6) deleteDept
DELETE FROM DEPT WHERE DEPTNO=70;
ROLLBACK;

-- EMP DAO에 들어갈 QUERY
-- (1) 사원정보들 가져오는 함수 : getEmpList()
SELECT * FROM EMP;
-- (2) 부서번호로 사원정보 가져오는 함수 : getEmpList(10)
SELECT * FROM EMP WHERE DEPTNO=10;
-- (3) 부서명으로 사원정보 가져오는 함수 : getEmpList("sales")
SELECT E.* 
  FROM EMP E, DEPT D 
  WHERE E.DEPTNO=D.DEPTNO AND UPPER(DNAME)=UPPER('SALES');







