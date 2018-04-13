package com.selenium.codp.utilities;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	private static String date;
	private static Calendar cal;
	private static DateFormat dateFormat;
	private static String mnthlastdate;
	private static String mnthFdate;
	private static Date fromDate;
	private static Date toDate;
	
	
	public String getToday(){
		dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		cal = Calendar.getInstance();
		date = dateFormat.format(cal.getTime()).toUpperCase();
		return date;
		
	}
	public String getCurrentdate(){
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		cal = Calendar.getInstance();
		date = dateFormat.format(cal.getTime()).toUpperCase();
		return date;
		
	}
	public String getYesterday(){
		 dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		 cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		int day=cal.get(Calendar.DAY_OF_WEEK);
		if(day==1){
			cal.add(Calendar.DATE, -1);
			//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
			date = dateFormat.format(cal.getTime()).toUpperCase();
			//System.out.println(date);
			
		}
		else{
			//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
			date = dateFormat.format(cal.getTime()).toUpperCase();			
		}
		return date;
		
	}
	public String getPreviousMnth(){
		date=getToday();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.DATE, -day);
		mnthlastdate=dateFormat.format(cal.getTime()).toUpperCase();	
		//System.out.println("mnthlastdate: "+mnthlastdate);
		int ldate=cal.get(Calendar.DAY_OF_MONTH);
		ldate=ldate-1;
		//System.out.println(ldate);
		cal.add(Calendar.DATE,-ldate);
		mnthFdate=dateFormat.format(cal.getTime()).toUpperCase();	
		//System.out.println("mnthFdate: "+mnthFdate);
		String pm=mnthFdate+","+mnthlastdate;
		//System.out.println(pm);
		
		return pm;
		
	}
	
	
	//week To Yesterday
		public String weekToYesterday() throws Exception  {
			Date currentDate=getCurrectDayDate();
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			Date fromDate=getLastWeekStartDate(currentDate);
			getWeekStartDate(currentDate);
			
			Date toDate=getYesterdayEndDate();
			//System.out.println(toDate);
			
		Calendar currDateCal = Calendar.getInstance();
	    currDateCal.setTime(currentDate);
	    
	    int currDay = currDateCal.get(Calendar.DAY_OF_WEEK);
	    if(currDay == Calendar.SUNDAY || currDay == Calendar.MONDAY ){
	          fromDate = getLastWeekStartDate(currentDate);
	    }else {
	          fromDate = getWeekStartDate(currentDate);
	    }                          
	    toDate = getYesterdayEndDate();
	    String ToDate=df.format(toDate);
	   // System.out.println(fromDate);
	    String WeekToYesterdayDate = df.format(fromDate);
	    //System.out.println(WeekToYesterdayDate);
	    
	    String finaldate=WeekToYesterdayDate+","+ToDate;
	   // System.out.println("Week To yesterday Date:"+finaldate);
	    
		return finaldate;

		}

		
		 private static Date getLastMonthStartDate(Date currentDate) {
	         Calendar cal = Calendar.getInstance();
	         cal.setTime(currentDate);
	         cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
	         cal.add(Calendar.MONTH, -1);
	         return cal.getTime();
	  }

		 public static Date getWeekStartDate(Date currentDate) {
	         Calendar cal = Calendar.getInstance();
	         cal.setTime(currentDate);
	         cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	         return cal.getTime();
	  }
		 
		 private static Date getLastWeekStartDate(Date currentDate) {
	         Calendar cal = Calendar.getInstance();
	         cal.setTime(currentDate);
	         cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	         cal.add(Calendar.DATE, -7);
	         return cal.getTime();
	  }

		 public static Date getYesterdayEndDate() throws Exception   {
			 
			 Date date=getCurrectDayDate();
	         Calendar cal = Calendar.getInstance();
	         cal.setTime(date);
	         cal.add(Calendar.SECOND, -1);
	         return cal.getTime();
	  }
	public static Date getCurrectDayDate() throws Exception  {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    //get current date time with Date()
	   // Date date = new Date();
	    Calendar cal=Calendar.getInstance();
	    
	    //cal.add(Calendar.DATE,-1);
	    String today=cal.getTime().toString();
	   // String today =dateFormat.format(date);
	    //System.out.println(today);
	    
	    String date=dateFormat.format(cal.getTime());
	    Date currentDate = dateFormat.parse(date);
	    
	    
	    
	    //System.out.println(dateFormat.format(date));
		return currentDate;
	}

	//previous week

	public String previousWeek() throws Exception{
		
		
		Date currentDate=getCurrectDayDate();
		
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		
		Calendar curDt = Calendar.getInstance();
	    curDt.setTime(currentDate);
	    Date fromDate = getLastWeekStartDate(getLastWeekStartDate(currentDate));
	    Date toDate = getLastWeekEndDate(getLastWeekStartDate(currentDate));
	    int curDay = curDt.get(Calendar.DAY_OF_WEEK);
	    if(curDay == Calendar.SUNDAY){
	          fromDate = getLastWeekStartDate(getLastWeekStartDate(currentDate));
	         String PreviousStart=df.format(fromDate);
	        // System.out.println(PreviousStart);
	          toDate = getLastWeekEndDate(getLastWeekStartDate(currentDate));
	         String previousEnd=df.format(toDate);
	         
	         String previousWeek=PreviousStart+","+previousEnd;
	         //System.out.println(previousWeek);
	    }
	    else{
	          fromDate = getLastWeekStartDate(currentDate);
	          String PreviousStart=df.format(fromDate);
	          //System.out.println(PreviousStart);
	          
	          toDate = getLastWeekEndDate(currentDate);
	          String previousEnd=df.format(toDate);
	          //System.out.println(previousEnd);
	          String previousWeek=PreviousStart+","+previousEnd;
	          //System.out.println(previousWeek);
	    }
	       
	    
	    String PreviousStart=df.format(fromDate);
	   // System.out.println(PreviousStart);
	    
	    
	    String previousEnd=df.format(toDate);
	  //  System.out.println(previousEnd);
	    String previousWeek=PreviousStart+","+previousEnd;
	   // System.out.println("previous Week date :"+previousWeek);
		
		
		return previousWeek;
		
	}

	private static Date getLastWeekEndDate(Date currentDate) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(currentDate);
	    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    cal.add(Calendar.SECOND, -1);
	    return cal.getTime();
	}
	public String monthToYesterday() throws Exception {
				
	Date currentDate=getCurrectDayDate();
		
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		Date fromDate = getLastMonthStartDate(currentDate);
		getCurrentMonthStartDate(currentDate);
		Date toDate = getYesterdayEndDate();
		
		
		Calendar curDtCl = Calendar.getInstance();
	    curDtCl.setTime(currentDate);
	    if(curDtCl.get(Calendar.DAY_OF_MONTH) == curDtCl.getActualMinimum(Calendar.DAY_OF_MONTH)){
	          fromDate = getLastMonthStartDate(currentDate);
	    }else{
	    	fromDate = getCurrentMonthStartDate(currentDate);
	    }
	    toDate = getYesterdayEndDate();
	   
	    String fromdate=df.format(fromDate);
	   // System.out.println(fromdate);
	    
	    String todate=df.format(toDate);
	   // System.out.println(todate);
	    
	    String monthToYesterday=fromdate+","+todate;
	   // System.out.println("month to yesterday date :"+monthToYesterday);
	   
	return monthToYesterday;


	}
	private static Date getCurrentMonthStartDate(Date currentDate) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(currentDate);
	    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
	    return cal.getTime();
	}

	public static Date getLastMonthEndDate(Date currentDate){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(currentDate);
		return currentDate;
		
	}

	}

