package practice_package;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Slider {
	static String value= "70%";
	static WebDriver driver;
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demo.automationtesting.in/Slider.html");
	WebElement ele = driver.findElement(By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all']"));
	WebElement slider = driver.findElement(By.xpath("(//div[@id='slider'])[1]"));
	@Nullable
	String move = slider.getAttribute("style=\"left: '"+value+"'");
	Actions act = new Actions(driver);
	act.clickAndHold(ele).moveToElement(slider, 70, 0).perform();
	Assert.assertEquals(move,70, "not reached");
}
}
