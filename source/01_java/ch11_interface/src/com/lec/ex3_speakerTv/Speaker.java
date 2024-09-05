package com.lec.ex3_speakerTv;

public class Speaker implements IVolume {
	private int volumeLevel;
	private final int MAX_VOLUME = 50;
	private final int MIN_VOLUME = 1;
	public Speaker() {
		volumeLevel = 3;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("스피커 볼륨을 1올려 현재 볼륨은 " + volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치("+MAX_VOLUME+")여서 올리지 못했습니다");
		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > MIN_VOLUME ) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1만큼 내려 현재 볼륨은 " + volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최소치(" + MAX_VOLUME +")여서 내리지 못했습니다");
		}
	}
}








