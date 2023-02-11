package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOutPage extends BasePage {

	public SignOutPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements for page details
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement lnkSignIn;
	
	// Action methods for page details
	public void clickSignIn() {
		new WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkSignIn));
		lnkSignIn.click();
	}

}
