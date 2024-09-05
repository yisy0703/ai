package com.lec.ex3_speakerTv;

public class Tv implements IVolume {
	private int volumeLevel;
	private final int MAX_VOLUME = 100;
	private final int MIN_VOLUME = 0;
	public Tv() {
		volumeLevel = 10;
	}
	@Override
	public void volumeUp() { // 볼륨을 5씩 up
		if(volumeLevel == MAX_VOLUME) {
			System.out.println("TV 볼륨이 최대치(" + MAX_VOLUME + ")이여서 못 올려요");
		}else if( (volumeLevel+5) <= MAX_VOLUME) {
			volumeLevel += 5;
			System.out.println("TV 볼륨을 5올려 현재 볼륨은 " + volumeLevel);
		}else {
			int temp = MAX_VOLUME - volumeLevel;
			volumeLevel = MAX_VOLUME;
			System.out.println("TV 볼륨을 "+ temp + "만큼 올려 최대치입니다");
		}
	}
	@Override
	public void volumeDown() { // 볼륨을 5씩 Down
		if(volumeLevel == MIN_VOLUME) {
			System.out.println("TV 볼륨이 최소치(" + MIN_VOLUME + ")이여서 못 올려요");
		}
		
	}//volumeDown
}//class








