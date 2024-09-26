package com.ninjaproject.qa.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjaselenium.qa.base.Base;
import com.ninjaselenium.qa.pages.AllenHomePage;
import com.ninjaselenium.qa.pages.AllenLoginPage;
import com.ninjaselenium.qa.pages.LeftMenu;

public class LeftMenuClicked extends Base {

	public LeftMenuClicked() {
		super();

	}

	WebDriver driver;

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

	@BeforeMethod
	public void setup() {

		driver = initilizeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.get(prop.getProperty("allenUrl"));
		driver.getTitle();
	}

	@Test
	public void verifyOnClickLeftMenuModules() throws InterruptedException {

		AllenLoginPage alp = new AllenLoginPage(driver);
		alp.enterEnrollmentNo(prop.getProperty("enrollmentNo"));
		alp.enterPassword(prop.getProperty("password"));
		alp.enterCaptcha(prop.getProperty("captcha"));
		alp.clickOnLoginButton();

		AllenHomePage ahp = new AllenHomePage(driver);

		if (ahp.popupVisibilityofAllen() == true) {
			ahp.clickOnRedirectionPopupOfAllenPlatform();
		} else if (ahp.popupVisibilityofAllen() == false) {
			System.out.println("Redirection popup not found");
			return;
		}

		if (ahp.sessionPopupVisible() == true) {
			Thread.sleep(2);

			ahp.clickOnSessionPopup();
			Thread.sleep(2);
			ahp.clickOnSelectSession();

		} else {
			System.out.println("session popup not found");
		}
		if (ahp.sessionPopupVisible()) {
			ahp.clickOnRedirectionPopupOfAllenPlatform();
		} else {
			System.out.println("Redirection popup not found");
		}

//		boolean logo = ahp.visibilityOfLogo();
//		Assert.assertTrue(logo, "Logo is not visible");
		System.out.println("Client Name: " + driver.getTitle());
		System.out.println("Landing Page is: " + "\u001B[1m" + ahp.retrieveLandingPageModule() + "\u001B[0m");

//		String greeting = ahp.retrieveGreetingMessage();
		String greetingnew = ahp.retrieveGreetingMessageOfNewCal();
//		System.out.println("Greeting Message:- " + greeting);
		System.out.println("Greeting Message:- " + greetingnew);
		// System.out.println("Landing Page is: " + ahp.retrieveLandingPageModule());
		LeftMenu lmc = new LeftMenu(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

		boolean isStudyAvailable = lmc.isModuleNameOfStudyAvailable();
		Thread.sleep(5);
		// System.out.println("Visibility " + isStudyAvailable);
		if (isStudyAvailable) {

			lmc.clickOnStudy();
			String studyVisibitity = lmc.getModuleNameOfStudy();
			Assert.assertEquals(studyVisibitity, "Study", "Study module is not visible");
			System.out.println("Clicked on " + studyVisibitity);
		} else {
			System.out.println("Study module is not available for this student");
		}
		boolean isDigitalMaterialAvailable = lmc.isModuleNameOfDigitalmaterialAvailable();
		Thread.sleep(5);
		if (isDigitalMaterialAvailable) {
			lmc.clickOnDigitalMaterial();
			String digitalMaterialVisibitity = lmc.getModuleNameOfDigitalMaterial();
			Assert.assertEquals(digitalMaterialVisibitity, "Study Material", "Digital Material module is not visible");
			System.out.println("Clicked on " + digitalMaterialVisibitity);
		} else {
			System.out.println("Digital Material module is n" + "ot available for this student");
		}
		boolean isImprovementBookAvailable = lmc.isModuleNameOfImprovementbook();
		Thread.sleep(5);
		if (isImprovementBookAvailable) {
			lmc.clickOnImprovementbook();

			if (lmc.getModuleNameOfImprovementBook() == null) {

				lmc.clickOnImprovementbookPopup();
			}

			String improvementBookVisibility = lmc.getModuleNameOfImprovementBook();
			System.out.println("Clicked on " + improvementBookVisibility);
		} else {
			System.out.println("Improvement Book module is not available for this student");
		}
		boolean isHomeworkAvailable = lmc.isModuleNameOfHomeworkAvailable();

//		System.out.println(isHomeworkAvailable);
		Thread.sleep(5);
		if (isHomeworkAvailable) {
			Thread.sleep(2);
			lmc.clickOnHomework();
			String homeworkVisibitity = lmc.getModuleNameOfHomework();
			Assert.assertEquals(homeworkVisibitity, "Homework", "Homework module is not visible");
			System.out.println("Clicked on " + homeworkVisibitity);
		} else {
			System.out.println("Homework module is not available for this" + " student");
		}

		boolean isTestAndReportAvailable = lmc.isModuleNameOfTestAndReport();
		Thread.sleep(5);
		if (isTestAndReportAvailable) {
			lmc.clickOnTestAndReport();
			String testReportVisibitity = lmc.getModuleNameOfTest();
			Assert.assertEquals(testReportVisibitity, "Test", "Test & Reports module is not visible");
			System.out.println("Clicked on " + testReportVisibitity);
		} else {
			System.out.println("Test & Reports module is not available for this student");
		}

	}

}
