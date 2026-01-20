package practice_package;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeForm {
	WebDriver driver;
	WebDriverWait wait;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   }
	    public void perform(String value, String input)
	    {
	    	WebElement element = driver.findElement(By.xpath("//input[@id='"+value+"']"));
	    	element.sendKeys(input);
	    }
	    public void check(String Gender, String hobbies)
	    {
	    	perform("name", "Sumeet Gaikwad");
	    	perform("email", "sumeetgaikwad@gmail.com");
	    	perform("mobile", "8754457804");
	    	WebElement gender = driver.findElement(By.xpath("(//input[@type='radio'])['"+Gender+"']"));
	    	wait.until(ExpectedConditions.elementToBeClickable(gender));
	    	gender.click();
	    	
	    	driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("14-05-2005");
	    	perform("subjects", "Social Science");
	    	WebElement hobbiess = driver.findElement(By.xpath("(//input[@type='checkbox'])['"+hobbies+"']"));
	    	wait.until(ExpectedConditions.elementToBeClickable(hobbiess));
	    	hobbiess.click();
	    	perform("picture", "C:\\Users\\SUMEET GAIKWAD\\git\\repository3\\practiceproject\\data\\image (6).png");
	    	driver.findElement(By.xpath("//textarea[@id='picture']")).sendKeys("current address");
	    	WebElement element = driver.findElement(By.xpath("//select[@id='state']"));
	    	Select sel = new Select(element);
	    	sel.selectByValue("NCR");
	    	WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
	    	Select sel2 = new Select(city);
	    	sel2.selectByValue("Lucknow");
	    	driver.findElement(By.xpath("//input[@value='Login']")).click();
	    }
	    @Test
	    public void one()
	    {
	    	check("2", "2");
	    }
}
