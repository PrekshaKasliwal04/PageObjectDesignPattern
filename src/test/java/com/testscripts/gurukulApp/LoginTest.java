package com.testscripts.gurukulApp;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basesource.action.PreDefinedActions;
import com.gurukulApp.pages.DashboardPage;
import com.gurukulApp.pages.LoginPage;


public class LoginTest extends CommonTest {
	private static Logger LOGGER = Logger.getLogger(LoginTest.class);
	
	@Test(priority = 1, groups = { "REGRESSION"},description = "Verify User login with valid credentials")
	public final void verifyUserLoginWithValidCreds() throws Exception {
		waitForPageLoaded();
		login("admin", "admin");		
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Login Success");
        logout();
		LOGGER.info("Logout Success");		
	}
	@Test(priority = 2, groups = { "REGRESSION"},description = "Verify User login with valid credentials")
	public final void verifyUserLoginWithInValidCreds() throws Exception {
		LoginPage loginPage = new LoginPage(PreDefinedActions.getDriver()).getInstance();
		waitForPageLoaded();
		login("random", "random");	
		Assert.assertTrue(loginPage.getTextOfLoginPage("authError").equals("Authentication failed!"), "Entered user details are not In-valid");	
		LOGGER.info("Invalid User login error Success");		
		
		
	}
}
