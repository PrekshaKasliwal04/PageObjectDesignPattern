package com.gurukulApp.pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;

public class BranchPage extends CommonMethod {
	private ObjectReader branchPagePropertiesReader = new ObjectReader();
	private Properties branchPageProperties;

	private BranchPage instance;

	public BranchPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (BranchPage.class) {
				if (instance == null) {
					instance = new BranchPage(DRIVER);
				}
			}
		}
		return instance;
	}

	public BranchPage(WebDriver driver) throws IOException {
		branchPageProperties = branchPagePropertiesReader.getObjectRepository("BranchPage");
	}

	public final boolean waitForElementsOfBranchPage(String key) throws Exception {
		return verifyElementIsVisible(branchPageProperties.getProperty(key));
	}

	public final boolean matchTextOfBranchPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(branchPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsEnableOfBranchPage(String key) throws Exception {
		return verifyElementIsEnable(branchPageProperties.getProperty(key));
	}

	public final String getTextOfBranchPage(String key) throws Exception {
		return getTextBy(branchPageProperties.getProperty(key));
	}

	public final void clickOnElementsOfBranchPage(String key) throws Exception {
		click(branchPageProperties.getProperty(key));
	}


	public final void enterTextForBranchPage(String key, String Text) throws Exception {
		enterText(branchPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsClickableOfBranchPage(String key) throws Exception {
		return verifyElementIsClickable(branchPageProperties.getProperty(key));
	}


	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfBranchPage(String key) throws Exception {
		return waitUntillElementIsPresent(branchPageProperties.getProperty(key));
	}
}
