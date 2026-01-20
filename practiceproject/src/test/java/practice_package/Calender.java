package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {
static WebDriver driver;
static String value = "January 3, 2026";
static String date = "3";
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.className("hasDatepicker")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 900)");
		
		while(true)
		{
			String month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
			String years = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(month.equals("January") && years.equals("2026"))
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='"+date+"']")));
				((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", day);
				day.click();
			}
			else
			{
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			
		}
}
}
