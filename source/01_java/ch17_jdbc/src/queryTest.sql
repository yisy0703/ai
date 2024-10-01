-- ★ ★ ★ com.lec.ex1selectAll ★ ★ ★
SELECT * FROM EMP;
  
-- ★ ★ ★ com.lec.ex2selectWhere ★ ★ ★
-- Ex1. 부서번호를 받아 부서정보를 출력
SELECT * FROM DEPT WHERE DEPTNO=10;
INSERT INTO DEPT VALUES (50, 'IT', '서울');
SELECT * FROM DEPT;
COMMIT;
-- EX2. 부서번호 입력 받아 부서 정보와 사원 정보 출력
SELECT * FROM DEPT WHERE DEPTNO=10;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
  FROM EMP W, EMP M
  WHERE W.MGR=M.EMPNO AND W.DEPTNO=10;
















