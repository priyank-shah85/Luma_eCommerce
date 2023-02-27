package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.MinicartPopup;

public class MinicartPopupSteps {
	
	WebDriver driver;
	
	MinicartPopup mp = new MinicartPopup(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for pop up
	@And("user clicks on outside the cart")
	public void user_clicks_on_outside_the_cart() {
		try {
			mp.clickOutsideMinicart();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click outside the Minicart.");
		}
	}
	
	@Then("user can see {string} message in cart pop up")
	public void user_can_see_message_in_cart_pop_up(String msg) {
		try {
			Assert.assertTrue("Incorrect message in Minicart.", mp.verifyMiniCartMessage(msg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Minicart message.");
		}
	}
	
	@And("user clicks on View and Edit Cart link from minicart")
	public void user_clicks_on_view_and_Edit_cart_link_from_minicart() {
		try {
			mp.clickViewEditCart();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on View and Edit Cart link from Minicart pop up.");
		}
	}
	
	@Then("Minicart will be closed")
	public void minicart_will_be_closed() {
		try {
			Assert.assertTrue("Minicart is not closed.", mp.verifyMinicartClosed());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Minicart message.");
		}
	}
	
	@Then("user can see {string} button")
	public void user_can_see_button(String btnName) {
		try {
			Assert.assertTrue("Either Proceed to Checkout button is not present or button label is incorrect.", 
					mp.verifyProceedToCheckoutButton(btnName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Proceed to Checkout button in Minicart.");
		}
	}
	
	@And("button is in Blue color")
	public void button_is_in_blue_color() {
		try {
			Assert.assertTrue("Wrong background color for Proceed to Checkout button.", mp.verifyProceedToCheckoutBackgroundColor());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify background color of Proceed to Checkout button.");
		}
	}
	
	@And("button text is in White color")
	public void button_text_is_in_white_color() {
		try {
			Assert.assertTrue("Wrong font color for Proceed to Checkout button.", mp.verifyProceedToCheckoutFontColor());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify font color of Proceed to Checkout button.");
		}
	}
	
	@And("user clicks on Proceed to Checkout button from Minicart")
	public void user_clicks_on_proceed_to_checkout_button_from_minicart() {
		try {
			Thread.sleep(2000);
			mp.clickProceedToCheckout();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Proceed to Checkout from Minicart.");
		}
	}
	
	@Then("user can see Remove Item icon in Minicart")
	public void user_can_see_remove_item_icon_in_minicart() {
		try {
			Assert.assertTrue("Product did not removed from Minicart.", mp.verifyRemoveItemIcon());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Remove Item icon in Minicart.");
		}
	}
	
	@And("user clicks on Remove Item icon in Minicart")
	public void user_clicks_on_remove_item_icon_in_minicart() {
		try {
			mp.clickRemoveItemIcon();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Remove Item icon in Minicart.");
		}
	}
	
	@And("user can see pop up with {string} text")
	public void user_can_see_pop_up_with_text(String text) {
		try {
			Assert.assertTrue("Incorrect text on Remove Item pop up.", mp.verifyRemoveItemPopupText(text));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify pop up text.");
		}
	}
	
	@And("user clicks on {string} button")
	public void user_clicks_on_button(String name) {
		try {
			mp.clickRemoveItemPopupButton(name);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Cancel button inside pop up.");
		}
	}
	
	@Then("user can see the product exists in Minicart")
	public void user_can_see_the_product_exists_in_minicart() {
		try {
			Assert.assertTrue("No product exists in Minicart.", mp.verifyProductExistsInMinicart());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify product in Minicart.");
		}
	}

}
