import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test

public class HeaderBanner {

	public void testng() {

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Go to main page */
		driver.get("http://automationpractice.com/index.php");

		/* header banner - verify redirect URL */
		String bannerURL = "http://automationpractice.com/index.php";
		WebElement banner = driver.findElement(
				By.cssSelector("[src=\"http://automationpractice.com/modules/blockbanner/img/sale70.png\"]"));
		banner.click();
		if (driver.getCurrentUrl().equals(bannerURL)) {
			System.out.println("Veryfing banner URL passed");
		} else {
			System.out.println("Veryfing banner URL did not passed");
		}

	}

}