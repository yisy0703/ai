package com.lec.ex3_exceptions;
import java.util.Date;
public class Ex02_FriendMain {
	public static void main(String[] args) {
		Friend friend1 = new Friend("황보길동","010-9999-9999", new Date(98, 8, 10));
		System.out.println(friend1);
	}
}
