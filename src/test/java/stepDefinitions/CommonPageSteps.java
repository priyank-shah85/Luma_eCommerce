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
			Assert.assertTrue("User did not redirect to " + expectedTitle + " page.", cp.verifyPageTitle(expectedTitle));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to interact with page title.");
		}
	}

}
