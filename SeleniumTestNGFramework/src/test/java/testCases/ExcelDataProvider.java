package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Driver;
import util.ExcelUtils;

public class ExcelDataProvider {

	WebDriver driver;

	@BeforeTest
	public void setupTest() {
//		driver = Driver.setBrowser();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("BeforeTest");
	}

	@DataProvider
	public Object[][] testData() {
		ExcelUtils eu = new ExcelUtils("data.xlsx", "Sheet1");
		int rowCount = eu.getRowCount();
		int colCount = eu.getColumnCount();
		
		Object data[][] = new Object[rowCount][colCount];

		for (int i = 1; i <rowCount+1; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i -1][j] = eu.getStringCellData(i, j);
			}
		}
		return data;
	}


	@Test(dataProvider = "testData")
	public void dataProviderTest(String n, String s) {
		System.out.println(n + "-----" + s);
	}



	@AfterTest
	public void tearDown() {
//		Driver.closeBrowser();
		System.out.println("AfterTest");
	}
}
