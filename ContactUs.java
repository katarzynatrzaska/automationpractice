package automationpractise.com;

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

		WebElement ContactUs = driver.findElement(By.partialLinkText("Contact"));
		ContactUs.click();
		driver.getCurrentUrl();
		{
			Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact");
			driver.close();
		}
	}

	/* Choosing drop down first option */
	@Test(priority = 1)
	public void dropdownTests1() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		WebElement ContactUs = driver.findElement(By.partialLinkText("Contact"));
		ContactUs.click();
		Select Subject = new Select(driver.findElement(By.id("id_contact")));
		Subject.selectByVisibleText("Customer service");

		/* Checking if the text under the drop down is correct */
		WebElement CustomerText = driver.findElement(By.xpath("//*[@id=\"desc_contact2\"]"));
		CustomerText.getText();
		{
			Assert.assertEquals(CustomerText.getText(), "For any question about a product, an order");
			driver.close();
		}

	}

	/* Choosing drop down second option */
	@Test(priority = 2)
	public void dropdownTests2() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		WebElement ContactUs = driver.findElement(By.partialLinkText("Contact"));
		ContactUs.click();
		Select Subject = new Select(driver.findElement(By.id("id_contact")));
		Subject.selectByVisibleText("Webmaster");

		WebElement WebmasterText = driver.findElement(By.xpath("//*[@id=\"desc_contact1\"]"));
		WebmasterText.getText();
		{
			Assert.assertEquals(WebmasterText.getText(), "If a technical problem occurs on this website");
			driver.close();
		}

	}
}
