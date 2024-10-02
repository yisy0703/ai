package com.lec.dao;

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
	
	// (2) deptno로 부서정보 가져오는 함수 : getDept(10)
	
	// (3) dname으로 부서정보 가져오는 함수 : getDept("sales")
	
	// (4) insertDept
	
	// (5) updateDept
	
	// (6) deleteDept
}










