package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxes {
	WebDriver driver;
	WebDriverWait wait;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   }
	    public void perfor(String value, String input)
	    {
	    	WebElement element = driver.findElement(By.xpath("//input[@id='"+value+"']"));
	    	element.sendKeys(input);
	    	wait.until(ExpectedConditions.visibilityOf(element));
	    	driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Pune maharashtra");
	    	driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    }
	    @Test
	    public void check()
	    {
	    	perfor("fullname", "sumeet gaikwad");
	    	perfor("email", "sumeet@gmail.com");
	    	perfor("password", "12345Su@");
	    }
}
