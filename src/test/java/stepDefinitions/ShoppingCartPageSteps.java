package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.ShoppingCartPage;

public class ShoppingCartPageSteps {
	
	WebDriver driver;
	
	ShoppingCartPage scp = new ShoppingCartPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@And("user can see {string} presents as {string}")
	public void user_can_see_presents_as(String expectedName, String columnName) {
		try {
			Assert.assertTrue("Product " + expectedName + " is not present in the cart.", scp.verifyProductNameInCart(expectedName, columnName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify the products on Shopping Cart page.");
		}
	}
	
	@And("user can see total amount for the product")
	public void user_can_see_total_amount_for_the_product() {
		try {
			// Adding sleep to allow calculation of final Order Total amount
			Thread.sleep(4000);
			Assert.assertTrue("Order amount value is not displayed.", scp.verifyOrderTotalVisibility());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Order Amount value.");
		}
	}
	
	@And("user clicks on Proceed to Checkout button")
	public void user_clicks_on_proceed_to_checkout_button() {
		try {
			scp.clickProceedToCheckout();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Proceed To Checkout button.");
		}
	}

}
