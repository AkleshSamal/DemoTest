package com.anz.selenium.comcards.PageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.anz.selenium.utilities.WebTable;
import com.anz.selenium.utilities.WebTableReport;



public class OperatingAccountPage {

	@FindBy(xpath = "//*[@id='btr-accountsummary-controllist-section']/span[1]/a")
	private WebElement viewManageAccount;
	@FindBy(xpath = "//*[@id='btr-accountsummary-controllist-section']/span[2]/a")
	private WebElement groupByAccount;
	@FindBy(xpath = ".//*[@id='btr-accountsummary-controllist-section']/span[3]/a")
	private WebElement viewAction;
	@FindBy(xpath = "//*[@id='btr-accountsummary-controllist-section']/span[6]/span[1]/a/i[2]")
	private WebElement selectSearch;
	@FindBy(css = "div#btr-accountsummary-controllist-section.control-list span.search-field input.search-input")
	private WebElement findField;
	@FindBy(id = "$MNG$")
	private WebElement manageFolder;

	@FindBy(xpath = "//*[@id='btr-accountdetail-controllist-section']/span[2]/a")
	private WebElement AccountStatementReport;

	@FindBy(id = "servicerequest")
	private WebElement selfServiceRequest;

	@FindBy(id = "btr-acct-activity-view")
	private WebElement accountActivity;
	@FindBy(id = "btr-acct-history-view")
	private WebElement viewBalanceSummary;
	@FindBy(id = "btr-acct-stmt-req")
	private WebElement requestAccountStatement;
	@FindBy(id = "btr-acct-balhistory-req")
	private WebElement requestBalanceSummary;
	@FindBy(id = "btr-acct-smry-req")
	private WebElement requestAccountSummary;
	@FindBy(id = "btr-acct-service-request-view")
	private WebElement serviceRequest;

	@FindBy(id = "btr-acct-moveto-label")
	private WebElement moveTo;
	@FindBy(id = "TD")
	private WebElement today;
	@FindBy(id = "YD")
	private WebElement yesterday;
	@FindBy(id = "WY")
	private WebElement weekToYesterday;
	@FindBy(id = "PW")
	private WebElement preeviousWeek;
	@FindBy(id = "MY")
	private WebElement monthToYesterday;
	@FindBy(id = "PM")
	private WebElement preeviousMonth;
	@FindBy(id = "SD")
	private WebElement specificDate;
	@FindBy(id = "DR")
	private WebElement dateRange;

	@FindBy(id = "Request Account Statement")
	private WebElement accountActivityReport;
	@FindBy(css = "select.ui-datepicker-month")
	private WebElement selectMonth;

	@FindBy(css = "select.ui-datepicker-year")
	private WebElement selectYear;

	@FindBy(css = "div#ui-datepicker-div.ui-datepicker table.ui-datepicker-calendar tbody")
	private WebElement fromDateTable;

	@FindBy(css = "div.ui-datepicker-inline table.ui-datepicker-calendar tbody")
	private WebElement dateTable;

	@FindBy(css = "div.slick-viewport div.grid-canvas")
	private WebElement accountActivityTable;

	@FindBy(css = "div.slick-viewport")
	private WebElement operatingAcccountTable;

	@FindBy(id = "accounttype")
	private WebElement accountType;
	@FindBy(id = "bankname")
	private WebElement bankName;
	@FindBy(id = "compname")
	private WebElement company;
	@FindBy(id = "acctcntry")
	private WebElement country;
	@FindBy(id = "acctccy")
	private WebElement currency;
	@FindBy(id = "labelname")
	private WebElement folder;
	@FindBy(id = "$COLL$")
	private WebElement collapseAll;
	@FindBy(id = "$EXP$")
	private WebElement expandAll;
	@FindBy(id = "$DEF$")
	private WebElement collapseByDefault;

	@FindBy(xpath = "//*[@id='btr-accountsummary-controllist-section']/span[6]/span/a")
	private WebElement findSearch;
	@FindBy(xpath = "//*[@id='btr-accountsummary-controllist-section']/span[6]/input")
	private WebElement searchField;
	@FindBy(id = "acctname")
	private WebElement accountName;
	@FindBy(id = "acctnum")
	private WebElement accountNumber;
	@FindBy(id = "avlbal")
	private WebElement avalableBalance;
	@FindBy(id = "bankname")
	private WebElement BankName;
	@FindBy(id = "compname")
	private WebElement companyName;
	@FindBy(id = "acctcntry")
	private WebElement countryName;
	@FindBy(id = "acctccy")
	private WebElement currencyName;
	@FindBy(id = "ldgrbal")
	private WebElement ledgerBalance;
	@FindBy(id = "openavlbal")
	private WebElement openingAvailableBalance;
	@FindBy(id = "openldgrbal")
	private WebElement openingLedgerBalance;

	@FindBy(css = "div.slick-header")
	private WebElement row;

	@FindBy(id = "btr-set-ref-ccy")
	private WebElement setReferencyCurrency;
	@FindBy(id = "ul#userLabels.fixed-height li.active")
	private WebElement selectedCurrency;

	@FindBy(css = "select.ui-datepicker-month")
	private WebElement monthOption;

	@FindBy(css = "div#btr-acct-activity-viewCalDateRangeTo.hasDatepicker div.ui-datepicker-inline div.ui-datepicker-header div.ui-datepicker-title select.ui-datepicker-month")
	private WebElement lmonthOption;

	@FindBy(css = "select.ui-datepicker-year")
	private WebElement yearOption;

	@FindBy(css = "div#btr-acct-activity-viewCalDateRangeTo.hasDatepicker div.ui-datepicker-inline div.ui-datepicker-header div.ui-datepicker-title select.ui-datepicker-year")
	private WebElement lyearOption;

	@FindBy(css = "div#btr-acct-activity-viewCalDateRangeTo.hasDatepicker div.ui-datepicker-inline table.ui-datepicker-calendar tbody")
	private WebElement dateTable1;

	@FindBy(id = "btr-acct-activity-viewCalDateRangeBtnOk")
	private WebElement dateOKbutton;

	@FindBy(xpath = "//*[@id='header-section']/div[2]/div[1]/a/i")
	private WebElement navigationButton;
	@FindBy(id = "btr")
	private WebElement reporting;
	@FindBy(id = "accountsummary")
	private WebElement operatingAccount;

	@FindBy(xpath = "//*[@id='e9242ba2-869c-325e-bdae-2ce87286811d']/div[5]/div/div/div[1]/input")
	private WebElement operatinfAccountList;
	@FindBy(xpath = "//*[@id='btr-accountsummary-controllist-section']/span[3]/a")
	private WebElement actionButton;
	@FindBy(id = "btr-acct-service-request-view")
	private WebElement raiseServiceRequest;

	@FindBy(xpath = "/html/body/div/div[3]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div/span/input")
	private WebElement AllAccount;

	public OperatingAccountPage() {
		PageFactory.initElements(Browser.driver(), this);
	}

	public void viewmanageAccount() {
		assertTrue(this.viewManageAccount.isDisplayed());
		this.viewManageAccount.click();
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 20);
		Browser.driver().manage().timeouts()
				.implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void manageFolder() {
		this.manageFolder.click();
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 20);
		if (Browser.driver().getPageSource().contains("Encoding"));
	}

	// right click on the operating account
	public void clickOperatingAccount() throws InterruptedException {
		Thread.sleep(2000);

		Actions builder = new Actions(Browser.driver());
		List<WebElement> tableRows = Browser
				.driver()
				.findElements(
						By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(0);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(0);
		builder.contextClick(
				cell.findElements(By.xpath("//input[@type='checkbox']")).get(1))
				.build().perform();
		// WAIT
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 10);
		// wait.until(ExpectedConditions.visibilityOf(Browser.driver().findElement(By.id("btr-acct-activity-view"))));
	}

	public void selectReportTypes(String reports) throws InterruptedException {

		Thread.sleep(2000);
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);

		if (reports.equalsIgnoreCase("view Account Activity")) {
			builder.moveToElement(this.accountActivity).click().perform();

		} else if (reports.trim().equalsIgnoreCase("view Balance Summary")) {
			builder.moveToElement(this.viewBalanceSummary).click().perform();
		} else if (reports.trim().equalsIgnoreCase("Request Account Statement")) {
			builder.moveToElement(this.requestAccountStatement).click()
					.perform();
		} else if (reports.trim().equalsIgnoreCase("request Balance Summary")) {
			builder.moveToElement(this.requestBalanceSummary).click().perform();
		}

		else if (reports.trim().equalsIgnoreCase("Request Account Summary")) {
			builder.moveToElement(this.requestAccountSummary).click().perform();
		} else if (reports.trim().equalsIgnoreCase("Service Request")) {
			builder.moveToElement(this.serviceRequest).click().perform();
		} else if (reports.trim().equalsIgnoreCase("MoveTo")) {
			builder.moveToElement(this.moveTo).click().perform();
		}

	}

	public void selectDates(String dates) throws InterruptedException {
		// assertTrue(this.today.isDisplayed());
		Thread.sleep(2000);
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		if (dates.equalsIgnoreCase("Today")) {
			builder.moveToElement(this.today).click().perform();
		} else if (dates.trim().equalsIgnoreCase("yesterday")) {
			builder.moveToElement(this.yesterday).click().perform();
		} else if (dates.trim().equalsIgnoreCase("Week to yesterdey")) {
			builder.moveToElement(this.weekToYesterday).click().perform();
		} else if (dates.trim().equalsIgnoreCase("Previous week")) {
			builder.moveToElement(this.preeviousWeek).click().perform();
		} else if (dates.trim().equalsIgnoreCase("month to yesterday")) {
			builder.moveToElement(this.monthToYesterday).click().perform();
		} else if (dates.trim().equalsIgnoreCase("previous month")) {
			builder.moveToElement(this.preeviousMonth).click().perform();

		} else if (dates.trim().equalsIgnoreCase("Specific Date")) {
			builder.moveToElement(this.specificDate).click().perform();
		} else if (dates.trim().equalsIgnoreCase("Date Range")) {
			builder.moveToElement(this.dateRange).click().perform();

		}

		Thread.sleep(4000);

	}

	// verify the accountactivity webtable

	public void specificDate(int date, String month, int year) throws Exception {
		// this.fromDate.click();

		Thread.sleep(4000);
		// select year option
		Select yearoption = new Select(this.yearOption);
		assertFalse(yearoption.isMultiple());
		// assertEquals(1, yearoption.getOptions().size());
		String strYear = Integer.toString(year);
		yearoption.selectByVisibleText(strYear);

		// select month option
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
		// builder.moveToElement(this.specificDate).click().perform();
		// this.monthOption.click();
		Select month1 = new Select(this.monthOption);

		month1.selectByVisibleText(month);

		// Select monthoption = new Select(this.monthOption);
		// assertFalse(monthoption.isMultiple());
		// monthoption.selectByVisibleText(month);

		// select date
		WebTable calendarTable = new WebTable(this.dateTable);
		int i = calendarTable.getRowCount();
		int j = calendarTable.getColumnCount();

		outerloop: for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				String dateSelect = calendarTable.getCellData(k, l);
				if (!(dateSelect.trim().isEmpty())) {
					// convert String to Integer
					int idateSelect = Integer.parseInt(dateSelect);
					if (idateSelect == date) {
						WebElement cell = calendarTable
								.selectCellCalendar(k, l);
						String linkclass = cell.getAttribute("class");
						if (!linkclass.contains("disabled")) {
							calendarTable.selectCellCalendar(k, l).click();
							break outerloop;
						}

					}
				}
			}
		}

	}

	public void selectDateRange(int date, String month, int year, int ldate,
			String lmonth, int lyear) throws Exception {

		this.specificDate(date, month, year);
		// select year
		Select yearoption = new Select(this.lyearOption);
		assertFalse(yearoption.isMultiple());
		// assertEquals(1, yearoption.getOptions().size());
		String strYear = Integer.toString(lyear);
		yearoption.selectByVisibleText(strYear);

		// select month

		// Get the Dropdown as a Select using it's name attribute
		Select monthoption = new Select(this.lmonthOption);

		// Verify Dropdown does not support multiple selection
		assertFalse(monthoption.isMultiple());

		// Verify Dropdown has four options for selection
		// assertEquals(2, monthoption.getOptions().size());

		// select by visible Text
		monthoption.selectByVisibleText(lmonth);

		// assertEquals("Aug", monthoption.getFirstSelectedOption().getText());

		// select date
		WebTable calendarTable = new WebTable(this.dateTable1);
		int i = calendarTable.getRowCount();
		int j = calendarTable.getColumnCount();

		outerloop: for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				String dateSelect = calendarTable.getCellData(k, l);
				if (!(dateSelect.trim().isEmpty())) {
					// convert String to Integer
					int idateSelect = Integer.parseInt(dateSelect);
					if (idateSelect == ldate) {
						WebElement cell = calendarTable
								.selectCellCalendar(k, l);
						String linkclass = cell.getAttribute("class");
						if (!linkclass.contains("disabled")) {
							calendarTable.selectCellCalendar(k, l).click();

							break outerloop;
						}

					}
				}
			}
		}
		// for from date
		String fDatex = null;
		// check for attribute
		// String ftextval =
		// Browser.driver().findElement(By.xpath("//a[@title='Filter By Date or Date Range']")).getText();
		if (date <= 9) {
			// add zero before
			fDatex = 0 + "" + date;
		} else {
			fDatex = "" + date;
		}
		String confDate = month + " " + fDatex + "," + " " + year;
		// for to date
		String eDatex = null;
		// check for attribute

		if (ldate <= 9) {
			// add zero before
			eDatex = 0 + "" + ldate;
		} else {
			eDatex = "" + ldate;
		}
		String conEDate = lmonth + " " + eDatex + "," + " " + lyear;
		String ExpectedDatedisplay = confDate + "-" + conEDate;
		// assertEquals(eTextval,ExpectedDatedisplay);
		// click OK

	}

	public String getOperatingBalanceDetails() {
		WebTableReport wtTable = new WebTableReport(this.operatingAcccountTable);
		int iRowCount = wtTable.getRowCountReport();

		String AccountNumber = wtTable.getCellDataReport(1, 3);

		return AccountNumber;

	}

	public String getOperatingBalanceCurrency() {
		WebTableReport wtTable = new WebTableReport(this.operatingAcccountTable);
		int iRowCount = wtTable.getRowCountReport();

		String Currency = wtTable.getCellDataReport(1, 7);

		return Currency;

	}

	public void groupAccount(String Accounts) {

		this.groupByAccount.click();
		Actions builder = new Actions(Browser.driver());
		Browser.driver().manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);

		if (Accounts.equalsIgnoreCase("AccountType")) {
			builder.moveToElement(this.accountType).click().perform();
		} else if (Accounts.equalsIgnoreCase("Bank Name")) {
			builder.moveToElement(this.bankName).click().perform();

		} else if (Accounts.equalsIgnoreCase("Company")) {
			builder.moveToElement(this.company).click().perform();

		} else if (Accounts.equalsIgnoreCase("Country")) {
			builder.moveToElement(this.country).click().perform();

		} else if (Accounts.equalsIgnoreCase("Currency")) {
			builder.moveToElement(this.currency).click().perform();

		} else if (Accounts.equalsIgnoreCase("Folder")) {
			builder.moveToElement(this.folder).click().perform();

		} else if (Accounts.equalsIgnoreCase("CollapseAll")) {
			builder.moveToElement(this.collapseAll).click().perform();

		} else if (Accounts.equalsIgnoreCase("ExpandAll")) {
			builder.moveToElement(this.expandAll).click().perform();

		} else if (Accounts.equalsIgnoreCase("CollapseBydefault")) {
			builder.moveToElement(this.collapseByDefault).click().perform();

		}

	}

	public String selectSearchCriteria(String findSearch, String searchField) {

		this.selectSearch.click();
		Actions builder = new Actions(Browser.driver());

		if (findSearch.trim().equalsIgnoreCase("Account Name")) {
			builder.moveToElement(this.accountName).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Account Number")) {
			builder.moveToElement(this.accountNumber).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Available Balance")) {
			builder.moveToElement(this.avalableBalance).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Bank Name")) {
			builder.moveToElement(this.BankName).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Company")) {
			builder.moveToElement(this.companyName).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Country")) {
			builder.moveToElement(this.countryName).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Currency")) {
			builder.moveToElement(this.currencyName).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase("Ledger balance")) {
			builder.moveToElement(this.ledgerBalance).click().perform();
		} else if (findSearch.trim().equalsIgnoreCase(
				"Opening Available Balance")) {
			builder.moveToElement(this.openingAvailableBalance).click()
					.perform();
		} else if (findSearch.trim().equalsIgnoreCase("Opening Ledger Balance")) {
			builder.moveToElement(this.openingLedgerBalance).click().perform();
		}

		this.searchField.sendKeys(searchField);
		return searchField;
	}

	// get the row count
	public void getColCount(String company) {
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("div#btr-rptdownload-controllist-section.control-list span.btn a")));

		WebTableReport WtReport = new WebTableReport(this.row);
		int s = WtReport.getColumnCountReport();
		for (int i = 1; i <= s; i++) {
			String s1 = WtReport.getCellDataReport(i, 2);
			assertTrue(s1.equalsIgnoreCase(company));
		}

	}

	//
	public String getOpeningAvailableBalance(String OpAvaBalance) {

		WebTableReport wtTable = new WebTableReport(
				this.operatingAcccountTable);
		int icolName = wtTable.getColumnTextReport(OpAvaBalance);
		int iRowCount = wtTable.getRowCountReport();

		String Currency = wtTable.getCellDataReport(1, icolName);

		return Currency;

	}

	public String getReferencyCurrencySettings() throws InterruptedException {
		// click view actions
		String s = null;
		this.viewAction.click();
		Thread.sleep(4000);
		Actions builder = new Actions(Browser.driver());
		// click refCurrency
		builder.moveToElement(this.setReferencyCurrency).click().perform();

		List<WebElement> lst = Browser.driver().findElements(
				By.cssSelector("ul#userLabels.fixed-height li"));
		if (lst.size() > 0) {
			for (WebElement web : lst) {

				if (web.getAttribute("class").equals("active")) {
					s = web.getText();

				}

			}
		}
		// click on account number
		this.findSearch.click();
		return s;

	}

	// get the Application data from the operating Accounts
	public ArrayList<String[]> getOPAccountsDataValue(String... s) {
		WebTableReport wtTable = new WebTableReport(
				this.operatingAcccountTable);

		ArrayList<String[]> lstarray = new ArrayList<String[]>();
		// declare array
		String[] aData = new String[s.length];
		// row count
		int iRow = wtTable.getRowCountReport();
		for (int i = 0; i < iRow; i++) {
			for (int j = 0; j < s.length; j++) {

				int position = wtTable.getColumnTextReport(s[j]);

				if (s[j].equals("Ledger Balance")) {
					position = 11;
				}
				if (s[j].equals("Exchange Rate")) {
					position = 12;
				}

				System.out.println(position);
				// get cell data
				i = i + 1;
				aData[j] = wtTable.getCellDataReport(i, position);
				i = i - 1;
				System.out.println(aData[j]);
			}
			lstarray.add(aData);
		}
		return lstarray;

	}

	// get Exchage rate
	public ArrayList<String> getExchangeRate(String ExchangeRate) {

		ArrayList<String> lst = new ArrayList<String>();
		int icolName = 0;
		WebTableReport wtTable = new WebTableReport(
				this.operatingAcccountTable);
		if (ExchangeRate.equals("Exchange Rate")) {
			icolName = 12;
		}

		int iRowCount = wtTable.getRowCountReport();
		for (int i = 0; i < iRowCount; i++) {
			i = i + 1;
			String Currency = wtTable.getCellDataReport(i, icolName);
			i = i - 1;
			lst.add(Currency);
		}
		return lst;

	}

	public void clickOKbutton() {
		this.dateOKbutton.click();
	}

	// click running balance
	public void clickRunningbalance() throws InterruptedException {

		Thread.sleep(2000);
		WebElement sortIndicator = Browser.driver().findElement(
				By.xpath("//span[contains(text(),'Running Balance')]"));
		sortIndicator.click();
		Thread.sleep(3000);
		String sortIndicatortext = Browser
				.driver()
				.findElement(
						By.xpath("//span[contains(@class,'slick-sort-indicator slick-sort-indicator')]"))
				.getText();
		System.out.println(sortIndicatortext);
		WebElement sortIndicator2 = Browser
				.driver()
				.findElement(
						By.xpath("//span[contains(@class,'slick-sort-indicator slick-sort-indicator')]"));
		System.out.println(sortIndicator2.getAttribute("class"));
		Thread.sleep(5000);
		if (sortIndicator2.getAttribute("class").contains("desc")) {
			Browser.driver()
					.findElement(
							By.xpath("//span[contains(text(),'Running Balance')]"))
					.click();

		}
		Thread.sleep(8000);
	}

	public void navigateOperatingAccountScreen() throws Exception {
		Thread.sleep(5000);
		this.navigationButton.click();
		Thread.sleep(2000);

		this.reporting.click();
		Thread.sleep(2000);
		this.operatingAccount.click();
		Thread.sleep(3000);

	}

	public void navigateServiceRequest() throws Exception {
		Thread.sleep(3000);
		this.navigationButton.click();
		Thread.sleep(2000);

		this.selfServiceRequest.click();

	}

	public void selectOperatingAccount() throws Exception {
		Thread.sleep(2000);
		this.operatinfAccountList.click();
		Thread.sleep(2000);
		this.selectAction();

	}

	public void selectAction() throws Exception {
		Thread.sleep(2000);
		this.actionButton.click();
		Thread.sleep(2000);
		this.raiseServiceRequest.click();
		// Thread.sleep(2000);
		// IMPLICIT WAIT
		WebDriverWait wait4 = new WebDriverWait(Browser.driver(), 30);
		WebElement element4 = wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("Other request")));

		assertTrue(Browser.driver().getPageSource()
				.contains("What does your request relate to?"));

	}

	public void allAccounts() throws Exception {
		Thread.sleep(2000);
		this.AllAccount.click();
		Thread.sleep(2000);
		this.actionButton.click();
		assertTrue(!this.serviceRequest.isDisplayed());

	}

	public void navigateToAccountActvity() {

	}

}