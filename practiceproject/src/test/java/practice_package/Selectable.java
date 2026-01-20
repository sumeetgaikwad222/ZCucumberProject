package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public class DragandDrop {
		WebDriver driver;
		WebDriverWait wait;
		@BeforeMethod
		public void setup()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.tutorialspoint.com/selenium/practice/selectable.php");
			new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		@Test
		public void perform()
		{
			check("It is a long established fact that a");
			check("Many desktop publishing packages and web");
			check("in section 1.10.32.");
		}
		public void check(String value)
		{
			driver.findElement(By.xpath("//li[contains(text(),'"+value+"')]")).click();
		}
	}
}
