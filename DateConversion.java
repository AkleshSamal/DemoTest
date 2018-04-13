package com.selenium.codp.utilities;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConversion {
	
	//week To Yesterday
	public  static String weekToYesterday() throws ParseException{
		Date currentDate=getCurrectDayDate();
		
		DateFormat df = new SimpleDateFormat("MM/dd/yy");
		Date fromDate=getLastWeekStartDate(currentDate);
		getWeekStartDate(currentDate);
		
		Date toDate=getYesterdayEndDate();
		System.out.println(toDate);
		
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
    System.out.println(fromDate);
    String WeekToYesterdayDate = df.format(fromDate);
    System.out.println(WeekToYesterdayDate);
    
    String finaldate=WeekToYesterdayDate+","+ToDate;
    System.out.println("Week To yesterday Date:"+finaldate);
    
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

	 public static Date getYesterdayEndDate() throws ParseException {
		 
		 Date date=getCurrectDayDate();
         Calendar cal = Calendar.getInstance();
         cal.setTime(date);
         cal.add(Calendar.SECOND, -1);
         return cal.getTime();
  }
public static Date getCurrectDayDate() throws ParseException{
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    //get current date time with Date()
   // Date date = new Date();
    Calendar cal=Calendar.getInstance();
    
    //cal.add(Calendar.DATE,-1);
    String today=cal.getTime().toString();
   // String today =dateFormat.format(date);
    System.out.println(today);
    
    String date=dateFormat.format(cal.getTime());
    Date currentDate = dateFormat.parse(date);
    
    
    
    //System.out.println(dateFormat.format(date));
	return currentDate;
}

//previous week

public static String previousWeek() throws ParseException{
	
	
	Date currentDate=getCurrectDayDate();
	
	DateFormat df = new SimpleDateFormat("MM/dd/yy");
	
	Calendar curDt = Calendar.getInstance();
    curDt.setTime(currentDate);
    Date fromDate = getLastWeekStartDate(getLastWeekStartDate(currentDate));
    Date toDate = getLastWeekEndDate(getLastWeekStartDate(currentDate));
    int curDay = curDt.get(Calendar.DAY_OF_WEEK);
    if(curDay == Calendar.SUNDAY){
          fromDate = getLastWeekStartDate(getLastWeekStartDate(currentDate));
         String PreviousStart=df.format(fromDate);
         System.out.println(PreviousStart);
          toDate = getLastWeekEndDate(getLastWeekStartDate(currentDate));
         String previousEnd=df.format(toDate);
         
         String previousWeek=PreviousStart+","+previousEnd;
         System.out.println(previousWeek);
    }
    else{
          fromDate = getLastWeekStartDate(currentDate);
          String PreviousStart=df.format(fromDate);
          System.out.println(PreviousStart);
          
          toDate = getLastWeekEndDate(currentDate);
          String previousEnd=df.format(toDate);
          System.out.println(previousEnd);
          String previousWeek=PreviousStart+","+previousEnd;
          System.out.println(previousWeek);
    }
       
    
    String PreviousStart=df.format(fromDate);
    System.out.println(PreviousStart);
    
    
    String previousEnd=df.format(toDate);
    System.out.println(previousEnd);
    String previousWeek=PreviousStart+","+previousEnd;
    System.out.println("previous Week date :"+previousWeek);
	
	
	return previousWeek;
	
}

private static Date getLastWeekEndDate(Date currentDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(currentDate);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    cal.add(Calendar.SECOND, -1);
    return cal.getTime();
}
public static String monthToYesterday() throws ParseException{
	
	
Date currentDate=getCurrectDayDate();
	
	DateFormat df = new SimpleDateFormat("MM/dd/yy");
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
    System.out.println(fromdate);
    
    String todate=df.format(toDate);
    System.out.println(todate);
    
    String monthToYesterday=fromdate+","+todate;
    System.out.println("month to yesterday date :"+monthToYesterday);
   
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
