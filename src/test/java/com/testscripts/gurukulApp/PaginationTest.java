package com.testscripts.gurukulApp;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basesource.action.PreDefinedActions;
import com.gurukulApp.pages.BranchPage;
import com.gurukulApp.pages.DashboardPage;
import com.gurukulApp.pages.StaffPage;

public class PaginationTest extends CommonTest {
	private static Logger LOGGER = Logger.getLogger(PaginationTest.class);

	@Test(priority = 1, groups = { "REGRESSION" })
	public final void verifyPagination() throws Exception {
		waitForPageLoaded();
		login("admin", "admin");
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		BranchPage branchPage = new BranchPage(PreDefinedActions.getDriver()).getInstance();
		StaffPage staffPage = new StaffPage(PreDefinedActions.getDriver()).getInstance();
		sleeper(3000);
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"),"Dashboard title text is incorrect");
		LOGGER.info("Dashboard title is matched");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("entities");
		dashboardPage.clickOnElementsOfDashboardPage("entities");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("staff");
		dashboardPage.clickOnElementsOfDashboardPage("staff");
		staffPage.waitUntilElementsOfStaffPage("staffTitle");
		// Adding 50 staff below to generate pagination buttons
		for(int i =0;i<50;i++)
        {
		staffPage.clickOnElementsOfStaffPage("createStaff");
		Assert.assertTrue(staffPage.getTextOfStaffPage("createStaffText").equals("Create a new Staff"),	"Create a new Staff title text is incorrect");
		String name = branchPage.generateRandomString();
		staffPage.enterTextForStaffPage("nameInput", name);
		staffPage.clickOnElementsOfStaffPage("branchDropDown");
		staffPage.selectDropDownOfStaffPage("branchDropDown", "number:1");
		staffPage.clickOnElementsOfStaffPage("saveBtn");
		sleeper(3000);
		 }
		staffPage.scrollTillViewOfStaffPage("firstPageLastEntry");
		staffPage.verifyTextPresentOnElementOfStaffPage("firstPageLastEntry", "21");
		staffPage.clickOnElementsOfStaffPage("nextBtn");
		LOGGER.info("Clicked on next button");
		sleeper(3000);
		Assert.assertFalse(staffPage.verifyElementIsPresent("firstPageLastEntry"));
		LOGGER.info("Next button validated");
		staffPage.scrollTillViewOfStaffPage("prevBtn");
		staffPage.clickOnElementsOfStaffPage("prevBtn");
		LOGGER.info("Previous button validated");
		staffPage.scrollTillViewOfStaffPage("firstPageLastEntry");
		staffPage.clickOnElementsOfStaffPage("nextBtn");
		Assert.assertFalse(staffPage.verifyElementIsPresent("firstPageLastEntry"));
		staffPage.scrollTillViewOfStaffPage("firstBtn");
		staffPage.clickOnElementsOfStaffPage("firstBtn");
		LOGGER.info("First button validated");
		sleeper(3000);	
		staffPage.scrollTillViewOfStaffPage("lastBtn");
		staffPage.clickOnElementsOfStaffPage("lastBtn");
		Assert.assertFalse(staffPage.verifyElementIsPresent("firstPageLastEntry"));
		LOGGER.info("Last button validated");	
		sleeper(3000);

	}
}
