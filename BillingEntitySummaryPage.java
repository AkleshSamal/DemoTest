package com.anz.selenium.comcards.PageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.anz.selenium.utilities.ScreenShot;
import com.anz.selenium.utilities.WebTableReport;

import static org.junit.Assert.*;


public class BillingEntitySummaryPage {
	
	
	@FindBy(xpath="//*[@id='header-section']/div[2]/div[1]/a/i")
	private WebElement navigationButton;
	@FindBy(id="btr")
	private WebElement reporting;
	@FindBy(id="sr")
	private WebElement serviceRequest;
	@FindBy(id="ccaccountsummary")
	private WebElement comcardsSummaryTab;
	@FindBy(xpath="//input[contains(@class,'search-input')]")
	private WebElement searchAccount;
	
	@FindBy(xpath="//*[@id='btr-ccaccountsummary-controllist-section']/span[6]/span[1]/a/i[2]")
	private WebElement searchOptions;
	
	@FindBy(id="$MNG$")
	private WebElement manageFolder;
	@FindBy(xpath="//a[contains(@title,'Select Search Criteria')]")
	private WebElement clickSearchButton;
	@FindBy(id="availablefunds")
	private WebElement availableFunds;
	@FindBy(id="acctname")
	private WebElement billingEntityname;
	@FindBy(id="acctnum")
	private WebElement billingEntityNumber;
	@FindBy(id="acctstatus")
	private WebElement billingEntityStatus;
	@FindBy(id="compname")
	private WebElement companyName;
	@FindBy(id="acctccy")
	private WebElement Currency;
	@FindBy(id="lastupdated")
	private WebElement lastUpdated;
	@FindBy(id="minpymtdue")
	private WebElement minimumPaymentDue;
	@FindBy(id="openingbal")
	private WebElement openingBalance;
	@FindBy(id="pymtduedate")
	private WebElement paymentDuedate;
	@FindBy(id="producttype")
	private WebElement productType;
	@FindBy(id="totallimit")
	private WebElement totalLimit;
	@FindBy(id="unalloclimit")
	private WebElement allocatedLimit;
	
	@FindBy(xpath="//a[contains(@title,'View and Manage Account Folders')]")
	private WebElement folder;
	@FindBy(id="newLabel")
	private WebElement folderName;
	@FindBy(id="saveLabel")
	private WebElement addFolder;
	@FindBy(id="dbtnOk")
	private WebElement okButtonFolder;
	@FindBy(id="btr-ccmove-to")
	private WebElement moveTo;
	@FindBy(css="div#controlSubMenus.control-menus div#labelActionMenu.control-menu ul.fixed-height li")
	private WebElement selectFolder;
	
	@FindBy(id="btr-cccard-summary-view")
	private WebElement viewCardSummary;
	@FindBy(id="btr-ccacct-activity-view")
	private WebElement viewAccountActivity;
	@FindBy(id="btr-ccoutstanding-auth-view")
	private WebElement viewOutstatdingAuthorisation;
	
	@FindBy(id="btr-ccdeclined-tx-view")
	private WebElement viewDeclainedTransaction;
	@FindBy(id="btr-ccbal-summary-view")
	private WebElement viewBalanceSummary;
	@FindBy(id="btr-ccelectronic-stmt-view")
	private WebElement viewElectronicStatements;
	@FindBy(xpath="//a[contains(@title,'Close Message')]")
	private WebElement closeErrorMessage;
	
	@FindBy(xpath="//*[@id='sr-cmrlist-controllist-section']/span[1]/a")
	private WebElement newServiceRequest;
	public BillingEntitySummaryPage(){
		PageFactory.initElements(Browser.driver(), this);
					
		}
		
	public void navigateToCardsSummaryScreen(){
		
		WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
		wait.until(ExpectedConditions.visibilityOf(this.navigationButton));
		this.navigationButton.click();
		this.reporting.click();
		this.comcardsSummaryTab.click();
		
		
		wait.until(ExpectedConditions.visibilityOf(this.searchAccount));
		//assertTrue(this.manageFolder.isDisplayed());
	}
	
	public void quickSearchFunction(String availableFunds,String billingEntityName,String billingEntityNumber,
			String billingEntityStatus,String CompanyName,String currency,String lastUpdated,String minimumPaymentDue,
			String openingBalance,String paymentDuedate,String productType,String totalLimit,String allocatedLimit){
		
		
		for(int i=0;i<=13;i++){
				
		if(i==0){
			if(availableFunds!=null){
			this.clickSearchButton.click();
			this.availableFunds.click();
			this.searchAccount.sendKeys(availableFunds);
			WebTableReport wtTable=new WebTableReport();
		//int rowNumber=	wtTable.getRowCountReport();
			//assertTrue(rowNumber==1);
			
			
			}
		}
		
		if(i==1){
			if(billingEntityname!=null){
				this.clickSearchButton.click();
				this.billingEntityname.click();
				this.searchAccount.sendKeys(billingEntityName);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}
		if(i==2){
			if(billingEntityNumber!=null){
				this.clickSearchButton.click();
				this.billingEntityNumber.click();
				this.searchAccount.sendKeys(billingEntityNumber);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}
		if(i==3){
			if(billingEntityStatus!=null){
				this.clickSearchButton.click();
				this.billingEntityStatus.click();
				this.searchAccount.sendKeys(billingEntityStatus);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}
		if(i==4){
			if(companyName!=null){
				this.clickSearchButton.click();
				this.companyName.click();
				this.searchAccount.sendKeys(CompanyName);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}
		if(i==5){
			if(Currency!=null){
				this.clickSearchButton.click();
				this.Currency.click();
				this.searchAccount.sendKeys(currency);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}
		if(i==6){
			if(lastUpdated!=null){
				this.clickSearchButton.click();
				this.lastUpdated.click();
				this.searchAccount.sendKeys(lastUpdated);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}
		if(i==7){
			if(openingBalance!=null){
				this.clickSearchButton.click();
				this.openingBalance.click();
				this.searchAccount.sendKeys(openingBalance);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
			//	assertTrue(rowNumber==1);
				
				
				}
			
		}	
		if(i==8){
			if(paymentDuedate!=null){
				this.clickSearchButton.click();
				this.paymentDuedate.click();
				this.searchAccount.sendKeys(paymentDuedate);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}	
		if(i==9){
			if(productType!=null){
				this.clickSearchButton.click();
				this.productType.click();
				this.searchAccount.sendKeys(productType);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}	
		
		if(i==10){
			if(totalLimit!=null){
				this.clickSearchButton.click();
				this.totalLimit.click();
				this.searchAccount.sendKeys(totalLimit);
				WebTableReport wtTable=new WebTableReport();
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}	
		if(i==11){
			/*if(allocatedLimit!=null){
				this.clickSearchButton.click();
				this.allocatedLimit.click();
				this.searchAccount.sendKeys(allocatedLimit);
				WebTableReport wtTable=new WebTableReport();*/
			//int rowNumber=	wtTable.getRowCountReport();
				//assertTrue(rowNumber==1);
				
				
				}
			
		}	
			
		
		
	}
	
	public void createmanageFolder(String folderName) throws Exception{
		Thread.sleep(2000);
		this.searchAccount.clear();
		this.folder.click();
		this.manageFolder.click();
		this.folderName.sendKeys(folderName);
		Thread.sleep(2000);
		this.addFolder.click();
		Thread.sleep(2000);
		this.okButtonFolder.click();
		WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
		wait.until(ExpectedConditions.visibilityOf(this.searchAccount));
		this.searchAccount.clear();
	}
	
	public void moveRecordsToFolder() throws Exception{
		OperatingAccountPage operating= new OperatingAccountPage();
		operating.clickOperatingAccount();
		this.moveTo.click();
		Thread.sleep(2000);
		this.selectFolder.click();
	}

public void navigateServicerequest() throws Exception{
		
		WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
		wait.until(ExpectedConditions.visibilityOf(this.navigationButton));
		this.navigationButton.click();
		this.serviceRequest.click();
		Thread.sleep(2000);
		this.comcardsSummaryTab.click();
		Thread.sleep(2000);
		this.newServiceRequest.click();
		
		//wait.until(ExpectedConditions.visibilityOf(this.searchAccount));
		//assertTrue(this.manageFolder.isDisplayed());
	}

public ArrayList<String> UI(){
	
	ArrayList<String> data=new ArrayList<String>();
	
	
	data.add("Nidheesh");
	data.add("unni");
	
	//str[1]={"New Cardholder Request","Statement Preferences","Card Limit Change"};
	
	
	
	
	
	return data;
	
}

public void quickSearch(String searchField,String searchInput){
	this.searchOptions.click();
	
	Actions builder=new Actions(Browser.driver());
	
	if(searchField.trim().equalsIgnoreCase("Available Funds")){
		builder.moveToElement(this.availableFunds).click().perform();
		
	}
	else if(searchField.trim().equalsIgnoreCase("Billing Entity Name")){
		builder.moveToElement(this.billingEntityname).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Billing Entity Number")){
		builder.moveToElement(this.billingEntityNumber).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Billing Entity Status")){
		builder.moveToElement(this.billingEntityStatus).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Company Name")){
		builder.moveToElement(this.companyName).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Currency")){
		builder.moveToElement(this.Currency).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Last Updated")){
		builder.moveToElement(this.lastUpdated).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Minimum Payment Due")){
		builder.moveToElement(this.minimumPaymentDue).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Opening Balance")){
		builder.moveToElement(this.openingBalance).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Payment Due Date")){
		builder.moveToElement(this.paymentDuedate).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Product Type")){
		builder.moveToElement(this.productType).click().perform();
	}
	else if(searchField.trim().equalsIgnoreCase("Total Limit")){
		builder.moveToElement(this.totalLimit).click().perform();
	}
	
	this.searchAccount.sendKeys(searchInput);
}
	public void selectCardDetails(String options){
		
		
		
		
		Actions builder =new Actions(Browser.driver());
		
		if(options.trim().equalsIgnoreCase("View Card Summary")){
			builder.moveToElement(this.viewCardSummary).click().perform();
		}
		if(options.trim().equalsIgnoreCase("View Account Activity")){
			builder.moveToElement(this.viewAccountActivity).click().perform();
		}
		if(options.trim().equalsIgnoreCase("View Outstanding Authorisation")){
			builder.moveToElement(this.viewOutstatdingAuthorisation).click().perform();
		}
		if(options.trim().equalsIgnoreCase("View Declined Transactions")){
			builder.moveToElement(this.viewDeclainedTransaction).click().perform();
		}
		if(options.trim().equalsIgnoreCase("View Balance Summary")){
			builder.moveToElement(this.viewBalanceSummary).click().perform();
			//ScreenShot.TakesScreenshot("screenShotName");
		}
		
	}
	public void handleErrorMessagePopUp(){
		this.closeErrorMessage.click();
	}
	
	public void validateActions(){
		
		List<String> al=new ArrayList<String>();
		al.add("View Account Activity");
		al.add("View Outstanding Authorizations");
		al.add("View Declined Authorizations");
		al.add("View Electronic statement");
		al.add("Replace Card");
		al.add("Cancel Card");
		al.add("Card Limit Change");
		
		
		List<String> al1=new ArrayList<String>();
		
		
		
		
		
	}
}
