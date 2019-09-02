package com.testscripts.gurukulApp;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.basesource.action.PreDefinedActions;
import com.gurukulApp.pages.BranchPage;
import com.gurukulApp.pages.DashboardPage;
import com.gurukulApp.pages.StaffPage;
import com.gurukulApp.pages.ViewBranchPage;
import com.gurukulApp.pages.ViewStaffPage;


public class DashboardTest extends CommonTest {
	private static Logger LOGGER = Logger.getLogger(DashboardTest.class);
    public String branchName = null;	
    

	
	@Test(priority = 2, groups = { "REGRESSION"},description = "Test to verify branch addition")
	public final void verifyBranchEntityType() throws Exception {
		waitForPageLoaded();
		login("admin", "admin");		
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		BranchPage branchPage = new BranchPage(PreDefinedActions.getDriver()).getInstance();
		ViewBranchPage viewBranchPage = new ViewBranchPage(PreDefinedActions.getDriver()).getInstance();
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("entities");
		dashboardPage.clickOnElementsOfDashboardPage("entities");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("branch");
		dashboardPage.clickOnElementsOfDashboardPage("branch");
		Assert.assertTrue(branchPage.getTextOfBranchPage("branchTitle").equals("Branches"), "Branch page title text is incorrect");	
        branchPage.clickOnElementsOfBranchPage("createBranch");
		Assert.assertTrue(branchPage.getTextOfBranchPage("createBranchText").equals("Create a new Branch"), "Create a new branch title text is incorrect");	
        String str = branchPage.generateRandomString();
        branchPage.enterTextForBranchPage("nameInput", str);
        branchPage.enterTextForBranchPage("codeInput", str);
        branchPage.verifyElementIsClickableOfBranchPage("saveBtn");
        branchPage.clickOnElementsOfBranchPage("saveBtn");
        sleeper(3000);  
        branchPage.waitUntilElementsOfBranchPage("query");
        branchPage.enterTextForBranchPage("query", str);
        branchPage.clickOnElementsOfBranchPage("search");  
     	Assert.assertTrue(branchPage.getTextOfBranchPage("listName").equals(str), "Search functionality not working");   
     	branchName = str;
        LOGGER.info("Query functionality working");
        branchPage.clickOnElementsOfBranchPage("view");  
        viewBranchPage.waitUntilElementsOfViewBranchPage("viewBranchTitle");
        viewBranchPage.matchTextOfViewBranchPage("viewBranchTitle", "Branch");                    
	}
	
	
	@Test(priority = 3, groups = { "REGRESSION"}, dependsOnMethods = { "verifyBranchEntityType" },description = "Test to verify staff addition")
	public final void verifyStaffEntityType() throws Exception {
		login("admin", "admin");		
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		BranchPage branchPage = new BranchPage(PreDefinedActions.getDriver()).getInstance();
		StaffPage staffPage = new StaffPage(PreDefinedActions.getDriver()).getInstance();
		dashboardPage.waitUntillElementIsPresent("dashboardTitle");	
        Thread.sleep(4000);	
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");
 		dashboardPage.clickOnElementsOfDashboardPage("entities");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("staff");
		dashboardPage.clickOnElementsOfDashboardPage("staff");	
		staffPage.waitUntilElementsOfStaffPage("staffTitle");
		Assert.assertTrue(staffPage.getTextOfStaffPage("staffTitle").equals("Staffs"), "Staffs page title text is incorrect");
        staffPage.clickOnElementsOfStaffPage("createStaff");
		Assert.assertTrue(staffPage.getTextOfStaffPage("createStaffText").equals("Create a new Staff"), "Create a new Staff title text is incorrect");	
        String name = branchPage.generateRandomString();
        staffPage.enterTextForStaffPage("nameInput", name);
        sleeper(3000);
        staffPage.clickOnElementsOfStaffPage("branchDropDown");
        sleeper(2000);
        staffPage.selectDropDownOfStaffPage("branchDropDown", "number:1");
        staffPage.clickOnElementsOfStaffPage("saveBtn");
        sleeper(2000);
        staffPage.waitUntilElementsOfStaffPage("query");
        staffPage.enterTextForStaffPage("query", name);
        staffPage.clickOnElementsOfStaffPage("search");  
     	Assert.assertTrue(staffPage.getTextOfStaffPage("listName").equals(name), "Search functionality not working");        
      
	}	
	
	@Test(priority = 4, groups = { "REGRESSION"}, dependsOnMethods = { "verifyBranchEntityType"},description = "Test to Verify operations query,view,delete,edit for branch entity" )
	public final void verifyOperationsOfBranchEntityType() throws Exception {
		login("admin", "admin");		
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		BranchPage branchPage = new BranchPage(PreDefinedActions.getDriver()).getInstance();
		ViewBranchPage viewBranchPage = new ViewBranchPage(PreDefinedActions.getDriver()).getInstance();
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("entities");
		dashboardPage.clickOnElementsOfDashboardPage("entities");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("branch");
		dashboardPage.clickOnElementsOfDashboardPage("branch");
		Assert.assertTrue(branchPage.getTextOfBranchPage("branchTitle").equals("Branches"), "Branch page title text is incorrect");	
        sleeper(3000);  
        branchPage.clickOnElementsOfBranchPage("view");       
        viewBranchPage.waitUntilElementsOfViewBranchPage("viewBranchTitle");
        viewBranchPage.matchTextOfViewBranchPage("viewBranchTitle", "Branch");     
        viewBranchPage.matchTextOfViewBranchPage("name", branchName);     
        viewBranchPage.clickOnElementsOfViewBranchPage("back");  
        branchPage.clickOnElementsOfBranchPage("edit"); 
        branchPage.clickOnElementsOfBranchPage("saveBtn");
        sleeper(3000);
        branchPage.clickOnElementsOfBranchPage("delete"); 
        Assert.assertTrue(branchPage.matchTextOfBranchPage("deleteText", "Are you sure you want to delete Branch"));
        branchPage.verifyElementIsEnableOfBranchPage("deleteBtn"); 
 }
	@Test(priority = 5, groups = { "REGRESSION"}, dependsOnMethods = { "verifyStaffEntityType"},description = "Test to Verify operations query,view,delete,edit for staff entity" )
	public final void verifyOperationsOfStaffEntityType() throws Exception {
		login("admin", "admin");		
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		StaffPage staffPage = new StaffPage(PreDefinedActions.getDriver()).getInstance();
		ViewStaffPage viewStaffPage = new ViewStaffPage(PreDefinedActions.getDriver()).getInstance();
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");		
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("entities");
		dashboardPage.clickOnElementsOfDashboardPage("entities");
		dashboardPage.waitForPresenceOfElementsOfDashboardPage("staff");
		dashboardPage.clickOnElementsOfDashboardPage("staff");	
		staffPage.waitUntilElementsOfStaffPage("staffTitle");
		Assert.assertTrue(staffPage.getTextOfStaffPage("staffTitle").equals("Staffs"), "Staffs page title text is incorrect");		
		viewStaffPage.waitUntilElementsOfViewStaffPage("viewStaffTitle");
        viewStaffPage.matchTextOfViewStaffPage("viewStaffTitle", "Staff");     
        viewStaffPage.clickOnElementsOfViewStaffPage("back");  
        staffPage.waitUntilElementsOfStaffPage("edit");
        staffPage.clickOnElementsOfStaffPage("edit"); 
        staffPage.clickOnElementsOfStaffPage("saveBtn");
        sleeper(3000);
        staffPage.clickOnElementsOfStaffPage("delete"); 
        sleeper(3000);
        Assert.assertTrue(staffPage.matchTextOfStaffPage("deleteText", "Are you sure you want to delete Staff"));
  	}
}
