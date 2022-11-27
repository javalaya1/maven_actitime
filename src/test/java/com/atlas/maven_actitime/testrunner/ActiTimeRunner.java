package com.atlas.maven_actitime.testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atlas.maven_actitime.pages.ActTimeTasksPage;
import com.atlas.maven_actitime.pages.ActitimeTimeTrackPage;
import com.atlas.maven_actitime.utility.CommonUtility;

public class ActiTimeRunner extends BaseClass {
	@Test(groups = { "low" })
	public void verifyHomePageTitle() {
		// 6. take expected title from file
		String expected_title = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "homepage.title");
		System.out.println(expected_title);
		// 7
//		ActitimeTimeTrackPage actimePageObject = new ActitimeTimeTrackPage(driver);
//		String actualtitle = actimePageObject.getPageTitle();
//
//		// 8
//		Assert.assertEquals(actualtitle, expected_title);
	}

//	@Test(groups = { "high" })
//	public void verifyAddingACustomer() {
////		preSteps();
//		ActitimeTimeTrackPage attrack = new ActitimeTimeTrackPage(this.driver);
//		attrack.clickTasksLink();
//
//		ActTimeTasksPage attasks = new ActTimeTasksPage(this.driver);
//		attasks.clickAddNewButton();
//		attasks.clickNewCustomerButton();
//
//		// String enter customername - name take from props file
//		String customerName = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "taskspage.customername");
//		String customerDesc = CommonUtility.getPropertyValue("atlas_actitime_testconfig",
//				"taskspage.customerdescription");
//		attasks.enterCustomerName(customerName);
//		attasks.enterCustomerDesc(customerDesc);
//		attasks.clickCreateCustomer();
//		String actual = attasks.getCreatedCustomerText(customerName);
//
//		Assert.assertTrue(actual.equals(customerName));
//	}
//
//	@Test(groups = { "high" })
//	public void verifyDeleteCustomer() {
//		// 7
//		ActitimeTimeTrackPage attrack = new ActitimeTimeTrackPage(this.driver);
//		attrack.clickTasksLink();
//
//		ActTimeTasksPage attasks = new ActTimeTasksPage(this.driver);
//		String customerName = CommonUtility.getPropertyValue("atlas_actitime_testconfig", "taskspage.customername");
//		attasks.clickOnCustomerToDelete(customerName);
//		attasks.clickEditButton(customerName);
//		attasks.clickActions();
//		attasks.clickDeleteLink();
//		attasks.clickDeletePermanetlyButton();
//	}

}
