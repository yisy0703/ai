package com.lec.ex6prepareStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
// com.lec.ex2selectWhere.Ex2_selectWhere + Ex3_selectWhereDname 같은 기능
// 부서명을 입력 받아 해당 부서정보를 출력하고, 해당부서 사원(사번, 이름, 급여. 급여순)을 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String deptSql = "SELECT * FROM DEPT WHERE DNAME=UPPER(?)";
		String empSql = "SELECT EMPNO, ENAME, SAL "
				+ "  FROM EMP E, DEPT D"
				+ "  WHERE E.DEPTNO=D.DEPTNO "
				+ "    AND DNAME = UPPER(?)"
				+ "  ORDER BY SAL";
	}
}









