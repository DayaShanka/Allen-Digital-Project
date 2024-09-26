package com.ninjaselenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllenProfilePage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	WebElement clickProfile;
	@FindBy(xpath="//*[@class=\"formNumber\"]//p[2]")
	WebElement formId;
	@FindBy(css=".batchText.ml-3.mt-3.custombatch")
	WebElement batch;
	@FindBy(xpath="//div[@class='d-flex']//span[1]")
	WebElement session;
	@FindBy(xpath="//*[@class=\"stream-name\" and @title=\"PRE-MEDICAL\" or @title=\"PRE-NURTURE\" or @title=\"JEE MAIN + ADVANCED\" or @title=\"JEE MAIN\" ]")
	WebElement stream;
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	WebElement stName;
	
	public AllenProfilePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getEnrollmentNo() {
		
		return formId.getText();
	}
	public String getBatchName() {
		return batch.getText();
	}
	public void clickOnProfile() {
		
		clickProfile.click();
	}
	
	public String getSession() {
		return session.getText();
	}
	public WebElement getStream() {
		return stream;
	}
	public String getStudentName() {
		return stName.getText();
	}
	
}
