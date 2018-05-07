package com.anz.selenium.comcards.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	private static WebDriver driver;
	private static String URL="www.google.com";
	
	@FindBy(id="hplogo")
	private static WebElement googleLogo;
	
	@FindBy(id="q")
	private static WebElement inputBox;
	
	public Practice(){
		PageFactory.initElements(driver, this);
	}
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.get(URL);
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(googleLogo));
		inputBox.sendKeys("Selenium Interview Question");
		
	}

}
