package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.GoogleSearchTest;
import util.Driver;

public class BrowserTest {

	private static Logger log = LogManager.getLogger(BrowserTest.class);
	WebDriver driver = null;
	@BeforeTest
	public void setup() {
		//Manual Approach to setup the driver
		//	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = Driver.setBrowser();
		log.info("Launching Browser...");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Implicit Wait for 20 seconds");
	}

	@Test
	public void startTest() {
//		HomePage homePageObj = new HomePage(driver);
		GoogleSearchTest googleSearchTestObj =  new GoogleSearchTest(driver);
		
//		driver.get("https://www.seleniumeasy.com/	test/");
		driver.get("https://www.google.com/");
		log.debug("Opening the url");
		
//		homePageObj.clickOnStartPracticeButton();
		googleSearchTestObj.enterTheTextInGoogleSearchBox("Netflix");
		log.debug("Entering the value in the textbox");
//		driver.findElement(By.name("q")).sendKeys("Netflix");
		googleSearchTestObj.clickOnGoogleSearchButton();
		log.debug("Clicking on the search button");
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
//		driver.quit();
		log.info("Browser closed successfully!!!");
	}
}
