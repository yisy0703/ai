package com.lec.ex1_car;
// 클래스 : 속성(데이터=인스턴스변수)과 메소드
// Car myCar = new Car();
// myCar.method명()
public class Car {
	String color; 
	int    cc; // 배기량 1500 2000
	int    speed;
	public void park() {
		speed = 0;
		System.out.println(color + "색 주차함. 지금 속도 : " + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "색 차 드라이브 함. 지금 속도 : " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "색 차 레이싱 중. 지금 속도 : " + speed);
	}
}
