package com.lec.ex1_list;
// Friend f = new Friend("홍길동","010-7897-7897");
// sysout(f)
public class Friend {
	private String name;
	private String tel;
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", tel=" + tel + "]";
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
}
