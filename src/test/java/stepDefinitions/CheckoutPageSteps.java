package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.CheckoutPage;

public class CheckoutPageSteps {
	
	WebDriver driver;
	
	CheckoutPage cop = new CheckoutPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@And("user lands on {string} step")
	public void user_lands_on_step(String expectedTitle) {
		try {
			Thread.sleep(5000);
			Assert.assertTrue(expectedTitle + " step is not present on Checkout page.", cop.verifyStepAddressStep(expectedTitle));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify title for " + expectedTitle + " step.");
		}
	}
	
	@And("user clicks on Next button")
	public void user_clicks_on_next_button() {
		try {
			Thread.sleep(5000);
			cop.clickNext();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Next button.");
		}
	}
	
	@And("user can see {string} section")
	public void user_can_see_section(String name) {
		try {
			Assert.assertTrue("Order Summary section/lable is missing on Checkout page.", cop.verifyOrderSummaryExists(name));
			Assert.assertTrue("Order Total is not matching with Shopping Cart page.", cop.verifyOrderTotal());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Order Summary label.");
		}
	}
	
	@And("user clicks on Place Order button")
	public void user_clicks_on_place_order_button() {
		try {
			cop.clickPlaceOrderButton();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Place Order button.");
		}
	}

}
