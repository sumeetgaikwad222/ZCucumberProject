package practice_package;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HorizontalScroll {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/horizontal-scroll.php");
		new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public void check()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='horizan-scroll']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Moves the scrollbar 500 pixels to the Right
		js.executeScript("arguments[0].scrollBy(500, 0);", element);
	}
}
