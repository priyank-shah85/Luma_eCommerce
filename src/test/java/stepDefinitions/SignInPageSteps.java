package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.SignInPage;

public class SignInPageSteps {
	
	WebDriver driver;
	SignInPage sip = new SignInPage(HomePageSteps.driver);
	
	Logger logger = HomePageSteps.logger;
	
	// Steps to enter login details
	@And("user enters newly registered email")
	public void user_enters_newly_registered_email() {
		try {
			sip.enterEmailToSignIn();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Email field.");
		}
	}
	
	@And("user enters password for above email")
	public void user_enters_password_for_above_email() {
		try {
			sip.enterPasswordToSignIn();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Password field.");
		}
	}
	
	@And("user clicks on Sign In button")
	public void user_clicks_on_sign_in_button() {
		try {
			sip.clickSignInButton();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Sign In button.");
		}
	}

}
