package pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dynamicontent {
	
	@FindBy(xpath = "//a[contains(text(), 'Loading')]") private WebElement link;
	@FindBy(xpath = "//a[contains(.,'Example 1: Element on page that is hidden')]") private WebElement elementtoverify;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Dynamicontent(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(driver, this);
	}

	public WebElement getLink() {
		return link;
	}

	public void perform()
	{
		wait.until(ExpectedConditions.elementToBeClickable(link));
		link.click();
		@Nullable
		String actual = driver.getTitle();
		wait.until(ExpectedConditions.elementToBeClickable(elementtoverify));
		Assert.assertEquals(actual, "The Internet");
	}
}
