package com.cgpsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LauchWebApp {

	WebDriver driver = null;
	String USERNAME = "developer";
	String PASSWORD = "F88_cCCb19d7Aa1D-_8bEd2b651A-_A0";


	By by;
	//	public void getWebDriver(WebDriver driver) {
	//		this.driver = driver;
	//	}
	@Test
	public WebDriver openCGPS(String instance) {		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		if (instance.equalsIgnoreCase("production")) {
			driver.navigate().to("https://dev-coronationgps.x-shops.com/admin.php");	

		}else {
			driver.navigate().to("https://"+USERNAME+":"+PASSWORD+"@dev-coronationgps.x-shops.com/admin.php");	
		}

		by = By.cssSelector("[name='login']");


		driver.findElement(by).sendKeys("wole.onasanya@coronationinsurance.com.ng");

		// 3. Type 'LGHCzh27DV5F4mD4' in 'password'
		by = By.cssSelector("[name='password']");
		driver.findElement(by).sendKeys("LGHCzh27DV5F4mD4");
		// 4. Click 'Log in'
		by = By.xpath("//button[. = '\n  \n    \n    Log in']");
		driver.findElement(by).click();
		return driver;		
	}
	public WebDriver openPAP() {		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://coronationgps.postaffiliatepro.com/merchants");
		return driver;
	}

	public WebDriver openCGPSStoreFront(String path) {		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.navigate().to("https://coronationgps.x-shops.com/"+path);	
		return driver;
	}
}
