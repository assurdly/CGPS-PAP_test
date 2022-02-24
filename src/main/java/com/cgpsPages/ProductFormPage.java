package com.cgpsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFormPage {
	WebDriver driver;
	public ProductFormPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// First Name
	@FindBy(xpath = "//label[contains(text(),'First Name')]/following-sibling::textarea")
	private WebElement firstName;	
	public WebElement firstName() {
		return firstName;		
	}

	// lastName field
	@FindBy(xpath = "//label[contains(text(),'Last Name')]/following-sibling::textarea")
	private WebElement lastName;	
	public WebElement lastName() {
		return lastName;		
	}
	// phone number field
	@FindBy(xpath = "//label[contains(text(),'Phone Number')]/following-sibling::textarea")
	private WebElement phoneNo;	
	public WebElement phoneNo() {
		return phoneNo;		
	}

	// email field
	@FindBy(xpath = "//label[contains(text(),'Email')]/following-sibling::textarea")
	private WebElement email;	
	public WebElement email() {
		return email;		
	}
	// Home address field
	@FindBy(xpath = "//label[contains(text(),'Home Address')]/following-sibling::textarea")
	private WebElement address;	
	public WebElement address() {
		return address;		
	}

	// Home address field
	@FindBy(css = ".btn.mysubmit-btn.regular-button.submit")
	private WebElement submit;	
	public WebElement submitBtn() {
		return submit;	
	}

}
