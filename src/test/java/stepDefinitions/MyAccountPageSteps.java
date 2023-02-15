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
	
	// Steps for page details
	@Then("user can see the {string} section")
	public void user_can_see_the_section(String expectedMsg) {
		try {
			Assert.assertTrue("Incorrect section name.", map.verifyAccountInformationMessage(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Account Information section name.");
		}
	}
	
	@Then("user can see the {string} from left side panel")
	public void user_can_see_the_from_left_side_panel(String linkName) {
		try {
			Assert.assertTrue("Link " + linkName + " is not present.", map.verifyNavigationLink(linkName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Navigation Links.");
		}
	}
	
	@Then("user can see above First Name, Last Name & Email under {string}")
	public void user_can_see_above_first_name_last_name_email_under(String boxLabel) {
		try {
			Assert.assertTrue("User's information is missing or incorrect.", map.verifyContactInformationBox(boxLabel));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Contact Information box.");
		}
	}
	
	@And("user can see {string} and {string} links")
	public void user_can_see_and_links(String link1, String link2) {
		try {
			Assert.assertTrue(link1 + " and/or " + link2 + " is missing under Contact Information box.", map.verifyContactInformationLinks(link1, link2));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Contact Information's links.");
		}
	}
	
	@Then("user can see newsletter subscription preference under {string}")
	public void user_can_see_newsletter_subscription_preference_under(String boxLabel) {
		try {
			Assert.assertTrue("Newsletter preference is missing or incorrect.", map.verifyNewsletterBox(boxLabel));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Newsletter box.");
		}
	}
	
	@And("user can see {string} link")
	public void user_can_see_link(String linkName) {
		try {
			Assert.assertTrue(linkName + " is missing under Newsletter box.", map.verifyNewletterLinks(linkName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Newsletter's links.");
		}
	}
	
	@Then("user can see {string} message under {string} billing section")
	public void user_can_see_message_under_billing_section(String expectedMsg, String expectedBoxLabel) {
		try {
			Assert.assertTrue("Either " + expectedBoxLabel + " section is not present or it's not showing correct message.", 
					map.verifyDefaultBillingAddressBox(expectedMsg, expectedBoxLabel));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue with Default Billing Address section.");
		}
	}
	
	@And("user can see {string} message under {string} shipping section")
	public void user_can_see_message_under_shipping_section(String expectedMsg, String expectedBoxLabel) {
		try {
			Assert.assertTrue("Either " + expectedBoxLabel + " section is not present or it's not showing correct message.", 
					map.verifyDefaultShippingAddressBox(expectedMsg, expectedBoxLabel));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue with Default Shipping Address section.");
		}
	}
	
	@Then("user can see same Default Billing Address")
	public void user_can_see_same_default_billing_address() {
		try {
			Assert.assertTrue("Default Billing Address on My Account is not matching with Address Book.", 
					map.verifyDefaultBillingAddressBox("", ""));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue with Default Billing Address section.");
		}
	}
	
	@And("user can see same Default Shipping Address")
	public void user_can_see_same_default_shipping_address() {
		try {
			Assert.assertTrue("Default Shipping Address on My Account is not matching with Address Book.", 
					map.verifyDefaultShippingAddressBox("", ""));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue with Default Shipping Address section.");
		}
	}
	
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
	
	@Then("user will see {string} text on top right corner of the page")
	public void user_will_see_text_on_top_right_corner_of_the_page(String text) {
		try {
			Assert.assertTrue("Incorrect welcome message.", map.verifyPartialWelcomeMessageAfterSignIn(text));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with Welcome message.");
		}
	}
	
	@And("user clicks on My Account link")
	public void user_clicks_on_my_account_link() {
		try {
			map.clickActionButton();
			map.clickMyAccountLink();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to move to My Account page.");
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
	
	// Steps for navigation links
	@And("user clicks on Address Book link")
	public void user_clicks_on_address_book_link() {
		try {
			map.clickAddressBookLink();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Address Book link is missing or disabled.");
		}
	}
	
	@And("user clicks on My Orders link")
	public void user_clicks_on_my_orders_link() {
		try {
			map.clickMyOrdersLink();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("My Orders link is missing or disabled.");
		}
	}

}
