package com.papPages;

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

	// username field
	@FindBy(css = "input[name='username']")
	private WebElement userNameField;	
	public WebElement getUserNameField() {
		return userNameField;		
	}

	// password field
	@FindBy(css = "input[name='password']")
	private WebElement passwordField;	
	public WebElement getPasswordField() {
		return passwordField;		
	}
	
	// login Button
	@FindBy(css = ".Button.pap-btn .ButtonText")
	private WebElement loginBtn;	
	public WebElement getLoginBtn() {
		return loginBtn;		
	}
}
