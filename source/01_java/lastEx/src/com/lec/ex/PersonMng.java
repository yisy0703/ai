package com.lec.ex;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.dao.PersonRepository;

public class PersonMng {
	public static void main(String[] args) {
		PersonRepository repository = PersonRepository.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn;
		ArrayList<String> jnames = repository.jnameList(); //직업 리스트
		do {
			System.out.print("1:입력 || 2:직업별출력 || 3:전체출력 || 그외:종료");
			fn = scanner.next();
			switch(fn) {
			case "1": // 이름, 직업명, 국, 영, 수 입력받아 insert
				System.out.print("입력할 이름은?");
				break;
			case "2":// 직업명 입력받아 해당 직업명인 사람 리스트 quiz와 같이 출력
				System.out.println("출력할 직업" + jnames);
				break;
			case "3":// 등록된 모든 person의 리스트 quiz와 같이 출력
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
