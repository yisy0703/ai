package strategy1.step2;

public class Robot {
	public void shape() {
		String className = getClass().getName(); // 클래스이름 "strategy1.step2.SuperRobot"
		System.out.println(className + "의 외형은 팔, 다리, 머리, 몸통이 있습니다 = = =");
	}
	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}
}
