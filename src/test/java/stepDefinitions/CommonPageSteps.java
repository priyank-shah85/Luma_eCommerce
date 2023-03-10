package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.CommonPage;

public class CommonPageSteps {
	
	WebDriver driver;
	
	CommonPage cp = new CommonPage(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	
	@And("user can see page heading as {string}")
	public void user_can_see_page_heading_as(String expectedTitle) {
		try {
			Thread.sleep(4000);
			Assert.assertTrue("User did not redirect to " + expectedTitle + " page.", cp.verifyPageTitle(expectedTitle));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with page title.");
		}
	}
	
	@And("user clicks on browser back button")
	public void user_clicks_on_browser_back_button() {
		try {
			cp.clickBrowserBackButton();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to redirect to previous page.");
		}
	}
	
	@And("user clicks on LUMA logo")
	public void user_clicks_on_luma_logo() {
		try {
			cp.clickLUMALogo();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on LUMA logo.");
		}
	}
	
	@And("user can see {string} product added next to cart icon")
	public void user_can_see_product_added_next_to_cart_icon(String count) {
		try {
			Assert.assertTrue("Count has not increased.", cp.verifyProductCountAddedToCart(count));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Product was not successfully added to cart.");
		}
	}
	
	@And("user clicks on cart icon")
	public void user_clicks_on_cart_icon() {
		try {
			cp.clickMinicartLink();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on Minicart icon.");
		}
	}

}
