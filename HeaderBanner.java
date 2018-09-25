package automationpractise.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

	@Test()(priority = 0)
	public void logoRedirectURL() {
		driver = new ChromeDriver();

		/* Go to main page */
		driver.get("http://automationpractice.com/index.php");

		/* Your Logo img - verify redirect URL */
		String yourLogoURL = "http://automationpractice.com/index.php";
		WebElement yourLogo = driver.findElement(By.cssSelector("[src=\"http://automationpractice.com/img/logo.jpg"));
		yourLogo.click();

		assertEquals(driver.getCurrentUrl(), yourLogoURL);
	}
}
