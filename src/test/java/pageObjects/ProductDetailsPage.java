package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements for product details
	@FindBy(xpath = "//div[@attribute-code='size']//div[@role='listbox']//div")
	List<WebElement> selectSize;
	
	@FindBy(xpath = "//div[@attribute-code='color']//div[@role='listbox']//div")
	List<WebElement> selectColor;
	
	@FindBy(id = "product-addtocart-button")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement msgAddToCartConfirmation;
	
	// Action methods for product details
	public boolean selectRightSize(String size) throws InterruptedException {
		int i;
		boolean result = false;
		int sizeCount = selectSize.size();
		
		// Iterating in Size box to find and click the right size
		for(i=0; i<sizeCount; i++) {
			List<WebElement> sizes = driver.findElements(By.xpath("//div[@attribute-code='size']//div[@role='listbox']//div"));
			// System.out.println(sizes.get(i).getText());
			
			// Matching every size with desired one
			if(sizes.get(i).getText().contentEquals(size)) {
				result = true;
				sizes.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		// Checking if entire loop was traversed and still not found the size
		if(i == sizeCount) {
			result = false;;
		}
		return result;
	}
	
	public boolean selectRightColor(String color) throws InterruptedException {
		int i;
		boolean result = false;
		int colorCount = selectColor.size();
		
		// Iterating in Color box to find and click the right color
		for(i=0; i<colorCount; i++) {
			List<WebElement> colors = driver.findElements(By.xpath("//div[@attribute-code='color']//div[@role='listbox']//div"));
			// System.out.println(colors.get(i).getAttribute("option-label"));
			
			// Matching every color with desired one
			if(colors.get(i).getAttribute("option-label").contentEquals(color)) {
				result = true;
				colors.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		// Checking if entire loop was traversed and still not found the color
		if(i == colorCount) {
			result = false;
		}
		return result;
	}
	
	public void clickAddToCart() {
		btnAddToCart.click();
	}
	
	public boolean verifyAddToCartConfirmationMessage(String expectedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgAddToCartConfirmation));
		// System.out.println(msgAddToCartConfirmation.getText());
		if(msgAddToCartConfirmation.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}

}
