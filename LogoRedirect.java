package automationpractice.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class LogoRedirect {

	public void testng () {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Go to main page */
		driver.get("http://automationpractice.com/index.php");

		/* Your Logo img - verify redirect URL */
		String yourLogoURL = "http://automationpractice.com/index.php";
		WebElement yourLogo = driver.findElement(By.cssSelector("[src=\"http://automationpractice.com/img/logo.jpg"));
		yourLogo.click();
		if (driver.getCurrentUrl().equals(yourLogoURL)) {
			System.out.println("Veryfing yourLogo URL passed");
		} else {
			System.out.println("Veryfing yourLogo URL did not passed");
		}

	}
}