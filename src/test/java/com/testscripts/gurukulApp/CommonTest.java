package com.testscripts.gurukulApp;


import java.util.Properties;

import org.testng.Assert;

import com.basesource.action.PreDefinedActions;
import com.basesource.utils.ObjectReader;
import com.basetest.environments.SetTestEnvironments;
import com.gurukulApp.pages.LoginPage;

public class CommonTest extends SetTestEnvironments {

	private CommonTest instance;
	private Properties selecteCredentialsProperties;
	private ObjectReader commonTestPropertiesReader = new ObjectReader();
	public static String environment;
	public CommonTest getInstance() {
		if (instance == null) {
			synchronized (CommonTest.class) {
				if (instance == null) {
					instance = new CommonTest();

				}
			}
		}
		return instance;
	}

	public final String getCredentials(String credentials, String key) throws Exception {
		selecteCredentialsProperties = commonTestPropertiesReader.getCredentials(credentials);
		return selecteCredentialsProperties.getProperty(key);
	}

	/**
	 * Login method
	 * 
	 */
	public final void login(String loginId, String password) throws Exception {
		LoginPage loginPage = new LoginPage(PreDefinedActions.getDriver());
		loginPage = loginPage.getInstance();
		loginPage.clickOnElementsOfLoginPage("loginButton");
		loginPage.waitForElementsOfLoginPage("loginId");
		Assert.assertTrue(loginPage.verifyElementsOfLoginPage("loginId"), "Login page did not open successfully");
		loginPage.enterTextForLoginPage("loginId", getCredentials("LoginCredentials", loginId));
		loginPage.enterTextForLoginPage("password", getCredentials("LoginCredentials", password));
		loginPage.clickOnElementsOfLoginPage("authenticate");
	}

	/**
	 * Logout method
	 * 
	 */
	public final void logout() throws Exception {
		LoginPage loginPage = new LoginPage(PreDefinedActions.getDriver()).getInstance();
		loginPage.clickOnElementsOfLoginPage("account");
		loginPage.clickOnElementsOfLoginPage("logoutBtn");
	}
}
