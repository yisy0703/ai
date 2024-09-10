package com.lec.ex1_trycatch;
import java.util.InputMismatchException;
import java.util.Scanner;
// 첫번째 정수를 제대로 입력할 때까지 입력받음, 두번째 정수를 제대로 입력하지 않으면 1로 처리하여 수행하도록
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int i=0, j=1;
		try {
			System.out.print("첫번째 정수는 ");
			i = scanner.nextInt(); // InputMismatchException
			System.out.print("두번째 정수는 ");
			j = scanner.nextInt(); // InputMismatchException
			System.out.println("i/j = " + (i/j));//ArithmeticException
		}catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("i*j = " + (i*j));
		System.out.println("i+j = " + (i+j));
		System.out.println("i-j = " + (i-j));
		scanner.close();
	}
}