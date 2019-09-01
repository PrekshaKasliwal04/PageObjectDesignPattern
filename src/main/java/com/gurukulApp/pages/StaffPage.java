package com.gurukulApp.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;


public class StaffPage extends CommonMethod {
	private ObjectReader staffPagePropertiesReader = new ObjectReader();
	private Properties staffPageProperties;

	private StaffPage instance;

	public StaffPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (StaffPage.class) {
				if (instance == null) {
					instance = new StaffPage(DRIVER);

				}
			}
		}
		return instance;
	}

	public StaffPage(WebDriver driver) throws IOException {
		staffPageProperties = staffPagePropertiesReader.getObjectRepository("StaffPage");
	}

	/**
	 * @param language: Language code for localization testing
	 * @param localefolder: To specify the folder where the key is present
	 * @param key: Contains the string which is localized
	 * @return String which is localized
	 * @throws Exception
	 */
	

	public final boolean verifyElementsOfStaffPage(String key) throws Exception {
		return verifyElementIsPresent(staffPageProperties.getProperty(key));
	}

	public final boolean waitForElementsOfStaffPage(String key) throws Exception {
		return verifyElementIsVisible(staffPageProperties.getProperty(key));
	}

	public final boolean waitForPresenceOfElementsOfStaffPage(String key) throws Exception {
		return waitUntillElementIsPresent(staffPageProperties.getProperty(key));
	}

	public final boolean matchTextOfStaffPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(staffPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsEnableOfStaffPage(String key) throws Exception {
		return verifyElementIsEnable(staffPageProperties.getProperty(key));
	}


	public final String getTextOfStaffPage(String key) throws Exception {
		return getTextBy(staffPageProperties.getProperty(key));
	}


	public final void clickOnElementsOfStaffPage(String key) throws Exception {
		click(staffPageProperties.getProperty(key));
	}
	public final void selectDropDownOfStaffPage(String key, String value) throws Exception {
		
       selectValueFromDropdown(staffPageProperties.getProperty(key), value)	;
    }

	public final void enterTextForStaffPage(String key, String Text) throws Exception {
		enterText(staffPageProperties.getProperty(key), Text);
	}
	
	public final void verifyTextPresentOnElementOfStaffPage(String key, String Text) throws Exception {
		verifyTextPresentOnElement(staffPageProperties.getProperty(key), Text);
	}
	public final void scrollTillViewOfStaffPage(String key) throws Exception {
		scrollTillView(staffPageProperties.getProperty(key));
	}	
	public final boolean verifyElementIsClickableOfStaffPage(String key) throws Exception {
		return verifyElementIsClickable(staffPageProperties.getProperty(key));
	}

	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfStaffPage(String key) throws Exception {
		return waitUntillElementIsPresent(staffPageProperties.getProperty(key));
	}
	
}
