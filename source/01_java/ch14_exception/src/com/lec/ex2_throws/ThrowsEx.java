package com.lec.ex2_throws;
public class ThrowsEx {
	public ThrowsEx() {
		actionB();
	}
	private void actionB() {
		System.out.println("actionB 전반부");
		actionA();
		System.out.println("actionB 후반부");
	}
	private void actionA() {
		System.out.println("actionA 전반부");
		int[] arr = {0, 1, 3};
		System.out.println(arr[3]);
		System.out.println("actionA 후반후");
	}
}
