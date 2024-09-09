package com.lec.quiz;
// new Sawon("24a001","홍길동",Sawon.COMPUTER, 2024, 9, 9)
//new Sawon("24a001","홍길동",Sawon.COMPUTER)
import java.util.Date;
public class Sawon {
	public static final String COMPUTER = "전산실";
	public static final String PLANNING = "기획팀";
	public static final String DESIGN   = "설계팀";
	private String no;   // 사번
	private String name; // 사원명
	private String dept; // 부서명
	private Date hiredate; // 입사일
	public Sawon(String no, String name, String dept) {
		this.no = no;
		this.name = name;
		this.dept = dept;
	}
	
}
