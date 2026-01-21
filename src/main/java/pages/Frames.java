package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {
	
	@FindBy(xpath = "//a[normalize-space()='Frames']") private WebElement firstlink;
	@FindBy(xpath = "(//a[normalize-space()='Nested Frames'])[1]") private WebElement nestedframelink;
	@FindBy(xpath = "(//a[normalize-space()='iFrame'])[1]") private WebElement framelink;
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Frames(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void nested()
	{
		firstlink.click();
		framelink.click();
		
		driver.switchTo().frame("mce_0_ifr");
		WebElement element = driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']"));
		System.out.println(element.getText());
		
	}
}
