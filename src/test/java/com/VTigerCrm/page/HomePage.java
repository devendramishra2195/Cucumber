package com.VTigerCrm.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTigerCrm.Common.CommonActions;
import com.aventstack.extentreports.ExtentTest;
public class HomePage extends CommonActions {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="New Lead")
	WebElement newlead;
	
	public void clickNewLead()
	{
		ClickElement(newlead,"New Lead link clicked");
	}
	
	public void clickLogout()
	{
		ClickElement(logout,"Logout link clicked");
	}
	
	public void verifyLogout()
	{
		ElementExist(logout,"Logout link is appear on home page");
	}

	public void verifyHomepage()
	{
		
	}

}

