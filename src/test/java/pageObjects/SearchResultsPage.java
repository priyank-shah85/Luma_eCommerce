package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements for page details
	@FindBy(className = "base")
	WebElement headingSearchPage;
	
	@FindBy(xpath = "//dl[@class='block']")
	WebElement blockResultSearchTerm;
	
	@FindBy(xpath = "//div[@class='message notice']//div")
	WebElement msgNoSearchResults;
	
	// Action methods for page details
	public boolean verifySearchPageHeading(String searchTerm, String pageHeading) {
		boolean results = false;
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(headingSearchPage));
		String expectedHeading = headingSearchPage.getText();
		String actualHeading = pageHeading + "'" + searchTerm + "'";
		//System.out.println("Actual: " + actualHeading + " | Expected: " + expectedHeading);
		
		if(actualHeading.contentEquals(expectedHeading)) {
			results = true;
		}
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifySearchTermBlockLinks(String searchTerm, String sectionName) {
		boolean results = false;
		int totalSearchLinks = 0;
		
		if(blockResultSearchTerm.findElement(By.tagName("dt")).getText().contentEquals(sectionName)) {
			List<WebElement> links = blockResultSearchTerm.findElements(By.tagName("dd"));
			//System.out.println("Total links: " + links.size());
			for(int i=0; i<links.size(); i++) {
				List<WebElement> resultLinks = blockResultSearchTerm.findElements(By.tagName("a"));
				//System.out.println("Link name: " + resultLinks.get(i).getText());
				if(resultLinks.get(i).getText().toLowerCase().contains(searchTerm.toLowerCase())) {
					totalSearchLinks++;
				}
			}
			//System.out.println("Value of counter: " + totalSearchLinks);
			if(totalSearchLinks == links.size()) {
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
	
	public boolean verifyNoSearchResultsMsg(String expectedMsg) {
		if(msgNoSearchResults.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}

}
