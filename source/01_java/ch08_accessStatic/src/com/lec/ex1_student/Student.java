package com.lec.ex1_student;
// 데이터 : name(String), kor(int), eng(int), mat(int), tot(int), avg(double)
// 생성자 : new Student("정우성", 90,90,90)
// 메소드 : infoPrint(), infoString()
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	public Student() {} // 디폴트 생성자
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.0;
//		avg = (double)tot/3;
	}
	public void infoPrint() {
		
	}
}










