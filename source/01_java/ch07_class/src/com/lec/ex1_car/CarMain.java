package com.lec.ex1_car;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		//myPorsche.color="빨강";
		myPorsche.setColor("빨강");
		//myPorsche.cc = 2400;
		myPorsche.setCc(2400);
		System.out.println(myPorsche.getColor() + "색차량 배기량은 " + 
				myPorsche.getCc() + ", 속도는 " + myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getColor() + "색차량 배기량은 " + 
				myPorsche.getCc() + ", 속도는 " + myPorsche.getSpeed());
		Car yourPorsche = new Car();
		//yourPorsche.color = "gray";
		yourPorsche.setColor("gray");
		yourPorsche.drive();
		System.out.println(myPorsche.getColor() + "색차량 배기량은 " + 
				myPorsche.getCc() + ", 속도는 " + myPorsche.getSpeed());
		System.out.println(yourPorsche.getColor() + "색차량 배기량은 " + 
				yourPorsche.getCc() + ", 속도는 " + yourPorsche.getSpeed());
	}
}








