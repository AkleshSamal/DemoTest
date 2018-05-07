package com.anz.selenium.comcards.PageObjects;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.anz.selenium.utilities.ScreenShot;

import static org.junit.Assert.*;

public class CardSummaryPage {

	
	@FindBy(id="cardSummaryPanel")
	private WebElement EmptyMessage;
	
	@FindBy(xpath="//a[contains(@title,'View Actions)]")
	private WebElement viewAction;
	
	@FindBy(xpath="//a[contains(@title,'Download Card Summary Data in CSV Format')]")
	private WebElement downloadButton;
	@FindBy(xpath="//div[contains(@class,'notification-message')]")
	private WebElement notificationpopUp;
	
	@FindBy(xpath="//*[@id='btr-cccard-summary-view-controllist-section']/span[3]/a")
	private WebElement viewActions;
	@FindBy(xpath="//input[contains(@type,'checkbox')]")
	private WebElement checkBox;
	
	@FindBy(id="btr-ccreplace-card-view")
	private WebElement replaceCard;
	@FindBy(xpath="//a[contains(@title,'Group Card Summary by Selected Criteria')]")
	private WebElement groupBy;
	
	@FindBy(xpath="//*[@id='btr-cccard-summary-view-controllist-section']/span[6]/input")
	private WebElement quickSearch;
	@FindBy(xpath="//*[@id='btr-cccard-summary-view-controllist-section']/span[6]/span[1]/a")
	private WebElement selectSearch;
	
	@FindBy(id="btr-ccelectronic-stmt-view-sub")
	private WebElement viewElectronicStatement;
	
	@FindBy(id="billingEntityNumber")
	private WebElement billingEntityField;
	
	@FindBy(xpath="//*[@id='btr-ccelectronic-stmt-view']/div[2]/a/i")
	private WebElement closeElectronicStatementPopUp;
	
	@FindBy(id="btr-cccancel-card-view")
	private WebElement cancelCard;
	@FindBy(id="btr-ccCardLimitChange-view")
	private WebElement cardLimitChange;
	@FindBy(id="ovrthecounterlimit")
	private WebElement overTheCounterLimit;
	@FindBy(id="spendcap")
	private WebElement snapCap;
	@FindBy(id="transactionlimit")
	private WebElement transactionLimit;
	@FindBy(id="$COLL$")
	private WebElement collapseAll;
	@FindBy(id="$EXP$")
	private WebElement expandAll;
	@FindBy(id="$DEF$")
	private WebElement collapseByDefault;
	
	@FindBy(xpath="//span[contains(@class,'slick-group-title)]")
	private WebElement groupTitle;
		
	@FindBy(id="btr-ccacct-activity-view-sub")
	private WebElement viewAccountActivity;
	
	@FindBy(id="btr-ccoutstanding-auth-view-sub")
	private WebElement viewOutStandingAuthorization;
	@FindBy(id="btr-ccdeclined-tx-view-sub")
	private WebElement viewDeclainedTransaction;
	@FindBy(id="btr-ccelectronic-stmt-view-sub")
	private WebElement electronicStatement;
	@FindBy(id="btr-ccreplace-card-view")
	private WebElement cardReplacement;
	@FindBy(id="btr-cccancel-card-view")
	private WebElement cardCancel;
	@FindBy(id="btr-ccCardLimitChange-view")
	private WebElement limitCardChange;
	@FindBy(id="btr-cardsummary-remembersettings")
	private WebElement rememberMySettings;
	
	
	@FindBy(id="btr-cccard-summary-view-tab")
	private WebElement CardSummaryTab;
	
	@FindBy(id="btr-ccbal-summary-view-tab")
	private WebElement balanceSummaryTab;
	@FindBy(id="btr-ccacct-activity-view-tab")
	private WebElement accountActivityTab;
	@FindBy(id="btr-ccoutstanding-auth-view-tab")
	private WebElement outStandingAuthorisationTab;
	@FindBy(id="btr-ccdeclined-tx-view-tab")
	private WebElement declainedTransactionTab;
	
	
	
	
	@FindBy(id="atmlimit")
	private WebElement ATMLimit;
	@FindBy(id="availablefunds")
	private WebElement availableFunds;
	@FindBy(id="cardnum")
	private WebElement cardNumber;
	@FindBy(id="cardstatus")
	private WebElement cardStatus;
	@FindBy(id="cardholdername")
	private WebElement cardHolderName;
	@FindBy(id="closedate")
	private WebElement closedDate;
	@FindBy(id="acctccy")
	private WebElement currency;
	@FindBy(id="lastupdated")
	private WebElement lastUpdated;
	@FindBy(id="opendate")
	private WebElement openDate;
	@FindBy(id="openingbal")
	private WebElement openingBalance;
	@FindBy(id="btr-cccancel-card-view")
	private WebElement cancelcard;
	@FindBy(xpath="//*[@id='grid-norecords']/p")
	private WebElement ErrorMsg;
	
	
	public CardSummaryPage(){
		PageFactory.initElements(Browser.driver(), this);
	}
	
	
	public String readEmptyData(){
		
		String message=this.EmptyMessage.getText();
		return message;
		
	}
	
	public void downloadEmptyGrid() throws Exception{
		
		this.downloadButton.click();
		Thread.sleep(2000);
		String s=this.notificationpopUp.getText();
		String d="No records found to download!";
		assertTrue(s.equals(d));
	}
	
	public void downloadGridData(){
		this.downloadButton.click();
		
	}
	
	public void groupByFunction(String groupBy){
		
	}
public void validateActions() throws Exception{
	
	
		
		List<String> al=new ArrayList<String>();
		al.add("View Account Activity");
		al.add("View Outstanding Authorizations");
		al.add("View Declined Authorizations");
		al.add("View Electronic statement");
		al.add("Replace Card");
		al.add("Cancel Card");
		al.add("Card Limit Change");
		al.add("Remember My Settings");
				
		List<String> al1=new ArrayList<String>();
		
		this.viewActions.click();
				
		
	}

public void quickSearchFunctionCardSummaryScreen(String accNumber){
	
	assertTrue(this.quickSearch.isDisplayed());
	
	this.selectSearch.click();

	this.quickSearch.sendKeys(accNumber);
	//need to add the row count
	
	

	
}

public void rightClickOnSingleCard() throws Exception{
	
	//OperatingAccountPage page=new OperatingAccountPage();
	//page.clickOperatingAccount();
	
	Thread.sleep(3000);
	Browser.driver().findElement(By.xpath("//*[@id='8281792d-14f1-3a36-8506-146128676ff7']/div[5]/div/div[4]/div[1]/input")).click();
	Thread.sleep(2000);
	Browser.driver().findElement(By.xpath("//*[@id='btr-cccard-summary-view-controllist-section']/span[3]/a")).click();
	
	this.viewElectronicStatement.click();
	Thread.sleep(2000);
	assertTrue(this.billingEntityField.isDisplayed());
	this.closeElectronicStatementPopUp.click();
	
}

public void ClickMultipleChecBoxSelectOptions(){
	
	
	WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
	wait.until(ExpectedConditions.visibilityOf(this.quickSearch));
	
	for(int i=7;i<=8;i++){
		
		
	
	Actions builder = new Actions(Browser.driver());
	
	
	List<WebElement> tableRows = Browser.driver().findElements(By.xpath("//input[@type='checkbox']"));
	System.out.println(tableRows.size());
	WebElement currentRow = tableRows.get(i);
	builder.click(currentRow.findElements(By.xpath("//input[@type='checkbox']")).get(i)).build().perform();
	
	
	
	}
}

public void validateLessThan11Records() throws Exception{
	OperatingAccountPage page=new OperatingAccountPage();
	page.clickOperatingAccount();
	assertTrue(this.cancelCard.isDisplayed());
	assertTrue(this.cardLimitChange.isDisplayed());
	
}

public void checkQuickSearchOption(String ATMLimit,String AvailableFunds,String cardNumber,
		String cardStatus,String cardHolderName,String closeDate,String currency,String lastUpdated,String openDate,
		String OpeningBalance) throws Exception{
	
	
	WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
	wait.until(ExpectedConditions.visibilityOf(this.quickSearch));
	//Actions builder=new Actions(Browser.driver());
	
	for(int i=1;i<=10;i++){
		
		//Thread.sleep(2000);
		if(i==1){
			this.selectSearch.click();
			this.ATMLimit.click();
			this.quickSearch.sendKeys(ATMLimit);
			Thread.sleep(2000);
			this.quickSearch.clear();
			
		}
		if(i==2){
			/*this.selectSearch.click();
			this.availableFunds.click();
			this.quickSearch.sendKeys(AvailableFunds);
			Thread.sleep(2000);
			this.quickSearch.clear();*/
		}
		if(i==3){
			this.selectSearch.click();
			this.cardNumber.click();
			this.quickSearch.sendKeys(cardNumber);
			Thread.sleep(2000);
			this.quickSearch.clear();
		}
		if(i==4){
			this.selectSearch.click();
			this.cardStatus.click();
			this.quickSearch.sendKeys(cardStatus);
			Thread.sleep(2000);
			this.quickSearch.clear();
		}
		if(i==5){
			this.selectSearch.click();
			this.cardHolderName.click();
			this.quickSearch.sendKeys(cardHolderName);
			Thread.sleep(2000);
			this.quickSearch.clear();
		}
		if(i==6){
			this.selectSearch.click();
			this.closedDate.click();
			this.quickSearch.sendKeys(closeDate);
			Thread.sleep(2000);
			this.quickSearch.clear();
		}
		if(i==7){
			/*this.selectSearch.click();
			this.currency.click();
			this.quickSearch.sendKeys(currency);
			Thread.sleep(2000);
			this.quickSearch.clear();*/
		}
		if(i==8){
			/*this.selectSearch.click();
			this.lastUpdated.click();
			this.quickSearch.sendKeys(lastUpdated);
			Thread.sleep(2000);
			this.quickSearch.clear();*/
		}
		if(i==9){
			this.selectSearch.click();
			this.openDate.click();
			this.quickSearch.sendKeys(openDate);
			Thread.sleep(2000);
			this.quickSearch.clear();
		}
		if(i==10){
			/*this.selectSearch.click();
			this.openingBalance.click();
			this.quickSearch.sendKeys(OpeningBalance);
			Thread.sleep(2000);
			this.quickSearch.clear();*/
		}
	}
	
	
}

public void rightClickSelectedAccount() throws Exception{
	
	Actions builder=new Actions(Browser.driver());
	
	builder.contextClick(Browser.driver().findElement(By.xpath("//*[@id='8281792d-14f1-3a36-8506-146128676ff7']/div[5]/div/div[7]/div[1]/input"))).build().perform();
	Thread.sleep(2000);
	assertTrue(this.cancelcard.isDisplayed());
	assertTrue(this.cardLimitChange.isDisplayed());
	
}

public void selectFirstRecord(){
	WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
	wait.until(ExpectedConditions.visibilityOf(this.quickSearch));
	Browser.driver().findElement(By.xpath("//*[@id='8281792d-14f1-3a36-8506-146128676ff7']/div[5]/div/div[7]/div[1]/input")).click();
}

public void actionsFunction(){
	
	this.viewActions.click();
	
	assertTrue(this.viewAccountActivity.isDisplayed());
	assertTrue(this.viewOutStandingAuthorization.isDisplayed());
	assertTrue(this.viewDeclainedTransaction.isDisplayed());
	assertTrue(this.electronicStatement.isDisplayed());
	assertTrue(this.cardReplacement.isDisplayed());
	assertTrue(this.cardCancel.isDisplayed());
	assertTrue(this.limitCardChange.isDisplayed());
	assertTrue(this.rememberMySettings.isDisplayed());
				
}

public void navigateFromActions() throws Exception{
	
	for(int i=1;i<=6;i++){
		
	if(i==1){
	
	this.viewOutStandingAuthorization.click();
	Thread.sleep(2000);
	assertTrue(this.outStandingAuthorisationTab.isEnabled());
	this.CardSummaryTab.click();
	}
	if(i==2){
		this.viewActions.click();
		this.viewDeclainedTransaction.click();
		Thread.sleep(2000);
		assertTrue(this.declainedTransactionTab.isEnabled());
		this.CardSummaryTab.click();
	}
	if(i==3){
		this.viewActions.click();
		this.replaceCard.click();
		WebDriverWait wait=new WebDriverWait(Browser.driver(), 120);
		wait.until(ExpectedConditions.visibilityOf(Browser.driver().findElement(By.xpath("//*[@id='btr-cccard-summary-view-controllist-section']/span[3]/a"))));
		assertTrue(Browser.driver().getPageSource().contains("New"));
		BillingEntitySummaryPage page=new BillingEntitySummaryPage();
		page.navigateToCardsSummaryScreen();
		
		
	}
	}
	
	
}
public void groupingFunction() throws Exception{
	
	Thread.sleep(6000);
	
	this.groupBy.click();
	
	assertTrue(this.ATMLimit.isDisplayed());
	assertTrue(this.cardStatus.isDisplayed());
	assertTrue(this.closedDate.isDisplayed());
	//assertTrue(this.currency.isDisplayed());
	assertTrue(this.openDate.isDisplayed());
	assertTrue(this.overTheCounterLimit.isDisplayed());
	assertTrue(this.snapCap.isDisplayed());
	assertTrue(this.transactionLimit.isDisplayed());
	assertTrue(this.collapseAll.isDisplayed());
	assertTrue(this.expandAll.isDisplayed());
	//assertTrue(this.collapseByDefault.isDisplayed());
	
	ScreenShot.TakesScreenshot("grouping");
		
	for(int i=1;i<=9;i++){
		
		Thread.sleep(2000);
		if(i==1){
			this.ATMLimit.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("ATm Limit"));
		}
		if(i==2){
			this.groupBy.click();
			this.cardStatus.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Card Status"));
		}
		if(i==3){
			
			this.groupBy.click();
			this.closedDate.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Close Date"));
		}
		if(i==4){
			//this.groupBy.click();
			//this.currency.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Currency"));
		}
		if(i==5){
			this.groupBy.click();
			this.openDate.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Open Date"));
		}
		if(i==6){
			this.groupBy.click();
			this.overTheCounterLimit.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Over The Counter"));
		}
		if(i==7){
			this.groupBy.click();
			this.snapCap.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Spend Cap"));
		}
		if(i==8){
			this.groupBy.click();
			this.transactionLimit.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Transaction"));
		}
		if(i==9){
			this.groupBy.click();
			this.transactionLimit.click();
			//String s=this.groupTitle.getText();
			//assertTrue(s.contains("Transaction"));
		}
	}
}
}

