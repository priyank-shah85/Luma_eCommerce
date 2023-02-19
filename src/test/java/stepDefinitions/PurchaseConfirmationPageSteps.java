package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.PurchaseConfirmationPage;

public class PurchaseConfirmationPageSteps {
	
	WebDriver driver;
	
	PurchaseConfirmationPage pcp = new PurchaseConfirmationPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@And("user can see order number")
	public void user_can_see_order_number() {
		try {
			Assert.assertTrue("Order number is missing on page.", pcp.storeOrderNumber());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to extract Order Number.");
		}
	}

}
