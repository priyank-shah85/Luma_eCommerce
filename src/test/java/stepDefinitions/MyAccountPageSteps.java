package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.MyAccountPage;

public class MyAccountPageSteps {
	
	WebDriver driver;
	MyAccountPage map = new MyAccountPage(HomePageSteps.driver);
	
	Logger logger = HomePageSteps.logger;
	
	// Steps for Create Account result
	@Then("user will see {string} message on next page")
	public void user_will_see_message_on_next_page(String expectedMsg) {
		try {
			Assert.assertTrue("No new account created.", map.verifyNewAccountCreation(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue with creating new account.");
		}
	}
	
	// Steps for user account actions
	@Then("user will see {string} text along with first & last name at top right corner of the page")
	public void user_will_see_text_along_with_first_last_name_at_top_right_corner_of_the_page(String text) {
		try {
			Assert.assertTrue("Incorrect welcome message.", map.verifyWelcomeMessageAfterSignIn(text));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Welcome message.");
		}
	}
	
	@And("user logs out from the account")
	public void user_logs_out_from_the_account() {
		try {
			map.clickActionButton();
			map.clickSignOutLink();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to log out.");
		}
	}

}
