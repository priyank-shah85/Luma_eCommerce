package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;
import stepDefinitions.HomePageSteps;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext sc = CreateAccountPage.sc;
	ScenarioContext commonpagesc = CommonPage.commonpagesc;
	ScenarioContext addressbooksc = AddressBookPage.addressbooksc;
	CommonPage cp = new CommonPage(HomePageSteps.driver);
	AddressBookPage abp = new AddressBookPage(HomePageSteps.driver);
	
	// Elements for page details
	@FindBy(xpath = "//div[@class='block block-dashboard-info']//div[@class='block-title']//strong")
	WebElement msgAccountInformation;
	
	@FindBy(xpath = "//ul[@class='nav items']//li")
	List<WebElement> navigationModule;
	
	@FindBy(css = ".box.box-information")
	WebElement boxContactInformation;
	
	@FindBy(css = ".box.box-newsletter")
	WebElement boxNewsletter;
	
	@FindBy(css = ".box.box-billing-address")
	WebElement boxDefaultBillingAddress;
	
	@FindBy(xpath = "//div[@class='box box-billing-address']//address")
	WebElement txtDefaultBillingAddress;
	
	@FindBy(css = ".box.box-shipping-address")
	WebElement boxDefaultShippingAddress;
	
	@FindBy(xpath = "//div[@class='box box-shipping-address']//address")
	WebElement txtDefaultShippingAddress;
	
	// Elements for Create Account result
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement msgNewAccountCreated;
	
	// Elements for user account actions
	@FindBy(xpath = "//div[@class='panel header']//ul//li//span[@class='logged-in']")
	WebElement welcomeMsgAfterSignIn;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement btnAction;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//ul//li//a[contains(text(),'My Account')]")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//ul//li//a[contains(text(),'Sign Out')]")
	WebElement lnkSignOut;
	
	// Elements for specific navigation links
	@FindBy(linkText = "Address Book")
	WebElement lnkAddressBook;
	
	@FindBy(linkText = "My Orders")
	WebElement lnkMyOrders;
	
	// Action methods for page details
	public boolean verifyAccountInformationMessage(String expcetedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgAccountInformation));
		
		if(msgAccountInformation.getText().contentEquals(expcetedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyNavigationLink(String expectedLinkName) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(navigationModule.get(0)));
		
		boolean results = false;
		
		// Iterating through each link and see if it's matching with expected link name
		for(int i=0; i<navigationModule.size() ; i++) {
			List<WebElement> navLinks = driver.findElements(By.xpath("//ul[@class='nav items']//li"));
			
			// comparing the link text
			if(navLinks.get(i).getText().contentEquals(expectedLinkName)) {
				results = true;
				break;
			}
			else {
				continue;
			}
		}
		return results;
	}
	
	public boolean verifyContactInformationBox(String boxLabel) {
		boolean results;
		
		// Checking if the Contact Information text is present inside the box
		WebElement lblContactInformation = boxContactInformation.findElement(By.tagName("strong"));
		if(lblContactInformation.getText().contentEquals(boxLabel)) {
			// Formatting the expected full name with combination of first & last name which user used while registering new account
			String expectedName = sc.getContext(Context.FIRST_NAME).toString() + " " 
					+ sc.getContext(Context.LAST_NAME).toString();
			
			// Formatting the entire box content with above expectedName and email address which user used for registration
			String expectedFinalContent = expectedName + "\n" + sc.getContext(Context.EMAIL).toString();
			
			// Fetching actual full name and storing it in a variable
			String actualFinalContent = boxContactInformation.findElement(By.tagName("p")).getText();
			
			// Comparing both content
			if(actualFinalContent.contentEquals(expectedFinalContent)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifyContactInformationLinks(String expectedLink1, String expectedLink2) {
		boolean results;
		
		// Storing both links as List
		List<WebElement> expectedLinks= boxContactInformation.findElement(By.className("box-actions")).findElements(By.tagName("a"));
		
		// Storing total number of links
		int totalLinks = 2;
		
		// Comparing total links with List size
		if(expectedLinks.size() == totalLinks) {
			// Storing actual link names
			String actualLink1 = expectedLinks.get(0).getText();
			String actualLink2 = expectedLinks.get(1).getText();
			
			// Comparing actual vs expected
			if(actualLink1.contentEquals(expectedLink1) && actualLink2.contentEquals(expectedLink2)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifyNewsletterBox(String boxLabel) {
		new WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(boxNewsletter));
		boolean results;
		
		// Checking if the Newsletter text is present inside the box
		WebElement lblNewsletter = boxNewsletter.findElement(By.tagName("strong"));
		if(lblNewsletter.getText().contentEquals(boxLabel)) {
			// Storing both possible preferences in variables
			String expectedText1 = "You are subscribed to \"General Subscription\".";
			String expectedText2 = "You aren't subscribed to our newsletter.";
			
			// Fetching actual preference and storing it in a variable
			String actualText = boxNewsletter.findElement(By.className("box-content")).findElement(By.tagName("p")).getText();
			
			// Comparing both content
			if(actualText.contentEquals(expectedText1) || actualText.contentEquals(expectedText2)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifyNewletterLinks(String expectedLinkName) {
		boolean results;
		
		// Storing both links as List
		List<WebElement> expectedLinks = boxNewsletter.findElement(By.className("box-actions")).findElements(By.tagName("a"));
		
		// Storing total number of links
		int totalLinks = 1;
		
		// Comparing total links with List size
		if(expectedLinks.size() == totalLinks) {
			// Storing actual link names
			String actualLink = expectedLinks.get(0).getText();
			
			// Comparing actual vs expected
			if(actualLink.contentEquals(expectedLinkName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifyDefaultBillingAddressBox(String expectedMsg, String expectedBoxLabel) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(boxDefaultBillingAddress));
		boolean results = false;
		
		// Fetching stored page title value from AddressBook page
		String pageTitle = commonpagesc.getContext(Context.PAGE_TITLE).toString();
		
		switch (pageTitle) {
		
		case "Add New Address":
			// Getting actual values for label and message
			String actualBoxLabel = boxDefaultBillingAddress.findElement(By.tagName("strong")).getText();
			String actualMsg = boxDefaultBillingAddress.findElement(By.className("box-content")).findElement(By.tagName("address")).getText();
			
			// Comparing actual vs expected
			if(actualBoxLabel.contentEquals(expectedBoxLabel)) {
				if(actualMsg.contentEquals(expectedMsg)) {
					results = true;
				}
				else {
					results = false;
				}
			}
			else {
				results = false;
			}
			break;
			
		case "Address Book":
			// Verifying the default billing address from Address Book
			String expectedBillingAdd = addressbooksc.getContext(Context.DEFAULT_BILLING_ADDRESS).toString();
			String actualBillingAdd = txtDefaultBillingAddress.getText();
			System.out.println("Expected billing: " + expectedBillingAdd + "\n Actual Billing: " + actualBillingAdd);
			
			if(actualBillingAdd.contentEquals(expectedBillingAdd)) {
				results = true;
			}
			else {
				results = false;
			}
			break;
		
		default:
			results = false;
			break;
		}
		return results;
	}
	
	public boolean verifyDefaultShippingAddressBox(String expectedMsg, String expectedBoxLabel) {
		boolean results = false;
		
		// Fetching stored page title value from AddressBook page
		String pageTitle = commonpagesc.getContext(Context.PAGE_TITLE).toString();
		
		switch (pageTitle) {
		
		case "Add New Address":
			
			// Getting actual values for label and message
			String actualBoxLabel = boxDefaultShippingAddress.findElement(By.tagName("strong")).getText();
			String actualMsg = boxDefaultShippingAddress.findElement(By.className("box-content")).findElement(By.tagName("address")).getText();
			
			// Comparing actual vs expected
			if(actualBoxLabel.contentEquals(expectedBoxLabel)) {
				if(actualMsg.contentEquals(expectedMsg)) {
					results = true;
				}
				else {
					results = false;
				}
			}
			else {
				results = false;
			}
			
		case "Address Book":
			// Verifying the default shipping address from Address Book
			String expectedShippingAdd = addressbooksc.getContext(Context.DEFAULT_SHIPPING_ADDRESS).toString();
			String actualShippingAdd = txtDefaultShippingAddress.getText();
			System.out.println("Expected shipping: " + expectedShippingAdd + "\n Actual shipping: " + actualShippingAdd);
			
			if(actualShippingAdd.contentEquals(expectedShippingAdd)) {
				results = true;
			}
			else {
				results = false;
			}
			break;
			
		default:
			results = false;
			break;
		}
		return results;
	}
	
	// Action methods for Create Account result
	public boolean verifyNewAccountCreation(String expectedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgNewAccountCreated));
		if(msgNewAccountCreated.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Action methods for user account actions
	public boolean verifyWelcomeMessageAfterSignIn(String partialText) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(welcomeMsgAfterSignIn));
		
		// Formatting the expected welcome message with help of stored first & last name
		String expectedMsg = partialText + sc.getContext(Context.FIRST_NAME).toString() + " " 
				+ sc.getContext(Context.LAST_NAME).toString() + "!";
		
		// Extracting the actual welcome message from web page
		String actualMsg = welcomeMsgAfterSignIn.getText();
		//System.out.println("Expected: " + expectedMsg + " |Actual: " + actualMsg);
		
		// Comparing both messages
		if(actualMsg.contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyPartialWelcomeMessageAfterSignIn(String text) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(welcomeMsgAfterSignIn));
		
		// Comparing partial text within the actual Welcome message
		if(welcomeMsgAfterSignIn.getText().contains(text)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickActionButton() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnAction));
		btnAction.click();
	}
	
	public void clickMyAccountLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkMyAccount));
		lnkMyAccount.click();
	}
	
	public void clickSignOutLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkSignOut));
		lnkSignOut.click();
	}
	
	// Action methods for navigation links
	public void clickAddressBookLink() {
		lnkAddressBook.click();
	}
	
	public void clickMyOrdersLink() {
		lnkMyOrders.click();
	}

}
