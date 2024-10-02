package com.lec.dao;
import java.util.ArrayList;

import com.lec.dto.Person;
// 내가 만든 DAO 메소드들에 오류가 있는지 테스트 해 봄
public class TestRepository {
	public static void main(String[] args) {
		PersonRepository repository = PersonRepository.getInstance();
		int result = repository.insertPerson("신길동", "가수", 70, 80, 90);
		System.out.println(result==PersonRepository.SUCCESS? "성공":"실패");
		System.out.println("2.");
		ArrayList<Person> person = repository.getPerson("배우");
		for(Person p : person) {
			System.out.println(p);
		}
		System.out.println("3.");
		person = repository.getPerson();
		for(Person p : person) {
			System.out.println(p);
		}
		System.out.println("jnames");
		ArrayList<String> jnames = repository.jnameList();
			System.out.println(jnames);
	}
}
