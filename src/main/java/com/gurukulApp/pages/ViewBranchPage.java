package com.gurukulApp.pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;


public class ViewBranchPage extends CommonMethod {
	private ObjectReader viewBranchPagePropertiesReader = new ObjectReader();
	private Properties viewBranchPageProperties;

	private ViewBranchPage instance;

	public ViewBranchPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (ViewBranchPage.class) {
				if (instance == null) {
					instance = new ViewBranchPage(DRIVER);

				}
			}
		}
		return instance;
	}

	public ViewBranchPage(WebDriver driver) throws IOException {
		viewBranchPageProperties = viewBranchPagePropertiesReader.getObjectRepository("ViewBranchPage");
	}

	public final boolean waitForElementsOfViewBranchPage(String key) throws Exception {
		return verifyElementIsVisible(viewBranchPageProperties.getProperty(key));
	}

	public final boolean matchTextOfViewBranchPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(viewBranchPageProperties.getProperty(key), Text);
	}

	public final String getTextOfViewBranchPage(String key) throws Exception {
		return getTextBy(viewBranchPageProperties.getProperty(key));
	}


	public final void clickOnElementsOfViewBranchPage(String key) throws Exception {
		click(viewBranchPageProperties.getProperty(key));
	}


	public final void enterTextForBranchPage(String key, String Text) throws Exception {
		enterText(viewBranchPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsClickableOfViewBranchPage(String key) throws Exception {
		return verifyElementIsClickable(viewBranchPageProperties.getProperty(key));
	}


	public final WebElement getElementOfViewBranchPage(String key) throws Exception {
		return getElement(viewBranchPageProperties.getProperty(key));
	}


	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfViewBranchPage(String key) throws Exception {
		return waitUntillElementIsPresent(viewBranchPageProperties.getProperty(key));
	}
	

}
