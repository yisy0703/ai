package com.lec.ex1_inputstreamOutputstream;
import java.io.FileOutputStream;
import java.io.OutputStream;
// 파일 열기(스트림객체생성) -> 쓰기 -> 파일 닫기(스트림객체close)
public class Ex03_Output {
	public static void main(String[] args) {
		OutputStream os = null;
		os = new FileOutputStream("txtFile/outTest.txt");
	}
}
