package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절대값 : " + Arithmetic.abs(-9));
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(100);
		System.out.println("합은 " + tot);
		System.out.println(ar.evenOdd(tot));
	}
}
