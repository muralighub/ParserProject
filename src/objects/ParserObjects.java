package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParserObjects {
	WebDriver driver;

	@FindBy(css = "input.form-control")
	WebElement DateField;

	@FindBy(css = "input.btn.btn-default")
	WebElement SubmitBtn;

	@FindBy(xpath = "//div[@class='col-md-6']/div")
	WebElement ResultField;

	public ParserObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void clearDate() {
		DateField.clear();
	}

	public void inputDate(String Date) {
		DateField.sendKeys(Date);
	}
	
	public void submitbtn() {
		SubmitBtn.click();
	}

	public String getResult() {
		return ResultField.getText();
	}
}
