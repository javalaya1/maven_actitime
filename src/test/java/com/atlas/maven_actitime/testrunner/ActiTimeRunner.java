package com.atlas.maven_actitime.testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atlas.maven_actitime.pages.ActTimeTasks;
import com.atlas.maven_actitime.pages.ActitimeLoginPage;
import com.atlas.maven_actitime.pages.ActitimeTimeTrack;
import com.atlas.maven_actitime.utility.BrowserFactory;
import com.atlas.maven_actitime.utility.CommonUtility;

public class ActiTimeRunner {
	private WebDriver driver = null;

	@BeforeMethod
	public void preSteps() {
		// 1. Open any browser - read the data from the properties file and call a
		// method method of Browser factory
		String browserNameInput = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "browsername");
//		driver = BrowserFactory.openRequiredBorwser(browserNameInput);
//
//		// 2. launch application
//		String urlInput = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "applicationurl");
//		BrowserFactory.launchApplication(urlInput);
//
//		// 3. Enter the username in loginpage
//		ActitimeLoginPage loginPage = new ActitimeLoginPage(driver);
//		String usernameInput = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "username");
//		loginPage.enterUserName(usernameInput);
//
//		// 4. Enter the password in loginpage
//		String passwordInput = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "password");
//		loginPage.enterPassword(passwordInput);
//
//		// 5. Click on login button in loginPage
//		loginPage.clickLoginButton();
	}

//	@AfterMethod
//	public void closure() {
//		// 10.
//		BrowserFactory.closeCurrentBrowser();
//		BrowserFactory.closeAllBrowsers();
//	}

	@Test
	public void verifyHomePageTitle() {
		// 6. take expected title from file
//		String expected_title = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "homepage.title");
//
//		// 7
//		ActitimeTimeTrack actimePageObject = new ActitimeTimeTrack(driver);
//		String actualtitle = actimePageObject.getPageTitle();
//
//		// 8
//		Assert.assertEquals(actualtitle, expected_title);
	}

	@Test
	public void verifyAddingACustomer() {
//		preSteps();
		ActitimeTimeTrack attrack = new ActitimeTimeTrack(this.driver);
		attrack.clickTasksLink();

		ActTimeTasks attasks = new ActTimeTasks(this.driver);
		attasks.clickAddNewButton();
		attasks.clickNewCustomerButton();

		// String enter customername - name take from props file
		String customerName = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "taskspage.customername");
		String customerDesc = CommonUtility.getPropertyValue("atlas_actitime_testconfig",
				"taskspage.customerdescription");
		attasks.enterCustomerName(customerName);
		attasks.enterCustomerDesc(customerDesc);
		attasks.clickCreateCustomer();
		String actual = attasks.getCreatedCustomerText(customerName);

		Assert.assertTrue(actual.equals(customerName));
	}

	@Test
	public void verifyDeleteCustomer() {
		ActitimeTimeTrack attrack = new ActitimeTimeTrack(this.driver);
		attrack.clickTasksLink();

		ActTimeTasks attasks = new ActTimeTasks(this.driver);
		String customerName = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "taskspage.customername");
		attasks.clickOnCustomerToDelete(customerName);
		attasks.clickEditButton(customerName);
		attasks.clickActions();
		attasks.clickDeleteLink();
		attasks.clickDeletePermanetlyButton();
	}

}
