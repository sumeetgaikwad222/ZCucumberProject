package practice_package;

import java.awt.print.Book;
import java.time.Duration;

import javax.swing.text.html.Option;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMenu {
	
	static WebDriver driver;
	@BeforeMethod
	public void runalways()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
	}
	@Test
	public void menu()
	{
		driver.findElement(By.xpath("//span[contains(@class,'mbsc-textfield mbsc-textfield-outline mbsc-select mbsc-textfield-stacked mbsc-textfield-outline-stacked mbsc-textarea')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement books = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Books']")));
		books.click();
		WebElement movies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Movies, Music & Games']")));
		movies.click();
		WebElement eclectronics = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Electronics & Computers']")));
		eclectronics.click();
		WebElement home = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Home, Garden & Tools']")));
		home.click();
		WebElement health = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Health & Beauty']")));
		health.click();
		WebElement toys = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Toys, Kids & Baby']")));
		toys.click();
		WebElement clothes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Toys, Kids & Baby']")));
		clothes.click();
		WebElement sports = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Sports & Outdoors']")));
		sports.click();
	}
	
}
