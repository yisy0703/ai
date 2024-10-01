package com.lec.ex2selectWhere;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
// 부서이름을 입력받아 해당 부서 정보 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 부서명은 ?");
		String dname = scanner.next();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
	}
}




