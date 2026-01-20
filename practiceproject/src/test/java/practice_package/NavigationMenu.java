package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMenu {
	static WebDriver driver;
	@BeforeMethod
	public void runalways()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialspoint.com/selenium/practice/menu.php");
	}
	@Test
	public void navbar()
	{
		WebElement navibar = driver.findElement(By.xpath("//a[normalize-space()='Navbar']"));
		WebElement Home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		Actions act = new Actions(driver);
		act.moveToElement(navibar).perform();
		act.click(Home).perform();
		WebElement options = driver.findElement(By.xpath("//a[normalize-space()='Dropdown']"));
		options.click();
		driver.findElement(By.xpath("//a[normalize-space()='Action']")).click();
		options.click();
		driver.findElement(By.xpath("//a[normalize-space()='Another action']")).click();
		options.click();
		driver.findElement(By.xpath("//a[normalize-space()='Something else here']")).click();
	//	WebElement option3 = driver.findElement(By.xpath("//ul[@class='dropdown-menu show']"));
		
	}
}
