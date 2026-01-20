package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipSelect {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(id = "multiple-select-example") private WebElement select;
	
	public MultipSelect(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void multi(String options) {

	    wait.until(ExpectedConditions.elementToBeClickable(select));
	    Select sel = new Select(select);
	    Actions act = new Actions(driver);
	    ScrollOrigin origin = WheelInput.ScrollOrigin.fromElement(select);
	    act.scrollFromOrigin(origin, 0,500);

	    String[] values = options.split(",");

	    for (String value : values) {
	        sel.selectByVisibleText(value);
	    }
	}
}
