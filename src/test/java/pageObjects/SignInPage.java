package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext sc = CreateAccountPage.sc;
	
	// Elements for page details	
	@FindBy(xpath = "//div[@class='login-container']//div[@class='block block-new-customer']")
	WebElement blkNewCustomer;
	
	@FindBy(css = ".action.remind")
	WebElement lnkForgotPassword;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement msgResetPasswordConfirmation;
	
	// Elements to enter login details
	@FindBy(xpath = "//label[@for='email']")
	WebElement lblEmailToSignIn;
	
	@FindBy(id = "email")
	WebElement fldEmailToSignIn;
	
	@FindBy(xpath = "//label[@for='pass']")
	WebElement lblPasswordToSignIn;
	
	@FindBy(name = "login[password]")
	WebElement fldPasswordToSignIn;
	
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement btnSignIn;
	
	@FindBy(id = "email-error")
	WebElement msgEmailValidation;
	
	@FindBy(id = "pass-error")
	WebElement msgPasswordValidation;
	
	// Action methods for page details
	public void clickCreateAccountFromSignIn() {
		blkNewCustomer.findElement(By.tagName("a")).click();
	}
	
	public boolean verifyForgotPasswordLink(String linkName) {
		if(lnkForgotPassword.isDisplayed() && lnkForgotPassword.getText().contentEquals(linkName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickForgotPassword() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkForgotPassword));
		lnkForgotPassword.click();
	}
	
	public boolean verifyResetPasswordConfirmationMessage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgResetPasswordConfirmation));
		
		// Storing expected and actual confirmation message in different variables
		String expectedMsg = "If there is an account associated with " 
				+ sc.getContext(Context.EMAIL).toString() + " you will receive an email with a link to reset your password.";
		String actualMsg = msgResetPasswordConfirmation.getText();
		
		System.out.println("Expected: " + expectedMsg + "\n Actual: " + actualMsg);
		
		// Comparing and returning the results
		if(actualMsg.contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Action methods to enter login details
	public boolean verifyRedAsteriskForEmailToSignIn(String name) {
		// Declaring variables at class level
		boolean results = false;
		String asteriskSign = null;
		String actualColor = null;
		String expectedColor = null;
		
		// Initializing JavascriptExecutor at class level
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		switch(name) {
		
		case "Email":
			// Getting CSS values for Pseudo ::after element
			asteriskSign = js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='email']\"),'::after').getPropertyValue('content')")
	                .toString();			
			
			actualColor = js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='email']\"),'::after').getPropertyValue('color')")
	                .toString();
			
			// Storing expected RGB formatter
			expectedColor = "rgb(224, 43, 39)";
			
			// System.out.println("Asterisk sign: " + asteriskSign + "| Actual Color: " + actualColor + "| Expected color: " + expectedColor);
			
			// Comparing CSS values with actual values
			if(asteriskSign.contains("*") && actualColor.contentEquals(expectedColor)) {
				results = true;
			}
			else {
				results = false;
			}
			break;
			
		case "Password":
			// Getting CSS values for Pseudo ::after element
			asteriskSign = js.executeScript("return window.getComputedStyle(document.querySelector(\"fieldset[class='fieldset login'] label[for='pass']\"),'::after').getPropertyValue('content')")
					.toString();			
			
			actualColor = js.executeScript("return window.getComputedStyle(document.querySelector(\"fieldset[class='fieldset login'] label[for='pass']\"),'::after').getPropertyValue('color')")
					.toString();
			
			// Storing expected RGB formatter
			expectedColor = "rgb(224, 43, 39)";
			
			System.out.println("Asterisk sign: " + asteriskSign + "| Actual Color: " + actualColor + "| Expected color: " + expectedColor);
			
			// Comparing CSS values with actual values
			if(asteriskSign.contains("*") && actualColor.contentEquals(expectedColor)) {
				results = true;
			}
			else {
				results = false;
			}
			break;
			
		default:
			results = false;
		}
		return results;
	}
	
	public void enterEmailToSignIn(String email) {
		if(email.isEmpty()) {
			fldEmailToSignIn.sendKeys(sc.getContext(Context.EMAIL).toString());
		}
		else {
			fldEmailToSignIn.sendKeys(email);
		}
		
	}
	
	public void enterPasswordToSignIn(String pwd) {
		if(pwd.isEmpty()) {
			fldPasswordToSignIn.sendKeys(sc.getContext(Context.PASSWORD).toString());
		}
		else {
			fldPasswordToSignIn.sendKeys(pwd);
		}
	}
	
	public void clickSignInButton() {
		btnSignIn.click();
	}
	
	public boolean verifyMandatoryValidationMsgs() {
		// Storing expected validation message for both the fields
		String msg = "This is a required field.";
		
		// Calling individual methods to verify validation message for both the fields
		boolean msg1 = verifyEmailMandatoryMsg(msg);
		boolean msg2 = verifyPwdMandatoryMsg(msg);
		
		// Comparing outcomes of individual methods and deriving the results
		if(msg1 && msg2) {
			System.out.println("Validation message presents for both fields.");
			return true;
		}
		else if(msg1 == true && msg2 == false){
			System.out.println("Validation message missing for Password field.");
			return false;
		}
		else if(msg1 == false && msg2 == true) {
			System.out.println("Validation message missing for Email field.");
			return false;
		}
		else {
			System.out.println("Validation message missing for both fields.");
			return false;
		}
	}
	
	private boolean verifyEmailMandatoryMsg(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyEmailValidationMsg(String msg) {
		if(msgEmailValidation.getText().contentEquals(msg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyPwdMandatoryMsg(String pwdMsg) {
		if(msgPasswordValidation.getText().contentEquals(pwdMsg)) {
			return true;
		}
		else {
			return false;
		}
	}

}
