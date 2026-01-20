package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mouse_Hover {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//button[@id='mousehover']") private WebElement mousehover;
	@FindBy(xpath = "//a[normalize-space()='Reload']") private WebElement reload;
	
	public Mouse_Hover(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void action()
	{
		wait.until(ExpectedConditions.elementToBeClickable(mousehover));
		Actions act = new Actions(driver);
		act.moveToElement(mousehover).perform();
		wait.until(ExpectedConditions.elementToBeClickable(reload));
		act.moveToElement(reload).click().perform();
	}
}
