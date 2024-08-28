package com.lec.conditionQuiz;
import java.util.Scanner;
// 사용자에게 가위(0),바위(1),보(2) 입력받는다 
//    1. 0~2사이의 수를 입력 안 한 경우 : 프로그램 강제 종료
//    2. 0~2사이의 수를 입력 한 경우 (if, switch, 삼항연산자)
//          (1)컴퓨터가 0~2사의 난수를 발생
//          (2)당신과 컴퓨터가 낸 가위바위보 출력 (ex. 당신 가위, 컴퓨터는 바위)
//          (3)가위바위보 결과 출력(ex 당신이 졌습니다 ㅠ.ㅠ)
public class Quiz4_srp_com {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) 입력 : ");
		int you = sc.nextInt();
		System.out.println(you);
	}
}


















