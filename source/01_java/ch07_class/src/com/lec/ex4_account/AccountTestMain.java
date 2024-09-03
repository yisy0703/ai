package com.lec.ex4_account;
public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("100-1", "홍길동");
		hong.deposite(100);
		hong.withdraw(150);
		hong.infoPrint();
		System.out.println(hong.infoString());
	}
}
