package com.lec.ex5_super;
public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("아빠곰");
		papa.setCharacter("뚱뚱해");
		papa.intro();
		Person mom = new Person("엄마곰", "날씬해");
		mom.intro();
		Baby baby1 = new Baby();
		Baby baby2 = new Baby("아기곰", "귀여워");
	}
}
