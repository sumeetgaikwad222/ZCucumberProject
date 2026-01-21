package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Keypresses {
	
	@FindBy(xpath = "//a[normalize-space()='Key Presses']") private WebElement firstlink;
	@FindBy(id = "target") private WebElement input;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Keypresses(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void write() throws AWTException, IOException {
		firstlink.click();
		input.sendKeys("sumeet");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File loc = new File("./src/test/resources/image02.png");
		Files.copy(src, loc);
		
		System.out.println(input.getText());
	}
}
