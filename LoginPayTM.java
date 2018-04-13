package com.selenium.codp.LoginPage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPayTM {

	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='_3ac-'][text()='Log In/Sign Up']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='usern]ame'][@id='input_0']")).sendKeys("wwttt");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("input_1")).sendKeys("9886570789");
		
		driver.findElement(By.name("ng-scope")).click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
		
	

	}

}
