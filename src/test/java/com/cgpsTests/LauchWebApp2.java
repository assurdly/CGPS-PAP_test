package com.cgpsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LauchWebApp2 {


	@Test
	public void openCGPS() throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
        //navigate to url
        driver.get("https://webpay-ui.k9.isw.la/");
        Thread.sleep(2000);
        //scroll down to where other wallet is
       JavascriptExecutor ja = (JavascriptExecutor) driver;
        ja.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
       driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[6]/div[2]")).click();
       driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]")).click();
       //here a search is done instead of selecting for the list
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/input[1]")).sendKeys("mt");       //return to change payment method
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h6[contains(text(),'MTN')]")).click();
       Thread.sleep(2000);
        //we can go back to Change payment method to select from the list
       driver.findElement(By.xpath("//p[contains(text(),'Change payment method')]")).click();
     //scroll down and select from the list instead of a search
       Thread.sleep(2000);
       WebElement selwal = driver.findElement(By.xpath("//p[contains(text(),'Make secure payments using third-party payment sol')]"));
       ja.executeScript("arguments[0].click();", selwal);
       Thread.sleep(2000);
       driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]")).click();
       //selects the choice provider from the list
       String testprov= driver.findElement(By.xpath("//h4[contains(text(),'Select Provider')]")).getText();
        System.out.println(testprov);
       //driver.findElement(By.cssSelector(".sc-dRPiIx .jbJDWL:nth-of-type(4)")).click();

      WebElement selpro = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[3]/div[4]"));
       ja.executeScript("arguments[0].click();", selpro);

	}
}
