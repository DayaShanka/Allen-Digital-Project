package com.ninjaselenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement enterEmailId;

	@FindBy(name = "password")
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//h1[contains(text(), 'Account Logout')]")
	private WebElement logoutSuccessMessage;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterValidEmail(String emailText) {

		enterEmailId.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		enterPassword.sendKeys(passwordText);

	}

	public void clickOnLoginButton() {
		loginButton.click();

	}
	
	public String getLogoutSuccessMessage() {
		
		String lsm = logoutSuccessMessage.getText();
		return lsm;
	}
}
