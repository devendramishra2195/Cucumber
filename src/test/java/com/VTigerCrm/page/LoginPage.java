package com.VTigerCrm.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTigerCrm.Common.CommonActions;
import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends CommonActions {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	//By username = By.name("user_name");
	//String username = "user_name";
	
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(xpath="//input[@name='user_password']")
	WebElement password;
	
	@FindBy(name="Login")
	List<WebElement> login;
	
	@FindBy(xpath="//*[contains(text(),'')]")
	List<WebElement> login1;
	
	public void login(String userid, String pwd)
	{
	    SetInput(username, userid,userid +" has been entered into username field");
	    SetInput(password, pwd, "****** has been entered into password field");
		ClickElement(login.get(0),"Login button clicked");
	}
	
	public void verifyErrorMsg()
	{
		
	}
	
	

}
