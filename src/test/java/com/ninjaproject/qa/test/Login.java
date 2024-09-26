package com.ninjaproject.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjaselenium.qa.base.Base;
import com.ninjaselenium.qa.pages.Homepage;
import com.ninjaselenium.qa.pages.LoginPage;
import com.ninjaselenium.qa.util.Utilities;

public class Login extends Base {

	public Login() {

		super();
	}

	// Using inheritance of base class so that we can access their methods.

	WebDriver driver; // Set globally so that use with all methods in this class

	@AfterMethod
	public void tearDown() { // it will call in end to close browser with every methods.
		if (driver != null) {
			driver.quit();
		}

	}

	@BeforeMethod
	public void setup() { // it will call in starting with every methods.

		driver = initilizeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLoginOption();

//		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
//		driver.findElement(By.linkText("Login")).click();
	}

	@Test(priority = 2)
	public void verifyInvalidEmailAndPassword() throws InterruptedException {
		Thread.sleep(4);
		LoginPage login = new LoginPage(driver);
		login.enterValidEmail(Utilities.generateEmailWithTimeStamp());
		login.enterPassword(prop.getProperty("validPassword"));
		login.clickOnLoginButton();

//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.name("password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]"))
				.isDisplayed(), testprop.getProperty("warningMsgOfwrongEmailAndPassword"));
		WebElement actualWarningMsg = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]"));
		System.out.println("Warning msg: " + actualWarningMsg.getText());

	}

	@Test(priority = 1) // , dataProvider = "validCredentialsSupplier") // we can write method name or
						// given name which is
						// coming from name variable.
	public void verifyValidEmailAndPassword() {

//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUserName"));
//		driver.findElement(By.name("password")).sendKeys(prop.getProperty("validPassword"));
		// using this with supplyTestData method

		LoginPage login = new LoginPage(driver);
		login.enterValidEmail(prop.getProperty("validUserName"));
		login.enterPassword(prop.getProperty("validPassword"));
		login.clickOnLoginButton();

//		driver.findElement(By.id("input-email")).sendKeys(email);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		WebElement info = driver.findElement(By.linkText("Edit your account information"));
		System.out.println("After Login: " + info.getText());
		Assert.assertTrue(info.isDisplayed(), "Edit your account information");
		Assert.assertTrue(driver.findElement(By.linkText("Qafox.com")).isDisplayed(), "Qafox.com");

		if (info.getText().equals("Edit your account information")) {
			System.out.println("Test Passed Successfully");
		} else {
			System.out.println("Test Failed");
		}

	}

//Data suppling from this created method
//	@DataProvider(name = "validCredentialsSupplier")
//	public Object[][] supplyTestData() {
//
////		Object[][] data = { { "daya.choubey.111@gmail.com", "123456" }, { "daya@gmail.com", "123456" } };
//
//		Object[][] data = Utilities.getTestDataFromExcel("Login");
//		return data;
//
//	}

	@Test(priority = 3)
	public void verifyLogout() {

		LoginPage login = new LoginPage(driver);
		login.enterValidEmail(prop.getProperty("validUserName"));
		login.enterPassword(prop.getProperty("validPassword"));
		login.clickOnLoginButton();

//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUserName"));
//		driver.findElement(By.name("password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Getting Logout Msg:- " + login.getLogoutSuccessMessage());
//		String logOutMsg = driver.findElement(By.xpath("//h1[contains(text(), 'Account Logout')]")).getText();
		Assert.assertEquals(login.getLogoutSuccessMessage(), testprop.getProperty("logoutSuccessMsg"),
				"Unable to find logout message");
		System.out.println(
				driver.findElement(By.xpath("//h1[contains(text(), 'Account Logout')]")).getText() + " Successfully");

	}

}
