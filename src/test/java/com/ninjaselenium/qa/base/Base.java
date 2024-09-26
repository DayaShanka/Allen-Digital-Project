package com.ninjaselenium.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	WebDriver driver;// set globly.

	public Properties prop;
	public Properties testprop;

	public Base() {

		testprop = new Properties();
		File testPropFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\ninjaselenium\\qa\\testdata\\testdata.properties");

		try {
			FileInputStream fis2 = new FileInputStream(testPropFile);
			testprop.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prop = new Properties();

		File propFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\ninjaselenium\\qa\\config\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(propFile);

			prop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public String getProperty(String key) {
//        return prop.getProperty(key);
//    }

	// Set globally so that use with all methods in this class

	public WebDriver initilizeBrowserAndOpenApplicationURL(String browserName) {
		// returning driver so we are using WebDriver data type.

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {

		} else {
			System.out.println("Invalid browser name provided: " + browserName);
		}

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//		Homepage homepage = new Homepage(driver);
//		homepage.clickOnMyAccount();
//		driver.get(prop.getProperty("url"));
//		driver.get(prop.getProperty("allenUrl"));

		return driver;

	}

}
