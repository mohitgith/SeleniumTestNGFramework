package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.GoogleSearchTest;

public class ExtentReportBasic {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		//creating extent report
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);

		//created extent test
		ExtentTest test = extent.createTest("Google Search", "this is test to check extent report");
		
		//regular steps for test
		WebDriverManager.chromedriver().setup();
		
		test.log(Status.INFO, "Starting the test");
		
		System.out.println("Launching Browser...");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		GoogleSearchTest googleSearchTestObj =  new GoogleSearchTest(driver);
		driver.get("https://www.google.com/");
		test.pass("Navigated to the google.com");
		
		googleSearchTestObj.enterTheTextInGoogleSearchBox("Amazon Prime Video");
		test.pass("Searched for Amazon Prime Video");
		
		googleSearchTestObj.clickOnGoogleSearchButton();
		test.pass("Clicked on Search");
		
		driver.close();
		driver.quit();
		test.pass("Closing the browser");
		
		//created extent test
		ExtentTest test2 = extent.createTest("Google Search 2", "this is test to check  multiple test in extent report");
		
		//regular steps for test
		WebDriverManager.chromedriver().setup();
		
		test2.log(Status.INFO, "Starting the test");
		
		System.out.println("Launching Browser...");
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		GoogleSearchTest googleSearchTestObj1 =  new GoogleSearchTest(driver);
		driver.get("https://www.google.com/");
		test2.pass("Navigated to the google.com");
		
		googleSearchTestObj1.enterTheTextInGoogleSearchBox("Amazon Prime Video");
		test2.pass("Searched for Amazon Prime Video");
		
		googleSearchTestObj1.clickOnGoogleSearchButton();
		test2.fail("Clicked on Search");
		
		driver.close();
		driver.quit();
		test2.pass("Closing the browser");
		
		extent.flush();
	}

}
