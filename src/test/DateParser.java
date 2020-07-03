package test;

/* This program enters the date in the format dd-mmmm-yyyy , dd-mmmm-yy, dd-mmm-yyyy using seperators -./,space. 

   Then verifies that the input date and output date are same using Date formatter Utility  */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.FormatUtility;

public class DateParser extends FormatUtility {
	WebDriver driver;
	// String resultformat;

	@BeforeTest
	public void Login() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		driver = new ChromeDriver(options);
		Reporter.log("Browser has has been initialized");
		driver.get("https://vast-dawn-73245.herokuapp.com");
		Reporter.log("Site has been opened in the Browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "getDateFormat1")
	public void dateParser(String date) {
		driver.findElement(By.cssSelector("input.form-control")).sendKeys(date);
		Reporter.log("Date has been entered in the text field " + date);
		driver.findElement(By.cssSelector("input.btn.btn-default")).click();
		String resultDate = driver.findElement(By.xpath("//div[@class='col-md-6']/div")).getText();

		FormatUtility f = new FormatUtility();
		String result = f.dateFormater(date);
		System.out.println(result);
		System.out.println(resultDate);

		if (resultDate.contains(result.substring(0, 15))) {

			System.out.println(
					" Formatted Input date " + result + " and output dates " + resultDate + " have been verified.");
			Reporter.log(
					" Formatted Input date " + result + " and output dates " + resultDate + " have been verified.");
		} else {

			System.out.println(
					" Formatted Input date " + result + " and output dates " + resultDate + " have not been verified.");
			Reporter.log(
					" Formatted Input date " + result + " and output dates " + resultDate + " have not been verified.");
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

	@DataProvider
	public Object[][] getDateFormat1() {

		Object[][] getDate = new Object[12][1];

		// using separator "-" and date format dd-mmmm-yyyy , dd-mmmm-yy,
		// dd-mmm-yyyy,dd-mmm-yy
		getDate[0][0] = "02-July-2020";
		getDate[1][0] = "02-July-20";
		getDate[2][0] = "02-Jul-2020";
		getDate[3][0] = "02-Jul-20";

		// using separator "/" and date format dd/mmmm/yyyy , dd/mmmm/yy,
		// dd/mmm/yyyy,dd/mmm/yy
		getDate[4][0] = "02/July/2020";
		getDate[5][0] = "02/July/20";
		getDate[6][0] = "02/Jul/2020";
		getDate[7][0] = "02/Jul/20";

		// using separator "space" and date format dd mmmm yyyy , dd mmmm yy,dd mmm
		// yyyy, dd mmm yy
		getDate[8][0] = "02 July 2020";
		getDate[9][0] = "02 July 20";
		getDate[10][0] = "02 Jul 2020";
		getDate[11][0] = "02 Jul 20";

		return getDate;

	}

}
