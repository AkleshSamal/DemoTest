package com.selenium.codp.LoginPage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.selenium.PDFverificationPage.PDFVerification;
import com.selenium.codp.utilities.SpreadsheetData;
import com.selenium.codp.LoginPage.Browser;




@RunWith(value=Parameterized.class)
public class CodpLoginTestPage {

	private static CodpLoginPage loginPage;
	private static Browser browser;
	private static EntitiesProductTab entityProductTab;
	private static PDFVerification pdfverification;
	
	//Declaring variables
	
	private String userName;
	private String password;
	private String browserType;
	
	@Before
	public void setup(){
		loginPage=new CodpLoginPage(browserType);
		browser=new Browser();	
		entityProductTab=new EntitiesProductTab(); 
		pdfverification=new PDFVerification();
	}
	@Parameters
	public static Collection testData() throws Exception {
		InputStream spreadsheet = new FileInputStream("CodpLoginTestPage.xlsx");
		return new SpreadsheetData(spreadsheet).getData();
		}
	
	public CodpLoginTestPage(String browserType,String userName,String password){
		this.userName=userName;
		this.password=password;
		this.browserType=browserType;		
	}
	@Test
	public void loginTest() throws Exception{
		try{
		//pdfverification.readData();
		loginPage.load();
		System.out.println("Browser loaded successfully");
		loginPage.loginToApp(userName, password);
		System.out.println("Entered user credentials successfully");
		loginPage.navigateToCodpForm();
		entityProductTab.clickEntityTab();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown(){
		Browser.close();
		
	}
}
