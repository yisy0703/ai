package com.lec.ex.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.Person;
public class PersonRepository {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private DataSource ds;
	private static PersonRepository INSTANCE = new PersonRepository();
	public static PersonRepository getInstance() {
		return INSTANCE;
	}
	private PersonRepository() { // 커넥션 풀에 있는 DataSource 가져오기(ds)
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
//	private Connection getConnection() throws SQLException {
//		Connection conn = null;
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
//			conn = ds.getConnection();
//		} catch (NamingException e) {
//			System.out.println(e.getMessage());
//		}
//		return conn;
//	}
	//1. LIST (PAGING없이)
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> dtos = new ArrayList<Person>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM PERSON";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				int id    	   = rs.getInt("id");
				String name    = rs.getString("name");
				String tel     = rs.getString("tel");
				String address = rs.getString("address");
				Date birth     = rs.getDate("birth");
				String memo    = rs.getString("memo");
				Timestamp rdate= rs.getTimestamp("rdate");
				dtos.add(new Person(id, name, tel, address, birth, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(rs, pstmt, conn);
		}
		return dtos;
	}
	//1. LIST (PAGING추가) 
	public ArrayList<Person> getPersonList(int startRow, int endRow){
		ArrayList<Person> dtos = new ArrayList<Person>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				int id    	   = rs.getInt("id");
				String name    = rs.getString("name");
				String tel     = rs.getString("tel");
				String address = rs.getString("address");
				Date birth     = rs.getDate("birth");
				String memo    = rs.getString("memo");
				Timestamp rdate= rs.getTimestamp("rdate");
				dtos.add(new Person(id, name, tel, address, birth, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(rs, pstmt, conn);
		}
		return dtos;
	}
	//2. getCount (PAGING처리시 필요한 전체 갯수) : public int getCount()
	//3. 추가 : public int insertPerson(Person person)
	//4. 한명출력 : public Person getPerson(int id)
	//5. 수정 : public int updatePerson(Person person)
	//6. 삭제 : public int deletePerson(int id)
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}













