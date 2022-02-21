package com.papPages;
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


	// Affiliate Menu
	@FindBy(css = "div[title='Affiliates']  .MenuEntryLabel")
	private WebElement affMenu;	
	public WebElement getAffMenu() {
		return affMenu;		
	}

	// Affiliate Manager Menu
	@FindBy(css =  "div[title='Affiliates Manager']  .MenuEntryLabel")
	private WebElement affMngrMenu;	
	public WebElement getAffMngrMenu() {
		return affMngrMenu;		
	}
	
	// Campaigns  Menu
	@FindBy(css = "div[title='Campaigns']  .MenuEntry")
	private WebElement campaignsMenu;	
	public WebElement getCampaignsMenu() {
		return campaignsMenu;		
	}

	// Affiliate Manager Menu
	@FindBy(css =  "div[title='Campaigns Manager']  .MenuEntryLabel")
	private WebElement campgnMngrMenu;	
	public WebElement getCampgnMngrMenu() {
		return campgnMngrMenu;		
	}


}
