package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.ScenarioContext;
import enums.Context;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext sc = CreateAccountPage.sc;
	
	// Elements to enter login details
	@FindBy(id = "email")
	WebElement fldEmailToSignIn;
	
	@FindBy(name = "login[password]")
	WebElement fldPasswordToSignIn;
	
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement btnSignIn;
	
	// Action methods to enter login details
	public void enterEmailToSignIn() {
		fldEmailToSignIn.sendKeys(sc.getContext(Context.EMAIL).toString());
	}
	
	public void enterPasswordToSignIn() {
		fldPasswordToSignIn.sendKeys(sc.getContext(Context.PASSWORD).toString());
	}
	
	public void clickSignInButton() {
		btnSignIn.click();
	}

}
