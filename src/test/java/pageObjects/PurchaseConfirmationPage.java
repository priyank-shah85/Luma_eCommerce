package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.ScenarioContext;
import enums.Context;

public class PurchaseConfirmationPage extends BasePage {

	public PurchaseConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public static ScenarioContext ordernosc = new ScenarioContext();
	
	// Elements for page details
	@FindBy(xpath = "//a[@class='order-number']//strong")
	WebElement txtOrderNumber;
	
	// Action methods for page details
	public boolean storeOrderNumber() {
		if(txtOrderNumber.isDisplayed()) {
			ordernosc.setContext(Context.ORDER_NUMBER, txtOrderNumber.getText());
			return true;
		}
		else {
			return false;
		}
	}

}
