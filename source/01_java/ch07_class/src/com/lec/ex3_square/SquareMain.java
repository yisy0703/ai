package com.lec.ex3_square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		System.out.println("s1의 한변은 " + s1.getSide());
		s1.setSide(5);
		System.out.println("수정된 s1의 넓이는 " + s1.area());
		System.out.println("----------------------------");
		Square s2 = new Square(10);
		System.out.println("s2의 한변은 " + s2.getSide());
		System.out.println("s2의 넓이는 " + s2.area());
	}
}
