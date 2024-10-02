package com.lec.dao;
public class EmpRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id  = "scott";
	private String pw  = "tiger";
	private static EmpRepository INSTANCE;
	public static EmpRepository getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new EmpRepository();
		}
		return INSTANCE;
	}
	private EmpRepository() {}
}
