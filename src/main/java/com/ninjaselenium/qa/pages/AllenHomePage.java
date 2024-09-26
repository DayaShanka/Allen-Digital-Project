package com.ninjaselenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllenHomePage {

	WebDriver driver;
	@FindBy(xpath = "//a[@class='navbar-brand main-logo mr-sm-3 ml-4 ml-sm-0'] //img")
	WebElement logo;
	@FindBy(xpath = "//nav[@class='navbar navbar-expand-sm navbar-dark dash-head p-0 ng-star-inserted'] //span[contains(text(), 'Schedule')]")
	WebElement schedulePage;
	@FindBy(xpath = "//div[@class='float-left cal-message-text']")
	WebElement greeting;
	@FindBy(xpath = "//p[@class='kudos-name']")
	WebElement greetingnewcal;
	@FindBy(xpath = "//img[@class = 'cancel-icon']")
	private WebElement allenRedirectionPopup;
	@FindBy(xpath = "//img[@class = 'cancel-icon']")
	private WebElement RedirectionPopupVisibility;
	@FindBy(xpath = "//p[@class='input ng-star-inserted' and @id='5']")
	WebElement sessionPopup;
	@FindBy(xpath = "//p[@class='input ng-star-inserted' and @id='5']")
	WebElement sessionPopupVisibility;
	@FindBy(xpath = "//*[@id=\"session-modal\"]/div[2]/div/div/button")
	WebElement selectSession;

	public AllenHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean visibilityOfLogo() {
		return logo.isDisplayed();

	}

	public String retrieveLandingPageModule() {

		return schedulePage.getText();
	}

	public String retrieveGreetingMessage() {

		return greeting.getText();
	}

	public String retrieveGreetingMessageOfNewCal() {

		return greetingnewcal.getText();
	}

	public void clickOnRedirectionPopupOfAllenPlatform() {
		allenRedirectionPopup.click();
	}

	public boolean popupVisibilityofAllen() {
		return RedirectionPopupVisibility.isDisplayed();
	}

	public void clickOnSessionPopup() {
		sessionPopup.click();
	}

	public boolean sessionPopupVisible() {
		return sessionPopup.isDisplayed();
	}

	public void clickOnSelectSession() {
		selectSession.click();
	}
}
