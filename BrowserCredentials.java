package com.selenium.codp.utilities;

public enum BrowserCredentials {
	
	Firefox("FF"),Chrome("Chrome"),InternetExplorer("IE");
	
	private String browserType;
	
	private BrowserCredentials(String browserType){
		this.browserType = browserType;
	}
	
	public String getBrowserType(){		
		return browserType;
	}

}
