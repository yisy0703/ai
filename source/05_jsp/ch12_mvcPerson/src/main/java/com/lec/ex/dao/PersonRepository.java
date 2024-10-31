package com.lec.ex.dao;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
	//1. LIST (PAGING없이)public ArrayList<Person> getPersonList()
	//1. LIST (PAGING추가) : public ArrayList<Person> getPersonList(int startRow, int endRow)
	//2. getCount (PAGING처리시 필요한 전체 갯수) : public int getCount()
	//3. 추가 : public int insertPerson(Person person)
	//4. 한명출력 : public Person getPerson(int id)
	//5. 수정 : public int updatePerson(Person person)
	//6. 삭제 : public int deletePerson(int id)
}













