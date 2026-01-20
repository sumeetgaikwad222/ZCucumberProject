package practice_package;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tabs {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/tabs.php");
		WebElement hometab = driver.findElement(By.xpath("//button[@id='nav-home-tab']"));
		WebElement profile = driver.findElement(By.xpath("//button[@id='nav-profile-tab']"));
		WebElement contact = driver.findElement(By.xpath("//button[@id='nav-contact-tab']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.withTimeout(Duration.ofSeconds(10));
		act.moveToElement(contact).click().perform();
		wait.until(ExpectedConditions.invisibilityOf(contact));
		act.moveToElement(hometab).click().perform();
	}
}
