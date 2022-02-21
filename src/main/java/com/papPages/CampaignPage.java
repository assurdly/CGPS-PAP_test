package com.papPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
	public CampaignPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Ola edit button icon
	@FindBy(xpath = "//tbody/tr[3]/td[9]/div[1]/div[2]/div[1]")
	private WebElement editIcon;	
	public WebElement getEditIcon() {
		return editIcon;		
	}

	// Product ID  title
	@FindBy(xpath = "//h2[contains(text(),'Product ID ')]")
	private WebElement productIdTitle;	
	public WebElement getProductIdTitle() {
		return productIdTitle;		
	}

	// Product ID  Field
	@FindBy(css = "textarea[name='productid']")
	private WebElement productIdField;	
	public WebElement getProductIdField() {
		return productIdField;		
	}

	// saveBtn
	@FindBy(css = ".Button.btn-primary.pap-btn  .ButtonText")
	private WebElement saveBtn;	
	public WebElement getSaveBtn() {
		return saveBtn;		
	}	

}
