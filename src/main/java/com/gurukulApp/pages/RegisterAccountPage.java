package com.gurukulApp.pages;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;

public class RegisterAccountPage extends CommonMethod {
	private ObjectReader registerAccountPagePropertiesReader = new ObjectReader();
	private Properties registerAccountPageProperties;

	private RegisterAccountPage instance;

	public RegisterAccountPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (RegisterAccountPage.class) {
				if (instance == null) {
					instance = new RegisterAccountPage(DRIVER);

				}
			}
		}
		return instance;
	}

	public RegisterAccountPage(WebDriver driver) throws IOException {
		registerAccountPageProperties = registerAccountPagePropertiesReader.getObjectRepository("RegisterAccountPage");
	}

	/**
	 * @param language: Language code for localization testing
	 * @param localefolder: To specify the folder where the key is present
	 * @param key: Contains the string which is localized
	 * @return String which is localized
	 * @throws Exception
	 */
	

	public final boolean verifyElementsOfRegisterAccountPage(String key) throws Exception {
		return verifyElementIsPresent(registerAccountPageProperties.getProperty(key));
	}

	public final boolean waitForElementsOfRegisterAccountPage(String key) throws Exception {
		return verifyElementIsVisible(registerAccountPageProperties.getProperty(key));
	}

	public final boolean waitForPresenceOfElementsOfRegisterAccountPage(String key) throws Exception {
		return waitUntillElementIsPresent(registerAccountPageProperties.getProperty(key));
	}

	public final boolean matchTextOfRegisterAccountPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(registerAccountPageProperties.getProperty(key), Text);
	}

	public final String getTextOfRegisterAccountPage(String key) throws Exception {
		return getTextBy(registerAccountPageProperties.getProperty(key));
	}

	public final void clickOnElementsOfRegisterAccountPage(String key) throws Exception {
		click(registerAccountPageProperties.getProperty(key));
	}


	public final void enterTextForRegisterAccountPage(String key, String Text) throws Exception {
		enterText(registerAccountPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsClickableOfRegisterAccountPage(String key) throws Exception {
		return verifyElementIsClickable(registerAccountPageProperties.getProperty(key));
	}

	public final WebElement getElementOfRegisterAccountPage(String key) throws Exception {
		return getElement(registerAccountPageProperties.getProperty(key));
	}

	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfRegisterAccountPage(String key) throws Exception {
		return waitUntillElementIsPresent(registerAccountPageProperties.getProperty(key));
	}
}
