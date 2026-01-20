package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxSelection {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public CheckboxSelection(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void perform(String option)
	{
		String boxes = null;
		switch(option.toUpperCase())
		{
		case "BMW" : boxes = "bmwcheck"; break;
		case "BENZ" : boxes = "benzcheck"; break;
		case "HONDA" : boxes = "hondacheck"; break;
		}
		WebElement element = driver.findElement(By.id(boxes));
		wait.until(driver -> element.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
