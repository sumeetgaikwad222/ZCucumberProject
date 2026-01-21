package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlerts {
	
	@FindBy(xpath = "//a[normalize-space()='JavaScript Alerts']") private WebElement firstlink;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public JavaScriptAlerts(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void perform()
	{
		firstlink.click();
		String [] value = {"Click for JS Prompt", "Click for JS Alert", "Click for JS Confirm"};
		
		for(String text : value)
		{
			WebElement button = driver.findElement(By.xpath("//button[normalize-space()='"+text+"']"));
			wait.until(driver -> button.isDisplayed());
			if (text.equals("Click for JS Prompt")) {
				wait.until(ExpectedConditions.elementToBeClickable(button));
				button.click();
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().sendKeys("sumeet");
				driver.switchTo().alert().accept();
				System.out.println("First one");
			}
			else if (text.equals("Click for JS Alert")) {
				wait.until(ExpectedConditions.elementToBeClickable(button));
				button.click();
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();
				System.out.println("Second one");
			}
			else if (text.equals("Click for JS Confirm")) {
				wait.until(ExpectedConditions.elementToBeClickable(button));
				button.click();
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().dismiss();
				System.out.println("Third one");
			}
			else
			{
				System.out.println("nothing found as per now");
			}
		}
	}
}
