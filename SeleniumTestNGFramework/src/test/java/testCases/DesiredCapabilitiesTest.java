package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.GoogleSearchTest;

public class DesiredCapabilitiesTest {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriverManager.iedriver().setup();
		System.out.println("Launching Browser...");
		driver  = new InternetExplorerDriver(cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		GoogleSearchTest googleSearchTestObj =  new GoogleSearchTest(driver);
		
		driver.get("https://www.google.com/");

		googleSearchTestObj.enterTheTextInGoogleSearchBox("Amazon Prime Video");
		googleSearchTestObj.clickOnGoogleSearchButton();
		
		driver.close();
		driver.quit();
		System.out.println("Browser closed successfully!!!");

	}

}
