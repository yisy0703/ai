package com.lec.dao;

public class EmpRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";
	private static EmpRepository INSTANCE = new EmpRepository();
	public static EmpRepository getInstance() {
		return INSTANCE;
	}
	private EmpRepository() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// SELECT * FROM EMP 수행결과 return
	// 부서번호로 검색해서 empList return
	// 이름으로 검색해서 empList return
}













