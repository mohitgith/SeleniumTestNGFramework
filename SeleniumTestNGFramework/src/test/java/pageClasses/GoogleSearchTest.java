package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.SeleniumUtil;

public class GoogleSearchTest {
	
	public GoogleSearchTest(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver = null;
	
	//Locator from the page
	By searchTextBox = By.xpath("//input[@name='q']");
	By searchButton = By.name("btnK");
	
	public void enterTheTextInGoogleSearchBox(String searchText) {
		SeleniumUtil.enterTextInTextbox(driver, searchTextBox, searchText);
	}
	
	public void clickOnGoogleSearchButton() {
		SeleniumUtil.clickOnButton(driver, searchButton);
	}
	

}
