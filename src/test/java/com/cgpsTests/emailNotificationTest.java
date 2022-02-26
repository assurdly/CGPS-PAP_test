package com.cgpsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.emailVerification.EmailPages;

import java.util.concurrent.TimeUnit;

public class emailNotificationTest {
	WebDriver driver;
	SoftAssert softAssert;

	@BeforeClass
	public void launchBrowser() {
		System.out.println("------ADD NEW MAIL TEST STARTED -----");
		//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\chromedriver.exe"); //chrome96
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver.exe"); //chrome92
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		softAssert = new SoftAssert();

	}
	@Test
	public void addInbox() throws InterruptedException {
		//Load URL on chrome browser
		driver.get("https://getnada.com/");
		Thread.sleep(5000);

		//SignIn
		EmailPages newMail = new EmailPages(driver);

		//click on addinboxe
		newMail.clickAddInbox().click();

		//click on user field
		newMail.clickUser().clear();
		newMail.clickUser().sendKeys(Utils.email);
		
		Select select = new Select(driver.findElement(By.tagName("Select")));
		select.selectByValue("vomoto.com");
		
		newMail.addNow().click();
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", newMail.subjectTitle());
		WebElement email1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
		WebElement email2 = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		System.out.println(email1.getText()+"\n"+ email2.getText());
		//email.click();


	}

}
