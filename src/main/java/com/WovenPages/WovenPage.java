package com.WovenPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WovenPage {
	WebDriver driver;
	public WovenPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Sign in 
	@FindBy(linkText = "Sign In")
	private WebElement signInBtn;	
	public WebElement signInBtn() {
		return signInBtn;		
	}

	// email field
	@FindBy(css =  "input[placeholder='Email Address']")
	private WebElement emailField;	
	public WebElement emailField() {
		return emailField;		
	}
	// password field
	@FindBy(css = "input[placeholder='Password']")
	private WebElement pswrdField;	
	public WebElement pswrdField() {
		return pswrdField;		
	}
	// Login page
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	private WebElement loginBtn;	
	public WebElement loginBtn() {
		return loginBtn;		
	}

	// Development menu
	@FindBy(xpath =  "//div[contains(text(),'Development')]")
	private WebElement devMenu;
	public WebElement devMenu() {
		return devMenu;		
	}
	// vNuban field
	@FindBy(xpath =  "//label[contains(text(),'VNuban')]/following-sibling::input")
	private WebElement vnubanField;	
	public WebElement vnubanField() {
		return vnubanField;		
	}
	// Amount field
	@FindBy(xpath = "//label[contains(text(),'Amount')]/following-sibling::input")
	private WebElement amountField;	
	public WebElement amountField() {
		return amountField;		
	}

	// bank selection menu
	@FindBy(css =  "input#icon--")
	private WebElement bankSlct;
	public WebElement bankSlct() {
		return bankSlct;		
	}
	// Next button
	@FindBy(xpath =  "//button[contains(text(),'Next')]")
	private WebElement nextBtn;	
	public WebElement nextBtn() {
		return nextBtn;		
	}

	//Finish button
	@FindBy(xpath =  "//button[contains(text(),'Finish')]")
	private WebElement finishBtn;	
	public WebElement finishBtn() {
		return finishBtn;		
	}
	
	// Transfer successful text
	@FindBy(xpath =  "//div[contains(text(),'Transfer was successful')]")
	private WebElement successMsg;	
	public WebElement successMsg() {
		return successMsg;		
	}
}
