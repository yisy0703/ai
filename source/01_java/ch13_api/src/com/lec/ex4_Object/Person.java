package com.lec.ex4_Object;
// Person p1 = new Person(9812121021452L)
// Person p2 = new Person(9812121021452L)
// p1.equals(p2) => true
// sysout(p1) => 주민번호는 9812121021452입니다
public class Person{
	private long juminNo; //9812121021452L
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민번호는 " +juminNo;
	}
	
}
