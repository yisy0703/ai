package com.lec.dao;
public class DeptRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";	
	private static DeptRepository INSTANCE;
	public static DeptRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DeptRepository();
		}
		return INSTANCE;
	}	
	private DeptRepository() {}
	//SELECT DEPTNO, DNAME FROM DEPT 실행결과 return 함수
}















