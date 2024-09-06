package strategy2.modularization;
import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;
public class Genesis extends Car {
	public Genesis() {
		// engine, km, fuel setting
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("★ 제네시스 차량은 문, 시트, 핸들로 이루어져 있습니다");
	}
}
