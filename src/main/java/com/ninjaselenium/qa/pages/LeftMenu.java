package com.ninjaselenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='nav-link' and @routerlink='/study']")
	WebElement study;
	@FindBy(xpath = "//span[@class='fadeInRight animated nav-link-name name-hide tax-show' and contains(text(), 'Homework')]")
	WebElement homework;
	@FindBy(xpath = "//span[@class='fadeInRight animated nav-link-name name-hide tax-show' and contains(text(), 'Improvement Book')]")
	WebElement improvementbook;
	@FindBy(xpath = ".p-dialog-header-close-icon.ng-tns-c92-36.pi.pi-times")
	WebElement popupcloseofimprovementbook;
	@FindBy(xpath = "//a[@class='nav-link' and @routerlink='digital-material']")
	WebElement digitalmaterial;
	@FindBy(xpath = "//span[@class='fadeInRight animated nav-link-name name-hide tax-show' and contains(text(),'Test and Reports ')]")
	WebElement testAndReport;
	// Using this to visibility of element (true/false)
	@FindBy(xpath = "//a[@class='nav-link' and @routerlink='/study']")
	WebElement studyvisible;
	@FindBy(xpath = "//span[@class='fadeInRight animated nav-link-name name-hide tax-show' and contains(text(), 'Homework')]")
	WebElement homeworkvisible;
	@FindBy(xpath = "//span[@class='fadeInRight animated nav-link-name name-hide tax-show' and contains(text(), 'Improvement Book')]")
	WebElement improvementbookvisibile;
	@FindBy(xpath = "//a[@class='nav-link' and @routerlink='digital-material']")
	WebElement digitalmaterialvisible;
	@FindBy(xpath = "//span[@class='fadeInRight animated nav-link-name name-hide tax-show' and contains(text(),'Test and Reports ')]")
	WebElement testandreportvisible;
	@FindBy(xpath = "//p[@class='header-text' and contains(text(),'Study')]")
	WebElement modulenameofstudy;
	@FindBy(xpath = "//p[@class='v-t' and contains(text(),'Homework')]")
	WebElement modulenameofhomework;
	@FindBy(xpath = "//span[@class='p-tabview-title ng-star-inserted' and contains(text(),'Study Material')]")
	WebElement modulenameofdigitalmaterial;
	@FindBy(xpath = "//h2[@ng-show=\"$parent.showMainMenu == 'testSummary'\"]//span[1]")
	WebElement modulenameoftest;

	public LeftMenu(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnStudy() {
		study.click();

	}

	public void clickOnHomework() {
		homework.click();

	}

	public void clickOnImprovementbook() {
		improvementbook.click();

	}

	public void clickOnImprovementbookPopup() {
		popupcloseofimprovementbook.click();

	}

	public void clickOnDigitalMaterial() {
		digitalmaterial.click();

	}

	public void clickOnTestAndReport() {
		testAndReport.click();

	}

	public String getModuleNameOfStudy() {
		return modulenameofstudy.getText();

	}

	public String getModuleNameOfHomework() {
		return modulenameofhomework.getText();

	}

	public String getModuleNameOfDigitalMaterial() {
		return modulenameofdigitalmaterial.getText();

	}

	public String getModuleNameOfTest() {
		return modulenameoftest.getText();

	}

	public String getModuleNameOfImprovementBook() {
		return improvementbook.getText();

	}

	public boolean isModuleNameOfStudyAvailable() {
		return studyvisible.isDisplayed();

	}

	public boolean isModuleNameOfHomeworkAvailable() {
		return homeworkvisible.isDisplayed();

	}

	public boolean isModuleNameOfDigitalmaterialAvailable() {
		return digitalmaterialvisible.isDisplayed();

	}

	public boolean isModuleNameOfImprovementbook() {
		return improvementbookvisibile.isDisplayed();

	}

	public boolean isModuleNameOfTestAndReport() {
		return testandreportvisible.isDisplayed();

	}

}
