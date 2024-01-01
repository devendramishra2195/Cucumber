package com.VTigerCrm.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTigerCrm.Common.CommonActions;
import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends CommonActions {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public LeadPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(name="button")
	List<WebElement> save;
	
	public void createLeadwithMandatoryfields(String lname, String comp)
	{
		SetInput(lastname, lname,lname+" has been entered into lastname field");
		SetInput(company, comp,comp+" has been entered into company field");
		ClickElement(save.get(2),"2nd save button clicked");
	}
	

}
