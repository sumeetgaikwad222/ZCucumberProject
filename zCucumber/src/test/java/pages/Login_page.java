package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_page {
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public Login_page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void selectRadio(String option) {

	    String radioId;

	    switch (option.toUpperCase()) {
	        case "BMW":
	            radioId = "bmwradio";
	            break;
	        case "BENZ":
	            radioId = "benzradio";
	            break;
	        case "HONDA":
	            radioId = "hondaradio";
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid radio option: " + option);
	    }

	    WebElement element = wait.until(
	            ExpectedConditions.elementToBeClickable(By.id(radioId))
	    );
	    element.click();
	}
}
