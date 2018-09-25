package automationpractise.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test

public class HeaderBanner {
	protected static WebDriver driver;
	
	@BeforeTest()
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	}
	@AfterTest()
	public void afterTest() 
	{
		driver.quit();
	}

	@Test(priority = 0)
	public void headerUrlRedirect() {
		/* Go to main page */
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		/* header banner - verify redirect URL */
		String bannerURL = "http://automationpractice.com/index.php";
		WebElement banner = driver.findElement(
				By.cssSelector("[src=\"http://automationpractice.com/modules/blockbanner/img/sale70.png\"]"));
		banner.click();

		assertEquals(driver.getCurrentUrl(), bannerURL);
	}

}
