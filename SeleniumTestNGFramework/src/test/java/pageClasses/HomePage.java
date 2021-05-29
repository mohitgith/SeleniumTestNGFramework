package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.SeleniumUtil;

public class HomePage {
	
	private WebDriver driver = null;
	
	By startPracticeButton = By.xpath("//a[@id='btn_basic_example']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnStartPracticeButton() {
		SeleniumUtil.clickOnButton(driver, startPracticeButton);
	}

}
