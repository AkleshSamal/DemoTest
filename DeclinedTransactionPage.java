package com.anz.selenium.comcards.PageObjects;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.anz.selenium.utilities.WebTableReport;

public class DeclinedTransactionPage {

	@FindBy(xpath = "//div[contains(@class,'slick-viewport')]")
	private WebElement webTable;

	@FindBy(id = "btr-ccdeclined-tx-view-tab")
	private WebElement declinedTransactionTab;

	@FindBy(xpath = ".//*[@id='slickgrid_348330txdate']/span[1]")
	private WebElement rowDateTime;

	@FindBy(xpath = "//*[@id='slickgrid_49391cardnum']/span[1]")
	private WebElement rowCardNum;

	@FindBy(xpath = "//*[@id='slickgrid_49391cardholdername']/span[1]")
	private WebElement rowCardHolderName;

	@FindBy(xpath = "//*[@id='slickgrid_49391merchantnameandlocation']/span[1]")
	private WebElement rowMerchantNameLocation;

	@FindBy(xpath = "//*[@id='slickgrid_49391debit']/span[1]")
	private WebElement rowDebit;

	@FindBy(xpath = "//*[@id='slickgrid_49391credit']/span[1]")
	private WebElement rowCrebit;

	@FindBy(xpath = "//*[@id='slickgrid_49391merchantgroup']/span[1]")
	private WebElement rowMerchantGroup;

	@FindBy(xpath = "//*[@id='slickgrid_49391declinedreason']/span[1]")
	private WebElement rowDeclineReason;

	@FindBy(xpath = "//*[@id='btr-ccdeclined-tx-view-controllist-section']/span[4]/span[1]/a")
	private WebElement searchOption;

	@FindBy(id = "cardnum")
	private WebElement cardNumber;

	@FindBy(id = "cardholdername")
	private WebElement cardHolderName;

	@FindBy(id = "credit")
	private WebElement credit;

	@FindBy(id = "debit")
	private WebElement debit;

	@FindBy(id = "declinedreason")
	private WebElement declinedReason;

	@FindBy(id = "merchantgroup")
	private WebElement merchantGroup;

	@FindBy(id = "merchantnameandlocation")
	private WebElement merchantnameandLocation;

	@FindBy(id = "txdate")
	private WebElement txdateTime;

	@FindBy(xpath = "//a[@title='Download Declined Transactions Data in CSV Format']")
	private WebElement downloadButton;
	
	@FindBy(xpath="//a[@title='Select Search Criteria']")
	private WebElement selectSearch;
	
	@FindBy(xpath="//*[@id='btr-ccdeclined-tx-view-controllist-section']/span[4]/input")
	private WebElement searchField;

	public DeclinedTransactionPage() {
		PageFactory.initElements(Browser.driver(), this);
	}

	public void navigateToDeclineTransPage() {
		
		this.declinedTransactionTab.click();
		
	}

	public ArrayList<String[]> validateDeclinedTransactionData() {
		
		ArrayList<String[]> transactionData=new ArrayList<String[]>();
		//WebElement Wtable = this.webTable;
		WebTableReport wtab=new WebTableReport(Browser.driver().findElement(By.xpath("//div[contains(@class,'grid-canvas')]")));
		int rows=wtab.getRowCountReportDeclainTransaction();
		
		
		for (int i=1;i<=rows;i++){
			
			String[] str=new String[rows];
			int col=0;
			
			for(int j=1;j<=rows;j++){
				String cellVal=wtab.getDeclineCellData(i, j);
				System.out.println(cellVal);
				str[col]=cellVal;
				col++;			
			}
			transactionData.add(str);
			}
		return transactionData;
		
		//List<WebElement> rows = Wtable.findElements(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		//System.out.println("No of Rows in WebTable :- " + rows.size());
		/*for (int i = 0; i < rows.size(); i++) {
			WebElement irow = rows.get(i);
			System.out.println(irow.getText());
			List<WebElement> rcols = irow.findElements(By
					.tagName("//div[contains@class,'div.slick-cell']"));
			for (int j = 0; j < rcols.size(); j++) {
				WebElement icols = rcols.get(j);
				System.out.println(icols.getText());

			}
		}*/
	}

	public void validateErrMsgDeclineTranPage() {

		String actualValue = "There is no transaction information found for this selected period ";
		WebElement element = Browser.driver().findElement(By.xpath("//*[@id='grid-norecords']/p"));
		/*
		 * Actions builder=new Actions(Browser.driver());
		 * builder.moveToElement(element).build().perform();
		 */
		String expectedResult = element.getText();
		System.out.println("Error Message : " + expectedResult);
		Assert.assertEquals((actualValue).equals(expectedResult), true);
		if ((actualValue).equals(expectedResult)) {
			System.out.println("Result is matched....");
		} else {
			System.out.println("Result not matched....");
		}

	}

	
	// Validating Decline Reason Values
	public void validateDeclineReasonValues() {
		WebElement Wtable = this.webTable;
		
		 
		//WebTableReport wTable=new WebTableReport(Browser.driver().findElement(By.xpath("//div[contains(@class,'grid-canvas')]")));
	
		/*WebTableReport wTable=new WebTableReport(Browser.driver().findElement(By.xpath("//div[contains(@class,'slick-viewport')]")));
		int rowCount=wTable.getRowCountReportDeclainTransaction();*/
		
		
		List<WebElement> rows = Wtable.findElements(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		System.out.println("No of rows in Table :-" + rows.size());
		int row_num = 1;
		for (WebElement trElement : rows) {
			List<WebElement> column8 = trElement.findElements(By.xpath("//*[@id='0cf7df42-5fa2-308e-bb1e-1d8562aac793']/div[5]/div/div[1]/div[8]"));
			System.out.println("No of cols in Table :- " + column8.size());
			int col_num = 1;
			for (WebElement tdElement : column8) {
			System.out.println("row # " + row_num + ", col # " + col_num+ " text =" + tdElement.getText());
				col_num++;
			}
			row_num++;

		}

	}

	// Validating merchant group value
	public void merchantGroupValue() {

		WebElement wtable = this.webTable;
		List<WebElement> rows = wtable
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		System.out.println("No of rows in Table :-" + rows.size());
		int row_num = 1;
		for (WebElement trow : rows) {
			List<WebElement> column7 = trow
					.findElements(By
							.xpath("//*[@id='0cf7df42-5fa2-308e-bb1e-1d8562aac793']/div[5]/div/div/div[7]"));
			System.out.println("No of cols in the table = " + column7.size());
			int col_num = 1;
			for (WebElement tcol : column7) {
				System.out.println("row:- " + row_num + " , col # " + col_num
						+ " text =" + tcol.getText());
				col_num++;
			}
			row_num++;
		}

	}

	public void validateFooterSection() {

		String actualNote = "Only transactions declined by ANZ will appear here. ANZ does not have visibility of transactions declined outside of ANZ systems.";
		WebElement element = Browser.driver().findElement(
						By.xpath("//div[@id = '0cf7df42-5fa2-308e-bb1e-1d8562aac793-bottom-controls-section']/div[@id= 'selectedRowCount-section']/div/div[2]/div/i"));
		Actions builder = new Actions(Browser.driver());
		builder.moveToElement(element).build().perform();
		String expectedNote = element.getAttribute("title");
		System.out.println("Disclaimer note present on footer section : "
				+ expectedNote);
		if ((actualNote).equals(expectedNote)) {
			System.out.println("Result is as expected......");
		} else {
			System.out.println("Result not matched");
		}
	}

	public void validateRefreshIcon() {

		String actualNote = "Refresh";
		WebElement element = Browser.driver().findElement(
				By.xpath("//a[@title='Refresh']"));
		Actions builder = new Actions(Browser.driver());
		builder.moveToElement(element).build().perform();
		String expectedNote = element.getAttribute("title");
		System.out.println("Mouse hover Note : " + expectedNote);
		if ((actualNote).equals(expectedNote)) {
			System.out.println("Result is as expected......");
			// Assert.assertEquals("Refresh" , expectedNote);
		} else {
			System.out.println("Result not Matched");
		}

	}

	public void validateQuickSearchOptions() {

		this.searchOption.click();
		assertTrue(this.cardNumber.isDisplayed());
		assertTrue(this.cardHolderName.isDisplayed());
		assertTrue(this.credit.isDisplayed());
		assertTrue(this.debit.isDisplayed());
		assertTrue(this.declinedTransactionTab.isDisplayed());
		assertTrue(this.declinedReason.isDisplayed());
		assertTrue(this.merchantGroup.isDisplayed());
		assertTrue(this.merchantnameandLocation.isDisplayed());
		assertTrue(this.txdateTime.isDisplayed());
		System.out.println("Quick Search options are validated");

	}

	public void downloadGridData() {
		this.downloadButton.click();
	}
	
	public void checkQuickSearchOption(String CardNumber,String CardHolderName,String Credit,String Debit,String DeclinedReason,String MerchantGroup,String MerchantNameandlocation,String TxnDateTime) throws Exception{
		
		
		for(int i=1;i<=8;i++){
			
			if(i==1){
				this.selectSearch.click();
				this.searchField.sendKeys(CardNumber);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==2){
				this.selectSearch.click();
				this.searchField.sendKeys(CardHolderName);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==3){
				this.selectSearch.click();
				this.searchField.sendKeys(Credit);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==4){
				this.selectSearch.click();
				this.searchField.sendKeys(Debit);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==5){
				this.selectSearch.click();
				this.searchField.sendKeys(DeclinedReason);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==6){
				this.selectSearch.click();
				this.searchField.sendKeys(MerchantGroup);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==7){
				this.selectSearch.click();
				this.searchField.sendKeys(MerchantNameandlocation);
				Thread.sleep(2000);
				this.searchField.clear();
			}if(i==8){
				this.selectSearch.click();
				this.searchField.sendKeys(TxnDateTime);
				Thread.sleep(2000);
				this.searchField.clear();
			}				
			
		}
		
		
	}

}