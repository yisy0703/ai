package com.lec.ex;
// x부터 y까지 정수 합과 그 결과가 짝/홀수인지 출력
public class Ex02_method {
	private static int sum(int from, int to) {
		return 100;
	}
	
	public static void main(String[] args) {
		int tot = sum(1, 10); 
		System.out.println("1부터 10까지 정수의 합은 " + tot);
		System.out.println(tot%2==0 ? "짝수입니다":"홀수입니다");
		//------ 주 ---------- 석 -------------------
		tot = sum(10, 100);
		System.out.println("10부터 100까지 정수의 합은 " + tot);
		System.out.println(tot%2==0 ? "짝수입니다":"홀수입니다");
		//------ 주 ---------- 석 -------------------
		tot = sum(5, 10);
		System.out.println("5부터 10까지 정수의 합은 " + tot);
	}
}
