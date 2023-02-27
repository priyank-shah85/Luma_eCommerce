package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.ProductLists;

public class ProductListsSteps {
	
	WebDriver driver;
	
	ProductLists pl = new ProductLists(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for traversing through product list
	@And("user clicks on {string} product")
	public void user_clicks_on_product(String productName) {
		try {
			Assert.assertTrue("Product " + productName + "not found.", pl.clickProductNameLink(productName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on the product name.");
		}
	}
	
	@Then("user can see {string} message on page")
	public void user_can_see_message_on_page(String msg) {
		try {
			Assert.assertTrue("Message is missing on page.", pl.clickProductNameLink(msg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify message.");
		}
	}
	
	@Then("user can see maximum {string} products on page")
	public void user_can_see_maximum_products_on_page(String no) {
		try {
			Assert.assertTrue("Total product count is more than " + no + ".", pl.verifyMaxDefaultProducts(no));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify all products from list.");
		}
	}
	
	@And("page has more than 12 products")
	public void page_has_more_than_12_products() {
		try {
			Assert.assertTrue("Total product count is less than 12.", pl.verifyTotalProductCount());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify total product count.");
		}
	}
	
	@Then("user can move to next page till all products dipslayed")
	public void user_can_move_to_next_page_till_all_products_dipslayed() {
		try {
			Assert.assertTrue("You are already on last page.", pl.verifyLastPage());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to move to next page.");
		}
	}
	
	@And("user can see {string} block on left side")
	public void user_can_see_block_on_left_side(String label) {
		try {
			Assert.assertTrue("Incorrect label for Shopping Options block.", pl.verifyShoppingOptionsLabel(label));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify label for Shopping Options block.");
		}
	}
	
	@Then("user can see {string} on left side")
	public void user_can_see_on_left_side(String value) {
		try {
			Assert.assertTrue(value + "shopping option is not present.", pl.verifyShoppingOptionValue(value));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not abel to verify "+ value + " shopping option.");
		}
	}
	
	@And("the {string} is below the {string}")
	public void the_is_below_the(String value, String preValue) {
		try {
			Assert.assertTrue(value + "is at incorrect place. Should be below " + preValue + ".", 
					pl.verifyShoppingOptionPosition(value, preValue));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to find position of " + value + " shopping option.");
		}
	}
	
	@And("user selects {string} size for {string} product")
	public void user_selects_size_for_product(String size, String productName) {
		try {
			Assert.assertTrue("Either the " + size + " size or " + productName + " product not found.", pl.selectSizeOnList(size, productName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select the " + size + " size for " + productName + " product.");
		}
	}
	
	@And("user selects {string} color for {string} product")
	public void user_selects_color_for_product(String color, String productName) {
		try {
			Assert.assertTrue("Either the " + color + " color or " + productName + " product not found.", pl.selectColorOnList(color, productName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select the " + color + " color for " + productName + " product.");
		}
	}
	
	@And("user clicks on Add to Cart button for {string} product")
	public void user_clicks_on_add_to_cart_button_for_product(String productName) {
		try {
			pl.clickOnAddToCartButtonOnList(productName);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Add to Cart button for " + productName + " product.");
		}
	}

}
