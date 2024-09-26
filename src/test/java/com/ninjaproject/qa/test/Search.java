package com.ninjaproject.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjaselenium.qa.base.Base;
import com.ninjaselenium.qa.pages.SearchPage;

public class Search extends Base {

	public Search() {

		super();
	}

	WebDriver driver;

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@BeforeMethod
	public void setup() {

		driver = initilizeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));

	}

	@Test(priority = 1)
	public void verifySearchWithExistsKeywords() {

		SearchPage sp = new SearchPage(driver);
		sp.inputTextInTextBox(testprop.getProperty("ProductName"));
		sp.clickOnSearchBoxIcon();
		System.out.println("Getting Product:- " + sp.getSerachedValue());

//		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("HP");
//		driver.findElement(By.cssSelector(".fa.fa-search")).click();
//		String product = driver.findElement(By.linkText("HP LP3065")).getText();
//		System.out.println("Founded product is: "+ product);
		Assert.assertEquals(sp.getSerachedValue(), "HP LP3065", "Found correct product");

	}

}
