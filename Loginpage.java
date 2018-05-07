package com.anz.selenium.comcards.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.junit.Assert.*;

public class Loginpage extends LoadableComponent<Loginpage> {

	@FindBy(id = "j_username")
	private WebElement userName;
	@FindBy(id = "j_password")
	private WebElement password;
	@FindBy(id = "loginSubmit")
	private WebElement Submit;
	@FindBy(id = "plainuser")
	private WebElement caasUsername;
	
	@FindBy(css = "div#Submit_Button.submitButton span a")
	private WebElement caasUsernameSubmit;
	@FindBy(id = "USER_PASSWORD")
	private WebElement caasPassword;
	
	@FindBy(xpath = "//*[@id='id_btn_logon_token']/a")
	private WebElement caasPasswordSubmit;

	//private String Url = "https://trntbos.stganztransactiveclient01.online.ecom.anz/stage/channel/login.html";
	// private String Url =
	// "https://trntbos.pnvanztransactiveclient01.online.ecom.anz/home/channel/login.html";
	private String title = "ANZ Transactive";
	
	
	@FindBy(id="htmlPASSWORD")
	private WebElement PassLoginPassword;
	@FindBy(xpath="//*[@id='id_btn_logon_pwd']/a")
	private WebElement passLoginSubmit;
	
	@FindBy(id="USERID")
	private WebElement changePaswdUserID;
	@FindBy(id="USEROLDPASSWORD")
	private WebElement oldPassword;
	
	@FindBy(id="USERNEWPASSWORD")
	private WebElement newPassword;
	
	@FindBy(id="USERCNFRMNEWPASSWORD")
	private WebElement confirmationPassword;
	@FindBy(id="saveButton")
	private WebElement confirmSaveButton;
	
	
	public Loginpage(String browserType) {
		Browser.setup(browserType.trim());
		PageFactory.initElements(Browser.driver(), this);
		
	}

	public void load(String Url) {
	
			try {
				Browser.open(Url);				
				Browser.driver().navigate().to("javascript:document.getElementById('overridelink').click()");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public void loadwithCAAS() {
		// Browser.open(CAASUrl);
	}

	public void close() {
		Browser.close();
	}

	@Override
	protected void isLoaded() {
		assertTrue(Browser.driver().getTitle().contains(title));
		// assertTrue(Browser.driver().getCurrentUrl());
		String url = Browser.driver().getCurrentUrl();
		assertTrue("Not on the issue entry page: " + url,
				url.endsWith("/login.html"));
	}

	// login into main application
	public void loginClient(String userName, String password) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		// this.password.clear();
		this.password.sendKeys(password);
		this.Submit.click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
	}

	public void loginUsername(String userName) throws Exception {

		Thread.sleep(5000);
		assertTrue(this.userName.isDisplayed());
		this.userName.clear();
		this.userName.sendKeys(userName);
		this.Submit.click();

	}

	// to handle submit by using CAAS login
	public void clickSubmit() throws Exception {
		Thread.sleep(2000);

		if (this.Submit.isDisplayed()) {
			this.Submit.click();
		}
	}

	public void caasLogin(String cUsername, String cPassword) throws Exception {

		Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(Browser.driver(), 10);
		//WebElement element = wait.until(this.caasUsernameSubmit.isDisplayed());
		
		assertTrue(this.caasUsername.isDisplayed());
		this.caasUsername.clear();
		this.caasUsername.sendKeys(cUsername);
		assertTrue(this.caasUsernameSubmit.isDisplayed());
		this.caasUsernameSubmit.click();
		
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 120);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("USER_PASSWORD")));
		
		//Thread.sleep(2000);
		assertTrue(this.caasPassword.isDisplayed());
		Thread.sleep(2000);
		this.caasPassword.clear();
		this.caasPassword.sendKeys(cPassword);
		//for OTP
		Thread.sleep(20000);
		this.caasPasswordSubmit.click();
		Thread.sleep(2000);
		

	}
	public void normalLogin(String userName,String Password) throws Exception{
		
		Thread.sleep(3000);
		this.caasUsername.isDisplayed();
		this.caasUsername.sendKeys(userName);
		
		this.caasUsernameSubmit.click();
		Thread.sleep(5000);
		
		this.caasPassword.isDisplayed();
		this.caasPassword.sendKeys(Password);
		
		Thread.sleep(20000);
		this.caasPasswordSubmit.click();
		
	}
	public void preferLogin(String cUsername, String cPassword, String userName)
			throws Exception {
		
		Thread.sleep(2000);

		try {
			
			assertTrue(this.caasUsername.isDisplayed());
			this.caasLogin(cUsername, cPassword);
		} catch (Exception e) {
			this.loginUsername(userName);
		}
		/*
		 * if(caasUsername.isEnabled()){ this.caasLogin(cUsername, cPassword);
		 * }else if(this.userName.isDisplayed()){ this.loginUsername(userName);
		 * }
		 */
	}
	

	public void clickIECertification() throws Exception{
		Thread.sleep(3000);
		//Browser.driver().navigate().to("javascript:document.getElementById('overridelink').click())");
		Browser.driver().navigate().to(("javascript:document.getElementById('overridelink').click()"));
		Thread.sleep(2000);
		Browser.driver().navigate().to(("javascript:document.getElementById('overridelink').click()"));
		//Browser.driver().findElement(By.id("overridelink")).click();
		//Browser.driver().findElement(By.name("overridelink")).click();
		//Browser.driver().findElement(By.linkText("Continue to this website (not recommended). ")).click();
		//Thread.sleep(2000);
		
	}

	public void loginAfterGeneratePassword(String selectField,String GenePassword){
		//this.caasUsername.sendKeys(selectField);
		
		Browser.driver().findElement(By.id("plainuser")).sendKeys(selectField);
		Browser.driver().findElement(By.cssSelector("div#Submit_Button.submitButton span a")).click();
		
		//this.caasUsernameSubmit.click();
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 120);
		WebElement element2 = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("htmlPASSWORD")));
		
		
		
		
		Browser.driver().findElement(By.id("htmlPASSWORD")).sendKeys(GenePassword);
		
		
		Browser.driver().findElement(By.xpath("//*[@id='id_btn_logon_pwd']/a")).click();
		
		WebDriverWait wait1 = new WebDriverWait(Browser.driver(), 120);
		WebElement element = wait1.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("USERID")));
		
				
	}
	
	public void changePassword(String selectField,String genePassword,String newPassword,String ConPassword){
		
		
		
		Browser.driver().findElement(By.id("USERID")).sendKeys(selectField);
		Browser.driver().findElement(By.id("USEROLDPASSWORD")).sendKeys(genePassword);
		Browser.driver().findElement(By.id("USERNEWPASSWORD")).sendKeys(newPassword);
		Browser.driver().findElement(By.id("USERCNFRMNEWPASSWORD")).sendKeys(ConPassword);
		
		Browser.driver().findElement(By.id("saveButton")).click();
		
		//this.confirmSaveButton.click();
		
		WebDriverWait wait1 = new WebDriverWait(Browser.driver(), 120);
		WebElement element = wait1.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("submitButton")));
		
		Browser.driver().findElement(By.id("submitButton")).click();
		
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 120);
		WebElement element1 = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("plainuser")));
		
	}
	public void login1FA(String selectField,String GenePassword) throws Exception{
	
		Browser.driver().findElement(By.id("plainuser")).sendKeys(selectField);
		Browser.driver().findElement(By.cssSelector("div#Submit_Button.submitButton span a")).click();
		
		//this.caasUsernameSubmit.click();
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 120);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("htmlPASSWORD")));
		
		Browser.driver().findElement(By.id("htmlPASSWORD")).sendKeys(GenePassword);
		Browser.driver().findElement(By.xpath("//*[@id='id_btn_logon_pwd']/a")).click();
		WebDriverWait wait3 = new WebDriverWait(Browser.driver(), 120);
		WebElement element1 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginSubmit")));
		Browser.driver().findElement(By.id("loginSubmit")).click();
		
		WebDriverWait wait1 = new WebDriverWait(Browser.driver(), 120);
		WebElement element = wait1.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Manage Workspaces')]")));
		Thread.sleep(3000);
		assertTrue(Browser.driver().findElement(By.xpath("//a[contains(@title,'Manage Workspaces')]")).isDisplayed());
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
}
