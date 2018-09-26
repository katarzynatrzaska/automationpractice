package automationpractice.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoRedirect {
	protected static WebDriver driver;

	@BeforeTest()
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	}

	@AfterTest()
	public void afterTest() {
		driver.quit();
	}

	@Test(priority = 0)
	public void logoRedirectURL() {
		driver = new ChromeDriver();

		/* Go to main page */
		driver.get("http://automationpractice.com/index.php");

		/* Your Logo img - verify redirect URL */
		driver.findElement(By.cssSelector("[src=\"http://automationpractice.com/img/logo.jpg")).click();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php");
	}
}
