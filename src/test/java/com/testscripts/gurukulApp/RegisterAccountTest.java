package com.testscripts.gurukulApp;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.basesource.action.PreDefinedActions;
import com.gurukulApp.pages.DashboardPage;
import com.gurukulApp.pages.LoginPage;
import com.gurukulApp.pages.RegisterAccountPage;


public class RegisterAccountTest extends CommonTest {
	private static Logger LOGGER = Logger.getLogger(RegisterAccountTest.class);
	
	@Test(priority = 1, groups = { "REGRESSION"})
	public final void verifyRegisterAccountEnrollFailure() throws Exception {
        LoginPage loginPage = new LoginPage(PreDefinedActions.getDriver()).getInstance();
		DashboardPage dashboardPage = new DashboardPage(PreDefinedActions.getDriver()).getInstance();
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(PreDefinedActions.getDriver()).getInstance();
		dashboardPage.waitUntilElementsOfDashBoardPage("dashboardTitle");		
		Assert.assertTrue(dashboardPage.getTextOfDashboardPage("dashboardTitle").equals("Welcome to Gurukula!"), "Dashboard title text is incorrect");	
		LOGGER.info("Dashboard title is matched");
        loginPage.clickOnElementsOfLoginPage("registerAccount");
		Assert.assertTrue(registerAccountPage.getTextOfRegisterAccountPage("registerAccountTitle").equals("Registration"), "Registration title text is incorrect");	
		LOGGER.info("Registration title is matched");
		String name = registerAccountPage.generateAlphaRandomNumber();
        String email = name + "@abc.com";
        String password = name;
		registerAccountPage.enterTextForRegisterAccountPage("loginID", name);
		registerAccountPage.enterTextForRegisterAccountPage("email", email);
		registerAccountPage.enterTextForRegisterAccountPage("password", password);
		registerAccountPage.enterTextForRegisterAccountPage("confirmPassword", password);
	    registerAccountPage.verifyElementIsClickable("registerBtn");
        registerAccountPage.clickOnElementsOfRegisterAccountPage("registerBtn");
        Assert.assertTrue(registerAccountPage.matchTextOfRegisterAccountPage("errorMsg", "Registration failed!"), "Registration failed message is not displayed");     			        
	}
}
