package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageObjects.TopMenuLinks;

public class TopMenuLinksSteps {
	
	WebDriver driver;
	
	TopMenuLinks tml = new TopMenuLinks(HomePageSteps.driver);
	Logger logger = HomePageSteps.logger;
	 
	// Steps for Level0 main menus
	@And("user opens {string} menu")
	public void user_opens_menu(String mainMenu) {
		try {
			tml.mouseHoverOnMainMenu(mainMenu);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(mainMenu + " menu does not exists.");
		}
	}
	
	@And("user hovers on {string} sub menu")
	public void user_hovers_on_sub_menu(String subMenu) {
		try {
			tml.mouseHoverOnSubMenu(subMenu);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(subMenu + " sub menu does not exists.");
		}
	}
	
	@And("user clicks on {string} link")
	public void user_clicks_on_link(String productLink) {
		try {
			tml.clickOnProductLink(productLink);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(productLink + " link does not exists.");
		}
	}

}
