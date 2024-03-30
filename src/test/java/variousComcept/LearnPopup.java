package variousComcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnPopup {

	WebDriver Driver;
	// ELEMENT LIST - By type
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().deleteAllCookies();
		Driver.get("https://codefios.com/ebilling/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testLogin() throws InterruptedException {
	    
		Driver.findElement(SIGNIN_BUTTON_FIELD).click();
		Thread.sleep(2000);
		String alerttext = Driver.switchTo().alert().getText();
		System.out.println(alerttext);
	    Driver.switchTo().alert().accept();
	   
	}
	
	
}
