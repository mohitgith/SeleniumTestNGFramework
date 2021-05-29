package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.GoogleSearchTest;

public class ExtentReportTestNG {
	
	ExtentReports extent;
	ExtentSparkReporter spark;

	WebDriver driver = null;
	@BeforeTest
	public void setup() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark/SparkTestNG.html");
		extent.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		System.out.println("Launching Browser...");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void startTest() {
		ExtentTest test = extent.createTest("startTest", "This is a test to check Extent Report with TestNG");
		
		test.log(Status.INFO, "Starting the test");
		
		GoogleSearchTest googleSearchTestObj =  new GoogleSearchTest(driver);
		driver.get("https://www.google.com/");
		test.pass("Navigated to the google.com");
		
		googleSearchTestObj.enterTheTextInGoogleSearchBox("Amazon Prime Video");
		test.pass("Searched for Amazon Prime Video");
		
		googleSearchTestObj.clickOnGoogleSearchButton();
		test.pass("Clicked on Search");
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Closing the browser");
		extent.flush();
	}
}
