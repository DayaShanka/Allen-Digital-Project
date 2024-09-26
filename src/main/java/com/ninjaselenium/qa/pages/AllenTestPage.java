package com.ninjaselenium.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllenTestPage {

	WebDriver driver;

	@FindBy(xpath="//span[contains(text(),'Test and Reports')]")
	WebElement testAndReport;
	@FindBy(xpath = "//a[@class='btn test-active ng-scope starttest']")
	List<WebElement> startTest;
	@FindBy(xpath = "//a[@class='test-missed']")
	List<WebElement> missedTest;
	@FindBy(xpath = "//div[@class='resume_button']")
	List<WebElement> resumeTest;
	@FindBy(xpath="//a[@class='btn test-submit ng-scope submitted_test']//div[text()='Submitted']")
	List<WebElement> submittedTest;

	public AllenTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTestAndReport() {
		testAndReport.click();
	}
	
	public int getCountOfStartTest() {
		return startTest.size();
	}

	public int getCountOfMissedTest() {
		return missedTest.size();
	}
	
	public int getCountOfResumeTest() {
		return resumeTest.size();
	}
	public int getSubmittedTest() {
		return submittedTest.size();
	}
}