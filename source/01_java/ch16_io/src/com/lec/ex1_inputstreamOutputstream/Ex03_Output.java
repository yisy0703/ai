package com.lec.ex1_inputstreamOutputstream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 파일 열기(스트림객체생성) -> 쓰기 -> 파일 닫기(스트림객체close)
public class Ex03_Output {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			// 1. 파일 열기
			os = new FileOutputStream("txtFile/outTest.txt"); // 있는 파일은 덮어쓰고, 없는 파일은 생성
			// byte[] bs = {'H', 'e', 'l','l','o',',', ' '};
			String msg = "Hello, World\nHi, AI\n";
			byte[] bs = msg.getBytes(); // 스트링을 byte배열로
			// 2. 데이터 쓰기
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (IOException e) {
			System.out.println("폴더가 없을 때 : "+e.getMessage());
		} finally {
			try { // 3. 파일 닫기
				if(os!=null) os.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}//try-catch-finally
	}//main
}//class







