package com.selenium.codp.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodpLoginPage {
	
	private String url= "https://nonprod-cobdpworkflow-tst/";
	
	WebDriverWait wait=null;
	
	@FindBy(id="loginForm:j_username")
	private WebElement userName;
	
	@FindBy(id="loginForm:j_password")
	private WebElement password;
	
	@FindBy(id="loginForm:submitButton")
	private WebElement submit;
	
	@FindBy(linkText="here")
	private WebElement linkToLogin;
	
	//@FindBy(linkText="Customer On-Boarding")
	//private WebElement OnboardingForm;
	
	@FindBy(xpath="//*[@id='content']/div[3]/div[2]/div/ul/li/div[2]/a")
	private WebElement OnboardingForm1;
	
	
	public CodpLoginPage(String browserType){
		Browser.setup(browserType.trim());
		PageFactory.initElements(Browser.driver(), this);
		
	}
	
	public void load() {
		
		try {
			Browser.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void loginToApp(String userName, String password) {
		
		wait=new WebDriverWait(Browser.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(this.linkToLogin));
		this.linkToLogin.click();
		wait.until(ExpectedConditions.visibilityOf(this.userName));
		this.userName.clear();
		this.userName.sendKeys(userName);
		this.password.clear();
		wait.until(ExpectedConditions.visibilityOf(this.password));
		this.password.sendKeys(password);
		this.submit.click();  
		// WebDriverWait wait = new WebDriverWait(driver, 10);
	}
	
	public void navigateToCodpForm(){
		wait=new WebDriverWait(Browser.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(OnboardingForm1));
		this.OnboardingForm1.click();
	//S	return Browser.driver;
		
	}
	
	public void close() {
		Browser.close();
		
	}
	
	
	
}
