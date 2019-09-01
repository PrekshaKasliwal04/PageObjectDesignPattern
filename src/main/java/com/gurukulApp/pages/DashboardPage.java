package com.gurukulApp.pages;


import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.basesource.action.CommonMethod;
import com.basesource.utils.ObjectReader;

public class DashboardPage extends CommonMethod {
	private ObjectReader dashboardPagePropertiesReader = new ObjectReader();
	private Properties dashboardPageProperties;
	private DashboardPage instance;

	public DashboardPage getInstance() throws IOException {
		if (instance == null) {
			synchronized (DashboardPage.class) {
				if (instance == null) {
					instance = new DashboardPage(DRIVER);
				}
			}
		}
		return instance;
	}

	public DashboardPage(WebDriver driver) throws IOException {
		dashboardPageProperties = dashboardPagePropertiesReader.getObjectRepository("DashboardPage");
	}

	/**
	 * @param language: Language code for localization testing
	 * @param localefolder: To specify the folder where the key is present
	 * @param key: Contains the string which is localized
	 * @return String which is localized
	 * @throws Exception
	 */
	

	public final boolean verifyElementsOfDashboardPage(String key) throws Exception {
		return verifyElementIsPresent(dashboardPageProperties.getProperty(key));
	}

	public final boolean waitForElementsOfDashboardPage(String key) throws Exception {
		return verifyElementIsVisible(dashboardPageProperties.getProperty(key));
	}

	public final boolean waitForPresenceOfElementsOfDashboardPage(String key) throws Exception {
		return waitUntillElementIsPresent(dashboardPageProperties.getProperty(key));
	}

	public final boolean matchTextOfDashboardPage(String key, String Text) throws Exception {
		return verifyTextPresentOnElement(dashboardPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsEnableOfDashboardPage(String key) throws Exception {
		return verifyElementIsEnable(dashboardPageProperties.getProperty(key));
	}

	public final String getTextOfDashboardPage(String key) throws Exception {
		return getTextBy(dashboardPageProperties.getProperty(key));
	}

	public final void clickOnElementsOfDashboardPage(String key) throws Exception {
		click(dashboardPageProperties.getProperty(key));
	}


	public final void enterTextForDashboardPage(String key, String Text) throws Exception {
		enterText(dashboardPageProperties.getProperty(key), Text);
	}

	public final boolean verifyElementIsClickableOfDashboardPage(String key) throws Exception {
		return verifyElementIsClickable(dashboardPageProperties.getProperty(key));
	}

	/**
	 * This is a method to wait Until element is visible
	 * 
	 * @param key
	 * @return true
	 * @throws Exception
	 */
	public final boolean waitUntilElementsOfDashBoardPage(String key) throws Exception {
		return waitUntillElementIsPresent(dashboardPageProperties.getProperty(key));
	}
}
