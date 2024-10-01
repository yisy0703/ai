package com.lec.ex6prepareStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Ex1_InsertDept {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		//Statement  stmt = null;
		PreparedStatement pstmt = null;		
		System.out.print("입력할 부서번호는 >");
		int deptno = scanner.nextInt();
		System.out.print("입력할 부서명은 >");
		String dname = scanner.next();
		System.out.print("입력할 부서위치는 >");
		String loc = scanner.next();
		String sql = "INSERT INTO DEPT VALUES (?, UPPER(?), UPPER(?))";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // 첫번째 물음표는 int값 deptno로 채움
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "입력성공":"입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 7. 연결해제
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}















