package com.testscripts.gurukulApp;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.basesource.action.PreDefinedActions;
import com.gurukulApp.pages.DashboardPage;
import com.gurukulApp.pages.SettingsPage;


public class AccountTest extends CommonTest {
	private static Logger LOGGER = Logger.getLogger(AccountTest.class);
	
	@Test(priority = 1, groups = { "REGRESSION"})
	public final void verifyAccountMenuSettingsValidations() throws Exception {
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		SettingsPage settingsPage = new SettingsPage(PreDefinedActions.getDriver()).getInstance();
		login("admin", "admin");	
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");		
		dashboardPage.waitUntillElementIsPresent("account");	
		dashboardPage.clickOnElementsOfDashboardPage("account");
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("accountText").equals("Account"), "Account title text is incorrect");
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("settingText").equals("Settings"), "Settings text is incorrect");
		dashboardPage.clickOnElementsOfDashboardPage("settings");
		Assert.assertTrue(settingsPage.matchTextOfSettingsPage("settingsTitle", "User settings for"),"Settings page title is incorrect");
	    settingsPage.clickOnElementsOfSettingsPage("firstName");
	    settingsPage.clearTextForSettingsPage("firstName");
        settingsPage.clickOnElementsOfSettingsPage("lastName");	    
		Assert.assertTrue(settingsPage.matchTextOfSettingsPage("firstNameBlank", "Your first name is required."),"Error message for blank first name field is incorrect ");
	    settingsPage.clearTextForSettingsPage("lastName");
		settingsPage.clickOnElementsOfSettingsPage("firstName");
		sleeper(2000);
		Assert.assertTrue(settingsPage.matchTextOfSettingsPage("lastNameBlank", "Your last name is required."),"Error message for blank last name field is incorrect ");
		}
	
	@Test(priority = 2, groups = { "REGRESSION"})
	public final void verifyAccountMenuSettingsNotSavedError() throws Exception {
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		SettingsPage settingsPage = new SettingsPage(PreDefinedActions.getDriver()).getInstance();
		login("admin", "admin");	
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");		
		dashboardPage.waitUntillElementIsPresent("account");	
		sleeper(2000);
		dashboardPage.clickOnElementsOfDashboardPage("account");
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("accountText").equals("Account"), "Account title text is incorrect");
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("settingText").equals("Settings"), "Settings text is incorrect");
		dashboardPage.clickOnElementsOfDashboardPage("settings");
		Assert.assertTrue(settingsPage.matchTextOfSettingsPage("settingsTitle", "User settings for"),"Settings page title is incorrect");
        settingsPage.clickOnElementsOfSettingsPage("firstName");
        settingsPage.clearTextForSettingsPage("firstName");
        settingsPage.enterTextForSettingsPage("firstName", "User1");
        settingsPage.clickOnElementsOfSettingsPage("lastName");
        settingsPage.clearTextForSettingsPage("lastName");
        settingsPage.enterTextForSettingsPage("lastName", "Name");
        settingsPage.clickOnElementsOfSettingsPage("email");
        settingsPage.clearTextForSettingsPage("email");
        settingsPage.enterTextForSettingsPage("email", "User1Name@gmail.com");
        settingsPage.selectDropDownOfSettingsPage("language", "string:en");
        sleeper(4000);
        settingsPage.clickOnElementsOfSettingsPage("save");
        settingsPage.waitUntilElementsOfSettingsPage("error");		       
		Assert.assertTrue(settingsPage.matchTextOfSettingsPage("error", "An error has occurred!"),"User setting is saved successfully, we are expecting error");
        sleeper(4000);

     		
	}
}
