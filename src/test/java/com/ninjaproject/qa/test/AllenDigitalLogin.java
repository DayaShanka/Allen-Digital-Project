package com.ninjaproject.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjaselenium.qa.base.Base;
import com.ninjaselenium.qa.pages.AllenHomePage;
import com.ninjaselenium.qa.pages.AllenLoginPage;
import com.ninjaselenium.qa.pages.AllenProfilePage;
import com.ninjaselenium.qa.pages.AllenTestPage;

public class AllenDigitalLogin extends Base {

	public AllenDigitalLogin() {

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

	}

	@Test
	public void verifyWithValidCredentials() {

		AllenLoginPage alp = new AllenLoginPage(driver);
		alp.enterEnrollmentNo(prop.getProperty("enrollmentNo"));
		alp.enterPassword(prop.getProperty("password"));
		alp.enterCaptcha(prop.getProperty("captcha"));
		alp.clickOnLoginButton();

		AllenHomePage ahp = new AllenHomePage(driver);

		System.out.println("Getting module name as: " + ahp.retrieveLandingPageModule());
		String greeting = ahp.retrieveGreetingMessage();
		System.out.println("Greeting Message:- " + greeting);
		boolean logo = ahp.visibilityOfLogo();
		Assert.assertTrue(logo, "Logo is not visible");

		AllenProfilePage app = new AllenProfilePage(driver);
		app.clickOnProfile();
//		 driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		String formNumber = app.getEnrollmentNo();
		System.out.println("Enrollment_No:- " + formNumber);
		String batchText = app.getBatchName();
		System.out.println("Batch:- " + batchText);
		String session = app.getSession();
		System.out.println("Session:- " + session);
		WebElement retriveStreamName = app.getStream();
		String streamName = retriveStreamName.getText();
		String title = retriveStreamName.getAttribute("title");
		if (title.contains("PRE-NURTURE")) {
			System.out.println("Stream:- " + streamName);
		} else if (title.contains("PRE-MEDICAL")) {
			System.out.println("Stream:- " + streamName);
		} else if (title.contains("JEE MAIN + ADVANCED")) {
			System.out.println("Stream:- " + streamName);
		} else {
			System.out.println("Stream name does not match the expected value.");
		}
		String studentName = app.getStudentName();
		System.out.println("Student Name: -" + studentName);

//		driver.findElement(By.name("user")).sendKeys("1000606939");
//		driver.findElement(By.name("pass")).sendKeys("dstd#123");
//		driver.findElement(By.id("reg-code")).sendKeys("susr");
//		driver.findElement(By.id("submit")).click();
//		WebElement getTitle = driver.findElement(By.xpath(
//				"//nav[@class='navbar navbar-expand-sm navbar-dark dash-head p-0 ng-star-inserted'] //span[contains(text(), 'Schedule')]"));
//		System.out.println("Getting module name as: " + getTitle.getText());

		AllenTestPage atp = new AllenTestPage(driver);

		driver.findElement(By.xpath("//span[contains(text(),'Test and Reports')]")).click();
		int allStartStatus = atp.getCountOfStartTest();
		int allMissedStatus = atp.getCountOfMissedTest();
		int allResumeStatus = atp.getCountOfResumeTest();
		int allSubmittedStatus = atp.getSubmittedTest();
		System.out.println("Count of Start Test:- " + allStartStatus);
		System.out.println("Count of Missed Test:- " + allMissedStatus);
		System.out.println("Count of Resume Test:- " + allResumeStatus);
		System.out.println("Count of Submitted Test:- " + allSubmittedStatus);
//		for (WebElement startButton : allStartStatus) {// enhanced loop
//			if (startButton.isDisplayed() && startButton.isEnabled()) {
//				// startButton.click();
//				System.out.println("Clicked on 'Start Test' button");
//				break;
//			} else {
//				System.out.println("'Start Test' button is not clickable");
//			}
//		}

//		for (int i = 0; i < allStartStatus; i++) {
//		    int buttonText = allStartStatus;
//		    System.out.println("Clicked on button with text: " + buttonText);
//		    
//		}
//		    		    
//		    if (buttonText.contains("Start Test")) {
//		        // Click on the "Start Test" button
//		        allStartStatus.get(i).click();

		// Perform any actions after clicking the button

		// Print the text of the button

//		}

//		}

	}

}
