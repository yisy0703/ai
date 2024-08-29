package com.lec.loop;
// 1~10까지 숫자 중 3의 배수의 합을 출력
public class Ex09while {
	public static void main(String[] args) {
		int tot = 0; // 누적변수
		int i = 1;
		while(i <= 10) {
			if(i%3 == 0) { // 3의 배수일 때만 누적 (방법1)
				tot += i;
			} // if
			i++;
		} // while
		System.out.println("1~10까지 3의 배수의 합은 "+tot);
	} // main
}
