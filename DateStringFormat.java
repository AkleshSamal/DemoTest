package com.selenium.codp.utilities;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormatSymbols;

public class DateStringFormat {

	public static String sqlToAppDateFormat(String dateString) {

		String[] s = dateString.split(",");
		String s1 = s[0];
		String s2 = s[1];
		String s4 = s2.trim();
		// split
		String[] s3 = s1.split(" ");
		char s5 = s4.charAt(2);
		char s6 = s4.charAt(3);

		String sd = s3[1] + "/" + s3[0] + "/" + s5 + s6;
		System.out.println(sd);
		return sd;
	}

	public static String AppDateToSqlFormat(String dateString) throws Exception {

		// String appDate = "Jun 25, 2010";
		String pattern = "dd/MM/yyyy";
		String sMonth;
		String sDate;
		Date date = new SimpleDateFormat(pattern).parse(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// calendar.set(2010, 05, 20, 00, 00, 00);
		int iYear = calendar.get(Calendar.YEAR);
		int iMonth = calendar.get(Calendar.MONTH);
		int iDate = calendar.get(Calendar.DATE);

		// idate add 0
		if (iDate <= 9) {
			sDate = "0" + iDate;
		} else {
			sDate = "" + iDate;
		}

		// Month
		iMonth = iMonth + 1;
		if (iMonth <= 9) {
			sMonth = "0" + iMonth;
		} else {
			sMonth = "" + iMonth;
		}

		String sYear = "" + iYear;
		// String iMonthword = new SimpleDateFormat("MMM").format(date);
		String datefinal = sYear + "-" + sDate + "-" + sMonth + " "
				+ "00:00:00";
		System.out.println(datefinal);
		return datefinal;
	}

	public static String AppDateToSqlFormatTransaction(String dateString)
			throws Exception {

		// String appDate = "Jun 25, 2010";
		String pattern = "MMM dd, yyyy";
		String sMonth;
		String sDate;
		Date date = new SimpleDateFormat(pattern).parse(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// calendar.set(2010, 05, 20, 00, 00, 00);
		int iYear = calendar.get(Calendar.YEAR);
		int iMonth = calendar.get(Calendar.MONTH);
		int iDate = calendar.get(Calendar.DATE);
		// /format
		// String wMonth = new SimpleDateFormat("MMM").format(iMonth);
		// idate add 0
		if (iDate <= 9) {
			sDate = "0" + iDate;
		} else {
			sDate = "" + iDate;
		}

		// Month
		iMonth = iMonth + 1;
		if (iMonth <= 9) {
			sMonth = "0" + iMonth;
		} else {
			sMonth = "" + iMonth;
		}

		String sYear = "" + iYear;
		String fyear = sYear.replace('2', ' ').replace('0', ' ');

		

		String monthString = new DateFormatSymbols().getMonths()[iMonth - 1];

		// convert into
		String wMonth = monthString.replace('h', ' ').replace('c', ' ').trim().toUpperCase();
		String datefinal = sDate + "/" + wMonth + "/" + fyear.trim();
		return datefinal;
	}
	
	
	public static String depositAppDateToSqlFormat(String dateString) throws Exception {

		// String appDate = "Jun 25, 2010";
		String pattern = "dd/MM/yyyy";
		
		String sDate;
		String sMonth;
		Date date = new SimpleDateFormat(pattern).parse(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// calendar.set(2010, 05, 20, 00, 00, 00);
		int iYear = calendar.get(Calendar.YEAR);
		int iMonth = calendar.get(Calendar.MONTH);
		int iDate = calendar.get(Calendar.DATE);

		// idate add 0
		if (iDate <= 9) {
			sDate = "0" + iDate;
		} else {
			sDate = "" + iDate;
		}

		// Month
		iMonth = iMonth + 1;
		if (iMonth <= 9) {
			sMonth = "0" + iMonth;
		} else {
			sMonth = "" + iMonth;
		}

		String sYear = "" + iYear;
		// String iMonthword = new SimpleDateFormat("MMM").format(date);
		String datefinal = sYear + "-" + sMonth + "-" + sDate + " "
				+ "00:00:00";
		return datefinal;
	}
	
	

}
