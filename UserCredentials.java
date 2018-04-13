package com.selenium.codp.utilities;

//Below enum is for CAAS USERName and CAAS Password , Normal UserName is for without CAAS
public enum UserCredentials {

	//TBosUserName("TWOFACTORUSERSIX");
	TBosUserName("TMUSER1"), TBosPassword("Password123"), TBosNormalUserName("R3CISUSER1");
	//TBosUserName("E2ETWCUSTU2"), TBosPassword("Password99"), TBosNormalUserName("R3CISUSER1");
	//TBosUserName("TESTDA05"), TBosPassword("Password02"), TBosNormalUserName("TBOS05");
	//CISUserName("tasocetest1"), CISPassword("Password1");
	private String credential;
	//private String credential1;

	private UserCredentials(String credential) {
		this.credential = credential;
		//this.credential1=credential1;
		
	}

	public String getCredentials() {
		return credential;
	}

}
