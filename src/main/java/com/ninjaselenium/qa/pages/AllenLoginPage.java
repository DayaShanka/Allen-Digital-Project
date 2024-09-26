package com.ninjaselenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllenLoginPage {

	WebDriver driver;
	@FindBy(name = "user")
	private WebElement EnrollmentNo;
	@FindBy(name = "pass")
	private WebElement Password;
	@FindBy(id = "reg-code")
	WebElement Captcha;
	@FindBy(id = "submit")
	WebElement LoginButton;

	public AllenLoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEnrollmentNo(String enrollmentNo) {

		EnrollmentNo.sendKeys(enrollmentNo);
	}

	public void enterPassword(String password) {

		Password.sendKeys(password);
	}

	public void enterCaptcha(String captcha) {

		Captcha.sendKeys(captcha);
	}

	public void clickOnLoginButton() {

		LoginButton.click();
	}

}
