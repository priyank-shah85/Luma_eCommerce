package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext cartsc = ShoppingCartPage.cartsc;
	
	// Elements for page details
	@FindBy(xpath = "//div[@class='step-title']")
	List<WebElement> stepAddressTitle;
	
	@FindBy(xpath = "//button[@class='button action continue primary']")
	WebElement btnNext;
	
	@FindBy(css = "span[class='title']")
	WebElement lblOrderSummary;
	
	@FindBy(xpath = "//strong//span[@class='price']")
	WebElement amtOrderTotal;
	
	@FindBy(css = ".action.primary.checkout")
	WebElement btnPlaceOrder;
	
	// Action methods for page details
	public boolean verifyStepAddressStep(String expectedTitle) {
		for(int i=0; i<stepAddressTitle.size(); i++) {
			List<WebElement> stepTitle = driver.findElements(By.xpath("//div[@class='step-title']"));
			if(stepTitle.get(i).getText().contentEquals(expectedTitle)) {
				return true;
			}
		}
		return false;
	}
	
	public void clickNext() {
		new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(btnNext));
		btnNext.click();
	}
	
	public boolean verifyOrderTotal() {
		String expected = amtOrderTotal.getText();
		String actual=cartsc.getContext(Context.ORDER_TOTAL).toString();		
		
		//Comparing both values
		if(actual.contentEquals(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyOrderSummaryExists(String expectedName) {
		if(lblOrderSummary.getText().contentEquals(expectedName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickPlaceOrderButton() {
		btnPlaceOrder.click();
	}

}
