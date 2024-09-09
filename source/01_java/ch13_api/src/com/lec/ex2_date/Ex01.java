package com.lec.ex2_date;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Ex01 {
	public static void main(String[] args) {
		Date nowDate    = new Date();  // 현 시점
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar();
		System.out.println(nowDate);
		System.out.println(nowCal);
		System.out.println(nowGc);
	}
}
