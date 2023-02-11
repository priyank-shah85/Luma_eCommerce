package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext sc = CreateAccountPage.sc;
	
	// Elements for Create Account result
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement msgNewAccountCreated;
	
	// Elements for user account actions
	@FindBy(xpath = "//div[@class='panel header']//ul//li//span[@class='logged-in']")
	WebElement welcomeMsgAfterSignIn;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement btnAction;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//ul//li//a[contains(text(),'Sign Out')]")
	WebElement lnkSignOut;
	
	// Action methods for Create Account result
	public boolean verifyNewAccountCreation(String expectedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgNewAccountCreated));
		if(msgNewAccountCreated.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Action methods for user account actions
	public boolean verifyWelcomeMessageAfterSignIn(String partialText) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(welcomeMsgAfterSignIn));
		
		// Formatting the expected welcome message with help of stored first & last name
		String expectedMsg = partialText + sc.getContext(Context.FIRST_NAME).toString() + " " 
				+ sc.getContext(Context.LAST_NAME).toString() + "!";
		
		// Extracting the actual welcome message from web page
		String actualMsg = welcomeMsgAfterSignIn.getText();
		//System.out.println("Expected: " + expectedMsg + " |Actual: " + actualMsg);
		
		// Comparing both messages
		if(actualMsg.contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickActionButton() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnAction));
		btnAction.click();
	}
	
	public void clickSignOutLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkSignOut));
		lnkSignOut.click();
	}

}
