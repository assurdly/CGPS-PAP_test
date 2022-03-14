package com.cgpsTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cgpsPages.AddProductPage;
import com.cgpsPages.HomePage;
import com.cgpsPages.LoginPage;

public class BulkUpload {
	SoftAssert SoftAssert = new SoftAssert();
	@Test
	public void bulkUpload () throws IOException, InterruptedException {
		System.out.println("--- sTARTING aGENT bULKuPLOAD tEST");
		LauchWebApp kApp = new LauchWebApp();
		WebDriver driver = kApp.openCGPS("", true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Utils fileTsting = new Utils();
	    fileTsting.write();
	    
	    HomePage home = new HomePage(driver);
		//home.getHamburgerIcon().click();
		Thread.sleep(3000);
		home.getUsersMenu().click();
		home.getAgentBulkUpload().click();
		
		AddProductPage addProd = new AddProductPage(driver);
		
	    addProd.getFileUpload().sendKeys(System.getProperty("user.dir")+"/src/cgps/output.csv");
	    addProd.getImportBtn().click();
	    String actualStatus = driver.findElement(By.xpath("//body/div[@id='status-messages']/ul[1]/li[1]")).getText();
	    String expectedStatus = "File Processed Successfully: Registered (1) Duplicate (0) Error (0)";
     
	    SoftAssert.assertEquals(actualStatus, expectedStatus);
	    SoftAssert.assertAll();
	    System.out.println("bULK uPLOAD cOMPLETED");
	}
	@Test
	public void newAgentLogin() {
		System.out.println("--- sTARTING aGENT bULKuPLOAD tEST");
		LauchWebApp kApp = new LauchWebApp();
		WebDriver driver = kApp.openCGPS("", false);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userNameField().sendKeys(Utils.email+"@vomoto.com");
		loginPage.pwrdField().sendKeys(Utils.email.toLowerCase());
		loginPage.loginBtn().click();
		String changePswrdText = "Admin has requested a change of password for your account. Please change the password before you proceed.";
		String actualTextString = driver.findElement(By.tagName("p")).getText();
		SoftAssert.assertEquals(changePswrdText, actualTextString);
	    SoftAssert.assertAll();		
	}
}
