package com.selenium.codp.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntitiesProductTab {
	
	@FindBy(linkText="People")
	private WebElement peopleAccordion;
	
	@FindBy(how=How.ID,using="afIFrame")
	private WebElement frame;
	
	@FindBy(linkText="Entities & Products")
	private WebElement EntitiesTab;
	
	WebDriverWait wait;
	
	public EntitiesProductTab(){
		PageFactory.initElements(Browser.driver(), this);
		
	}
	
	public void clickEntityTab(){
		wait=new WebDriverWait(Browser.driver, 30);
		System.out.println("Driver current url : "+ Browser.driver.getCurrentUrl());
		Browser.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Browser.driver.switchTo().frame(frame);
		this.EntitiesTab.click();
		this.peopleAccordion.click();
		//Browser.driver.findElement(By.linkText("Entities & Products")).click();
		//Browser.driver.findElement(By.id("guideContainer-rootPanel-group-panel-guidetextbox___widget")).sendKeys("Aklesh");
		//Browser.driver.switchTo().frame(arg0);		                                          
		
	}

}
