package com.lec.ex7_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍길동", "010-9999-9999", "서울", "01-01");
		customer.buy(500000);
		System.out.println("----------------");
		customer.buy(500000);
	}
}
