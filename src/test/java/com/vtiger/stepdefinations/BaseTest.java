package com.vtiger.stepdefinations;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
public WebDriver driver;
public Properties prop;
public Map<String, Map<String,String>> alldata;
public  ExtentHtmlReporter htmlReporter;
public  ExtentReports extent;
public  ExtentTest logger;
public static String vTCName;

public void inititation()
{
	prop = readProperties();
	alldata = readExcelData(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx","Sheet1");
	System.out.println(alldata);
	//System.exit(0);
	createExtentReport();
}
	
	
	public void launchApp()
	{
		if(prop.getProperty("BrowserName").equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("BrowserName").equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(prop.getProperty("BrowserName").equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		int time = Integer.parseInt(prop.getProperty("ImplicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public Properties readProperties()
	{
		Properties prop = null;
		try
		{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/setting.properties");
		prop.load(fis);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return prop;
	}
	
	public Map<String, Map<String,String>> readExcelData(String file, String sheet)
	{
		Map<String, Map<String,String>>	alldata = null;
		try
		{
		alldata = new HashMap<String, Map<String,String>>();
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(file);
		String strQuery="Select * from "+sheet;
		Recordset recordset=connection.executeQuery(strQuery);	
		int clmcount = recordset.getFieldNames().size();
		List<String> colmname = recordset.getFieldNames();
		while(recordset.next()){
		//System.out.println(recordset.getField("Details"));
			Map<String,String> rowdata = new HashMap<String,String>();
			for(int i=0;i<clmcount;i++)
			{
				rowdata.put(colmname.get(i), recordset.getField(colmname.get(i)));
			}
			
			alldata.put(recordset.getField(colmname.get(0)), rowdata);
		}
		 
		recordset.close();
		connection.close();
		}
		catch(Exception e)
		{
			
		}
		
		return alldata;
	}
	
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
		
	}

}
