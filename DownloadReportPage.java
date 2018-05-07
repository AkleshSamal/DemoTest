package com.anz.selenium.comcards.PageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.anz.selenium.utilities.AutoITUtil;
import com.anz.selenium.utilities.WebTable;
import com.anz.selenium.utilities.WebTableReport;

public class DownloadReportPage {

	@FindBy(partialLinkText = "Download Selected Files")
	private WebElement download;
	@FindBy(xpath = "//*[@id='btr-rptdownload-controllist-section']/span[2]/a")
	private WebElement groupAccount;

	@FindBy(xpath = "//a[@title='Filter By Date or Date Range']")
	private WebElement datefilter;
	@FindBy(id = "TD")
	private WebElement today;
	@FindBy(id = "YD")
	private WebElement yesterday;
	@FindBy(id = "WD")
	private WebElement weektodate;
	@FindBy(id = "PW")
	private WebElement previousweek;
	@FindBy(id = "MD")
	private WebElement monthtodate;
	@FindBy(id = "PM")
	private WebElement previousmonth;
	@FindBy(partialLinkText = "Group Downloads By Selected Criteria")
	private WebElement reportFilter;

	@FindBy(id = "repFormat")
	private WebElement reportFormat;

	@FindBy(id = "btr-rptdownload-remembersettings")
	private WebElement rememberTheseSettings;

	@FindBy(xpath = "//a[@title='View Actions']")
	private WebElement viewActions;
	@FindBy(xpath = "//a[@title='Select Search Criteria']")
	private WebElement selectsearchcriteria;

	@FindBy(id = "note")
	private WebElement reportDescription;

	private WebElement repFormat;

	@FindBy(xpath = "//*[@id='btr-rptdownload-controllist-section']/span[5]/input")
	private WebElement findReport;
	@FindBy(xpath = "//*[@id='btr-rptdownload-controllist-section']/span[5]/a")
	public WebElement refreshButton;
	@FindBy(id = "SD")
	private WebElement specificDate;
	@FindBy(id = "DR")
	private WebElement dateRange;

	@FindBy(className = "control-menu date-menu")
	private WebTable calendarTable;

	@FindBy(xpath = "//*[@id='btr-rptdownload-controllist-section']/span[2]/a")
	private WebElement grouping;
	@FindBy(id = "$OFF$")
	private WebElement Off;
	@FindBy(id = "reportDate")
	private WebElement reportDate;
	@FindBy(css = "div#rptSearchControlSCMenu.control-menu ul li.active a#repId")
	private WebElement reportType;
	@FindBy(id = "reqType")
	private WebElement runType;
	@FindBy(id = "$COLL$")
	private WebElement collapseAll;
	@FindBy(id = "$EXP$")
	private WebElement expandAll;
	@FindBy(id = "$DEF$")
	private WebElement collapseByDefault;
	@FindBy(id = "slickgrid_948211receivedDate")
	private WebElement reportScreen;
	@FindBy(id = "btr-rptdownload-file")
	private WebElement downloadSelectedfile;
	@FindBy(id = "btr-rptdownload-remove")
	private WebElement removeReport;
	@FindBy(id = "cfmBtnYes")
	private WebElement yesButton;
	@FindBy(id = "feedback response")
	private WebElement feedBack;
	@FindBy(xpath="//*[@title='Refresh']")
	private WebElement refresh;
	
	WebDriverWait wait;

	// Constructor to initialize page elements
	public DownloadReportPage() {
		PageFactory.initElements(Browser.driver(), this);
	}

	// click download button
	public void clickDownload() {
		this.download.click();

	}

	// date selector from lists
	public void dateSelectorSearch(String dateRange) throws Exception {
		Thread.sleep(4000);

		try {
			this.datefilter.click();
			Actions builder = new Actions(Browser.driver());
			Browser.driver().manage().timeouts()
					.implicitlyWait(10, TimeUnit.SECONDS);

			if (dateRange.trim().equalsIgnoreCase("Today")) {
				builder.moveToElement(this.today).click().perform();
			} else if (dateRange.trim().equalsIgnoreCase("weektodate")) {
				builder.moveToElement(this.weektodate).click().perform();
			} else if (dateRange.trim().equalsIgnoreCase("previousweek")) {
				builder.moveToElement(this.previousweek).click().perform();
			} else if (dateRange.trim().equalsIgnoreCase("yesterday")) {
				builder.moveToElement(this.yesterday).click().perform();
			} else if (dateRange.trim().equalsIgnoreCase("monthtodate")) {
				builder.moveToElement(this.monthtodate).click().perform();
			} else if (dateRange.trim().equalsIgnoreCase("previousmonth")) {
				builder.moveToElement(this.previousmonth).click().perform();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/*
	 * //report Selector from lists public void reportTypeSearch(String
	 * reportTypeformat){
	 * 
	 * try{ this.reportFilter.click(); Actions builder = new
	 * Actions(Browser.driver());
	 * Browser.driver().manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS);
	 * 
	 * if(reportTypeformat.equalsIgnoreCase("ReportDate")){
	 * builder.moveToElement(this.reportDate).click().perform();
	 * 
	 * } else if(reportTypeformat.equalsIgnoreCase("ReportFormat")){
	 * builder.moveToElement(this.reportFormat).click().perform(); } else
	 * if(reportTypeformat.equalsIgnoreCase("ReportName")){
	 * builder.moveToElement(this.reportName).click().perform(); } else
	 * if(reportTypeformat.equalsIgnoreCase("RunType")){
	 * builder.moveToElement(this.runType).click().perform(); }
	 * }catch(NoSuchElementException e){ e.printStackTrace();
	 * 
	 * }
	 */

	public void clickrefreshDownloadreport() {
		this.refreshButton.click();

	}

	public void specificDateSelect(String month, int year, int date) {

		this.datefilter.click();
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		builder.moveToElement(this.specificDate).click().perform();

		// Get the Dropdown as a Select using it's name attribute
		Select monthoption = new Select(Browser.driver().findElement(
				By.className("ui-datepicker-month")));

		// Verify Dropdown does not support multiple selection
		assertFalse(monthoption.isMultiple());

		// Verify Dropdown has four options for selection
		assertEquals(3, monthoption.getOptions().size());

		// select by visible Text
		monthoption.selectByVisibleText(month);

		assertEquals("Aug", monthoption.getFirstSelectedOption().getText());

		// Select year
		Select yearoption = new Select(Browser.driver().findElement(
				By.className("ui-datepicker-year")));
		assertFalse(yearoption.isMultiple());
		assertEquals(1, yearoption.getOptions().size());
		String strYear = Integer.toString(year);
		yearoption.selectByVisibleText(strYear);
		// select date

		int i = calendarTable.getRowCount();
		int j = calendarTable.getColumnCount();

		for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				String dateSelect = calendarTable.getCellData(k, l);
				// convert String to Integer
				int idateSelect = Integer.parseInt(dateSelect);
				if (idateSelect == date) {
					calendarTable.selectCellCalendar(k, l).click();
					break;
				}
			}
		}

	}

	// find report by selected Criteria
	public void findReportbySelectCriteria(String reportOption,
			String reportsearchValue) throws Exception {
		try {
			wait=new WebDriverWait(Browser.driver(), 60);
			wait.until(ExpectedConditions.visibilityOf(this.selectsearchcriteria));
			this.selectsearchcriteria.click();
			Actions builder = new Actions(Browser.driver());
			Browser.driver().manage().timeouts()
					.implicitlyWait(10, TimeUnit.SECONDS);

			if (reportOption.trim().equalsIgnoreCase("ReportDescription")) {
				builder.moveToElement(this.reportDescription).click().perform();
			} else if (reportOption.trim().equalsIgnoreCase("ReportFormat")) {
				builder.moveToElement(this.repFormat).click().perform();
			} else if (reportOption.trim().equalsIgnoreCase("Report Type")) {
				builder.moveToElement(this.reportType).click().perform();
			}
			wait.until(ExpectedConditions.visibilityOf(this.refresh));
			Thread.sleep(30000);
			this.refresh.click();
			
			Thread.sleep(3000);
			// enter reportsearch value
			this.findReport.sendKeys(reportsearchValue);

			WebTableReport Wtable = new WebTableReport(
					Browser.driver()
							.findElement(
									By.xpath(("//div[contains(@class,'ui-widget-content slick-row')]"))));
			int i = Wtable.getRowCountReport();
			assertTrue(i > 0);

			// Browser.driver().manage().timeouts().implicitlyWait(10,
			// TimeUnit.SECONDS);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
	public void findReportbySelectCriterianew(String reportOption,
			String reportsearchValue) throws Exception {
		try {
			wait=new WebDriverWait(Browser.driver(), 60);
			wait.until(ExpectedConditions.visibilityOf(this.selectsearchcriteria));
			this.selectsearchcriteria.click();
			Actions builder = new Actions(Browser.driver());
			Browser.driver().manage().timeouts()
					.implicitlyWait(10, TimeUnit.SECONDS);

			if (reportOption.trim().equalsIgnoreCase("ReportDescription")) {
				builder.moveToElement(this.reportDescription).click().perform();
			} else if (reportOption.trim().equalsIgnoreCase("ReportFormat")) {
				builder.moveToElement(this.repFormat).click().perform();
			} else if (reportOption.trim().equalsIgnoreCase("Report Type")) {
				builder.moveToElement(this.reportType).click().perform();
			}
			wait.until(ExpectedConditions.visibilityOf(this.refresh));
			this.refresh.click();
			
			wait.until(ExpectedConditions.visibilityOf(this.refresh));
			wait.until(ExpectedConditions.visibilityOf(this.findReport));
			// enter reportsearch value
			this.findReport.sendKeys(reportsearchValue);

			WebTableReport Wtable = new WebTableReport(
					Browser.driver()
							.findElement(
									By.xpath(("//div[contains(@class,'ui-widget-content slick-row')]"))));
			int i = Wtable.getRowCountReport();
			assertTrue(i > 0);

			// Browser.driver().manage().timeouts().implicitlyWait(10,
			// TimeUnit.SECONDS);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public static void dateRangeSelect(int fDate, String fMonth, int fYear,
			int eDate, String eMonth, int eYear) {
		// call specific date Select
		specificDateSelectFrom(fDate, fMonth, fYear);
		WebElement filter = Browser.driver().findElement(
				By.xpath("//a[@title='Filter By Date or Date Range']"));
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		builder.moveToElement(Browser.driver().findElement(By.id("DR")))
				.click().perform();

		// Get the Dropdown as a Select using it's name attribute
		Select monthoption = new Select(
				Browser.driver()
						.findElement(
								By.cssSelector("div#receivedDateCalDateRangeTo.hasDatepicker div.ui-datepicker-inline div.ui-datepicker-header div.ui-datepicker-title select.ui-datepicker-month")));

		// Verify Dropdown does not support multiple selection
		assertFalse(monthoption.isMultiple());

		// Verify Dropdown has four options for selection
		assertEquals(2, monthoption.getOptions().size());

		// select by visible Text
		monthoption.selectByVisibleText(eMonth);

		// assertEquals("Aug", monthoption.getFirstSelectedOption().getText());
		// Select year
		Select yearoption = new Select(
				Browser.driver()
						.findElement(
								By.cssSelector("div#receivedDateCalDateRangeTo.hasDatepicker div.ui-datepicker-inline div.ui-datepicker-header div.ui-datepicker-title select.ui-datepicker-year")));
		assertFalse(yearoption.isMultiple());
		assertEquals(1, yearoption.getOptions().size());
		String strYear = Integer.toString(eYear);
		yearoption.selectByVisibleText(strYear);

		// select date
		WebTable calendarTable = new WebTable(
				Browser.driver()
						.findElement(
								By.cssSelector("div#receivedDateCalDateRangeTo.hasDatepicker div.ui-datepicker-inline table.ui-datepicker-calendar tbody")));
		int i = calendarTable.getRowCount();
		int j = calendarTable.getColumnCount();

		outerloop: for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				String dateSelect = calendarTable.getCellData(k, l);
				if (!(dateSelect.length() < 0)) {
					// convert String to Integer
					int idateSelect = Integer.parseInt(dateSelect);
					if (idateSelect == eDate) {
						WebElement cell = calendarTable
								.selectCellCalendar(k, l);
						String linkclass = cell.getAttribute("class");
						if (!linkclass.contains("disabled")) {
							calendarTable.selectCellCalendar(k, l).click();
							Browser.driver()
									.findElement(
											By.id("receivedDateCalDateRangeBtnOk"))
									.click();
							break outerloop;
						}
						break outerloop;
					}
				}
			}
		}
		// for from date
		String fDatex = null;
		// check for attribute
		// String ftextval =
		// Browser.driver().findElement(By.xpath("//a[@title='Filter By Date or Date Range']")).getText();
		if (fDate <= 9) {
			// add zero before
			fDatex = 0 + "" + fDate;
		} else {
			fDatex = "" + fDate;
		}
		String confDate = fMonth + " " + fDatex + "," + " " + fYear;
		// for to date
		String eDatex = null;
		// check for attribute
		String eTextval = Browser
				.driver()
				.findElement(
						By.xpath("//a[@title='Filter By Date or Date Range']"))
				.getText();
		if (eDate <= 9) {
			// add zero before
			eDatex = 0 + "" + eDate;
		} else {
			eDatex = "" + eDate;
		}
		String conEDate = eMonth + " " + eDatex + "," + " " + eYear;
		String ExpectedDatedisplay = confDate + "-" + conEDate;
		assertEquals(eTextval, ExpectedDatedisplay);

	}

	public static void specificDateSelectFrom(int inDate, String inMonth,
			int inYear) {
		// String inDatex=null;
		// this.datefilter.click();
		// WebElement filter =
		// Browser.driver().findElement(By.xpath("//a[@title='Filter By Date or Date Range']"));
		// filter.click();
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		// builder.moveToElement(Browser.driver().findElement(By.id("DR"))).click().perform();
		// Get the Dropdown as a Select using it's name attribute
		Select monthoption = new Select(
				Browser.driver()
						.findElement(
								By.cssSelector("div#receivedDateCalDateRangeFrom.hasDatepicker div.ui-datepicker-inline div.ui-datepicker-header div.ui-datepicker-title select.ui-datepicker-month")));

		// Verify Dropdown does not support multiple selection
		assertFalse(monthoption.isMultiple());
		// Verify Dropdown has four options for selection
		assertEquals(3, monthoption.getOptions().size());
		// select by visible Text
		monthoption.selectByVisibleText(inMonth);

		// Select year
		Select yearoption = new Select(
				Browser.driver()
						.findElement(
								By.cssSelector("div#receivedDateCalDateRangeFrom.hasDatepicker div.ui-datepicker-inline div.ui-datepicker-header div.ui-datepicker-title select.ui-datepicker-year")));
		assertFalse(yearoption.isMultiple());
		assertEquals(1, yearoption.getOptions().size());
		String strYear = Integer.toString(inYear);
		yearoption.selectByVisibleText(strYear);
		// select date

		WebTable calendarTable = new WebTable(
				Browser.driver()
						.findElement(
								By.cssSelector("div#receivedDateCalDateRangeFrom.hasDatepicker div.ui-datepicker-inline table.ui-datepicker-calendar tbody")));
		int i = calendarTable.getRowCount();
		int j = calendarTable.getColumnCount();

		outerloop: for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				String dateSelect = calendarTable.getCellData(k, l);
				if (!(dateSelect.isEmpty())) {
					// convert String to Integer
					int idateSelect = Integer.parseInt(dateSelect);
					if (idateSelect == inDate) {
						WebElement cell = calendarTable
								.selectCellCalendar(k, l);
						String linkclass = cell.getAttribute("class");
						if (!linkclass.contains("disabled")) {
							calendarTable.selectCellCalendar(k, l).click();
							break outerloop;
						}
						break outerloop;
					}
				}
			}
		}

	}

	public void clickgroup() {
		assertTrue(this.grouping.isDisplayed());
		this.grouping.click();

	}

	public void selectGroup(String accounts) throws Exception {
		this.groupAccount.click();
		Thread.sleep(4000);
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		if (accounts.trim().equalsIgnoreCase("Off")) {
			builder.moveToElement(this.Off).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("ReportDate")) {
			builder.moveToElement(this.reportDate).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("ReportFormat")) {
			builder.moveToElement(this.reportFormat).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("ReportType")) {
			builder.moveToElement(this.reportType).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("RunType")) {
			builder.moveToElement(this.runType).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("CollapseAll")) {
			builder.moveToElement(this.collapseAll).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("ExpandAll")) {
			builder.moveToElement(this.expandAll).click().perform();
		} else if (accounts.trim().equalsIgnoreCase("CollapseByDefault")) {
			builder.moveToElement(this.collapseByDefault).click().perform();
		}

	}

	public void viewAction() throws Exception {
		this.viewActions.click();
		Thread.sleep(4000);

	}

	public void rememberSettings() throws Exception {

		assertTrue(this.rememberTheseSettings.isDisplayed());
		Thread.sleep(2000);
		this.rememberTheseSettings.click();

	}

	/*
	 * public void columnValidation(){ WebTableReport wTable=new
	 * WebTableReport(Browser
	 * .driver().findElement(By.xpath("//div[contains(@class,'slick-header')]"
	 * ))); int s=wTable.getDownloadRowCountReport(); System.out.println(s);
	 * //ArrayList<String> a1 = new ArrayList<String>(); for(int i=1;i<=s;i++){
	 * //String s1=wTable.getDownloadCellDataReportDetails(1,1);
	 * //System.out.println(s1);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * //ArrayList<String> al = new ArrayList<String>();
	 * 
	 * //wTable.getDownloadCellDataReportDetails(i, 2); //int
	 * s=wTable.getColumnCountReport(); //System.out.println(s); }
	 */

	public void rightClickDownloadReport(String options, String reportOption,
			String reportsearchValue) throws Exception {
		
		this.findReportbySelectCriteria(reportOption, reportsearchValue);
		wait=new WebDriverWait(Browser.driver(), 180);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]")));
		Thread.sleep(3000);
		Actions builder = new Actions(Browser.driver());
		List<WebElement> tableRows = Browser
				.driver()
				.findElements(
						By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(0);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(0);
		builder.contextClick(cell.findElements(By.xpath("//input[@type='checkbox']")).get(1)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(this.downloadSelectedfile));
		
		
		if (options.trim().equalsIgnoreCase("DownloadSelectedFile")) {
			builder.moveToElement(this.downloadSelectedfile).click().perform();
		} else if (options.trim().equalsIgnoreCase("DeleteSelectedFiles")) {
			builder.moveToElement(this.removeReport).click().perform();
			assertTrue(this.yesButton.isDisplayed());
			this.yesButton.click();
			// String s=this.feedBack.getText();
			// assertTrue(s.contains("Selected"));

		}

	}
	
	public String rightClickDownloadReport(String options, String reportOption,
			String reportsearchValue,String resultsPath,String format,String browserType) throws Exception {
		String filepath = null;
		this.findReportbySelectCriteria(reportOption, reportsearchValue);
		wait=new WebDriverWait(Browser.driver(), 180);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]")));
		Thread.sleep(3000);
		Actions builder = new Actions(Browser.driver());
		List<WebElement> tableRows = Browser
				.driver()
				.findElements(
						By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(0);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(0);
		builder.contextClick(cell.findElements(By.xpath("//input[@type='checkbox']")).get(1)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(this.downloadSelectedfile));
		
	
		if (options.trim().equalsIgnoreCase("DownloadSelectedFile")) {
			AutoITUtil autosave=new AutoITUtil();
			filepath=autosave.autoFileDownload(resultsPath, reportsearchValue+"."+format.toLowerCase(),browserType);
			builder.moveToElement(this.downloadSelectedfile).click().perform();
		} else if (options.trim().equalsIgnoreCase("DeleteSelectedFiles")) {
			builder.moveToElement(this.removeReport).click().perform();
			assertTrue(this.yesButton.isDisplayed());
			this.yesButton.click();
			// String s=this.feedBack.getText();
			// assertTrue(s.contains("Selected"));

		}
		return filepath;

	}
	
	public void rightClickDownloadReportnew(String options, String reportOption,
			String reportsearchValue) throws Exception {
		
		//this.findReportbySelectCriterianew(reportOption, reportsearchValue);
		wait=new WebDriverWait(Browser.driver(), 180);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]")));
		
		Actions builder = new Actions(Browser.driver());
		List<WebElement> tableRows = Browser
				.driver()
				.findElements(
						By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(0);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.ui-widget-content div.slick-cell"));
		
		System.out.println(tableCols.get(5).getText());
		
		 for(int i=0;i<100;i++){
			
			 this.findReportbySelectCriterianew(reportOption, reportsearchValue);
			 if(tableCols.get(5).getText().contains("Ready for download")){
				 System.out.println("if loop");
				 break;
			 }
		 }
		 
				
		
		
		
		
		
		WebElement cell = tableCols.get(0);
		builder.contextClick(cell.findElements(By.xpath("//input[@type='checkbox']")).get(1)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(this.downloadSelectedfile));
		
		
		if (options.trim().equalsIgnoreCase("DownloadSelectedFile")) {
			builder.moveToElement(this.downloadSelectedfile).click().perform();
		} else if (options.trim().equalsIgnoreCase("DeleteSelectedFiles")) {
			builder.moveToElement(this.removeReport).click().perform();
			assertTrue(this.yesButton.isDisplayed());
			this.yesButton.click();
			// String s=this.feedBack.getText();
			// assertTrue(s.contains("Selected"));

		}

	}

	public static String getReportName()  {
		String s;
		
			WebTableReport Wtable = new WebTableReport(
					Browser.driver()
							.findElement(
									By.xpath(("//div[contains(@class,'ui-widget-content slick-row')]"))));
			try{
			s = Wtable.getCellDataReport(1, 4);
		} catch (Exception e) {
			 s = Wtable.getCellDataReport(2, 4);
		}
			
		//System.out.println(s);
		return s;

	}
	
public void ScheduledDownload(){
		
		WebTableReport Wtable = new WebTableReport(
				Browser.driver()
						.findElement(
								By.xpath(("//div[contains(@class,'ui-widget-content slick-row')]"))));
		//Wtable.getCellDataReport(1,4);
		int i=Wtable.getRowCountReport();
		assertTrue(i>0);
			
	}
public boolean isFileDownloaded(String downloadPath, String fileName) {
	boolean flag = false;
    File dir = new File(downloadPath);
    File[] dir_contents = dir.listFiles();
  	
   // for(int check=0;check<10;check++)
	for (int i = 0; i < dir_contents.length; i++) {
    if (dir_contents[i].getName().equals(fileName))
        return flag=true;
        }
   
    return flag;
}

public boolean isNotificationPresent(){
	 try{
		 
		WebDriverWait wait = new WebDriverWait(Browser.driver(),20);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("html.wf-fontawesome-n4-active body.ie8Fix div#notifyMessage.notification div.notification-message span")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='notifyMessage']")));
	 }
	 catch(Exception ex){
		 return false;
	 }
	// if(Browser.driver().findElements(By.cssSelector("html.wf-fontawesome-n4-active body.ie8Fix div#notifyMessage.notification div.notification-message span")).size()!=0)
   if(Browser.driver().findElements(By.xpath("//*[@id='notifyMessage']")).size()!=0)
	{
		//System.out.println("Requested report will be available in download section notification displayed. Navigate to Download report to get file");
		return true;
	}	
   return false;
}
public void DownloadReportFile(String reportSearchOption,String reportSearchValue) throws InterruptedException
{
	
	
	
	ClientUsersPrivilegesPage clientuserpage;

	clientuserpage = new ClientUsersPrivilegesPage();
	if(clientuserpage.clickHomeButton()== false)
		clientuserpage.clickMenuButton();
	
	clientuserpage.clickReporting();
	clientuserpage.clickDownloadReportstab();
	
	for(int i=0;i<10;i++)
	{
		clientuserpage.clickRefreshButton();
		Thread.sleep(3000);
		this.SearchFileBySelectCriteria(reportSearchOption,reportSearchValue);
		/*WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(Browser.driver().findElement(By.xpath("//*[contains(text(),'" + reportSearchValue + "')]"))));
		*/
			if(Browser.driver().findElements(By.xpath("//*[contains(text(),'" + reportSearchValue + "')]")).size()==1)
			{
				Browser.driver().findElement(By.xpath("//*[contains(text(),'" + reportSearchValue + "')]")).click();
				break;
			}
	
	}
	WebElement rightclick = Browser.driver().findElement(By.xpath("//*[contains(text(),'"+reportSearchValue+"')]"));
	
	Actions act = new Actions(Browser.driver());	
	act.contextClick(rightclick).build().perform();
	Browser.driver().findElement(By.id("btr-rptdownload-file")).click();
	Thread.sleep(15000);
	
}
public void SearchFileBySelectCriteria(String reportOption,
		String reportsearchValue) {

		this.selectsearchcriteria.click();
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);

		if (reportOption.trim().equalsIgnoreCase("ReportDescription")) {
			builder.moveToElement(this.reportDescription).click().perform();
		} else if (reportOption.trim().equalsIgnoreCase("ReportFormat")) {
			builder.moveToElement(this.repFormat).click().perform();
		} else if (reportOption.trim().equalsIgnoreCase("Report Type")) {
			builder.moveToElement(this.reportType).click().perform();
		}
		this.findReport.sendKeys(reportsearchValue);

}





}
