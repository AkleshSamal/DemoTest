	package com.anz.selenium.comcards.PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ClientUsersPrivilegesPage {
	
	@FindBy(xpath="//*[@id='appadmin']")
	private WebElement appAdmin;
	
	@FindBy(xpath="//*[@id='contmgmtsummary']")
	private WebElement contentAdmin;
	
	@FindBy(xpath="//*[@id='home']")
	private WebElement homeButton;
	
	@FindBy(xpath="//*[@id='header-section']/div[2]/div[1]/a/i")
	private WebElement menuButton;
	
	@FindBy(xpath="//*[@id='btr']")
	private WebElement reporting;
	
	@FindBy(xpath="//*[@id='accountsummary']")
	private WebElement operatingAccounts;
	
	@FindBy(xpath="//*[@id='selfservicesummary']")
	private WebElement enquiries;

	

	@FindBy(xpath="//a[contains(@title,'Administration')]")
	private WebElement administrationtab;

	
	@FindBy(id="extapp")
	private WebElement myApplications;
	
	@FindBy(id="tbos-extapp-adm-transactive-tt")
	private WebElement anzTransactiveAUNZ;

	@FindBy(xpath="//a[contains(@title,'Workspaces')]")
	private WebElement workspacestab;
	
	@FindBy(id="usermanagement")
	private WebElement usermanagementtab;
	
	
	
	@FindBy(xpath="//*[@id='branding-section']")
	private WebElement validateHeaderText;

	@FindBy(xpath="//a[contains(@title,'Show Menu')]")
	private WebElement showmenuTooltip;


	@FindBy(xpath="//a[contains(@title,'Settings & Preferences')]")
	private WebElement tmTooltip;


	@FindBy(xpath="//*[@id='message']")
	private WebElement contactTooltip;
 
	@FindBy(xpath="//*[@id='help']")
	private WebElement helpTooltip;

	
	@FindBy(xpath="//a[contains(@title,'Click to view the content you can add to this workspace')]")
	private WebElement addWorkspaceTooltip;
	
	@FindBy(xpath="//a[contains(@title,'Click for more information')]")
	private WebElement addWidgetInfoTooltip;
	
	@FindBy(xpath="//a[contains(@title,'Click to add to this to your workspace')]")
	private WebElement addWidgetTooltip;
	
	@FindBy(xpath="//a[contains(@title,'Manage Workspaces')]")
	private WebElement managespaceTooltip;

	@FindBy(xpath="a[contains(@title,'Download')]")
	private WebElement downloadTooltip;


	@FindBy(xpath="a[contains(@title,'Settings')]")
	private WebElement settingsToolTip;


	@FindBy(xpath="a[contains(@title,'Remove')]")
	private WebElement removeToolTip;
	
	@FindBy(id="tbos-extapp-adm-gcis-cac-au")
	private WebElement ANZCashactiveControlAU;

	@FindBy(xpath="//a[contains(@title,'Group by selected criteria')]")
	public WebElement CreteriaToolTip;


	@FindBy(xpath="//a[contains(@title,'More actions')]")
	public WebElement ActionsToolTip;


	@FindBy(xpath="//a[contains(@title,'Export Net Position to CSV')]")
	public WebElement NPexportToolTip;

	
	
	@FindBy(xpath="//a[contains(@title,'Advanced Search Collapse')]")
	private WebElement TSSearchToolTip;
	
	
	
	@FindBy(xpath="//a[contains(@title,'Export Transaction Search to CSV')]")
	public WebElement TSexportToolTip;
	
	
	@FindBy(xpath="//a[contains(@title,'Select to view shared or personal Report Profiles')]")
	public WebElement RPViewProfilesToolTip;
	
	
	@FindBy(xpath="//a[contains(@title,'Create a new Report Profile')]")
	public WebElement RPCreateNewProfilesToolTip;
	
	@FindBy(xpath="//a[contains(@title,'Refresh')]")
	public WebElement refreshToolTip;

	@FindBy(xpath="//a[contains(@title,'Select search criteria') or contains(@title,'Select Search Criteria') ]")
	public WebElement SelectsearchCriteriaToolTip;

	
	
	@FindBy(xpath="//a[contains(@title,'Show Search Criteria') or contains(@title,'Hide Search Criteria')]")
	public WebElement ShowSearchCreteriaToolTip;


	@FindBy(className="search-input")
	public WebElement searchCriteriaToolTip;
		
	@FindBy(id="btr-set-ref-ccy")
	public WebElement NPActionsSetRefCurrencyToolTip;

	@FindBy(id="btr-netposition-req")
	public WebElement NPActionsReqNPToolTip;

	@FindBy(id="btr-netposition-remembersettings")
	public WebElement NPActionsRemSettingsToolTip;
	
	
	@FindBy(xpath="//a[contains(@title,'View or manage Folders')]")
	private WebElement OAviewmanagefolderToolTip;

	@FindBy(xpath="//a[contains(@title,'Export Operating Accounts to CSV')]")
	private WebElement OAExtractToolTip;

	
	
	
	@FindBy(id="btr-acct-moveto-label")
	private WebElement OAActionsMoveToToolTip;

	@FindBy(id="$RMV$")
	private WebElement OARemoveFolderToolTip;

	@FindBy(id="$MNG$")
	private WebElement OACreateRenameFolderToolTip;
	
	@FindBy(xpath="//a[contains(@title,'View and manage folders')]")
	private WebElement NAviewmanagefolderToolTip;
	
	@FindBy(xpath="//a[contains(@title,'Export Nostro Accounts to CSV')]")
	private WebElement NAExportToolTip;
	
	@FindBy(xpath="//a[contains(@title,'Save Search Criteria')]")
	private WebElement SearchCritariaToolTip;

	
	@FindBy(xpath="//a[contains(@title,'Create a new Scheduled Report')]")
	private WebElement SRNewReportToolTip;
	

	@FindBy(xpath="//a[contains(@title,'Save and create another Scheduled Report')]")
	private WebElement SRSaveCreateAnotherReportToolTip;
		
	@FindBy(xpath="//a[contains(@title,'Save Scheduled Report')]")
	private WebElement SRSaveReportToolTip;
	
	@FindBy(xpath="//a[contains(@title,'View or manage Folders')]")
	private WebElement DPviewmanagefolder;
	
	@FindBy(xpath="//a[contains(@title,'Export Deposits to CSV')]")
	private WebElement DPExportToolTip;

	
	@FindBy(xpath="//a[contains(@title,'View or Manage Saved Searches')]")
	private WebElement DPSviewmanagefolder;
	
	@FindBy(xpath="//a[contains(@title,'Export Deposit Search to CSV')]")
	private WebElement DPSexportToolTip;
	
	@FindBy(xpath="//a[contains(@title,'Search')]")
	private WebElement DSSearchToolTip;
	
	@FindBy(xpath="//a[contains(@title,'Reset')]")
	private WebElement DSResetToolTip;
	
	
	@FindBy(xpath="//a[contains(@title,'Group Downloads By Selected Criteria')]")
	private WebElement DRCriteriaToolTip;
	
	
	@FindBy(xpath="//a[contains(@title,'Filter By Date or Date Range')]")
	private WebElement DRFilterToolTip;
	
	
	@FindBy(xpath="//a[contains(@title,'View Actions')]")
	private WebElement DRViewActionsToolTip;
	
	@FindBy(xpath="//a[contains(@title,'Filter by selected criteria')]")
	private WebElement UsrMgmtFilterToolTip;

	@FindBy(xpath="//a[contains(@title,'Enter New User')]")
	private WebElement UsrMgmtEnterNewUserTip;
	
	@FindBy(id="downloadreports")
	private WebElement downloadReportsTab;

	@FindBy(id="netposition")
	private WebElement NetPositiontab;

	@FindBy(id="termdeposit")
	private WebElement Depositstab;
	
	@FindBy(id="depositsearch")
	private WebElement DepositsSearchtab;

	@FindBy(id="accountsummary")
	private WebElement OperatingAccountstab;

	@FindBy(id="txnsearch")
	private WebElement TransactionSearchtab;


	@FindBy(id="nostroaccountsummary")
	private WebElement NostroAccountstab;


	@FindBy(id="nostrosearch")
	private WebElement NostroAccountsSearchtab;


	@FindBy(id="rptprofilelist")
	private WebElement ReportProfilestab;


	@FindBy(id="mngschedule")
	private WebElement ScheduledReportstab;


	@FindBy(id="rptdownload")
	private WebElement DownloadReportstab;


	@FindBy(id="selfservicesummary")
	private WebElement Enquiriestab;
	
	public ClientUsersPrivilegesPage(){
		PageFactory.initElements(Browser.driver(), this);
	}
	
	
	
	
	@FindBy(id="tbos-extapp-adm-fxonline")
	private WebElement AnzFxonline;

	public void clickANZFxonline() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.AnzFxonline));
		this.AnzFxonline.click();
		Thread.sleep(2000);
	}

	public void clickActions () throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ActionsToolTip));
		this.ActionsToolTip.click();
		Thread.sleep(2000);
	}
	
	
	public void clickANZCashactiveControlAU()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZCashactiveControlAU));
		this.ANZCashactiveControlAU.click();
		
	}

	@FindBy(id="tbos-extapp-adm-ot-online")
	private WebElement AnzOnline;

	public void clickAnzOnline()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.AnzOnline));
		this.AnzOnline.click();
	}



	@FindBy(id="tbos-extapp-adm-gcis-cac-nz")
	private WebElement ANZCashactiveControlNZ;

	public void clickANZCashactiveControlNZ()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZCashactiveControlNZ));
		this.ANZCashactiveControlNZ.click();
	}



	@FindBy(id="tbos-extapp-adm-gcis-fa")
	private WebElement ANZFileactive;

	public void clickANZFileactive()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZFileactive));
		this.ANZFileactive.click();
	}


	@FindBy(id="tbos-extapp-adm-ematching-au")
	private WebElement ANZeMatchingAU;

	public void clickANZeMatchingAU()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZeMatchingAU));
		this.ANZeMatchingAU.click();
	}



	@FindBy(id="tbos-extapp-adm-gcp")
	private WebElement ANZTransactiveCashAsia;

	public void clickANZTransactiveCashAsia()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZTransactiveCashAsia));
		this.ANZTransactiveCashAsia.click();
	}



	@FindBy(id="tbos-extapp-adm-ot-royal")
	private WebElement ANZRoyalTransactive;

	public void clickANZRoyalTransactive()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZRoyalTransactive));
		this.ANZRoyalTransactive.click();
	}




	@FindBy(id="tbos-extapp-adm-gcis-cav-au")
	private WebElement ANZCashactiveVirtualAU;

	public void clickANZCashactiveVirtualAU()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZCashactiveVirtualAU));
		this.ANZCashactiveVirtualAU.click();
	}




	@FindBy(id="tbos-extapp-adm-ot-apea")
	private WebElement ANZTransactiveAPEA;

	public void clickANZTransactiveAPEA()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZTransactiveAPEA));
		this.ANZTransactiveAPEA.click();
	}



	@FindBy(id="tbos-extapp-adm-gcis-cav-nz")
	private WebElement ANZCashactiveVirtualNZ;

	public void clickANZCashactiveVirtualNZ()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZCashactiveVirtualNZ));
		this.ANZCashactiveVirtualNZ.click();
	}



	@FindBy(id="tbos-extapp-adm-ematching-nz")
	private WebElement ANZeMatchingNZ;

	public void clickANZeMatchingNZ()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZeMatchingNZ));
		this.ANZeMatchingNZ.click();
	}




	@FindBy(id="tbos-extapp-adm-lm")
	private WebElement ANZLiquidityManagement;

	public void clickANZLiquidityManagement()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZLiquidityManagement));
		this.ANZLiquidityManagement.click();
	}



	@FindBy(id="tbos-extapp-adm-billinganalytics")
	private WebElement ANZBillingAnalytics;

	public WebElement property;

	public void clickANZBillingAnalytics()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ANZBillingAnalytics));
		this.ANZBillingAnalytics.click();
	}

	public boolean clickHomeButton() throws InterruptedException
	{
		
		
			/*WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
			wait.until(ExpectedConditions.visibilityOf(this.homeButton));
			this.homeButton.click();*/
		
			try{
			
			if(Browser.driver().findElements(By.xpath("//*[@id='home']")).size() >0)
				{
					Actions actions = new Actions(Browser.driver());
					actions.moveToElement(Browser.driver().findElement(By.xpath("//*[@id='home']"))).click().perform();
					//Browser.driver().findElement(By.xpath("//*[@id='home']")).click();
					return true;
				}
			}
			catch ( NoSuchElementException E)
			{
				
			}
			return false;
		
	}
	
	public void clickMenuButton() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 60);
		wait.until(ExpectedConditions.visibilityOf(this.menuButton));
		this.menuButton.click();
		//Thread.sleep(2000);
	}
	
	
	
	
	public void clickMyApplications() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.myApplications));
		this.myApplications.click();
		Thread.sleep(2000);
	}
	
	public void clickANZTranscativeAUNZ()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.anzTransactiveAUNZ));
		this.anzTransactiveAUNZ.click();
	}
	public void clickAdministration() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.administrationtab));
		this.administrationtab.click();
		Thread.sleep(2000);
	}
	public void clickDeposits()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.Depositstab));
		this.Depositstab.click();
	}
	
	public void clickDepositsSearch()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.DepositsSearchtab));
		this.DepositsSearchtab.click();
	}

	public void clickNetPositiontab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.NetPositiontab));
		this.NetPositiontab.click();
		
		wait = new WebDriverWait(Browser.driver(), 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div/div[1]/span[1]")));

	}

	public void clickOperatingAccountstab() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 60);
		wait.until(ExpectedConditions.visibilityOf(this.OperatingAccountstab));
		this.OperatingAccountstab.click();
		
		wait = new WebDriverWait(Browser.driver(), 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div/div[1]/span[1]")));
		
		//Thread.sleep(30000);
	}


	public void clickTransactionSearchtab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.TransactionSearchtab));
		this.TransactionSearchtab.click();
	}


	public void clickNostroAccountstab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.NostroAccountstab));
		this.NostroAccountstab.click();
		wait = new WebDriverWait(Browser.driver(), 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div/div[1]/span[1]")));
	}
	public void clickWorkspaces() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.workspacestab));
		this.workspacestab.click();
		Thread.sleep(2000);
	}


	public void clickNostroAccountsSearchtab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.NostroAccountsSearchtab));
		this.NostroAccountsSearchtab.click();
		
		wait = new WebDriverWait(Browser.driver(), 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div/div[1]/span[1]")));
		
	}


	public void clickReportProfilestab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ReportProfilestab));
		this.ReportProfilestab.click();
		
		/*if(Browser.driver().findElements(By.xpath(".//*[@id='btr-subMenu']/div[1]/a/i")).size()>0)
		{
			
			if(Browser.driver().findElement(By.xpath(".//*[@id='btr-subMenu']/div[1]/a/i")).isDisplayed() || Browser.driver().findElement(By.xpath(".//*[@id='btr-subMenu']/div[1]/a/i")).isEnabled())
				Browser.driver().findElement(By.xpath(".//*[@id='btr-subMenu']/div[1]/a/i")).click();
		}*/
	
		
	}
	public void clickScheduledReportsTab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.ScheduledReportstab));
		this.ScheduledReportstab.click();
	}

	public void clickDownloadReportstab()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.DownloadReportstab));
		this.DownloadReportstab.click();
		wait = new WebDriverWait(Browser.driver(), 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div/div[1]/span[1]")));
	}
	
	


	public void clickEnquiriestab() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 90);
		wait.until(ExpectedConditions.visibilityOf(this.Enquiriestab));
		this.Enquiriestab.click();
		//wait = new WebDriverWait(Browser.driver(), 90);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btr-selfservicesummary-controllist-section']/span[3]/a")));
		//wait = new WebDriverWait(Browser.driver(), 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div/div[1]/span[1]")));
		Thread.sleep(20000);
	}
	
	
	public void clickReporting() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 60);
		wait.until(ExpectedConditions.visibilityOf(this.reporting));
		this.reporting.click();
		//Thread.sleep(2000);
	}
	
	public void clickRefreshButton() throws InterruptedException
	{
		this.refreshToolTip.click();
	}
	
	
	
	public boolean verifyEnquiriesPage() throws InterruptedException
	{
		this.clickMenuButton();
		this.clickReporting();
		
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.enquiries));
		
		if(this.enquiries.isDisplayed())
		{
			this.enquiries.click();
			System.out.println("Enquiries page is present for the user");
			return true;
		}
		System.out.println("Enquiries  page is NOT present for the user");
		return false;
		
	}
	
	public boolean validateANZHeaderText()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.validateHeaderText));
		if (this.validateHeaderText.isDisplayed())
		{
			System.out.println("ANZ Transcative Header is present and is displayed as "+this.validateHeaderText.getText());
			return true;
		}
		System.out.println("ANZ Transcative Header is not present and is displayed as "+this.validateHeaderText.getText());
		return false;
	}
	
	public void validateToolTips(WebElement property)
	{
		
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = this.property;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		//if(tipmessage.getAttribute("title").equals(ExpectedToolTipInfo))
		//{
			System.out.println("Tool tip : "+tipmessage.getAttribute("title"));
		//}
		
	}
	
	public void validateCommonToolTips() throws InterruptedException
	{
		Actions tooltip = new Actions(Browser.driver());
		//WebElement tipmessage = this.CreteriaToolTip;
		
				
		if(this.CreteriaToolTip.isDisplayed())
		{
			tooltip.clickAndHold(this.CreteriaToolTip).perform();
			System.out.println("Tool tip:  "+((WebElement) this.CreteriaToolTip).getAttribute("title"));
		}
		
		
		//tipmessage = this.ActionsToolTip;
		if(this.ActionsToolTip.isDisplayed() )
		{
			tooltip.clickAndHold(this.ActionsToolTip).perform();
			System.out.println(" Tool tip:"+this.ActionsToolTip.getAttribute("title"));
		}
		//tipmessage = this.refreshToolTip;
		if(this.refreshToolTip.isDisplayed())
		{
			tooltip.clickAndHold(this.refreshToolTip).perform();
			System.out.println("Tool tip: "+this.refreshToolTip.getAttribute("title"));
		}
		//tipmessage = this.SelectsearchCriteriaToolTip;
		if(this.SelectsearchCriteriaToolTip.isDisplayed() )
		{
			tooltip.clickAndHold(this.SelectsearchCriteriaToolTip).perform();
			System.out.println("Tool tip: "+this.SelectsearchCriteriaToolTip.getAttribute("title"));
		}
		//tipmessage = this.searchCriteriaToolTip;
		if(this.searchCriteriaToolTip.isDisplayed())
		{
			tooltip.clickAndHold(this.searchCriteriaToolTip).perform();
			System.out.println("Tool tip: "+this.searchCriteriaToolTip.getAttribute("title"));
		}
		
		
	}
	
	
	
	public void validateNPToolTips() throws InterruptedException
	{
	
		validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = (WebElement) this.CreteriaToolTip;

		tipmessage = this.NPexportToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println("Tool tip : "+tipmessage.getAttribute("title"));

		
		
				
	/*	
		clickActions();
		clickAndHoldActions(NPActionsSetRefCurrencyToolTip);
		validateToolTips(NPActionsSetRefCurrencyToolTip);

		clickAndHoldActions(NPActionsReqNPToolTip);
		validateToolTips(NPActionsReqNPToolTip);

		clickAndHoldActions(NPActionsRemSettingsToolTip);
		validateToolTips(NPActionsRemSettingsToolTip);*/
		
		
	}
	
	public boolean isElementPresent(By ele) {
	    
	    boolean returnVal = true;
	    try{
	        Browser.driver().findElements(ele);
	    } catch (NoSuchElementException e){
	        returnVal = false;
	    } 
	    return returnVal;
	}
	public void validateDepositsToolTips() throws InterruptedException
	{
	
		validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = this.DPviewmanagefolder;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));

		tipmessage = this.DPExportToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
	
		
	}
	
	public void validateDepositsSearchToolTips() throws InterruptedException
	{
	
		//validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
			tooltip.clickAndHold(this.CreteriaToolTip).perform();
			System.out.println("Tool tip:  "+((WebElement) this.CreteriaToolTip).getAttribute("title"));

		
			tooltip.clickAndHold(this.ActionsToolTip).perform();
			System.out.println(" Tool tip:"+this.ActionsToolTip.getAttribute("title"));
		
		
		
		WebElement tipmessage = this.DPSviewmanagefolder;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));

		tipmessage = this.DPSexportToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
	
		
		tipmessage = this.SearchCritariaToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		
		tipmessage = this.DSSearchToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		tipmessage = this.DSResetToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		
	}
	
	
	
	public void validateOAToolTips() throws InterruptedException
	{
	
		validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = this.OAviewmanagefolderToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		tipmessage = this.OAExtractToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));

		
		
		/***** Add logic to do Manage folder 
		 * Add folder and verify remove tool tip
		 */
		
		
	}
	
	public void validateTSToolTips() throws InterruptedException
	{
	
				
		//validateCommonToolTips();
		Actions tooltip = new Actions(Browser.driver());
		tooltip.clickAndHold(this.CreteriaToolTip).perform();
		System.out.println("Tool tip:  "+((WebElement) this.CreteriaToolTip).getAttribute("title"));

		tooltip.clickAndHold(this.ActionsToolTip).perform();
		System.out.println(" Tool tip:"+this.ActionsToolTip.getAttribute("title"));
		
		
		WebElement tipmessage = this.DPSviewmanagefolder;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));

		tipmessage = this.TSexportToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		tipmessage = this.SearchCritariaToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
	
		

	/*	
		tipmessage = this.TSSearchToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));*/
		
		tooltip.clickAndHold(this.ShowSearchCreteriaToolTip).perform();
		System.out.println(" Tool tip : "+this.ShowSearchCreteriaToolTip.getAttribute("title"));
		
		/***** Add logic to do Manage folder 
		 * Add folder and verify remove tool tip
		 */
		
		
	}
	public void validateNAToolTips() throws InterruptedException
	{
	
		//validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		
		tooltip.clickAndHold(this.CreteriaToolTip).perform();
		System.out.println("Tool tip:  "+((WebElement) this.CreteriaToolTip).getAttribute("title"));

		tooltip.clickAndHold(this.ActionsToolTip).perform();
		System.out.println(" Tool tip:"+this.ActionsToolTip.getAttribute("title"));
	
		tooltip.clickAndHold(this.NAviewmanagefolderToolTip).perform();
		System.out.println(" Tool tip : "+this.NAviewmanagefolderToolTip.getAttribute("title"));
		
		tooltip.clickAndHold(this.NAExportToolTip).perform();
		System.out.println(" Tool tip : "+this.NAExportToolTip.getAttribute("title"));

		tooltip.clickAndHold(this.refreshToolTip).perform();
		System.out.println("Tool tip: "+this.refreshToolTip.getAttribute("title"));

	
		tooltip.clickAndHold(this.SelectsearchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.SelectsearchCriteriaToolTip.getAttribute("title"));
		
		
		/***** Add logic to go Move to and check None , Manage folder 
		 * Add folder and verify remove tool tip
		 */
		
		
	}
	
	
	
	public void validateSRToolTips() throws InterruptedException
	{
	
		//validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		
		tooltip.clickAndHold(this.CreteriaToolTip).perform();
		System.out.println("Tool tip:  "+((WebElement) this.CreteriaToolTip).getAttribute("title"));

		tooltip.clickAndHold(this.ActionsToolTip).perform();
		System.out.println(" Tool tip:"+this.ActionsToolTip.getAttribute("title"));

		tooltip.clickAndHold(this.SelectsearchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.SelectsearchCriteriaToolTip.getAttribute("title"));
	
		tooltip.clickAndHold(this.searchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.searchCriteriaToolTip.getAttribute("title"));
		
		
		WebElement tipmessage = this.SRNewReportToolTip;	
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		
		this.SRNewReportToolTip.click();
		Thread.sleep(1000);
		tooltip.clickAndHold(this.SRSaveReportToolTip).perform();
		System.out.println("Tool tip: "+this.SRSaveReportToolTip.getAttribute("title"));
		
		tooltip.clickAndHold(this.SRSaveCreateAnotherReportToolTip).perform();
		System.out.println("Tool tip: "+this.SRSaveCreateAnotherReportToolTip.getAttribute("title"));

		

		/***** Add logic to gnew scheduled record and check tool tips  
		 * 
		 */
		
		
	}
	
	public void validateNASearchToolTips() throws InterruptedException
	{
	
		//validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());

		tooltip.clickAndHold(this.DPSviewmanagefolder).perform();
		System.out.println(" Tool tip : "+this.DPSviewmanagefolder.getAttribute("title"));
	
		tooltip.clickAndHold(this.CreteriaToolTip).perform();
		System.out.println(" Tool tip : "+this.CreteriaToolTip.getAttribute("title"));
	
		tooltip.clickAndHold(this.ActionsToolTip).perform();
		System.out.println(" Tool tip : "+this.ActionsToolTip.getAttribute("title"));

		tooltip.clickAndHold(this.SearchCritariaToolTip).perform();
		System.out.println(" Tool tip : "+this.SearchCritariaToolTip.getAttribute("title"));

		tooltip.clickAndHold(this.TSexportToolTip).perform();
		System.out.println(" Tool tip : "+this.TSexportToolTip.getAttribute("title"));


		tooltip.clickAndHold(this.ShowSearchCreteriaToolTip).perform();
		System.out.println(" Tool tip : "+this.ShowSearchCreteriaToolTip.getAttribute("title"));

		
		
	}
	
	
	public void validateRPToolTips() throws InterruptedException
	{
	
		//validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		
		tooltip.clickAndHold(this.CreteriaToolTip).perform();
		System.out.println("Tool tip:  "+((WebElement) this.CreteriaToolTip).getAttribute("title"));

		tooltip.clickAndHold(this.ActionsToolTip).perform();
		System.out.println(" Tool tip:"+this.ActionsToolTip.getAttribute("title"));

		tooltip.clickAndHold(this.SelectsearchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.SelectsearchCriteriaToolTip.getAttribute("title"));
	
		tooltip.clickAndHold(this.searchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.searchCriteriaToolTip.getAttribute("title"));
			
		WebElement tipmessage = this.RPViewProfilesToolTip;

		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		
		tipmessage = this.RPCreateNewProfilesToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));

		/***** Add logic to gnew scheduled record and check tool tips  
		 * 
		 */
		
		
	}
	
	public void validateDRToolTips() throws InterruptedException
	{
	
		//validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		
		tooltip.clickAndHold(this.DRCriteriaToolTip).perform();
		System.out.println("Tool tip:  "+(this.DRCriteriaToolTip).getAttribute("title"));

		tooltip.clickAndHold(this.DRViewActionsToolTip).perform();
		System.out.println(" Tool tip:"+this.DRViewActionsToolTip.getAttribute("title"));

		tooltip.clickAndHold(this.refreshToolTip).perform();
		System.out.println("Tool tip: "+this.refreshToolTip.getAttribute("title"));
		
		tooltip.clickAndHold(this.SelectsearchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.SelectsearchCriteriaToolTip.getAttribute("title"));
	
		tooltip.clickAndHold(this.searchCriteriaToolTip).perform();
		System.out.println("Tool tip: "+this.searchCriteriaToolTip.getAttribute("title"));
		
		
		WebElement tipmessage = this.DRFilterToolTip;
	
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		

		/***** Add logic to gnew scheduled record and check tool tips  
		 * 
		 */
		
		
	}
	
	public void validateUsrMgmtToolTips() throws InterruptedException
	{
	
		validateCommonToolTips();
		
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = this.UsrMgmtFilterToolTip;

		
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		tipmessage = this.UsrMgmtEnterNewUserTip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println(" Tool tip : "+tipmessage.getAttribute("title"));
		
		

		/***** Add logic to gnew scheduled record and check tool tips  
		 * 
		 */
		
		
	}
	
	public void clickAndHoldActions(WebElement property)
	{
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = this.ActionsToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		
	}
	
	public void validateToolTipsANZTranscativeAUNZ()
	{

	}
	public void validateToolTipsANZFxonline()			
	{

	}
	public void validateToolTipsANZCashactiveControlAU()
	{

	}
	public void validateToolTipsAnzOnline()
	{

	}
	public void validateToolTipsANZCashactiveControlNZ()
	{

	}
	public void validateToolTipsANZFileactive()
	{

	}
	public void validateToolTipsANZeMatchingAU()
	{

	}
	public void validateToolTipsANZTransactiveCashAsia()
	{

	}

	public void validateToolTipsANZRoyalTransactive()
	{

	}
	public void validateToolTipsANZCashactiveVirtualAU()
	{

	}
	public void validateToolTipsANZTransactiveAPEA()
	{

	}
	public void validateToolTipsANZCashactiveVirtualNZ()
	{

	}
	public void validateToolTipsANZeMatchingNZ()
	{

	}
	public void validateToolTipsANZLiquidityManagement()
	{

	}
	public void validateToolTipsANZBillingAnalytics()
	{

	}
	
	public void validateToolTipsHomePage()
	{
		Actions tooltip = new Actions(Browser.driver());
		WebElement tipmessage = this.showmenuTooltip;
		tooltip.moveToElement(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Show Menu"))
		{
			System.out.println("Menu Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}
		
		tipmessage = this.tmTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Settings & Preferences"))
		{
			System.out.println("Settings Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}
		tipmessage = this.contactTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Contact"))
		{
			System.out.println("Phone Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}
		
		
		tipmessage = this.helpTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Help"))
		{
			System.out.println("Help tool tip is present and is "+tipmessage.getAttribute("title"));
		}
		tipmessage = this.addWorkspaceTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Click to view the content you can add to this workspace"))
		{
			System.out.println("Add workspace tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}
		tipmessage = this.managespaceTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Manage Workspaces"))
		{
			System.out.println("Manage Workspaces tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}
		
		
		this.addWorkspaceTooltip.click();
		
		tipmessage = this.addWidgetTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		
		
		if(tipmessage.isDisplayed())
		{
			System.out.println("Add Widget Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}
		
		
		tipmessage = this.addWidgetInfoTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		System.out.println("Widget Info Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		
	/*	
		tipmessage = this.downloadTooltip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Download"))
		{
			System.out.println("Download Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}



		tipmessage = this.refreshToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Refresh"))
		{
			System.out.println("Settings Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}



		tipmessage = this.settingsToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Settings"))
		{
			System.out.println("Settings Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}



		tipmessage = this.removeToolTip;
		tooltip.clickAndHold(tipmessage).perform();
		//System.out.println(tipmessage.getAttribute("title"));
		
		if(tipmessage.getAttribute("title").equals("Remove"))
		{
			System.out.println("Settings Tool tip is present and is displayed as "+tipmessage.getAttribute("title"));
		}*/
	
	}

	public void verifyDAUserAdminstrationsTabs() throws InterruptedException
	{
		this.clickMenuButton();
		this.clickAdministration();
		
		if(this.usermanagementtab.isDisplayed())
		{
			try{
			Thread.sleep(3);
			this.usermanagementtab.click();
			System.out.println("User Management tab page is present for the user");
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.clickMenuButton();
		this.clickAdministration();
		if(this.downloadReportsTab.isDisplayed())
		{
			try{
			Thread.sleep(3);
			this.downloadReportsTab.click();
			System.out.println("Download Reports  page is present for the user");
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}	


	public boolean verifyContentAdminpage()
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.contentAdmin));
		if(this.contentAdmin.isDisplayed())
		{
			this.contentAdmin.click();
			System.out.println("Content Administration page is present for the user");
			return true;
		}
		
		return false;
		
	}	
	
	public boolean verifyOperatingAccounts() throws InterruptedException
	{

		this.clickMenuButton();
		this.clickReporting();
		
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 30);
		wait.until(ExpectedConditions.visibilityOf(this.operatingAccounts));
		
		if(this.operatingAccounts.isDisplayed())
		{
			this.operatingAccounts.click();
			System.out.println("Operating Accounts page is present for the user");
			return true;
		}
		System.out.println("Operating Accounts page is NOT present for the user");
		return false;
		
	}
}
