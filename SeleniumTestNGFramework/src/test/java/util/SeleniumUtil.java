package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumUtil {

	private static WebElement element = null;
	private static boolean elementStatus = false;

	public SeleniumUtil() {

	}

	/*
	 * Description - Clicks or hit Enter for the button
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static void clickOnButton(WebDriver driver, By locator) {
		element = driver.findElement(locator);
		try {
			if (elementIsEnabled(driver, locator)) {
				if (elementIsClickable(driver, locator)) {
					element.click();
				} else {
					element.sendKeys(Keys.RETURN);
				}
			}
		} catch (Exception e) {
			System.out.println("Error on clickOnButton - " + e.getMessage());
		}

	}

	/*
	 * Description - Enters the text to textBox
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static void enterTextInTextbox(WebDriver driver, By locator, String text) {
		element = driver.findElement(locator);
		try {
			if (elementIsEnabled(driver, locator)) {
				element.sendKeys(text);
			}
		} catch (Exception e) {
			System.out.println("Error on enterTextInTextbox - " + e.getMessage());
		}
	}

	/*
	 * Description - Select the Value from dropDown
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static void selectValueFromDropDown(WebDriver driver, By locator) {

	}

	/*
	 * Description - Drag and Drop
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static void dragAndDropElement(WebDriver driver, By locator) {

	}

	/*
	 * Description - Click on scroll down to the element
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static void scrollDownToTheElement(WebDriver driver, By locator) {

	}

	/*
	 * Description - Checks if the Element is visible
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static boolean elementIsVisible(WebDriver driver, By locator) {
		element = driver.findElement(locator);
		try {
			/*
			 * //using explicit wait for 5 sec WebDriverWait wait = new
			 * WebDriverWait(driver, 5);
			 * wait.until(ExpectedConditions.visibilityOf(element));
			 */
			if (element.isDisplayed()) {
				elementStatus = true;
			}
		} catch (Exception e) {
			elementStatus = false;
		}
		return elementStatus;
	}

	/*
	 * Description - Checks if the Element is enabled
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static boolean elementIsEnabled(WebDriver driver, By locator) {
		element = driver.findElement(locator);
		try {
			if (elementIsVisible(driver, locator)) {
				if (element.isEnabled()) {
					elementStatus = true;
				}
			}
		} catch (Exception e) {
			elementStatus = false;
		}
		return elementStatus;
	}

	/*
	 * Description - Checks if the Element is clickable
	 * Author - Mohit Shrivastava
	 * Date - 29/05/2021
	 */	
	public static boolean elementIsClickable(WebDriver driver, By locator) {
		element = driver.findElement(locator);
		try
		{
			if(elementIsEnabled(driver, locator)) {
				
				// Using explicit wait for 5 sec
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				elementStatus = true;
			}
		}
		catch (Exception e)
		{
			elementStatus = false;
		}
		return elementStatus;
	}
}
