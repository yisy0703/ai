package com.lec.ex1_String;
import java.util.Scanner;
// quiz : 전화번호(02-7894-7897) 입력받아, 전번, 짝수번째문자, 꺼꾸로, 국번, 뒷4자리 출력(x를입력할때까지 반복적)
public class Ex04_tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("전화번호(ooo-oooo-oooo), 단 종료시 x : ");
			String tel = scanner.next(); // "010-1234-5678"
			if(tel.equalsIgnoreCase("x")) break; // 반복문 종료 조건
			// 전화번호 출력 (tel출력)
			System.out.println("전화번호 : " + tel);
			// 짝수번째 문자열 출력 (length(), charAt(), 일반 for문 이용)
			
			// 꺼꾸로 출력(length(), charAt(), 일반 for문 이용)
			
			// 앞자리 출력 (indexOf(), substring() 이용)
			
			// 뒷자리 출력 (lastIndexOf(), substring() 이용)
			
		}
	}
}
