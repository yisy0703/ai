package com.lec.ex4_actor;
// new Actor("박보검")
public class Actor implements IPoliceMan, IFireFighter, IChef{
	private String name;
	public Actor(String name) {
		this.name = name;
	}
	@Override
	public void makePizza() {
		System.out.println(name + "은 요리사입니다. 파자를 굽습니다");
	}
	@Override
	public void makeSpaghetti() {
		System.out.println(name + "은 요리사입니다. 스파게티를 만듭니다");
	}
	@Override
	public void outFire() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveMan() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void canCatchCriminal() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void canSearch() {
		// TODO Auto-generated method stub
		
	}
}
