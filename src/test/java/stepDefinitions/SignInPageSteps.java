package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SignInPage;

public class SignInPageSteps {
	
	WebDriver driver;
	SignInPage sip = new SignInPage(HomePageSteps.driver);
	
	Logger logger = HomePageSteps.logger;
	
	// Background steps
	@And("user clicks on Forgot Password link")
	public void user_clicks_on_forgot_password_link() {
		try {
			sip.clickForgotPassword();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Forgot Password link on Sign In page.");
		}
	}
	
	// Steps for page details
	@And("user clicks on Create an Account button present under New Customers section")
	public void user_clicks_on_create_an_account_button_present_under_new_customers_section() {
		try {
			sip.clickCreateAccountFromSignIn();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Can't click on Create an Account link from Sign In page.");
		}
	}
	
	@Then("{string} link is present on page")
	public void link_is_present_on_page(String linkName) {
		try {
			Assert.assertTrue("Forgot Password link is not present on Sign In page.", sip.verifyForgotPasswordLink(linkName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Forgot Password link on Sign In page.");
		}
	}
	
	@Then("user will see confirmation message for reset password outcome")
	public void user_will_see_confirmation_message_for_reset_password_outcome() {
		try {
			Assert.assertTrue("Confirmation message is not as expected.", sip.verifyResetPasswordConfirmationMessage());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Cannot verify the Reset Password confirmation message.");
		}
	}
	
	// Steps to enter login details
	@Then("user can see red asterisk sign next to {string}")
	public void user_can_see_red_asterisk_sign_next_to(String name) {
		try {
			Assert.assertTrue("Red asterisk sign is missing for field: " + name + ".", sip.verifyRedAsteriskForEmailToSignIn(name));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify red asterisk.");
		}
	}
	
	@And("user enters newly registered email")
	public void user_enters_newly_registered_email() {
		try {
			sip.enterEmailToSignIn(null);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Email field.");
		}
	}
	
	@And("user enters password for above email")
	public void user_enters_password_for_above_email() {
		try {
			sip.enterPasswordToSignIn(null);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Password field.");
		}
	}
	
	@And("user enters email as {string}")
	public void user_enters_email_as(String email) {
		try {
			sip.enterEmailToSignIn(email);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Email field.");
		}
	}
	
	@And("user enters password as {string}")
	public void user_enters_password_as(String pwd) {
		try {
			sip.enterPasswordToSignIn(pwd);
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
	
	@Then("user will see validation message for both fields")
	public void user_will_see_validation_message_for_both_fields() {
		try {
			Assert.assertTrue("One or both validation messages are missing on page. Check the detailed log for exact section name.", 
					sip.verifyMandatoryValidationMsgs());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue while verifying validation messages.");
		}
	}
	
	@Then("user can see error message {string} for incorrect email format")
	public void user_can_see_error_message_for_incorrect_email_format(String expectedMsg) {
		try {
			Assert.assertTrue("Incorrect validation message for wrong input in Email field.", sip.verifyEmailValidationMsg(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Can't interact with Email validation message.");
		}
	}

}
