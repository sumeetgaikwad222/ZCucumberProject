package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMenu3 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
		new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public void check()
	{
		WebElement element = driver.findElement(By.id("inputGroupSelect03"));
		element.click();
		Select sel = new Select(element);
		sel.selectByValue("1");
		sel.selectByIndex(2);
		element.click();
	}
}
