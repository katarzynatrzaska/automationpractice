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

public class FormValidation {
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
	public void blankFormTest() {
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=contact");
		driver.findElement(By.id("submitMessage")).click();
		WebElement ErrorField = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
		Assert.assertEquals(ErrorField.getText(), "Invalid email address.");
	}

	@Test(priority = 1)
	public void correctEmailonly() {
		driver.findElement(By.id("email")).sendKeys("kasiatrzaska@o2.pl");
		driver.findElement(By.id("submitMessage")).click();
		WebElement ErrorField = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
		Assert.assertEquals(ErrorField.getText(), "The message cannot be blank.");
	}

	@Test(priority = 2)
	public void allCorrect() {

		Select subject = new Select(driver.findElement(By.id("id_contact")));
		subject.selectByVisibleText("Customer service");
		driver.findElement(By.id("id_order")).sendKeys("Order 123");
		driver.findElement(By.id("message")).sendKeys("Test message");
		/* File upload */
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\test_image.png");
		driver.findElement(By.id("submitMessage")).click();
		WebElement ErrorField = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
		Assert.assertEquals(ErrorField.getText(), "Your message has been successfully sent to our team.");
	}
}
