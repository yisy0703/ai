package com.lec.ex4update;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		System.out.print("수정할 부서번호는 >");
		int deptno = scanner.nextInt();
		// 부서번호 존재 여부 confirm
		String confirmSql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
	}
}







