package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage {

	public CommonPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
	@FindBy(xpath = "//h1[@class='page-title']//span")
	WebElement pageTitle;
	
	// Action methods
	public boolean verifyPageTitle(String expectedTitle) {
		// System.out.println(pageTitle.getText());
		if(pageTitle.getText().contentEquals(expectedTitle)) {
			return true;
		}
		else {
			return false;
		}
	}

}
