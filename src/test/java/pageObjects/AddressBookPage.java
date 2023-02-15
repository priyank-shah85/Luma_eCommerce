package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.ScenarioContext;
import enums.Context;

public class AddressBookPage extends BasePage {

	public AddressBookPage(WebDriver driver) {
		super(driver);
	}
	
	public static ScenarioContext addressbooksc = new ScenarioContext();
	
	// Elements for page details
	@FindBy(css = ".box.box-address-billing")
	WebElement boxDefaultBillingAddress;
	
	@FindBy(xpath = "//div[@class='box box-address-billing']//address")
	WebElement txtDefaultBillingAddress;
	
	@FindBy(css = ".box.box-address-shipping")
	WebElement boxDefaultShippingAddress;
	
	@FindBy(xpath = "//div[@class='box box-address-shipping']//address")
	WebElement txtDefaultShippingAddress;
	
	// Action methods for page details
	public void storeDefaultBillingAddress() { // Method to store the default billing address from Address book
		addressbooksc.setContext(Context.DEFAULT_BILLING_ADDRESS, txtDefaultBillingAddress.getText());
	}
	
//	public String defaultBillingAddressValue() { // Method to return the stored default billing address in previous method
//		return addressbooksc.getContext(Context.DEFAULT_BILLING_ADDRESS).toString();
//	}
	
	public void storeDefaultShippingAddress() { // Method to store the default shipping address from Address Book
		addressbooksc.setContext(Context.DEFAULT_SHIPPING_ADDRESS, txtDefaultShippingAddress.getText());
	}
	
//	public String defaultShippingAddressValue() { // Method to return the stored default shipping address in previous method
//		return addressbooksc.getContext(Context.DEFAULT_SHIPPING_ADDRESS).toString();
//	}

}
