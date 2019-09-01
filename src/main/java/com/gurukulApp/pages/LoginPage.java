package com.gurukulApp.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;

public class LoginPage extends CommonMethod {
	private ObjectReader loginPagePropertiesReader = new ObjectReader();
	private Properties loginPagePropertiesPageProperties;

	private LoginPage instance;
	public static String environment, URL;

	public LoginPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (LoginPage.class) {
				if (instance == null) {
					instance = new LoginPage(DRIVER);
				}
			}
		}
		return instance;
	}

	public LoginPage(WebDriver driver) throws IOException {
		loginPagePropertiesPageProperties = loginPagePropertiesReader.getObjectRepository("LoginPage");
	}

	public final boolean verifyElementsOfLoginPage(String key) throws Exception {
		return verifyElementIsPresent(loginPagePropertiesPageProperties.getProperty(key));
	}

	public final boolean waitForElementsOfLoginPage(String key) throws Exception {
		return verifyElementIsVisible(loginPagePropertiesPageProperties.getProperty(key));
	}

	public final boolean matchTextOfLoginPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(loginPagePropertiesPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsEnableOfLoginPage(String key) throws Exception {
		return verifyElementIsEnable(loginPagePropertiesPageProperties.getProperty(key));
	}
	public final String getTextOfLoginPage(String key) throws Exception {
		return getTextBy(loginPagePropertiesPageProperties.getProperty(key));
	}

	public final void clickOnElementsOfLoginPage(String key) throws Exception {
		click(loginPagePropertiesPageProperties.getProperty(key));
	}

	public final void enterTextForLoginPage(String key, String Text) throws Exception {
		enterText(loginPagePropertiesPageProperties.getProperty(key), Text);
	}
}
