package com.lec.ex3_static;
// Child child1 = new Child("첫째");
// child1.takeMoney(3000);
public class Child {
	private String name;
	static Mom mom = new Mom();
	public Child(String name) {
		this.name = name;
	}
	public static void method() {
		System.out.println("method");
	}
	public void takeMoney(int money) {
		if(mom.money >= money) {
			mom.money -= money; //mom.money = mom.money - money;
			System.out.println(name + "가 " + money + "원 가져가서 엄마 지갑엔 " + mom.money);
		}else {
			System.out.println(name + "가 돈 못 받음. 현재 엄마 지갑엔 " + mom.money);
		}
	}
}









