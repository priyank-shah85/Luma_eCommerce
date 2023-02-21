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
	@And("user can see {string} step")
	public void user_can_see_step(String expectedTitle) {
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
	
	// -----> Steps to add new address on Checkout page -> Shipping Address step <-----
	@And("user can see First Name")
	public void user_can_see_first_name() {
		try {
			Assert.assertTrue("First Name on Shipping Address is different than logged in user's first name.", 
					cop.verifyShippingAddressFirstName());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Shipping Address First Name.");
		}
	}
	
	@And("user can see Last Name")
	public void user_can_see_last_name() {
		try {
			Assert.assertTrue("Last Name on Shipping Address is different than logged in user's last name.", 
					cop.verifyShippingAddressLastName());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify Shipping Address Last Name.");
		}
	}
	
	@And("user enters {string} in Street Address1")
	public void user_enters_in_street_address1(String add1) {
		try {
			cop.enterShippingAddressStreetAdd1(add1);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Shipping Address Street Address 1.");
		}
	}
	
	@And("user enters {string} in Street Address2")
	public void user_enters_in_street_address2(String add2) {
		try {
			cop.enterShippingAddressStreetAdd2(add2);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Shipping Address Street Address 2.");
		}
	}
	
	@And("user enters {string} in Street Address3")
	public void user_enters_in_street_address3(String add3) {
		try {
			cop.enterShippingAddressStreetAdd3(add3);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Shipping Address Street Address 3.");
		}
	}
	
	@And("user enters {string} in City")
	public void user_enters_in_city(String city) {
		try {
			cop.enterShippintAddressCity(city);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Shipping Address City.");
		}
	}
	
	@And("user selects {string} Country")
	public void user_selects_country(String country) {
		try {
			cop.selectShippingAddressCountry(country);
			Thread.sleep(2000); // to allow Shipping Methods to refresh
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select Shipping Address Country.");
		}
	}
	
	@And("user selects {string} Region")
	public void user_selects_region(String state) {
		try {
			cop.selectShippingAddressRegion(state);
			Thread.sleep(2000); // to allow Shipping Methods to refresh
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select Shipping Address State/Province.");
		}
	}
	
	@And("user enters {string} Post Code")
	public void user_enters_zip_postal_code(String postcode) {
		try {
			cop.enterShippingAddressPostcode(postcode);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Shipping Address Zip/Postal Code.");
		}
	}
	
	@And("user enters {string} Phone Number")
	public void user_enters_phone_number(String phone) {
		try {
			cop.enterShippingAddressPhone(phone);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Shipping Address Phone Number.");
		}
	}
	
	@And("user selects {string} shipping method")
	public void user_selects_shipping_method(String method) {
		try {
			Assert.assertTrue("Shipping method " + method + " not found.", cop.selectShippingMethod(method));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to select Shipping Method.");
		}
	}

}
