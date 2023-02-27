package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinicartPopup extends BasePage {

	public MinicartPopup(WebDriver driver) {
		super(driver);
	}
	
	// Elements from pop up
	@FindBy(css = ".header.content")
	WebElement headerContent;
	
	@FindBy(css = ".subtitle.empty")
	WebElement msgNoItemsInCart;
	
	@FindBy(css = ".action.viewcart")
	WebElement lnkViewEditCart;
	
	@FindBy(id = "top-cart-btn-checkout")
	WebElement btnProceedToCheckout_Minicart;
	
	@FindBy(xpath = "//li[@data-role='product-item']")
	List<WebElement> listMinicartProducts;
	
	@FindBy(xpath = "//aside[contains(@class,'_show')]//div[contains(@class,'modal-content')]")
	WebElement txtRemoveItemPopup;
	
	@FindBy(css = ".action-secondary.action-dismiss")
	WebElement btnCancelRemoveItemPopup;
	
	@FindBy(css = ".action-primary.action-accept")
	WebElement btnOkRemoveItemPopup;
	
	// Action methods for pop up
	public boolean verifyMiniCartMessage(String expectedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgNoItemsInCart));
		
		if(msgNoItemsInCart.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickViewEditCart() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkViewEditCart));
		
		lnkViewEditCart.click();
	}
	
	public String outcomeOfProceedToCheckoutButton(String btnName) {
		String outcome = null;
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnProceedToCheckout_Minicart));
		
		// First verify whether the Proceed to Checkout button is visible and enable
		if(btnProceedToCheckout_Minicart.isEnabled()) {
			// Second verify the button text
			if(btnProceedToCheckout_Minicart.getText().contentEquals(btnName)) {
				outcome = "Proceed to Checkout button is visible and enable.";
			}
			else {
				outcome = "Button is visible but text is incorrect.";
			}
		}
		else {
			outcome = "Proceed to Checkout button is not enabled.";
		}
		return outcome;
	}
	
	public boolean verifyProceedToCheckoutButton(String btnName) {
		boolean results = false;
		
		// Storing all possible outcomes
		final String possibility1 = "Proceed to Checkout button is visible and enable.";
		final String possibility2 = "Button is visible but text is incorrect.";
		final String possibility3 = "Proceed to Checkout button is not enabled.";
		
		// Calling previous method to get the actual outcome
		String outcome = outcomeOfProceedToCheckoutButton(btnName);
		
		// Asserting the correct output based on actual outcome
		switch (outcome) {
		
		case possibility1:
			results = true;
			break;
			
		case possibility2:
			results = false;
			break;
			
		case possibility3:
			results = false;
			break;
			
		default:
			results = false;
			break;
		}
		return results;
	}
	
	public void clickProceedToCheckout() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkViewEditCart));
		
		btnProceedToCheckout_Minicart.click();
	}
	
	public void clickOutsideMinicart() {
		headerContent.click();
	}
	
	public boolean verifyMinicartClosed() {
		if(msgNoItemsInCart.isDisplayed() == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyProceedToCheckoutBackgroundColor() {
		// Initializing JavascriptExecutor at class level
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Storing RGB values
		String expectedColor = "rgb(25, 121, 195)";
		String actualColor = js.executeScript("return window.getComputedStyle(document.querySelector(\"#top-cart-btn-checkout\")).getPropertyValue('background-color')")
				.toString();
		
		// Comparing RGB strings
		if(actualColor.contentEquals(expectedColor)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyProceedToCheckoutFontColor() {
		// Initializing JavascriptExecutor at class level
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Storing RGB values
		String expectedColor = "rgb(255, 255, 255)";
		String actualColor = js.executeScript("return window.getComputedStyle(document.querySelector(\"#top-cart-btn-checkout\")).getPropertyValue('color')")
				.toString();
		
		// Comparing RGB strings
		if(actualColor.contentEquals(expectedColor)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyRemoveItemIcon() {
		// Checking if there is at least one product added to Minicart
		if(listMinicartProducts.size() > 0) {
			// Checking if the Remove Item icon is available for the product
			String productLoc = "//a[@title='Remove item']";
			WebElement productRemoveItemIcon = listMinicartProducts.get(0).findElement(By.xpath(productLoc));
			if(productRemoveItemIcon.isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void clickRemoveItemIcon() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(listMinicartProducts.get(0)));
		
		// Checking if there is at least one product added to Minicart
		if(listMinicartProducts.size() > 0) {
			// Checking if the Remove Item icon is available for the product
			String productLoc = "//a[@title='Remove item']";
			WebElement productRemoveItemIcon = listMinicartProducts.get(0).findElement(By.xpath(productLoc));
			if(productRemoveItemIcon.isDisplayed()) {
				// if Remove Item icon is present, click on it.
				productRemoveItemIcon.click();
			}
		}
	}
	
	public boolean verifyRemoveItemPopupText(String expectedTxt) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(txtRemoveItemPopup));
		
		if(txtRemoveItemPopup.getText().contentEquals(expectedTxt)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickRemoveItemPopupButton(String btnName) {
		// Checking the button name and clicking accordingly
		if(btnName.contentEquals("OK")) {
			btnOkRemoveItemPopup.click();
		}
		else if(btnName.contentEquals("Cancel")) {
			btnCancelRemoveItemPopup.click();
		}
	}
	
	public boolean verifyProductExistsInMinicart() {
		if(listMinicartProducts.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
