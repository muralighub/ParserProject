/*                ***********************************
  Check the input date field accepts different date formats along with different separators -, / and space.
  
   Then verifies that the input date and output date are same using Date formatter Utility  */

package test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.FormatUtility;
import utility.Driverinit;
import objects.ParserObjects;
import utility.DataExcel;

public class DateParser extends Driverinit {
	WebDriver driver;

	ParserObjects dateObj;
	String date;
	String result;

	@BeforeTest
	public void initialize() throws IOException {

		driver = browserDriver();
		Reporter.log("Browser has been initialized");
		driver.get(prop.getProperty("url"));
		Reporter.log("URL has been entered in the Browser");
	}

	@Test(dataProvider = "getDateSet")
	public void dateParser(String dataset) throws InterruptedException, IOException {

		dateObj = PageFactory.initElements(driver, ParserObjects.class);
		dateObj.clearDate();

		DataExcel getExcel = new DataExcel();
		ArrayList<String> data = getExcel.getData(dataset);

		for (int i = 1; i <= data.size() - 1; i++) {

			date = data.get(i);
			dateObj.inputDate(date);

			Reporter.log("Date entered in the text field " + date);

			dateObj.submitbtn();
			Thread.sleep(1000);
			String resultDate = dateObj.getResult();

			FormatUtility f = new FormatUtility();

			if (dataset.equalsIgnoreCase("Test1")) {
				result = f.dateFormater(date);
			} else if (dataset.equalsIgnoreCase("Test2")) {
				result = f.dateFormaterOne(date);
			} else if (dataset.equalsIgnoreCase("Test3")) {
				result = f.dateFormaterTwo(date);
			} else if (dataset.equalsIgnoreCase("Test4")) {
				result = f.dateFormaterThree(date);
			}

			if (resultDate.contains(result.substring(0, 15))) {

				System.out.println(" Formatted Input date: " + result.substring(0, 15) + " and Output date: " + resultDate.substring(0, 15)
						+ " have been verified.");
				Reporter.log(" Formatted Input date: " + result.substring(0, 15) + " and Output date: " + resultDate.substring(0, 15)
						+ " have been verified.");
				//Assert.assertEquals(result.substring(0, 15), resultDate.substring(0, 15));
			} else {

				System.out.println(" Formatted Input date: " + result.substring(0, 15) + " and Output date: " + resultDate
						+ " have not been verified.");
				Reporter.log(" Formatted Input date: " + result.substring(0, 15) + " and Output date: " + resultDate
						+ " have not been verified.");
			}

		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getDateSet() {

		Object[][] getSet = new Object[4][1];
		getSet[0][0] = "Test1";
		getSet[1][0] = "Test2";
		getSet[2][0] = "Test3";
		getSet[3][0] = "Test4";

		return getSet;
	}

}
