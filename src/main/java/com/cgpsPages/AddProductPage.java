package com.cgpsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	WebDriver driver;
	public AddProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	// choose file
	@FindBy(css =  "input#file-upload")
	private WebElement fileUpload;	
	public WebElement getFileUpload() {
		return fileUpload;		
	}
	// import button
	@FindBy(xpath = "//span[contains(text(),'Start Import')]")
	private WebElement importBtn;	
	public WebElement getImportBtn() {
		return importBtn;		
	}

}
