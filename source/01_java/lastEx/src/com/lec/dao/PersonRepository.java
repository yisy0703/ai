package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	public final static int SUCCESS = 1; 
	public final static int FAIL    = 0;
	private static PersonRepository INSTANCE = new PersonRepository();
	public static PersonRepository getInstance() {
		return INSTANCE;
	}
	private PersonRepository() {}
	// 1번기능과 2번 기능에서 입력가능한 직업명들
	public ArrayList<String> jnameList(){
		ArrayList<String> jnames = new ArrayList<String>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames;
	}
	//1번 기능 : PNAME, JNAME, KOR, ENG, MAT를 입력받아 PERSON 테이블 INSERT
	
}
