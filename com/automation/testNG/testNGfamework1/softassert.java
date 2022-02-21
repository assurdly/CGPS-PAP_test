package com.automation.testNG.testNGfamework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassert {
  @Test
  public void seacrhsoftassertt() {
	  System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\iankoh.SOFTALLIANCE\\Documents\\sellenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("ps5");
		driver.findElement(By.cssSelector("input[value='Go']")).click();
		
		String expectedurlString = "https://www.amazon.com/s?k=ps5&ref=nb_sb";
		String expectedtitleString = "Amazon.com : ps2";
		
		SoftAssert sa = new SoftAssert();
		String urlString= driver.getCurrentUrl();
		String titltString = driver.getTitle();
		
		System.out.println(urlString);
		System.out.println(titltString);
		
		sa.assertEquals(urlString, expectedurlString);
				
//		sa.assertEquals(urlString, expectedurlString);
//		sa.assertEquals(titltString, expectedtitleString);
//		
		sa.assertAll();
  }
}
