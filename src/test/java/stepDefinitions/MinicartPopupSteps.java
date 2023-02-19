package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.MinicartPopup;

public class MinicartPopupSteps {
	
	WebDriver driver;
	
	MinicartPopup mp = new MinicartPopup(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	// Steps for pop up
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

}
