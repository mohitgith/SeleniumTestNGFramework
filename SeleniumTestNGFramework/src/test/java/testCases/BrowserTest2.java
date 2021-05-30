package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.GoogleSearchTest;

public class BrowserTest2 {

	WebDriver driver = null;
	@BeforeTest
	public void setup() {
		//Manual Approach to setup the driver
		//	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//Automated approach to setup the driver using WebdriverManager
		WebDriverManager.chromedriver().setup();
		System.out.println("Launching Browser...");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void startTest1() {
		System.out.println("startTest1");
		GoogleSearchTest googleSearchTestObj1 =  new GoogleSearchTest(driver);
		
		driver.get("https://www.google.com/");
		
		googleSearchTestObj1.enterTheTextInGoogleSearchBox("Amazon Prime Video");
		googleSearchTestObj1.clickOnGoogleSearchButton();
	}

	@Test
	public void startTest2() {
		System.out.println("startTest2");
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Browser closed successfully!!!");
	}
}
