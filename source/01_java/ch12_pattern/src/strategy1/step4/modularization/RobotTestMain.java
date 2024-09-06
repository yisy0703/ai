package strategy1.step4.modularization;
public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot    superRobot    = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot      lowRobot      = new LowRobot();
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMssile();
			robot.actionKnife();
		}//for
		System.out.println("SuperRobot의 나는 부품을 높~~~~~~~이 나는 기능으로 업그레드");
	}//main
}//class






