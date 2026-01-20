package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Dropdown {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//select[@id='carselect']") private WebElement dropdownoptions;
	
	public Dropdown(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void dropdown(String option)
	{
		wait.until(ExpectedConditions.elementToBeClickable(dropdownoptions));
		Select sele = new Select(dropdownoptions);
		sele.selectByContainsVisibleText(option);
	}
}
