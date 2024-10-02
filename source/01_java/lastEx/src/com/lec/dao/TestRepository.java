package com.lec.dao;

public class TestRepository {
	public static void main(String[] args) {
		PersonRepository repository = PersonRepository.getInstance();
		int result = repository.insertPerson("신길동", "가수", 70, 80, 90);
		System.out.println();
	}
}
