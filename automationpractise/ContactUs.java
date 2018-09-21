package automationpractice.com;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test

public class ContactUs {

	public void testng() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/* Go to main page */
		driver.get("http://automationpractice.com/index.php");

		/* Contact Us tab - verify redirect URL */
		String ContactURL = "http://automationpractice.com/index.php?controller=contact";
		WebElement ContactUs = driver.findElement(By.partialLinkText("Contact"));
		ContactUs.click();
		{
			if (driver.getCurrentUrl().equals(ContactURL)) {
				System.out.println("Veryfing ContactUs URL passed");
			} else {
				System.out.println("Veryfing ContactUs URL did not passed");
			}

		}

		/* Choosing drop down first option */
		Select Subject = new Select(driver.findElement(By.id("id_contact")));
		Subject.selectByVisibleText("Customer service");

		/* Checking if the text under the drop down is correct */
		WebElement CustomerText = driver.findElement(By.xpath("//*[@id=\"desc_contact2\"]"));
		CustomerText.getText();
		{
			if (driver.getPageSource().contains("For any question about a product, an order")) {
				System.out.println("Text is correct");

			} else {
				System.out.println("Text is incorrect");

			}
		}

		/* Choosing drop down second option */
		Subject.selectByVisibleText("Webmaster");

		/* Checking if the text under the drop down is correct */
		WebElement WebmasterText = driver.findElement(By.xpath("//*[@id=\"desc_contact1\"]"));
		WebmasterText.getText();
		if (driver.getPageSource().contains("If a technical problem occurs on this website")) {
			System.out.println("Text is correct");

		} else {
			System.out.println("Text is incorrect");

		}

		/* CONTACT FORM VALIDATION */

		/* Leave inputs empty - click Submit */
		WebElement SendButton = driver.findElement(By.id("submitMessage"));
		SendButton.click();

		WebElement EmptyFieldsError = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
		EmptyFieldsError.getText();
		{
			if (driver.getPageSource().contains("Invalid email address.")) {
				System.out.println("EmptyFields error is correct");

			} else {
				System.out.println("EmptyFields error is incorect");

			}
		}

	}
}