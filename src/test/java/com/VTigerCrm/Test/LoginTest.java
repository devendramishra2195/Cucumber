package com.VTigerCrm.Test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.VTigerCrm.page.HomePage;
import com.VTigerCrm.page.LoginPage;
import com.vtiger.stepdefinations.BaseTest;

public class LoginTest extends BaseTest {
	
	
	
	@Test
	public void verifyValidLogin_TC01()
	{
		String vTCName = "verifyValidLogin_TC01";
		logger = extent.createTest(vTCName);		
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(alldata.get(vTCName).get("Userid"), alldata.get(vTCName).get("password"));
		HomePage hp = new HomePage(driver,logger);
		hp.verifyLogout();
		hp.clickLogout();
		extent.flush();
		
	}

}
