package practice_package;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class NestedFrames {
	WebDriver driver;
	WebDriverWait wait;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   }
	    @Test
	    public void perform()
	    {
	    	driver.switchTo().frame("frame1");
	    	WebElement element = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
	    	Actions act = new Actions(driver);
	    	act.scrollToElement(element);
	    	Assert.assertTrue(true);
	    	System.out.println(element.getText());
	    }
}
