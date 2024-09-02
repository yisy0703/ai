package com.lec.ex1_car;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		//myPorsche.color="빨강";
		myPorsche.setColor("빨강");
		//myPorsche.cc = 2400;
		myPorsche.setCc(2400);
		System.out.println(myPorsche.color + "색차량 배기량은 " + 
				myPorsche.cc + ", 속도는 " + myPorsche.speed);
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.color + "색차량 배기량은 " + 
				myPorsche.cc + ", 속도는 " + myPorsche.speed);
		Car yourPorsche = new Car();
		//yourPorsche.color = "gray";
		yourPorsche.setColor("gray");
		yourPorsche.drive();
		System.out.println(myPorsche.color + "색차량 배기량은 " + 
				myPorsche.cc + ", 속도는 " + myPorsche.speed);
		System.out.println(yourPorsche.color + "색차량 배기량은 " + 
				yourPorsche.cc + ", 속도는 " + yourPorsche.speed);
	}
}








