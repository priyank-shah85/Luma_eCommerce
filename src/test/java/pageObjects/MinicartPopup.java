package pageObjects;

import java.time.Duration;

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
	@FindBy(css = ".action.viewcart")
	WebElement lnkViewEditCart;
	
	// Action methods for pop up
	public void clickViewEditCart() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkViewEditCart));
		
		lnkViewEditCart.click();
	}

}
