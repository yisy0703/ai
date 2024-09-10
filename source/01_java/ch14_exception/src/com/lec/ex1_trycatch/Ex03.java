package com.lec.ex1_trycatch;
import java.util.Scanner;
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 정수는 ");
		int i=0, j=1;
		try {
			i = scanner.nextInt(); // InputMismatchException
			System.out.print("두번째 정수는 ");
			j = scanner.nextInt(); // InputMismatchException
			System.out.println("i/j = " + (i/j));//ArithmeticException
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("i*j = " + (i*j));
		System.out.println("i+j = " + (i+j));
		System.out.println("i-j = " + (i-j));
		scanner.close();
	}
}