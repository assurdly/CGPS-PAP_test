package com.cgpsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cgpsPages.ProductPage;
import com.papPages.CampaignPage;
import com.papPages.HomePage;
import com.papPages.LoginPage;

public class PAPAgents {
	WebDriver driver = null;
	JavascriptExecutor js;
	
	
	
	@BeforeMethod
	public void loginPAP() throws InterruptedException {
		
		LauchWebApp kApp = new LauchWebApp();
		//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		driver = kApp.openPAP();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		login.getUserNameField().sendKeys("technology@coronationgps.com");
		login.getPasswordField().sendKeys("C0r0n@t!0n");
		login.getLoginBtn().click();
		js =  (JavascriptExecutor) driver;
		
	}

	@Test
	public void verifyPAPAccount() throws InterruptedException {
		System.out.println("--- sTARTING vERIFYING nEW aGENT aCCOUNT tEST");
		HomePage homePage = new HomePage(driver);
		
		// checking that the agent is created
		homePage.getAffMenu().click();
		homePage.getAffMngrMenu().click();
		Thread.sleep(3000);
		for (int i = 1; i < 100; i++) {
			if (driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText().equalsIgnoreCase(Utils.email+"@vomoto.com")) {
				System.out.println("fOUND cREATED aGENT: "+driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText());
			}
		}
		
		driver.get("https://coronationgps.postaffiliatepro.com/merchants/index.php#Affiliate-Tree");
		driver.findElement(By.xpath("//div[contains(text(),'Michael Kalu')]")).click();
		
		// checking the affiliate tree for the new agent
		WebElement name = driver.findElement(By.xpath("//div[contains(text(),'michael.kalu@coronationgps.com')]/ancestor::tr/td/img"));	
		js.executeScript("arguments[0].scrollIntoView(true);",name);
		name.click();
		System.out.println("fOUND tHE aGENT iN tHE aFFILIATE tREE: "+driver.findElement(By.xpath("//div[contains(text(),'"+Utils.email+"@vomoto.com')][1]")).getText());
		
	}
	

	
//	@Test
	public void addProductTOCampaign() throws InterruptedException {
		
		System.out.println("--- sTARTING ADD pRPODUCT tO cAMPAIGN tEST ----");
		HomePage homePage = new HomePage(driver);
		homePage.getCampaignsMenu().click();
		homePage.getCampgnMngrMenu().click();
		
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getEditIcon().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);", campaign.getProductIdTitle());
		campaign.getProductIdField().click();
		Actions builderActions = new Actions(driver);
		builderActions.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.RIGHT).build().perform();
		
		campaign.getProductIdField().sendKeys(", "+CreateProduct.prodId);
		WebElement textBox = driver.findElement(By.cssSelector(".TextArea.TextBoxContainer"));

	    System.out.println("aDD pRODUCT tO cAMPAIGN cOMPLETED \nAll prodcut Ids: "+ campaign.getProductIdField().getAttribute("value"));
	

	}
}
