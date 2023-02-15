package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyOrdersPage extends BasePage {

	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements for page details
	@FindBy(xpath = "//div[@class='message info empty']//span")
	WebElement msgNoOrderPlaced;
	
	// Action methods for page details
	public boolean verifyNoOrderPlacedMessage(String expectedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgNoOrderPlaced));
		if(msgNoOrderPlaced.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}

}
