
package com.basesource.action;

import java.io.IOException;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethod extends PreDefinedActions {

	protected JSONParser parser = new JSONParser();  
	private CommonMethod instance;

	public CommonMethod getInstance() throws IOException {
		if (instance == null) {
			synchronized (CommonMethod.class) {
				if (instance == null) {
					instance = new CommonMethod();
				}
			}
		}
		return instance;
		
	}
	
	/**
	 * This is the method to select the any value from a drop down
	 * 
	 * @param dropdownListKey: List of values in drop down.
	 * @return
	 * @throws Exception
	 */
	public final String selectValueFromDropdown(String dropdownListKey,String number) throws Exception {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(this.getObject(dropdownListKey)));
		jsDriver().executeScript("arguments[0].style.border='3px solid red'", element);
       Select value = new Select(element);
       value.selectByValue(number);
       String text = element.getText();
      return text;
	}

	public final boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException er) {
			return false;
		}
	}

	public final boolean canClickNext(int activepageNumber, int lastPageNumber, boolean nextButtonStatus) {
		boolean Flag = false;
		if ((activepageNumber != lastPageNumber) && (nextButtonStatus)) {
			Flag = true;
		}
		return Flag;
	}

	public final boolean canClickPrevious(int activepageNumber, int firstPageNumber, boolean previousButtonStatus) {
		boolean Flag = false;
		if ((activepageNumber != firstPageNumber) && (previousButtonStatus)) {
			Flag = true;
		}
		return Flag;
	}

	/*
	 *
	 * This method generate randomString upto 11 characters
	 */
	public final String generateRandomString() {
		String randomStr = RandomStringUtils.randomAlphabetic(6);
		String upperRandom = randomStr.toUpperCase();
		return upperRandom;
	}
	
	/*
	 *
	 * This method generate random alphanumeric string upto 10 characters
	 */
	public final String generateAlphaRandomNumber() {
		String randomStr = RandomStringUtils.randomAlphanumeric(10);
		String lowerRandom = randomStr.toLowerCase();
		return lowerRandom;
	}
}