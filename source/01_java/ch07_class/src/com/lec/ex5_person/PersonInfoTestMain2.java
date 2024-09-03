package com.lec.ex5_person;

public class PersonInfoTestMain2 {
	public static void main(String[] args) {
		int i = 10;
		int[] scores = {i,100,95};
		PersonInfo[] person = {new PersonInfo("홍길동", 33, 'm'), new PersonInfo("홍길순", 32, 'f', "2001-12-01")};
		for(int idx=0 ; idx<person.length ; idx++) {
			// person[idx].print();
			System.out.println(person[idx].infoString());
		}
		for(PersonInfo p : person) {
			System.out.println(p.infoString());
		}
	}
}
