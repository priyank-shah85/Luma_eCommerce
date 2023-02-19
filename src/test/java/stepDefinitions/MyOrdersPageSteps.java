package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.MyOrdersPage;

public class MyOrdersPageSteps {
	
	WebDriver driver;
	
	MyOrdersPage mop = new MyOrdersPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@Then("user can see {string} message")
	public void user_can_see_message(String expectedMsg) {
		try {
			Assert.assertTrue("No order placed message is incorrect.", mop.verifyNoOrderPlacedMessage(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify no order placed message.");
		}
	}
	
	@And("user can see the same order number present under {string} column")
	public void user_can_see_the_same_order_number_present_under_column(String headerName) {
		try {
			Assert.assertTrue("Order number is not missing on My Orders table.", mop.verifyOrderNumber(headerName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to verify the My Ordres table.");
		}
	}

}
