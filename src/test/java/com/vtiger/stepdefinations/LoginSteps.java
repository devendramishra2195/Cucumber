package com.vtiger.stepdefinations;

import com.VTigerCrm.page.HomePage;
import com.VTigerCrm.page.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {
	
	/*@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost100");
		}
		*/
		
	@Before
	public void getScenario(Scenario scenario)
	{
		inititation();
		vTCName = scenario.getName();
		logger = extent.createTest(vTCName);		
	}
	
	@After
	public void savereport()
	{
		extent.flush();
	}
    
	@Given("user should be on login page")
	public void user_should_be_on_login_page () {
		launchApp();
	}
	@When("user enters valid credentials and click on login button")
	public void user_enters_valid_credentials_and_click_on_login_button() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(alldata.get(vTCName).get("Userid"), alldata.get(vTCName).get("password"));
	 
	}
	@Then("user should be navigate to home page")
	public void user_should_be_navigate_to_home_page() {
		HomePage hp = new HomePage(driver,logger);
		hp.verifyHomepage();
		
		
	}
	@Then("user can see logout link on home page")
	public void user_can_see_logout_link_on_home_page() {
		HomePage hp = new HomePage(driver,logger);
		hp.verifyHomepage();
		
	}
	
	@When("user enters invalid credentials and click on login button")
	public void user_enters_invalid_credentials_and_click_on_login_button() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(alldata.get(vTCName).get("Userid"), alldata.get(vTCName).get("password"));
	 
	   	
	}
	@Then("user can see the error message on login page")
	public void user_can_see_error_msg() {
	   
		
	}

}
