package com.lec.ex5_person;
// 데이터 : name, age, gender, birth(String=>13장 수업후에는 Date형)
// 생성자 : new PersonInfo("홍길동", 22, '남', "2001-12-01"), new PersonInfo("홍길동", 22, '남') - 오버로딩
// 메소드 : print()
public class PersonInfo {
	private String 	name;
	private int		age;
	private char	gender; // 한문자
	private String	birth;
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age  = age;
		this.gender = gender;
	}
	public PersonInfo(String name, int age, char gender, String birth) {
		this.name = name;
		this.age  = age;
		this.gender = gender;
		this.birth = birth;
	}
	public void print() { // 객체 정보 출력
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("생년월일 : " + birth);
	}
	public String infoString() { // 객체 정보를 스트링으로 바꿔서 return
		return    "이름 : " + name +
				"\n나이 : " + age + 
				"\n성별 : " + gender + 
				"\n생년월일 : " + birth;
	}
}
