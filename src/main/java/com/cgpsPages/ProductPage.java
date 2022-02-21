package com.cgpsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// hamburger icon
	@FindBy(xpath = "//span[contains(text(),'Add product')]")
	private WebElement addProduct;	
	public WebElement getAddProductMenu() {
		return addProduct;		
	}

	// select vendor field
	@FindBy(xpath = "//span[@id='select2-form_default_vendor-container']")
	private WebElement selectVendor;	
	public WebElement getSelectVendorField() {
		return selectVendor;		
	}
	// search field
	@FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
	private WebElement searchVendor;	
	public WebElement getSearchVendorField() {
		return searchVendor;		
	}

	// sku field
	@FindBy(id = "form_default_sku")
	private WebElement sku;	
	public WebElement getskuField() {
		return sku;		
	}
	// product name field
	@FindBy(id = "form_default_name")
	private WebElement productName;	
	public WebElement getProductNameField() {
		return productName;		
	}

	// price field
	@FindBy(xpath = "//input[@id='form_prices_and_inventory_price_price']")
	private WebElement price;	
	public WebElement getPriceField() {
		return price;		
	}
	// market price field
	@FindBy(xpath = "//input[@id='form_prices_and_inventory_price_market_price']")
	private WebElement marketPrice;	
	public WebElement getMarketPriceField() {
		return marketPrice;		
	}
	// Submit button field
	@FindBy(css = ".regular-main-button span")
	private WebElement addProductButton;	
	public WebElement getAddProductButton() {
		return addProductButton;		
	}

}
