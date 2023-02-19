package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.ProductDetailsPage;

public class ProductDetailsPageSteps {
	
	WebDriver driver;
	
	ProductDetailsPage pdp = new ProductDetailsPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for product details
	@And("user selects {string} size")
	public void user_selects_size(String size) {
		try {
			Assert.assertTrue("Size " + size + " not selected.", pdp.selectRightSize(size));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select size.");
		}
	}
	
	@And("user select {string} color")
	public void user_select_color(String color) {
		try {
			Assert.assertTrue("Color " + color + " not selected.", pdp.selectRightColor(color));
		}
		catch (Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select color.");
		}
	}
	
	@And("user clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
		try {
			pdp.clickAddToCart();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Add to Cart button.");
		}
	}
	
	@And("user can see {string} message on top of the same page")
	public void user_can_see_message_on_top_of_the_same_page(String expectedMsg) {
		try {
			Assert.assertTrue("Product was not added successfully to cart.", pdp.verifyAddToCartConfirmationMessage(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Issue while adding a product to cart.");
		}
	}

}
