package variousComcept;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropDown {
	WebDriver Driver;
	// ELEMENT LIST - By type
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	By CUSTOMERS_BUTTON_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADDCOSRTUMER_BUTTON_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By SUBMITION_BUTTON_FIELD = By.xpath("//*[@id=\"save_btn\"]");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By E_MAIL_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
	By PHONE_FIELD = By.xpath("//*[@id=\"phone\"]");
	By SELECT_OPTIONS_FIELD  = By.xpath("//select[@name=\"company_name\"]");
	

	
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().deleteAllCookies();
		Driver.get("https://codefios.com/ebilling/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void testLogin() {
		Driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		Driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		Driver.findElement(SIGNIN_BUTTON_FIELD).click();
		WebElement DASHBOARD_VALIDATION_ELEMENT = Driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
		Assert.assertTrue("Dashboard page not found",  DASHBOARD_VALIDATION_ELEMENT.isDisplayed());
		
		String DashboardElementTest = DASHBOARD_VALIDATION_ELEMENT.getText();
		String dashboardpagetitle = Driver.getTitle();
		
		Assert.assertEquals("Dashbord Page Not Found", "Codefios",dashboardpagetitle );
	
	}
	@Test
	public void testaddcustomer() {
		testLogin();
		Driver.findElement(CUSTOMERS_BUTTON_FIELD).click();
		Driver.findElement(ADDCOSRTUMER_BUTTON_FIELD).click();;
		Driver.findElement(FULL_NAME_FIELD).sendKeys("Selenium");
		Select sel = new Select(Driver.findElement(COMPANY_DROPDOWN_FIELD));
//		sel.selectByVisibleText("Walgreen");
		sel.selectByIndex(1);
		Driver.findElement(E_MAIL_FIELD).sendKeys("walid@hotmail.com");
		Driver.findElement(PHONE_FIELD).sendKeys("98772658623");
		Driver.findElement(SUBMITION_BUTTON_FIELD).click();
		
//		validation of all options available on a drop
//		1-creat an array of options
//		2- .getoption and convert into string
//		3- advance for loop
		
		WebElement SELECT_OPTION = Driver.findElement(SELECT_OPTIONS_FIELD);
		Select dropdown = new Select(SELECT_OPTION);
		
		List<WebElement> allOptions = dropdown.getOptions();
		String[] optionTextArray = new String[allOptions.size()];
		 for (int i = 0; i< allOptions.size();i++) {
			 optionTextArray[i] = allOptions.get(i).getText();
			 System.out.println(optionTextArray[i]);
			 
		 }
		
	
		
	}

}
	