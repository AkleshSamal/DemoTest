package com.anz.selenium.comcards.PageObjects;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.anz.selenium.utilities.ScreenShot;
import com.anz.selenium.utilities.SpreadsheetData;
import com.anz.selenium.utilities.XMLUtil;



@RunWith(value = Parameterized.class)
public class BalanceSummaryTest {
		
		private static StringBuffer verificationErrors = new StringBuffer();
		private String Url;
		private String UserName;
		private String searchField;
		private String searchInput;
		private String options;
		private String resultsPath;
		private static Loginpage loginpage;
		private static BillingEntitySummaryPage summary;
		private static CardSummaryPage card;
		private static XMLUtil xmlutil;
		private static OperatingAccountPage operating;
		private static BalanceSummaryPage balSumPageObjects;
		private String browserType;

		@Before
		public void setUp() {

			loginpage = new Loginpage(browserType);
			summary=new BillingEntitySummaryPage();
			card=new CardSummaryPage();
			xmlutil=new XMLUtil();
			operating=new OperatingAccountPage();
			balSumPageObjects=new BalanceSummaryPage();
		}

		@Parameters
		public static Collection testData() throws Exception {
			InputStream spreadsheet = new FileInputStream(
					"src\\test\\resources\\BalanceSummaryTest.xls");
			return new SpreadsheetData(spreadsheet).getData();

		}

		// constructor
		public BalanceSummaryTest(String Url,String searchField,String searchInput,String options,String UserName,String browserType) {
			this.Url=Url;
			this.searchField=searchField;
			this.searchInput=searchInput;
			this.options=options;
			this.UserName=UserName;
			this.browserType=browserType;
			
		}

		@Test
		public void QuickSearchTest() throws Exception {

			try {
				
				resultsPath=xmlutil.createResultsFolder("QuickSearchTest");
				
				loginpage.load(Url);
				loginpage.loginUsername(UserName);
				summary.navigateToCardsSummaryScreen();
				summary.handleErrorMessagePopUp();
				ScreenShot.TakesScreenshot("search");
				summary.quickSearch(searchField, searchInput);
				operating.clickOperatingAccount();
				summary.selectCardDetails(options);
				balSumPageObjects.validateFooterSection();
				balSumPageObjects.validateRefreshIcon();
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();

				/*verificationErrors.append(e.toString());
				fail();*/
			}

		}

		@AfterClass
		public static void tearDown() throws Exception {
			
			Browser.closeAll();
			/*String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}*/

		}

	}



