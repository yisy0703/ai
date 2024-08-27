package com.lec.ex;
// 산술연산자 : + - * / %(나머지연산자) 
// 산술연산시 : 4byte짜리와 4byte짜리간의 산술연산 결과는 4byte
//           8byte짜리와 4byte짜리간의 산술연산 결과는 8byte
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result;
		double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 / n2;
		resultDouble = (double)n1 / n2; // 8byte값/4byte값 => 8byte
		System.out.printf("%d %c %d = %d(정수결과)\n", n1, '/', n2, result);
		System.out.printf("%d %c %d = %.1f(실수결과)\n", n1, '/', n2, resultDouble);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
	}
}





