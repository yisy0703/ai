package strategy1.step4.modularization;
import strategy1.step4.interfaces.*;
public class LowRobot extends Robot{
	private FlyImpl     fly;
	private MissileImpl missile;
	private KnifeImpl   knife;
	public LowRobot() {
		//setI(10);                   i = 10;
		setFly(new FlyNo());        //fly = new FlyNo();
		setMissile(new MissileNo());//missile = new MissileNo();
		setKnife(new KnifeNo());    //knife   = new KnifeNo();
	}
	@Override
	public void actionFly()   {fly.fly();}
	@Override
	public void actionMssile(){missile.missile();}
	@Override
	public void actionKnife() {knife.knife();}
	public void setFly(FlyImpl fly) {this.fly = fly;}
	public void setMissile(MissileImpl missile) {this.missile = missile;}
	public void setKnife(KnifeImpl knife) {this.knife = knife;}
}






