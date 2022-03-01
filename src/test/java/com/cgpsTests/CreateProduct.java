package com.cgpsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cgpsPages.HomePage;
import com.cgpsPages.ProductPage;

public class CreateProduct {
	SoftAssert softAssert =  new SoftAssert();
	static String prodId;
	static String prodName;
	
	@Test
	public void creatOneProduct() throws InterruptedException {
		System.out.println("--- sTARTING cREATE nEW aGENT pRODUCT tEST");
		LauchWebApp kApp = new LauchWebApp();
		//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		WebDriver driver = kApp.openCGPS("");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage home = new HomePage(driver);
		home.getHamburgerIcon().click();
		   
		home.getCatalogMenu().click();
		home.getProductsMenu().click();
		home.getAddProductMenu().click();
		ProductPage product = new ProductPage(driver);		
		product.getSelectVendorField().click();
		
		
		product.getSearchVendorField().sendKeys(Utils.email+"@vomoto.com");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'("+Utils.email+"@vomoto.com)')]"))));
		
		Actions builderActions = new Actions(driver);
		builderActions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Created product with email: "+Utils.email);
		
		Utils utils = new Utils();
		String append = utils.randomString(4);
		prodName = "AutoTest"+ append;
		prodId = "AT-"+append;
		Thread.sleep(2000);
		product.getProductNameField().sendKeys(prodName);
		product.getskuField().sendKeys(prodId);
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", product.getPriceField());
		Thread.sleep(2000);
		product.getPriceField().click();
		builderActions.sendKeys(Keys.LEFT).sendKeys(Keys.LEFT).sendKeys(Keys.LEFT).sendKeys(Keys.LEFT).build().perform();
		product.getPriceField().sendKeys("15000");
		
		product.getMarketPriceField().click();
		builderActions.sendKeys(Keys.LEFT).sendKeys(Keys.LEFT).sendKeys(Keys.LEFT).sendKeys(Keys.LEFT).build().perform();
		product.getMarketPriceField().sendKeys("15000");
		product.getAddProductButton().click();
		
		softAssert.assertNotNull(driver.findElement(By.xpath("//body/div[@id='status-messages']/ul[1]")));
		softAssert.assertAll();

	    System.out.println("cREATE pRODUCT cOMPLETED");
	}

}
