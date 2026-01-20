package practice_package;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver driver;
	 WebDriverWait wait;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    @Test
	    public void perform()
	    {
	    	WebElement element = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][1]"));
	    	driver.switchTo().frame(element);
	    	WebElement texts = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
	    	Actions act = new Actions(driver);
	    	act.scrollToElement(texts).perform();
	    	if (texts.getText().contains("Sample New Tab")) {
				Assert.assertTrue(true);
				System.out.println(texts.getText());
			}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    @Test
	    public void perform1()
	    {

	    	WebElement element = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][2]"));
	    	driver.switchTo().frame(element);
	    	WebElement texts = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
	    	Actions act = new Actions(driver);
	    	act.scrollToElement(texts).perform();
	    	if (texts.getText().contains("Sample New Tab")) {
				Assert.assertTrue(true);
				System.out.println(texts.getText());
			}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    	
	    }
}
