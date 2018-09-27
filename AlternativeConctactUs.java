//var SendButton is calld using private WebElement getSendButton//

package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlternativeConctactUs {

	protected static WebDriver driver;

	@BeforeTest()
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=contact");
	}

	@Test(priority = 0)
	public void blankFormTest() {
		getSendButton().click();
		WebElement errorField = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
		Assert.assertEquals(errorField.getText(), "Invalid email address.");

	}

	@Test(priority = 1)
	public void correctEmailonly() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kasiatrzaska@o2.pl");
		getSendButton().click();
		WebElement errorField = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
		Assert.assertEquals(errorField.getText(), "The message cannot be blank.");

	}

	private WebElement getSendButton() {
		return driver.findElement(By.id("submitMessage"));
	}
}
