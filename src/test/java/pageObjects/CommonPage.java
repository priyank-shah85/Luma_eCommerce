package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;

public class CommonPage extends BasePage {

	public CommonPage(WebDriver driver) {
		super(driver);
	}
	
	public static ScenarioContext commonpagesc = new ScenarioContext();
	
	// Elements
	@FindBy(xpath = "//h1[@class='page-title']//span")
	WebElement pageTitle;
	
	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	WebElement logoLuma;
	
	@FindBy(className = "counter-number")
	WebElement numOfProductsAddedToCart;
	
	@FindBy(xpath = "//div[@data-block='minicart']//a[contains(@class,'action showcart')]")
	WebElement lnkMinicart;
	
	// Action methods
	public boolean verifyPageTitle(String expectedTitle) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(pageTitle));
		// System.out.println(pageTitle.getText());
		if(pageTitle.getText().contentEquals(expectedTitle)) {
			commonpagesc.setContext(Context.PAGE_TITLE, pageTitle.getText());
			return true;
		}
		else {
			return false;
		}
	}
	
//	public String getPageTitle() { // This method is used to compare page title with current browser page and decide next action accordingly
//		String title = commonpagesc.getContext(Context.PAGE_TITLE).toString();
//		return title;
//	}
	
	public void clickBrowserBackButton() {
		driver.navigate().back();
	}
	
	public void clickLUMALogo() {
		logoLuma.click();
	}
	
	public boolean verifyProductCountAddedToCart(String count) {
		// System.out.println(numOfProductsAddedToCart.getText());
		if(numOfProductsAddedToCart.getText().contentEquals(count)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickMinicartLink() {
		lnkMinicart.click();
	}

}
