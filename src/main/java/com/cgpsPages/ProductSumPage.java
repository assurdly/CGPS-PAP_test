package com.cgpsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSumPage {
	WebDriver driver;
	public ProductSumPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// First Name
	@FindBy(css = "input#order_documents")
	private WebElement uploadDoc;	
	public WebElement uploadDoc() {
		return uploadDoc;		
	}

	// lastName field
	@FindBy(css = ".action span")
	private WebElement uploadBtn;	
	public WebElement uploadBtn() {
		return uploadBtn;		
	}
	// confirm button
	@FindBy(css = ".comfirm-shipping span")
	private WebElement confirmBtn;	
	public WebElement confirmBtn() {
		return confirmBtn;		
	}

}
