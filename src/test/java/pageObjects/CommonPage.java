package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	// Action methods
	public boolean verifyPageTitle(String expectedTitle) {
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

}
