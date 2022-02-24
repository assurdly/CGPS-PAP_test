package com.cgpsTests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cgpsPages.CheckoutPage;
import com.cgpsPages.ProductFormPage;
import com.cgpsPages.ProductSumPage;

public class BuyProduct {
	
	static String FINAL_PRICE;
	static String AZA;
	SoftAssert SoftAssert = new SoftAssert();
	@Test
	public void test () throws IOException, InterruptedException {
		System.out.println("--- sTARTING aGENT bULKuPLOAD tEST");
		LauchWebApp kApp = new LauchWebApp();
		WebDriver driver = kApp.openCGPSStoreFront("Non-corporate-family-1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ProductFormPage formPage =new ProductFormPage(driver);
		formPage.firstName().sendKeys("inotest");
		formPage.lastName().sendKeys("konohamru");
		formPage.email().sendKeys("test@vomoto.com");
		formPage.phoneNo().sendKeys("070454008918");
		formPage.address().sendKeys("34 farin street");
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", formPage.submitBtn());
		js.executeScript("window.scroll(0, -300)");
		formPage.submitBtn().click();
		
		ProductSumPage sumPage =new ProductSumPage(driver);
		sumPage.uploadDoc().sendKeys(System.getProperty("user.dir")+"/src/cgps/sample.png");
		sumPage.uploadBtn().click();
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")));
		sumPage.confirmBtn().click();
		
		CheckoutPage checkout = new CheckoutPage(driver);
		FINAL_PRICE = checkout.finalPrice().getText()+"00";
		 checkout.wovenPayOptn().click();
		 checkout.termsAndCondtn().click();
		 js.executeScript("window.scroll(0, 200)");
		 checkout.buyBtn().click();
		 
		 driver.switchTo().frame("iframe");
		 checkout.payTransfer().click();
		 AZA = checkout.aza().getText();
		 System.out.println(AZA);
		 js.executeScript("window.open('');");
		 Set<String> windows =  driver.getWindowHandles();
		 for (String string : windows) {
			 driver.switchTo().window(string);
			 if (driver.getTitle().equalsIgnoreCase("")) {
				WovenPayment wovenPayment = new WovenPayment(driver);
				wovenPayment.wovenPaymentTest();
			}
		}
		 for (String string : windows) {
			 driver.switchTo().window(string);
			 if (!driver.getTitle().equalsIgnoreCase("")) {
				 driver.switchTo().frame("iframe");
				String modal = driver.findElement(By.cssSelector("subtitle")).getText();
				System.out.println(modal);
			 }
		 }
	}
}
