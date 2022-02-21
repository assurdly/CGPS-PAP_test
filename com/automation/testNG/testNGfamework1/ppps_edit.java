package com.automation.testNG.testNGfamework1;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ppps_edit {
	WebDriver driver;
	
  @BeforeClass
  public void personal_info_edit() {
	   WebDriver driver= new ChromeDriver();

	   driver.manage().window().maximize();  
	   driver.get("https://ssupgrade.softalliance.com:4581/softsuite/f?p=2000004:LOGIN:0:::::&tz=1:00");
	   driver.findElement(By.cssSelector("input#P9999_USERNAME")).sendKeys("DEMO USER");
	   driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password@123");
	   driver.findElement(By.cssSelector("div.t-Login-buttons")).click();
  }
  @AfterClass
  public void logout() {
	  
  }
  @Test
  public void login() {
	  driver.findElement(By.xpath("//h3[contains(text(),'My Profile')]")).click();
	  driver.findElement(By.xpath("//strong[contains(text(),'Employee Information')]")).click();
	  
//		Select selectDay = new Select(createNew.findElement(By.id("day")));
//		Select selectMonth = new Select(createNew.findElement(By.id("month")));
//		Select selectYear = new Select(createNew.findElement(By.id("year")));
//		
//		selectDay.selectByVisibleText("8");
//		selectMonth.selectByVisibleText("May");
//		selectYear.selectByVisibleText("2001");
  }
}
