package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.ProductLists;

public class ProductListsSteps {
	
	WebDriver driver;
	
	ProductLists pl = new ProductLists(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for traversing through product list
	@And("user clicks on {string} product")
	public void user_clicks_on_product(String productName) {
		try {
			pl.clickProductNameLink(productName);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on the product name.");
		}
	}

}
