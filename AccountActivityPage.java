package com.anz.selenium.comcards.PageObjects;



import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;










import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.anz.selenium.utilities.DateConversion;
import com.anz.selenium.utilities.WebTableReport;

public class AccountActivityPage {
	
	@FindBy(css="div.slick-viewport")
	private WebElement webTable;
	
	@FindBy(css="div#btr-acct-activity-view-controllist-section.control-list span.btn a")
	private WebElement groupAccountActivity;
	
	@FindBy(css="span.btn a.search-control-btn")
	private WebElement findAccount;
	
	@FindBy(css="span.search-field input.search-input")
	private WebElement searchAccount;
	
	@FindBy(xpath ="//a[@title='Request Account Statement']")
	private WebElement requestAccountStatement;
	
	@FindBy(xpath ="//*[@id='btr-acct-activity-view-controllist-section']/span[6]/span/a")
	private WebElement findfield;
	@FindBy(xpath="//*[@id='btr-acct-activity-view-controllist-section']/span[6]/input")
	private WebElement searchField;
	
	@FindBy(id="baicode")
	private WebElement biaCode;
	@FindBy(id="bankref")
	private WebElement bankreference;
	@FindBy(id="cramount")
	private WebElement creditAmount;
	@FindBy(id="custref")
	private WebElement customerreference;
	@FindBy(id="dramount")
	private WebElement debitAmount;
	@FindBy(id="txnnarration")
	private WebElement narrative;
	@FindBy(id="runbal")
	private WebElement runningBalance;
	@FindBy(id="swiftcode")
	private WebElement swiftCode;
	@FindBy(id="txntype")
	private WebElement tranType;
	@FindBy(xpath="//*[@id='btr-acct-activity-view-controllist-section']/span[2]/a")
	private WebElement groupAccount;
	@FindBy(id="$OFF$")
	private WebElement Off;
	@FindBy(id="postdate")
	private WebElement postDate;
	@FindBy(id="valuedate")
	private WebElement valueDate;
	@FindBy(id="$COLL$")
	private WebElement collapseAll;
	@FindBy(id="$EXP$")
	private WebElement expandAll;
	@FindBy(id="$DEF$")
	private WebElement collapseBydefault;
	
	@FindBy(id="div#accountActivityPanel.scroll-area")
	private WebElement panelArea;
	
	@FindBy(css="div#acctDetailData-section.static-content-area div div.static-content-area div.data-section div")
	private WebElement balanceAreaAccountActivity;
	
	@FindBy(css="div#btr-nostro-acct-activity-view-controllist-section.control-list span.btn a")
	private WebElement fromDate;
	
	@FindBy(xpath="//span[contains(@class,'btn has-menu show-selection')]")
	private WebElement fromdateOA;
	
	@FindBy(css="div#btr-acct-activity-view-controllist-section.control-list span.btn a")
	private WebElement fromdateOAp;
	
	@FindBy(css="div#btr-nostro-acct-activity-view-controllist-section.control-list span.btn a")
	private WebElement nostroFromDate;
	
	@FindBy(css="div#btr-acct-history-view-controllist-section.control-list span.btn a span")
	private WebElement fromDateBalanceSummary;
	@FindBy(css="div#btr-nostro-acct-history-view-controllist-section.control-list span.btn a")
	private WebElement fromDateNostroBalanceSummary;
	
	@FindBy(css="div#btr-nostro-acct-activity-view-controllist-section.control-list span.btn a")
	private WebElement nostroAccountActivityDateRange;
	
	
	@FindBy(css="div.top-controls div#btr-nostro-acct-activity-view-controllist-section.control-list span.btn a")
	private WebElement nostroAccountActivityDate;
	
	
	@FindBy(css="div#btr-nostro-acct-history-view-controllist-section.control-list span.btn a")
	private WebElement nostroBalanceSummaryDate;
	
	
	
	@FindBy(id="accountActivityPanel")
	private WebElement activityScreen;
	
	@FindBy(id="nostroAccountActivityPanel")
	private WebElement nostroEmptyScreen;
	
	@FindBy(id="nostroBalanceHistoryPanel")
	private WebElement nostroBalanceEmptyScreen;
	
	@FindBy(id="balanceHistoryPanel")
	private WebElement balanceScreen;
	
	@FindBy(xpath="div[contains(@class,'control-list')]")
	private WebElement getCheckBoxCount;
	
	@FindBy(xpath="//*[@id='btr-acct-activity-view-controllist-section']/span[4]/a")
	private WebElement downloadButton;
	
	@FindBy(xpath="//*[@id='btr-nostro-acct-activity-view-controllist-section']/span[4]/a")
	private WebElement downloadButtonNostro;
	
	
	
	
	public AccountActivityPage(){
		PageFactory.initElements(Browser.driver(), this);
	}
	
	public int getAccountActivityRowCount(){
		WebTableReport WtReport = new WebTableReport(Browser.driver().findElement(By.cssSelector("div.slick-viewport")));
		int s = WtReport.getRowCountReport();
		return s;
	}
	
	public void verifyAccountActivityTable(){
		WebTableReport WtReport = new WebTableReport(Browser.driver().findElement(By.cssSelector("div.slick-viewport")));
		int s = WtReport.getRowCountReport();
		
		for(int i=3;i<=4;i++){			
			String debits = WtReport.getCellDataReport(i, 4);
			if (!debits.isEmpty()){
				//compare the value
				assertEquals("Values are equal",debits,"245.00");				
			}	
						
		}	
		
		for(int i=3;i<=4;i++){			
			String debits = WtReport.getCellDataReport(i, 5);
			if (!debits.isEmpty()){
				//compare the value
				assertEquals("Values are equal",debits,"543.00");				
			}	
						
		}	
		
		for(int i=3;i<=4;i++){			
			String debits = WtReport.getCellDataReport(i, 6);
			if (!debits.isEmpty()){
				//compare the value
				assertEquals("Values are equal",debits,"639,363.83");				
			}
						
		}		
		
	}
	
	public void requestAccountActivity(){
		assertTrue(this.requestAccountStatement.isDisplayed());
		this.requestAccountStatement.click();
		
	}
	public void findSearch(String findField,String selectField){
		this.findfield.click();
		Actions builder = new Actions(Browser.driver());
		if (findField.trim().equalsIgnoreCase("BAI Code")){
			builder.moveToElement(this.biaCode).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("Bank Reference")){
			builder.moveToElement(this.bankreference).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("credits")){
			builder.moveToElement(this.creditAmount).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("Customer Reference")){
			builder.moveToElement(this.customerreference).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("Debits")){
			builder.moveToElement(this.debitAmount).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("Narrative")){
			builder.moveToElement(this.narrative).click().perform();
		}	
		if (findField.trim().equalsIgnoreCase("Running Balance")){
			builder.moveToElement(this.runningBalance).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("Swift Code")){
			builder.moveToElement(this.swiftCode).click().perform();
		}
		if (findField.trim().equalsIgnoreCase("Tran Type")){
			builder.moveToElement(this.tranType).click().perform();
		}
		this.searchField.sendKeys(selectField);
		
		//check the count
		/*String s = this.panelArea.getText();
		assertFalse(s.contains("No"));*/
		}
	
	public void groupSearch(String group){
		Actions builder =new Actions(Browser.driver());
		
		this.groupAccount.click();
		
		if (group.trim().equalsIgnoreCase("Off")){
			builder.moveToElement(this.Off).click().perform();
		}
		else if (group.trim().equalsIgnoreCase("Post Date")){
			builder.moveToElement(this.postDate).click().perform();
		}
		else if (group.trim().equalsIgnoreCase("Value Date")){
			builder.moveToElement(this.valueDate).click().perform();
		}
		else if (group.trim().equalsIgnoreCase("Collapse All")){
			builder.moveToElement(this.collapseAll).click().perform();
		}
		else if (group.trim().equalsIgnoreCase("Expand All")){
			builder.moveToElement(this.expandAll).click().perform();
		}
		else if (group.trim().equalsIgnoreCase("Collapse By Default")){
			builder.moveToElement(this.collapseBydefault).click().perform();
		}
		
	}
	public int accountActivityRowCount(){
		
		WebTableReport Wtable= new WebTableReport();
		int i = Wtable.getRowCountReport();
		
		return i;
	}
	
	public void clickWebTable(){
		WebTableReport Wtable= new WebTableReport(this.webTable);
		Wtable.selectfirstrowReport();
	}
	
	public String SpacificDate(){
		
		String S=this.fromDate.getText();
		System.out.println(S);
		
		
		//OperatingAccountPage ope= new OperatingAccountPage();
	    //String dateString=	ope.getOpeningDate();
	    
	    
	    String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yy");
		String specificDate =st1.format(d).toUpperCase();
		System.out.println(specificDate);
		return specificDate;
		
		//return S;
		
	}
	
	public String captureToDate(){
		
		String T=this.fromdateOAp.getText();
		int ToLength=T.length();
		System.out.println(ToLength);
		
		String original = T, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		int length = original.length();

		for (int i = 11; i <= length-1; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		return reverse;

			
		
	}
	
	public String captureFromDate(){
		String T=this.fromdateOAp.getText();
		int ToLength=T.length();
		System.out.println(ToLength);
		
		String original = T, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		int length = original.length();

		for (int i = 0; i <= length-12; i++)
			reverse = reverse + original.charAt(i);
		
		System.out.println("Reverse of entered string is: " + reverse);
		return reverse;

		
		
		
		
	}
	
	public String Todate(){
		String S=this.captureToDate();
		
		String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String Todate =st1.format(d).toUpperCase();
		System.out.println(Todate);
		return Todate;
		
	}
	
	public String FromDate(){
		String S=this.captureFromDate();
		String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String Fromdate =st1.format(d).toUpperCase();
		System.out.println(Fromdate);
		return Fromdate;
		
	}
	
	public String captureFromDateBalanceSummaryScreen(){
		String T=this.fromDateBalanceSummary.getText();
		int ToLength=T.length();
		System.out.println(ToLength);
		
		String original = T, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		int length = original.length();

		for (int i = 0; i <= length-12; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		return reverse;

			
		
	}
	public String FromDateBalanceSummry(){
		String S=this.captureFromDateBalanceSummaryScreen();
		String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String Fromdate =st1.format(d).toUpperCase();
		System.out.println(Fromdate);
		return Fromdate;
		
	}
	public String FromDateBalanceSummary(){
		String S=this.captureFromDateBalanceSummaryScreen();
		String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String Fromdate =st1.format(d).toUpperCase();
		System.out.println(Fromdate);
		return Fromdate;
		
	}
	
	public String ToDateBalanceSummary(){
		String S=this.captureToDateBalanceSummaryScreen();
		String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String Fromdate =st1.format(d).toUpperCase();
		System.out.println(Fromdate);
		return Fromdate;
		
	}
	
	
	public String ClosingDateDateBalanceSummary(){
		String S=this.captureToDateBalanceSummaryScreen();
		String date = S;

		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String Fromdate =st1.format(d).toUpperCase();
		System.out.println(Fromdate);
		return Fromdate;
		
	}
	public String captureToDateBalanceSummaryScreen(){
		String T=this.fromDateBalanceSummary.getText();
		int ToLength=T.length();
		System.out.println(ToLength);
		
		String original = T, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		int length = original.length();

		for (int i = 11; i <= length-1; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		return reverse;

		
		
		
		
	}
	
	public String CaptureOpeningDate(){
		String T=this.fromDate.getText();
		int ToLength=T.length();
		System.out.println(ToLength);
		
		String original = T, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		int length = original.length();

		for (int i = 0; i <= length-12; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		return reverse;

		
		
		
		
	}
	public void selectDBDetails(String dates){
		if(dates.trim().equalsIgnoreCase("Date Range")){
			
			this.FromDateBalanceSummry();
			this.ToDateBalanceSummary();
		}
	}
	
	public String FromDateWeekToYesterDay() throws ParseException{ 
		
		DateConversion conversion=new DateConversion();
		String S=conversion.weekToYesterday();
		
		
		int length=S.length();
		System.out.println(length);
		
		
		String original = S, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		

		for (int i = 0; i <8; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		
		
		String date = reverse;
		
		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String WeekToYesterdayFromDate =st1.format(d).toUpperCase();
		System.out.println(WeekToYesterdayFromDate);
		return WeekToYesterdayFromDate;
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
public String ToDateWeekToYesterDay() throws ParseException{ 
		
		DateConversion conversion=new DateConversion();
		String S=conversion.weekToYesterday();
		
		
		int length=S.length();
		System.out.println(length);
		
		
		String original = S, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		

		for (int i = 9; i <=16; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		
		
		String date = reverse;
		
		SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String WeekToYesterdayFromDate =st1.format(d).toUpperCase();
		System.out.println(WeekToYesterdayFromDate);
		return WeekToYesterdayFromDate;
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public String getWeekToYesterdayOpeningDate() throws ParseException{
		String S=this.FromDateWeekToYesterDay();
		System.out.println(S);
		
		/*int length=S.length();
		System.out.println(length);
		
		
		String original = S, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		

		for (int i = 0; i <=10; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);*/
		return S;
			
	}
public String FromDateMonthToYesterDay() throws ParseException{ 
		
		DateConversion conversion=new DateConversion();
		String S=conversion.monthToYesterday();
		
		//String date = S; 
		
		
		int length=S.length();
		System.out.println(length);
		
		
		String original = S, reverse = "";
		// Scanner in = new Scanner(System.in);

		// System.out.println("Enter a string to reverse");
		// original = in.nextLine();

		

		for (int i = 0; i <8; i++)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
		
		
		String date = reverse;
		
		SimpleDateFormat st = new SimpleDateFormat("MM/dd/yy");
		Date d = null;
		try {
			d = st.parse(date);
		} catch (Exception e) {
		}

		SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
		String WeekToYesterdayFromDate =st1.format(d).toUpperCase();
		System.out.println(WeekToYesterdayFromDate);
		return WeekToYesterdayFromDate;
		
	}


public String ToDateMonthToYesterDay() throws ParseException{ 
	
	DateConversion conversion=new DateConversion();
	String S=conversion.monthToYesterday();
	System.out.println(S);
	
	//String date = S; 
	
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 9; i <17; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	
	
	String date = reverse;
	
	SimpleDateFormat st = new SimpleDateFormat("MM/dd/yy");
	Date d = null;
	try {
		d = st.parse(date);
		System.out.println(d);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String WeekToYesterdayFromDate =st1.format(d).toUpperCase();
	System.out.println(WeekToYesterdayFromDate);
	return WeekToYesterdayFromDate;
	
}
	
public String getMonthToYesterdayOpeningDate() throws ParseException{
	String S=this.FromDateMonthToYesterDay();
	System.out.println(S);
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 0; i <=10; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;
		
}
public String FromDatePreviousWeek() throws ParseException{ 
	
	DateConversion conversion=new DateConversion();
	String S=conversion.previousWeek();
	
	//String date = S; 
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 0; i <=7; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	
	
	
	String date = reverse;
	
	SimpleDateFormat st = new SimpleDateFormat("MM/dd/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String FromDatePreviousWeek =st1.format(d).toUpperCase();
	System.out.println(FromDatePreviousWeek);
	return FromDatePreviousWeek;
	
	
	
}



public String ToDatePreviousWeek() throws ParseException{ 
	
	DateConversion conversion=new DateConversion();
	String S=conversion.previousWeek();
	
	//String date = S; 
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 9; i <=16; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	
	
	
	String date = reverse;
	
	SimpleDateFormat st = new SimpleDateFormat("MM/dd/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String FromDatePreviousWeek =st1.format(d).toUpperCase();
	System.out.println(FromDatePreviousWeek);
	return FromDatePreviousWeek;
	
	
	
}




public String getPreviousWeekOpeningDate() throws ParseException{
	String S=this.FromDatePreviousWeek();
	System.out.println(S);
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 0; i <=9; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	//return reverse;
	
	
	
	
	
	String date = reverse;
	
	SimpleDateFormat st = new SimpleDateFormat("MM/dd/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String WeekToYesterdayFromDate =st1.format(d).toUpperCase();
	System.out.println(WeekToYesterdayFromDate);
	return WeekToYesterdayFromDate;

	
	
}

public String getWeekToYesterdayToDate() throws ParseException{
	String S=this.ToDateWeekToYesterDay();
	System.out.println(S);
	
	/*int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 12; i <=22; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);*/
	return S;
		
}
public String getMonthToYesterDayToDate() throws ParseException{
	String S=this.FromDateMonthToYesterDay();
	System.out.println(S);
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 12; i <=21; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;
		
}
public String getPreviousWeekToDate() throws ParseException{
	String S=this.ToDatePreviousWeek();
	System.out.println(S);
	
	/*int length=S.length();
	System.out.println(length);
	*/
	/*
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 12; i <=22; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);*/
	return S;
		
}
public String getMonthToYesterdayToDate() throws ParseException{
	String S=this.ToDateMonthToYesterDay();
	System.out.println(S);
	
	int length=S.length();
	System.out.println(length);
	
	return S;
	
	
	
	/*String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 12; i <=22; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;
		*/
}

public String getEmptyData(){
	String S=this.activityScreen.getText();
	//driver.findElement(By.id("ctl00_SampleContent_Date5")).getAttribute("value");
	return S;
	
}


public String getNostroEmptyData(){
	String S=this.nostroEmptyScreen.getText();
	return S;
}
public String yesterdayDate(){
	 DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yy");
     Calendar cal = Calendar.getInstance();
     cal.add(Calendar.DATE, -1);    
     
   String yesterday=  dateFormat.format(cal.getTime());
     
   System.out.println(yesterday);
     return yesterday;
}
	
public String SpacificDateBalanceSummary(){
	
	String S=this.fromDateBalanceSummary.getText();
	System.out.println(S);
	
	
	//OperatingAccountPage ope= new OperatingAccountPage();
    //String dateString=	ope.getOpeningDate();
    
    
    String date = S;

	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String specificDate =st1.format(d).toUpperCase();
	System.out.println(specificDate);
	return specificDate;
	
	//return S;
	
}

public String FromDatePreviousMonth() throws ParseException{ 
	
	DateConversion conversion=new DateConversion();
	String S=conversion.previuosMonth();
	System.out.println(S);
	
	
	
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 0; i <8; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	
	
	
	
	
	
	
	
	
	
	
	
	String date = reverse; 

	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String PreviousMonthFromDate =st1.format(d).toUpperCase();
	System.out.println(PreviousMonthFromDate);
	return PreviousMonthFromDate;
	
}

public String getPreviousMonthOpeningDate() throws ParseException{
	String S=this.FromDatePreviousMonth();
	System.out.println(S);
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 0; i <=10; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;
		
}

public String ToDatePreviousMonth() throws ParseException{ 
	
	DateConversion conversion=new DateConversion();
	String S=conversion.previuosMonth();
	
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 9; i <=16; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	
	
	
	String date = reverse;
	
	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String FromDatePreviousWeek =st1.format(d).toUpperCase();
	System.out.println(FromDatePreviousWeek);
	return FromDatePreviousWeek;
	
}


public String getPreviousMonthClosingDate() throws ParseException{
	String S=this.ToDatePreviousMonth();
	System.out.println(S);
	
	int length=S.length();
	System.out.println(length);
	
	
	String original = S, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	

	for (int i = 12; i <=22; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;
		
	
}
public void dragDrop(){
	Actions dragger = new Actions(Browser.driver());
	WebElement draggablePartOfScrollbar = Browser.driver().findElement(By.id("da-audit-history-section"));
	int numberOfPixelsToDragTheScrollbarDown = 100;
	dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
}

public String getCheckBoxCount(){
	String checkBoxCount=this.getCheckBoxCount.getAttribute("value");
	return checkBoxCount;
	
}

public void dragAndDropAccountActivityScreen(){
	
	
	
	
	/*Actions builder=new Actions(Browser.driver());
	builder.clickAndHold().moveToElement(toElement).
	builder.m*/
	
	
Actions dragger = new Actions(Browser.driver());

WebElement draggablePartOfScrollbar = Browser.driver().findElement(By.xpath("//div[contains(@class,'slick-viewport')]"));

int numberOfPixelsToDragTheScrollbarDown = 300;

dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
}


public void downloadCSVFileFromGrid() throws Exception{
	
	this.downloadButton.click();
	Thread.sleep(20000);
}
public String BalanceSummaryGetEmptyData(){
	String S=this.balanceScreen.getText();
	//driver.findElement(By.id("ctl00_SampleContent_Date5")).getAttribute("value");
	return S;
	
}

public String getEmptyDataNostroScreen(){
	String S=this.nostroEmptyScreen.getText();
	//driver.findElement(By.id("ctl00_SampleContent_Date5")).getAttribute("value");
	return S;
	
}

public String getEmptyDataNostroBalanceSummary(){
	String S=this.nostroBalanceEmptyScreen.getText();
	//driver.findElement(By.id("ctl00_SampleContent_Date5")).getAttribute("value");
	return S;
	
}


public String captureFromDateNostro(){
	String T=this.nostroFromDate.getText();
	int ToLength=T.length();
	System.out.println(ToLength);
	
	String original = T, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	int length = original.length();

	for (int i = 0; i <= length-12; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;

	
	
	
	
}

public String FromDateNostro(){
	String S=this.captureFromDateNostro();
	
	String date = S;

	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String Todate =st1.format(d).toUpperCase();
	System.out.println(Todate);
	return Todate;
	
}

public String captureToDateNostro(){
	String T=this.nostroFromDate.getText();
	int ToLength=T.length();
	System.out.println(ToLength);
	
	String original = T, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	int length = original.length();

	for (int i = 11; i <= length-1; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;

	
	
	
	
}
public String ToDateNostro(){
	String S=this.captureToDateNostro();
	
	String date = S;

	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String Todate =st1.format(d).toUpperCase();
	System.out.println(Todate);
	return Todate;
	
}

public void downloadCSVFileFromGridNostro() throws Exception{
	
	this.downloadButtonNostro.click();
	Thread.sleep(20000);
}

public String captureNostroFromDateBalanceSummaryScreen(){
	String T=this.nostroBalanceSummaryDate.getText();
	int ToLength=T.length();
	System.out.println(ToLength);
	
	String original = T, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	int length = original.length();

	for (int i = 0; i <= length-12; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;

		
	
}
public String NostroFromDateBalanceSummry(){
	String S=this.captureNostroFromDateBalanceSummaryScreen();
	String date = S;

	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String Fromdate =st1.format(d).toUpperCase();
	System.out.println(Fromdate);
	return Fromdate;
	
}


public String NostrocaptureToDateBalanceSummaryScreen(){
	String T=this.nostroBalanceSummaryDate.getText();
	int ToLength=T.length();
	System.out.println(ToLength);
	
	String original = T, reverse = "";
	// Scanner in = new Scanner(System.in);

	// System.out.println("Enter a string to reverse");
	// original = in.nextLine();

	int length = original.length();

	for (int i = 11; i <= length-1; i++)
		reverse = reverse + original.charAt(i);

	System.out.println("Reverse of entered string is: " + reverse);
	return reverse;

	
	
	
	
}
public String NostroToDateBalanceSummry(){
	String S=this.NostrocaptureToDateBalanceSummaryScreen();
	String date = S;

	SimpleDateFormat st = new SimpleDateFormat("dd/MM/yy");
	Date d = null;
	try {
		d = st.parse(date);
	} catch (Exception e) {
	}

	SimpleDateFormat st1 = new SimpleDateFormat("dd/MMM/yyyy");
	String Fromdate =st1.format(d).toUpperCase();
	System.out.println(Fromdate);
	return Fromdate;
	
}



}

