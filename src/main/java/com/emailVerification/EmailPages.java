package com.emailVerification;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPages {


	final WebDriver driver;

	public EmailPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/div[1]/div[1]/ul[1]/li[1]/button[1]")
	private WebElement addInbox;
	public WebElement clickAddInbox() {
		return addInbox;
	}

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	private WebElement user;
	public WebElement clickUser() {
		return user;
	}

	@FindBy(xpath = "//th[contains(text(),'Subject')]")
	private WebElement subjectTitle;
	public WebElement subjectTitle() {
		return subjectTitle;
	}

	@FindBy(xpath = "//button[contains(text(),'Add now!')]")
	private WebElement addNOw;
	
	public WebElement addNow() {
		return addNOw;
	}

}
