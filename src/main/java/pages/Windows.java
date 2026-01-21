package pages;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windows {
	
	@FindBy(xpath = "//a[normalize-space()='Multiple Windows']") private WebElement firstlink;
	@FindBy(xpath = "//a[normalize-space()='Click Here']") private WebElement secondlink;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Windows(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void perform()
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstlink));
		firstlink.click();
		String defaultwindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(secondlink));
		secondlink.click();
		Set<String> allwindows = driver.getWindowHandles();
		for(String handle :allwindows)
		{
			if (!handle.equals(defaultwindow)) {
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				driver.switchTo().window(handle);
				@Nullable
				String title = driver.getTitle();
				System.out.println(title);
				
			}
		}
	}
}
