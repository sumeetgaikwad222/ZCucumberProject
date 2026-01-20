package practice_package;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Sortable {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/sortable.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void performSorting() {
//    	WebElement source = driver.findElement(By.xpath("//td[normalize-space()='3']"));
//    	wait.until(ExpectedConditions.elementToBeClickable(source));
//    	WebElement target = driver.findElement(By.xpath("//td[normalize-space()='1']"));
//    	wait.until(ExpectedConditions.elementToBeClickable(target));
//    	
//    	Actions action = new Actions(driver);
//    	action.clickAndHold(source).moveToElement(target).release().perform();
    	 // Drag row 3 above row 1
        WebElement source = driver.findElement(By.xpath("//td[normalize-space()='3']"));
        wait.until(ExpectedConditions.elementToBeClickable(source));
        WebElement target = driver.findElement(By.xpath("//td[normalize-space()='1']"));
        wait.until(ExpectedConditions.elementToBeClickable(target));

        Actions act = new Actions(driver);
        act.clickAndHold(source)
           .moveToElement(target)
           .release().perform();
        Reporter.log(source.getText(),true);
    }
    
    public String perforsorting2(String value)
    {
    	driver.findElement(By.xpath("//button[@id='nav-profile-tab']")).click();
    	WebElement source = driver.findElement(By.xpath("(//a[@role='button'][normalize-space()='Button'])['"+value+"']"));
    	Actions act = new Actions(driver);
    	act.clickAndHold(source).moveByOffset(300, 0).release().perform();
    	WebElement name = driver.findElement(By.xpath("//h3[normalize-space()='Thumbnail label 2']"));
    	return name.getText().trim();
    }
    @Test
    public void act()
    {
    	String names = perforsorting2("2");
    	Assert.assertEquals(names, "Thumbnail label 2");
    }
}
