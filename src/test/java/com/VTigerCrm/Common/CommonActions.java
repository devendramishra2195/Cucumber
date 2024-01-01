package com.VTigerCrm.Common;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	
	public WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest logger;
	
	public CommonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	public void SetInput(WebElement elm, String value,String msg)
	{
		try
		{		
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error ="+e.getMessage());
		}
	}
	
	public void ClickElement(WebElement elm,String msg)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error ="+e.getMessage());
		}
	}
	
	public void ElementExist(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to error ="+e.getMessage());
		}
	}
	
	
	
	
	

}
