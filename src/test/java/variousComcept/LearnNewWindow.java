package variousComcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;
import net.bytebuddy.jar.asm.Handle;

public class LearnNewWindow {

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
		Driver.get("https://www.yahoo.com/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testNewWindow() {

		Driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("selenium");
		Driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys(Keys.ENTER);
		String title = Driver.getTitle();
		System.out.println(title); 
		String handle1 = Driver.getWindowHandle();
		Driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Switching Driver to diff TAB
		Set<String> hndle = Driver.getWindowHandles();
		for (String string : hndle) {
			System.out.println(hndle);
			Driver.switchTo().window(string);
			
		}
		String title3 = Driver.getTitle();
		System.out.println(title3);
		Driver.switchTo().window(handle1);
		String title4 = Driver.getTitle();
		System.out.println(title4);
		
	}

}
