package com.cgpsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// terms and conditon checkbox
	@FindBy(id = "tosconsent")
	private WebElement termsAndCondtn;	
	public WebElement termsAndCondtn() {
		return termsAndCondtn;		
	}

	// woven radio button
	@FindBy(id = "pmethod196")
	private WebElement wovenPayOptn;	
	public WebElement wovenPayOptn() {
		return wovenPayOptn;		
	}

	//Buy button
	@FindBy(xpath = "//span[contains(text(),'BUY')]")
	private WebElement buyBtn;	
	public WebElement buyBtn() {
		return buyBtn;		
	}

	//Final price
	@FindBy(css = ".part-integer")
	private WebElement finalPrice;	
	public WebElement finalPrice() {
		return finalPrice;		
	}
	// Woven

	//Pay with transfer button
	@FindBy(xpath = "//p[contains(text(),'Pay with Transfer')]")
	private WebElement payTransfer;	
	public WebElement payTransfer() {
		return payTransfer;		
	}
	
	// aza number
	@FindBy(css = "div:nth-of-type(2) > div > .details-table__row__content.row > span")
	private WebElement aza;	
	public WebElement aza() {
		return aza;		
	}


}
