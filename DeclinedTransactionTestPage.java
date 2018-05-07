package com.anz.selenium.comcards.PageObjects;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.anz.selenium.utilities.AutoITUtil;
import com.anz.selenium.utilities.DBnAppData;
import com.anz.selenium.utilities.ScreenShot;
import com.anz.selenium.utilities.SpreadsheetData;
import com.anz.selenium.utilities.WebTableReport;
import com.anz.selenium.utilities.XMLUtil;

@RunWith(value = Parameterized.class)
public class DeclinedTransactionTestPage {

	private static StringBuffer verificationErrors = new StringBuffer();
	private String Url;
	private String UserName;
	private String searchField;
	private String searchInput;
	private String options;
	private String resultsPath;
	private String CardNumber;
	private String CardHolderName;
	private String Credit;
	private String Debit;
	private String DeclinedReason;
	private String MerchantGroup;
	private String MerchantNameandlocation;
	private String TxnDateTime;
	private static Loginpage loginpage;
	private static BillingEntitySummaryPage summary;
	private static CardSummaryPage card;
	private static XMLUtil xmlutil;
	private static AutoITUtil autosave;
	private static OperatingAccountPage operating;
	private static DeclinedTransactionPage declineTranPageObjects;
	private static WebTableReport webtableReport;
	private static DBnAppData appdata;
	private String browserType;
	private static String filePath;
	private String sqlQuery;
	private static ArrayList<String[]> dbData;

	@Before
	public void setUp() {

		loginpage = new Loginpage(browserType);
		summary = new BillingEntitySummaryPage();
		card = new CardSummaryPage();
		xmlutil = new XMLUtil();
		operating = new OperatingAccountPage();
		declineTranPageObjects = new DeclinedTransactionPage();
		appdata=new DBnAppData();
	}

	@Parameters
	public static Collection testData() throws Exception {
		InputStream spreadsheet = new FileInputStream(
				"src\\test\\resources\\DeclinedTransactionPage.xls");
		return new SpreadsheetData(spreadsheet).getData();

	}

	// constructor
	public DeclinedTransactionTestPage(String Url, String searchField,
			String searchInput, String options, String UserName,
			String browserType, String CardNumber, String CardHolderName,
			String Credit, String Debit, String DeclinedReason,
			String MerchantGroup, String MerchantNameandlocation,
			String TxnDateTime) {
		this.Url = Url;
		this.searchField = searchField;
		this.searchInput = searchInput;
		this.options = options;
		this.UserName = UserName;
		this.browserType = browserType;
		this.CardHolderName = CardHolderName;
		this.CardNumber = CardNumber;
		this.Credit = Credit;
		this.Debit = Debit;
		this.DeclinedReason = DeclinedReason;
		this.MerchantGroup = MerchantGroup;
		this.MerchantNameandlocation = MerchantNameandlocation;
		this.TxnDateTime = TxnDateTime;
	}

	@Test
	public void QuickSearchTest() throws Exception {

		try {

			resultsPath = xmlutil.createResultsFolder("QuickSearchTest");

			loginpage.load(Url);
			loginpage.loginUsername(UserName);
			ScreenShot.TakesScreenshot("login");
			summary.navigateToCardsSummaryScreen();
			summary.handleErrorMessagePopUp();
			ScreenShot.TakesScreenshot("summary");
			summary.quickSearch(searchField, searchInput);
			operating.clickOperatingAccount();
			summary.selectCardDetails(options);
			ScreenShot.TakesScreenshot("CardSummary");
			declineTranPageObjects.navigateToDeclineTransPage();
			ScreenShot.TakesScreenshot("Declinepage");
			declineTranPageObjects.validateDeclinedTransactionData();
			/*declineTranPageObjects.checkQuickSearchOption(CardNumber,
			 CardHolderName, Credit, Debit, DeclinedReason, MerchantGroup,
			 MerchantNameandlocation, TxnDateTime);*/
			//String FilePath=autosave.autoFileDownload(filePath,"DeclineTransactionGrid.csv", browserType);
			//declineTranPageObjects.downloadGridData();
			declineTranPageObjects.validateDeclineReasonValues();
			declineTranPageObjects.merchantGroupValue();
			declineTranPageObjects.validateQuickSearchOptions();
			declineTranPageObjects.validateRefreshIcon();
			declineTranPageObjects.validateFooterSection();
			// declineTranPageObjects.validateErrMsgDeclineTranPage();
			dbData=DBnAppData.getDbData(sqlQuery);
			

		} catch (Exception e) {
			e.printStackTrace();
		 verificationErrors.append(e.toString()); fail();
			 
		}

	}

	@AfterClass
	public static void tearDown() throws Exception {

		Browser.closeAll();
		
		 String verificationErrorString = verificationErrors.toString(); if
		 (!"".equals(verificationErrorString)) {
		 fail(verificationErrorString); }
		 

	}

}
