package com.lec.ex6_final;
public class Animal {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("동물이 뛰고 있어요. 현재 속도 : " + speed);
	}
}
