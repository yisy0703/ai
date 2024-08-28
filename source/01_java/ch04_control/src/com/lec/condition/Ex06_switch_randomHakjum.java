package com.lec.condition;
// 실행할 때마나 컴퓨터가 난수(random) 점수를 발생하여 학점 출력
public class Ex06_switch_randomHakjum {
	public static void main(String[] args) {
		// 0 <= Math.random() < 1 : 실수 난수
		// 0 <= Math.random()*51 < 51 : 실수 난수
		// 50<= Math.random()*51 + 50 < 101 : 실수
		// 50<= (int)(Math.random()*51 + 50) < 101 : 정수 (50~100)		
		// 0 <= Math.random()*101 < 101 : 실수 난수
		// 0 <= (int)(Math.random()*101) <101 : 정수 난수(0~100)
		// 0 <= Math.random()*45 < 45 : 실수
		// 1 <= (int)(Math.random()*45+1) < 46 : 정수
		System.out.println( (int)(Math.random()*101) );
	}
}
