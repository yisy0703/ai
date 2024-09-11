package com.lec.ex1_inputstreamOutputstream;
import java.io.*;
// (1)파일을 연다(스트림객체생성) (2)데이터를읽는다(read메소드사용) (3)파일을 닫는다(close메소드사용)
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");//1.파일열기
			// 2. 데이터읽는다(1byte씩 파일 끝까지)
			while(true) {
				int i = is.read(); // 1byte 씩 읽는다
				if(i == -1) break; // 파일의 끝이면 break;
				System.out.print((char)i);
			}
			System.out.println("끝");
		} catch (FileNotFoundException e) {
			System.out.println("예외메세지 : 파일 못 찾음. "+e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // 3. 파일 닫는다
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
