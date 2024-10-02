package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Dept;

public class DeptRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL    = 0;
	private static DeptRepository INSTANCE = new DeptRepository();
	public static DeptRepository getInstance() {
		return INSTANCE;
	}
	private DeptRepository() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// (1) 부서 정보들 가져오는 함수 : getDeptList
	public ArrayList<Dept> getDeptList(){
		ArrayList<Dept> dtos = new ArrayList<Dept>();
		// SQL수행한 결과를 dtos에 추가하기
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				int   deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc   = rs.getString("loc");
				dtos.add(new Dept(deptno, dname, loc));
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
			}//close
		}//try-catch-finally
		return dtos;
	}
	// (2) deptno로 부서정보 가져오는 함수 : getDept(99)
	public Dept getDept(int deptno) {
		Dept dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc   = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
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
			}//close()
		}//try-catch-finally
		return dto;
	}
	// (3) dname으로 부서정보 가져오는 함수 : getDept("sales")
	public Dept getDept(String dname) {
		Dept dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER(?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}//close()
		}//try-catch-finally
		return dto;
	}
	// (4) insertDept
	
	// (5) updateDept
	
	// (6) deleteDept
}










