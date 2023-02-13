package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.ScenarioContext;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext sc = CreateAccountPage.sc;
	
	// Elements for page details
	@FindBy(id = "captcha_user_forgotpassword")
	WebElement fldCaptcha;
	
	@FindBy(xpath = "//button[@class='action submit primary']")
	WebElement btnResetPassword;
	
	// Action methods for page details
	public void enterCaptcha() throws InterruptedException {
		if(fldCaptcha.isDisplayed()) {
			Thread.sleep(15000);
		}
	}
	
	public void clickResetPassword() {
		btnResetPassword.click();
	}

}
