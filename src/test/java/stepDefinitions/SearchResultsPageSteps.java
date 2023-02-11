package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SearchResultsPage;

public class SearchResultsPageSteps {
	
	WebDriver driver;
	SearchResultsPage srp = new SearchResultsPage(HomePageSteps.driver);
	
	Logger logger = HomePageSteps.logger;
	
	// Steps for page details
	@Then("user will redirect to page where heading contains the {string} after {string} text")
	public void user_will_redirect_to_page_where_heading_contains_the_after_text(String searchTerm, String pageHeading) {
		try {
			Assert.assertTrue("User redirected to incorrect results page.", srp.verifySearchPageHeading(searchTerm, pageHeading));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to view search results.");
		}
	}
	
	@And("user will see various {string} links under {string} section")
	public void user_will_see_various_links_under_section(String searchTerm, String sectionName) {
		try {
			Assert.assertTrue("One or more related links are outside of search text.", srp.verifySearchTermBlockLinks(searchTerm, sectionName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("The result page does not contain any related links for search text.");
		}
	}
	
	@And("user will see {string} message on page")
	public void user_will_see_message_on_page(String expectedMsg) {
		try {
			Assert.assertTrue("Incorrect message.", srp.verifyNoSearchResultsMsg(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}

}
