package com.lec.ex3_exceptions;
// 데이터 : 이름,전화번호,생년월일(Date) 
// Friend f = new Friend("홍길동", "010-9999-9999", new Date(98, 8, 10))
// sysout(f) => [이름]홍길* [전화]***-****-9999 [생일]9월10일 ♬ 생일축하 ♬
import java.util.Date;
public class Friend {
	private String name;
	private String tel;
	private Date birthday;
	public Friend(String name) {
		this.name = name;
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birthday) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}
	@Override
	public String toString() {//[이름]홍길* [전화]***-****-9999 [생일]9월10일 ♬ 생일축하 ♬
		String result = "";
		String nameOut = name.substring(0, name.length()-1) + "*";
		result += "[이름]" + nameOut;
		return result;
	}
}











