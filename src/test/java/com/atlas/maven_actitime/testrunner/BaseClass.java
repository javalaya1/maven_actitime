
package com.atlas.maven_actitime.testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.atlas.maven_actitime.pages.ActitimeLoginPage;
import com.atlas.maven_actitime.utility.BrowserFactory;
import com.atlas.maven_actitime.utility.CommonUtility;

public class BaseClass {
	WebDriver driver = null;
	String browName = null, url = null; // this.browName , this.url

	@Parameters({ "browsername", "url" }) // reading from xml file
	@BeforeTest(groups = { "high", "low" })
	public void readData(@Optional("edge") String bn, @Optional("https://demo.actitime.com/login.do") String url) { // method.
		this.browName = bn;
		this.url = url;
	}

	// @Parameters({ "uname", "pwd" })
	@BeforeMethod(groups = { "high", "low" })
	public void preSteps() {
		// 1. Open any browser - read the data from the properties file and call a
		// method method of Browser factory
		String browserNameInput = this.browName;

		// CommonUtility.getPropertyValue("atlas_actitime_testconfig", "browsername");
		driver = BrowserFactory.openRequiredBorwser(browserNameInput);

		// 2. launch application
		String urlInput = this.url;
		// CommonUtility.getPropertyValue("atlas_actitime_testconfig",
		// "applicationurl");
		BrowserFactory.launchApplication(urlInput);

		// 3. Enter the username in loginpage
		ActitimeLoginPage loginPage = new ActitimeLoginPage(driver);
		String usernameInput = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "username");
		loginPage.enterUserName(usernameInput);

		// 4. Enter the password in loginpage
		String passwordInput = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "password");
		loginPage.enterPassword(passwordInput);

		// 5. Click on login button in loginPage
		loginPage.clickLoginButton();
	}

	@AfterMethod(groups = { "high", "low" })
	public void closure() {
		// 10.
		BrowserFactory.closeCurrentBrowser();
		BrowserFactory.closeAllBrowsers();
	}

}
