package com.lec.ex6prepareStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(deptSql);
			System.out.print("검색할 부서명은?");
			String dname = scanner.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {// 부서가 있는 경우
				System.out.println("검색한 부서번호 : " + rs.getInt("deptno"));
				System.out.println("검색한 부서이름 : " + rs.getString("dname"));
				System.out.println("검색한 부서위치 : " + rs.getString("loc"));
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(empSql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if(rs.next()) {// 사원이 존재할 경우
					System.out.println("사번\t이름\t급여");
					do {
						int    empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int    sal   = rs.getInt("sal");
						System.out.println(empno + "\t" + ename + "\t" + sal);
					}while(rs.next());
				}else {// 사원이 없는 경우
					System.out.println(dname + " 부서 사원은 없습니다");
				}
			}else { // 부서가 없는 경우
				System.out.println(dname + "는 유효한 부서번호가 아닙니다");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 7. 연결해제
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}









