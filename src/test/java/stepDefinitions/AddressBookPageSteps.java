package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.AddressBookPage;

public class AddressBookPageSteps {
	
	WebDriver driver;
	
	AddressBookPage abp = new AddressBookPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@And("user stores Default Billing Address")
	public void user_stores_default_billing_address() {
		try {
			abp.storeDefaultBillingAddress();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to fetch and store the Default Billing Address from Address Book page.");
		}
	}
	
	@And("user stores Default Shipping Address")
	public void user_stores_default_shipping_address() {
		try {
			abp.storeDefaultShippingAddress();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to fetch and store the Default Shipping Address from Address Book page.");
		}
	}
	
}
