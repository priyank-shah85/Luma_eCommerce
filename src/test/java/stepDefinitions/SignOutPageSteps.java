package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.SignOutPage;

public class SignOutPageSteps {
	
	WebDriver driver;
	SignOutPage sop = new SignOutPage(HomePageSteps.driver);
	
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@And("user clicks on Sign In link")
	public void user_clicks_on_sign_in_link() {
		try {
			sop.clickSignIn();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to open Sign in page.");
		}
	}

}
