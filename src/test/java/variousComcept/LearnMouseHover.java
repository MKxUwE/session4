package variousComcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {
	WebDriver Driver;

	By COM_ACCESS_FIELD = By.xpath("//span[contains(text(), 'Computers & Accessories')]");

	By MONITORS_FIELD = By.xpath("//button[text()=\"Monitors\"]");

	By ALL_MONITORS_FIELD = By.xpath("//a[text()=\"View All Monitors\"]");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().deleteAllCookies();
		Driver.get("https://www.dell.com/en-us");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testMouseHover() {
 Actions Action = new Actions(Driver);
 Action.moveToElement(Driver.findElement(COM_ACCESS_FIELD)).build().perform();
 Action.moveToElement(Driver.findElement(MONITORS_FIELD)).build().perform();
 Driver.findElement(ALL_MONITORS_FIELD).click();
 
 
	}
}
