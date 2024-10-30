package com.lec.ch12.dao;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class MemberRepository {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private DataSource  ds;
	// 싱글톤 코드
	private static MemberRepository INSTANCE;
	public static MemberRepository getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new MemberRepository();
		}
		return INSTANCE;
	}
	private MemberRepository() { // 생성자함수에서 ds에 커넥션 풀을 가르키도록
		try {
			Context ctx = new InitialContext();
			ds = ctx.lookup("java:comp/env/) 
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
}






