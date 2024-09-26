package com.ninjaselenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='input-group']//input")
	private WebElement inputText;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement clickOnSearch;

	@FindBy(linkText = "HP LP3065")
	private WebElement getSearchedText;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void inputTextInTextBox(String searchData) {
		inputText.sendKeys(searchData);

	}

	public void clickOnSearchBoxIcon() {

		clickOnSearch.click();
	}

	public String getSerachedValue() {

		return getSearchedText.getText();
	}

}
