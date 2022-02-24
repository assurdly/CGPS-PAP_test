package com.cgpsTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.WovenPages.WovenPage;

public class WovenPayment {
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	public WovenPayment(WebDriver driver) {
		this.driver = driver;
	}
	@Test
	public void wovenPaymentTest () throws IOException {
		System.out.println("--- sTARTING aGENT bULKuPLOAD tEST");
		LauchWebApp kApp = new LauchWebApp();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://woven.finance/");
		WovenPage woven = new WovenPage(driver);
		woven.signInBtn().click();
		woven.emailField().sendKeys("finance@coronationgps.com");
		woven.pswrdField().sendKeys("Coron@tion2021");
		woven.loginBtn().click();

		driver.findElement(By.cssSelector(".dashboard__sidebar")).click();
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 500)");
		woven.devMenu().click();
		woven.vnubanField().sendKeys(BuyProduct.AZA);
		woven.amountField().sendKeys(BuyProduct.FINAL_PRICE);
		woven.bankSlct().click();
		woven.bankSlct().sendKeys("Sparkle");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		woven.nextBtn().click();
		woven.finishBtn().click();


		softAssert.assertEquals(woven.successMsg().getText(), "Transfer was successful");
		softAssert.assertAll();
		System.out.println(woven.successMsg().getText());
		

	}
}
