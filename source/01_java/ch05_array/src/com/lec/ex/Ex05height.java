package com.lec.ex;
import java.util.Scanner;
// 길동, 현식, 땅땅, 슘당, 대갈 친구의 키를 입력받고, 평균, 최장신 친구의 이름과 키, 최단신 친구의 이름과 키
public class Ex05height {
	public static void main(String[] args) {
		String[] names = {"길동", "현식", "땅땅", "슘당", "대갈"};
		int[] heights = new int[names.length];
		Scanner scanner = new Scanner(System.in);
		int totHeight = 0; // 키 누적변수
		// 친구들 키 입력받아 heights배열에 할당, 키 누적
		for(int idx=0 ; idx<names.length ; idx++) {
			System.out.print(names[idx] + "의 키는 ? ");
			heights[idx] = scanner.nextInt();
			totHeight += heights[idx]; // 키 누적
		}//for
		
	}
}









