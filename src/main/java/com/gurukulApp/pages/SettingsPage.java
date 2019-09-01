package com.gurukulApp.pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;

public class SettingsPage extends CommonMethod {
	private ObjectReader settingsPagePropertiesReader = new ObjectReader();
	private Properties settingsPageProperties;

	private SettingsPage instance;

	public SettingsPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (SettingsPage.class) {
				if (instance == null) {
					instance = new SettingsPage(DRIVER);
				}
			}
		}
		return instance;
	}

	public SettingsPage(WebDriver driver) throws IOException {
		settingsPageProperties = settingsPagePropertiesReader.getObjectRepository("SettingsPage");
	}

	public final boolean waitForElementsOfSettingsPage(String key) throws Exception {
		return verifyElementIsVisible(settingsPageProperties.getProperty(key));
	}

	public final boolean matchTextOfSettingsPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(settingsPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsEnableOfSettingsPage(String key) throws Exception {
		return verifyElementIsEnable(settingsPageProperties.getProperty(key));
	}

	public final String getTextOfSettingsPage(String key) throws Exception {
		return getTextBy(settingsPageProperties.getProperty(key));
	}

	public final void clickOnElementsOfSettingsPage(String key) throws Exception {
		click(settingsPageProperties.getProperty(key));
	}

	public final void enterTextForSettingsPage(String key, String Text) throws Exception {
		enterText(settingsPageProperties.getProperty(key), Text);
	}
	public final void clearTextForSettingsPage(String key) throws Exception {
		clearText(settingsPageProperties.getProperty(key));
	}
	public final void selectDropDownOfSettingsPage(String key, String value) throws Exception {
		
	       selectValueFromDropdown(settingsPageProperties.getProperty(key), value)	;
	    }
	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfSettingsPage(String key) throws Exception {
		return waitUntillElementIsPresent(settingsPageProperties.getProperty(key));
	}
	
}
