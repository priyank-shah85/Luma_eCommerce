package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
	
	static WebDriver driver;
	HomePage hp;

	static Logger logger; // for logging
	ResourceBundle rb; // for reading properties file
	String br; // to store browser name

	@Before // Junit hook - executes once before starting
	public void setup()
	{
		// for logging
		logger = LogManager.getLogger(this.getClass());
		// Reading config.properties (for browser)
		rb = ResourceBundle.getBundle("config");
		br = rb.getString("browser");
		
		if (br.equals("chrome")) {
			ChromeOptions coptions = new ChromeOptions();
			coptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			//coptions.addArguments("--password-store=basic");
			//coptions.setExperimentalOption("credentials_enable_service", false);
			//coptions.setExperimentalOption("profile.password_manager_enabled", false);
			driver = new ChromeDriver(coptions);
		} else if (br.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@After // Junit hook - executes once at end
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status ======>" + scenario.getStatus());
		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}
	
	// Background steps
	@Given("user navigates to {string}")
	public void user_navigates_to(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@When("user can see the {string} on page")
	public void user_can_see_the_on_page(String expectedMsg) {
		hp = new HomePage(driver);
		try {
			Assert.assertTrue("Incorrect Welcome message.", hp.verifyWelcomeMsg(expectedMsg));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	@When("user clicks on Create an Account link")
	public void user_clicks_on_create_an_account_link() {
		hp = new HomePage(driver);
		try {
			hp.clickCreateAccount();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to click on 'Create an Account' link.");
		}
	}
	
	// Steps for page details
	@Then("user can see browser title as {string}")
	public void use_can_see_browser_title_as(String expectedTitle) {
		hp = new HomePage(driver);
		try {
			Assert.assertTrue("Incorrect browser title.", hp.verifyBrowserTitle(expectedTitle));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
	
	@Then("user can see the LUMA image on page")
	public void user_can_see_the_luma_image_on_page() {
		hp = new HomePage(driver);
		try {
			Assert.assertTrue("Images are not same.", hp.compareHomePageLogo());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
	
	@Then("user can see the {string} in top menu item")
	public void user_can_see_the_in_top_menu_item(String expectedLinkText) {
		hp = new HomePage(driver);
		try {
			Assert.assertTrue("Link " + expectedLinkText + " is missing in top menu.", hp.verifyTopMenuLink(expectedLinkText));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	@And("search box is present on the page")
	public void search_box_is_present_on_the_page() {
		hp = new HomePage(driver);
		try {
			Assert.assertTrue("Search Box is not present on page.", hp.verifySearchBoxPresence());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
	
	@And("search box has placeholder present as {string}")
	public void search_box_has_placeholder_present_as(String expectedPlaceholder) {
		hp = new HomePage(driver);
		try {
			Assert.assertTrue("Incorrect placeholder in Search box.", hp.verifySearchBoxPlaceholder(expectedPlaceholder));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
	
	@Then("search icon is disabled to user")
	public void search_icon_is_disabled_to_user() {
		hp = new HomePage(driver);
		try {
			Assert.assertFalse("Search icon is enabled without any input.", hp.verifySearchIcon());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Search icon is not disabled.");
		}
	}
	
	@And("user enters {string} in search box")
	public void user_enters_in_search_box(String searchTerm) {
		hp = new HomePage(driver);
		try {
			hp.enterSearchTerm(searchTerm);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter text in Search box.");
		}
	}
	
	@And("user hits enter on keyboard")
	public void user_hits_enter_on_keyboard() {
		hp = new HomePage(driver);
		try {
			hp.hitEnterKey();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to hit Enter key.");
		}
	}

}
