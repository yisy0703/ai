package com.lec.ex5_final;

import constant.Constant;
// final 변수 : 수정 불가
public class FinalTestMain {
	public static void main(String[] args) {
		// final double PI = 3.141592;
		double r = 3;
		r = 5;
		double area = r* r * Constant.PI;
		System.out.println(area);
	}
}
