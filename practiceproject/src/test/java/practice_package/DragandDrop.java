package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
		new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public void check()
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='droppable']"))).perform();
		driver.findElement(By.xpath("//body//main//button[2]")).click();
		act.dragAndDrop(driver.findElement(By.xpath("(//div[@id='div2'])[1]")), driver.findElement(By.xpath("(//div[@id='div1'])[1]"))).perform();
	}
}
