package automationpractice.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

}
