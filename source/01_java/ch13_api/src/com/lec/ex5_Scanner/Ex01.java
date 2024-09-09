package com.lec.ex5_Scanner;
import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이 : " + age);
		System.out.print("이름 : ");
		String name = scanner.next(); // white space(space, tab, \n)앞까지만 return하고 나머지는 버퍼에
		System.out.println("입력한 이름 : " + name);
	}
}
