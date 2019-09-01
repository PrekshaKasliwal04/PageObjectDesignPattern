package com.gurukulApp.pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;


public class ViewStaffPage extends CommonMethod {
	private ObjectReader viewStaffPagePropertiesReader = new ObjectReader();
	private Properties viewStaffPageProperties;
	private ViewStaffPage instance;

	public ViewStaffPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (ViewStaffPage.class) {
				if (instance == null) {
					instance = new ViewStaffPage(DRIVER);

				}
			}
		}
		return instance;
	}

	public ViewStaffPage(WebDriver driver) throws IOException {
		viewStaffPageProperties = viewStaffPagePropertiesReader.getObjectRepository("ViewStaffPage");
	}

	public final boolean waitForElementsOfViewStaffPage(String key) throws Exception {
		return verifyElementIsVisible(viewStaffPageProperties.getProperty(key));
	}

	public final boolean matchTextOfViewStaffPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(viewStaffPageProperties.getProperty(key), Text);
	}

	public final String getTextOfViewStaffPage(String key) throws Exception {
		return getTextBy(viewStaffPageProperties.getProperty(key));
	}


	public final void clickOnElementsOfViewStaffPage(String key) throws Exception {
		click(viewStaffPageProperties.getProperty(key));
	}


	public final void enterTextForBranchPage(String key, String Text) throws Exception {
		enterText(viewStaffPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsClickableOfViewStaffPage(String key) throws Exception {
		return verifyElementIsClickable(viewStaffPageProperties.getProperty(key));
	}


	public final WebElement getElementOfViewStaffPage(String key) throws Exception {
		return getElement(viewStaffPageProperties.getProperty(key));
	}


	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfViewStaffPage(String key) throws Exception {
		return waitUntillElementIsPresent(viewStaffPageProperties.getProperty(key));
	}
	

}
