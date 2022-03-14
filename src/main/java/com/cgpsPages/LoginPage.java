package com.cgpsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// First Name
	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	private WebElement userName;	
	public WebElement userNameField() {
		return userName;		
	}
	// First Name
	@FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
	private WebElement pswrd;	
	public WebElement pwrdField() {
		return pswrd;		
	}
	// First Name
	@FindBy(xpath = "//span[contains(text(),'Log in')]")
	private WebElement login;	
	public WebElement loginBtn() {
		return login;		
	}
}
