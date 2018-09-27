package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeaderBanner {
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
	public void headerUrlRedirect() {

		/* Go to main page */
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		/* header banner - verify redirect URL */
		driver.findElement(By.cssSelector("[src=\"http://automationpractice.com/modules/blockbanner/img/sale70.png\"]"))
				.click();
		driver.getCurrentUrl();

		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php");
	}

}
