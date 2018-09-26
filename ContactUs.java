package automationpractice.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactUs {
	protected static WebDriver driver;

	@BeforeTest()
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	}

	@AfterTest()
	public void afterTest() {
		driver.quit();
	}

	/* Contact Us tab - verify redirect URL */
	@Test(priority = 0)
	public void contactUsTest() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.partialLinkText("Contact")).click();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact");
		driver.close();
	}

	/* Choosing drop down first option */
	@Test(priority = 1)
	public void dropdownTests1() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.partialLinkText("Contact")).click();
		Select subject = new Select(driver.findElement(By.id("id_contact")));
		subject.selectByVisibleText("Customer service");

		/* Checking if the text under the drop down is correct */
		WebElement customerText = driver.findElement(By.xpath("//*[@id=\"desc_contact2\"]"));
		customerText.getText();
		Assert.assertEquals(customerText.getText(), "For any question about a product, an order");
		driver.close();
	}

	/* Choosing drop down second option */
	@Test(priority = 2)
	public void dropdownTests2() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.partialLinkText("Contact")).click();
		Select subject = new Select(driver.findElement(By.id("id_contact")));
		subject.selectByVisibleText("Webmaster");
		WebElement webmasterText = driver.findElement(By.xpath("//*[@id=\"desc_contact1\"]"));
		webmasterText.getText();
		Assert.assertEquals(webmasterText.getText(), "If a technical problem occurs on this website");
		driver.close();
	}

}
