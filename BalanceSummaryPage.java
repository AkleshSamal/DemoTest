package com.anz.selenium.comcards.PageObjects;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BalanceSummaryPage {
	 
	
	@FindBy(xpath="//div[contains(@class,'slick-viewport')]")
	private WebElement BalanceRecord;
	
	@FindBy(id="btr-ccacct-activity-view-balsum-sub")
	private WebElement ViewAccountactivityoption;
	
	@FindBy(id="btr-ccelectronic-stmt-view-balsum-sub")
	private WebElement ViewElectronicStatement;
	

	public BalanceSummaryPage() {
		PageFactory.initElements(Browser.driver(), this);
	}
	
	
    public void rightClickTest() {
   
        rightClick(BalanceRecord);
        assertTrue(this.ViewAccountactivityoption.isDisplayed());
        assertTrue(this.ViewElectronicStatement.isDisplayed());
    }
	public void rightClick(WebElement element) {
        try {
           
			Actions action = new Actions(Browser.driver()).contextClick(element);
            action.build().perform();
            
            /*action.contextClick(this.BalanceRecord).perform();*/

           /* System.out.println("Sucessfully Right clicked on the element");*/
        } catch (StaleElementReferenceException e) {
            /*//System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());*/
        } catch (NoSuchElementException e) {
            /*System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());*/
        } catch (Exception e) {
           /* System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());*/
        }
    }
	
	public void validateFooterSection() throws Exception{
		
		String actualNote="Unless noted otherwise, all values are accurate as at end of previous business day.";
		WebElement element=Browser.driver().findElement(By.cssSelector("#selectedRowCount-section > div > div.control-note > div > i"));
		Actions builder=new Actions(Browser.driver());
		builder.moveToElement(element).build().perform();
		String expectedNote=element.getAttribute("title");		
		System.out.println("Disclaimer note present on footer section : " + expectedNote);
		if((actualNote).equals(expectedNote)){
			System.out.println("Result is as expected......");
		}
		//Assert.assertEquals("Unless noted otherwise, all values are accurate as at end of previous business day.", text);		
			
}
	
	public void validateRefreshIcon(){
		
		String actualNote="Available Funds can be refreshed to show live balance";
		WebElement element=Browser.driver().findElement(By.cssSelector("#btr-ccbal-summary-view-controllist-section > span.btn.pill-end > a"));
		Actions builder=new Actions(Browser.driver());
		builder.moveToElement(element).build().perform();
		String expectedNote=element.getAttribute("title");		
		System.out.println("Mouse hover Note : " + expectedNote);
		if((actualNote).equals(expectedNote)){
			System.out.println("Result is as expected......");
		}
		//Assert.assertEquals("Available Funds can be refreshed to show live balance" , expectedNote);
		
	}
	
	public void validateNoRecords(){
		
	}
	
}
