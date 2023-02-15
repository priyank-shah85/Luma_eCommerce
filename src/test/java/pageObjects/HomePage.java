package pageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Declaring global parameters
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	//Elements for page details
	@FindBy(xpath = "//div[@class='panel header']//span[@class='not-logged-in']")
	WebElement msgWelcome;
	
	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	WebElement logoLuma;
	
	@FindBy(xpath = "//li[contains(@class, 'level0')]")
	List<WebElement> topMenuItems;
	
	@FindBy(id = "search")
	WebElement fldSearch;
	
	@FindBy(xpath = "//button[@title='Search']")
	WebElement iconSearch;
	
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(), 'Create an Account')]")
	WebElement lnkCreateAccount;
	
	//Action methods for page details
	public boolean verifyWelcomeMsg(String expectedMsg) {
		WebElement actualWelcomeMsg = wait.until(ExpectedConditions.elementToBeClickable(msgWelcome));
		// System.out.println(actualWelcomeMsg.getText());
		if(actualWelcomeMsg.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyBrowserTitle(String expectedTitle) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgWelcome));
		// System.out.println(driver.getTitle());
		if(driver.getTitle().contentEquals(expectedTitle)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean compareHomePageLogo() throws IOException {
		boolean results = false;
		WebElement imgLuma = wait.until(ExpectedConditions.elementToBeClickable(logoLuma));
		
		// First downloading the logo image and storing it in local machine
		//Screenshot expectedLogoImage = new AShot().takeScreenshot(driver, imgLuma);
		String webImageLoc = imgLuma.getAttribute("src");
		//System.out.println("URL is: " + new URL(webImageLoc));
		BufferedImage buffimg =ImageIO.read(new URL(webImageLoc));
		File outputFile = new File(System.getProperty("user.dir")+"\\Screenshots\\expected.png");
		ImageIO.write(buffimg, "png", outputFile);
		
		// Taking screenshot of image element from search results
		Screenshot screenshot = new AShot().takeScreenshot(driver, logoLuma);
	    System.out.println("after taking screenshot");
	    File screenshotFile = new File(System.getProperty("user.dir") + "\\Screenshots\\actual.png");
		ImageIO.write(screenshot.getImage(), "png", screenshotFile);
		
		// Comparing both images
		BufferedImage expectedImage = ImageIO.read(outputFile); // Getting expected image
		BufferedImage actualImage = screenshot.getImage(); // Getting actual image
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage); // Storing diff result
		if(diff.hasDiff()) {
			System.out.println("Images are not same.");
			results = false;
		}
		else {
			System.out.println("Images are same.");
			results = true;
		}
		
		return results;
	}
	
	public boolean verifyTopMenuLink(String expectedLinkText) {
		boolean results = false;
		
		for(int i=0; i<topMenuItems.size(); i++) {
			List<WebElement> topMenuLinks = driver.findElements(By.xpath("//li[contains(@class, 'level0')]"));
			System.out.println(topMenuLinks.get(i).getText());
			if(topMenuLinks.get(i).getText().contentEquals(expectedLinkText)) {
				results = true;
				break;
			}
		}
		return results;
	}
	
	public boolean verifySearchBoxPresence() {
		if(fldSearch.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifySearchBoxPlaceholder(String expectedPlaceholder) {
		if(fldSearch.getAttribute("placeholder").contentEquals(expectedPlaceholder)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifySearchIcon() {
		if(iconSearch.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void enterSearchTerm(String text) {
		fldSearch.sendKeys(text);
	}
	
	public void hitEnterKey() {
		fldSearch.sendKeys(Keys.ENTER);
	}
	
	public void clickCreateAccount() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lnkCreateAccount));
		lnkCreateAccount.click();
	}

}
