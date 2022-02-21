package com.cgpsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// hamburger icon
	@FindBy(id = "Dashboard")
	private WebElement hamburgerIcon;	
	public WebElement getHamburgerIcon() {
		return hamburgerIcon;		
	}

	// catalog menu
	@FindBy(xpath =  "//div[@id='leftMenu']/ul[1]/li[2]/div[1]/a[1]")
	private WebElement catalogMenu;	
	public WebElement getCatalogMenu() {
		return catalogMenu;		
	}
	// products menu
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	private WebElement productsMenu;	
	public WebElement getProductsMenu() {
		return productsMenu;		
	}
	// add product menu
	@FindBy(xpath = "//span[contains(text(),'Add product')]")
	private WebElement addProduct;	
	public WebElement getAddProductMenu() {
		return addProduct;		
	}

	// users menu
	@FindBy(xpath =  "//div[@id='leftMenu']/ul[1]/li[5]/div[1]/span[1]")
	private WebElement usersMenu;	
	public WebElement getUsersMenu() {
		return usersMenu;		
	}
	// Agent bulk menu
	@FindBy(xpath =  "//span[contains(text(),'Agent Bulk Upload')]")
	private WebElement agentBulkUpload;	
	public WebElement getAgentBulkUpload() {
		return agentBulkUpload;		
	}
}
