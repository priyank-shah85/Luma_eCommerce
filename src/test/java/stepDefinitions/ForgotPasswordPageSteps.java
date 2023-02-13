package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.ForgotPasswordPage;

public class ForgotPasswordPageSteps {
	
	WebDriver driver;
	
	ForgotPasswordPage fpp = new ForgotPasswordPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@And("user manaully enters captcha")
	public void user_manaully_enters_captcha() {
		try {
			fpp.enterCaptcha();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Captcha element is not present on page.");
		}
	}
	
	@And("user clicks on Reset My Password button")
	public void user_clicks_on_reset_my_password_button() {
		try{
			fpp.clickResetPassword();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Reset Password button.");
		}
	}

}
