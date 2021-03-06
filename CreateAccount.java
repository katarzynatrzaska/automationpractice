package com.automationpractice;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount {
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
	public void correctSignIn() {

		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Sign")).click();
		driver.findElement(By.id("email_create")).sendKeys(EmailGenerator.getRandomEmail());
		driver.findElement(By.id("SubmitCreate")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_lastname")));

		driver.findElement(By.id("customer_firstname")).sendKeys((RandomStringUtils.randomAlphabetic(5)));
		/* If there was no automatic copy-paste names, use code below */
		// String customerFirstName =
		// driver.findElement(By.id("customer_firstname")).getText();
		// driver.findElement(By.id("firstname")).sendKeys(customerFirstName);

		driver.findElement(By.id("customer_lastname")).sendKeys((RandomStringUtils.randomAlphabetic(5)));
		/* If there was no automatic copy-paste names, use code below */
		// String customerLastName =
		// driver.findElement(By.id("customer_lastname")).getText();
		// driver.findElement(By.id("lastname")).sendKeys(customerLastName);

		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("passwd")).sendKeys((RandomStringUtils.randomAlphabetic(8)));
		driver.findElement(By.id("address1")).sendKeys((EmailGenerator.getRandomEmail() + " TestStreet"));
		driver.findElement(By.id("city")).sendKeys("TestCity");

		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Oklahoma");
		driver.findElement(By.id("postcode")).sendKeys("90210");
		driver.findElement(By.id("phone_mobile")).sendKeys((EmailGenerator.getRandomEmail() + "123456"));
		driver.findElement(By.id("submitAccount")).click();

		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(),
				"http://automationpractice.com/index.php?controller=authentication");
	}

	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);

	}
}
