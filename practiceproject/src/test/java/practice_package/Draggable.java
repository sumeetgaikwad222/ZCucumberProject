package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {
	 WebDriver driver;
	 WebDriverWait wait;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    @Test
	    public void perform()
	    {
	    	driver.findElement(By.xpath("//body//main//button[2]")).click();
	    	WebElement source = driver.findElement(By.xpath("//div[@id='div_element']"));
	    	wait.until(ExpectedConditions.elementToBeClickable(source));
	    	WebElement targer = driver.findElement(By.xpath("//div[@id='div_elementy']"));
	    	wait.until(ExpectedConditions.elementToBeClickable(targer));
	    	Actions act = new Actions(driver);
	    	act.clickAndHold(source).moveToElement(targer, 0, 0).release().perform();
	    }
	    @Test
	    public void perform1()
	    {
	    	WebElement one = driver.findElement(By.xpath("(//button[normalize-space()='Container Restricted'])[1]"));
	    	wait.until(ExpectedConditions.elementToBeClickable(one));
	    	one.click();
	    	WebElement source = driver.findElement(By.xpath("//div[@id='intro']"));
	    	wait.until(ExpectedConditions.elementToBeClickable(source));
	    	Actions act = new Actions(driver);
	    	act.clickAndHold(source).moveByOffset(250, 0).release().perform();
	    	
	    }
}
