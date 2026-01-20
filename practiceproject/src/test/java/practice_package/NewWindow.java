package practice_package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {
	WebDriver driver;
	 WebDriverWait wait;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    @Test
	    public void perform1()
	    {
	    	WebElement button=  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[normalize-space()='New Tab']"))));
	    	button.click();
	    	WebElement newwindow = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
	    	if (newwindow.getText().contains("Sample New Tab")) {
	    		Assert.assertTrue(true);
			}
	    	else
	    	{
	    		Assert.assertFalse(false);
	    	}
	    	System.out.print(newwindow.getText());
	    }
	    @Test
	    public void perfor2() throws IOException {

	        String defaultWindow = driver.getWindowHandle();

	        WebElement check = driver.findElement(
	            By.xpath("//button[normalize-space()='New Window']")
	        );
	        check.click();

	        Set<String> allWindows = driver.getWindowHandles();

	        for (String handle : allWindows) {
	            if (!handle.equals(defaultWindow)) {

	                driver.switchTo().window(handle);

	                // ✅ TAKE screenshot correctly
	                TakesScreenshot scr = (TakesScreenshot)driver;
	                File stc = scr.getScreenshotAs(OutputType.FILE);

	                File dest = new File("./data/Screenshot/visible.png");
	                dest.getParentFile().mkdirs();   // ✅ ensure folder exists
	                Files.copy(stc, dest);

	                break;  // ✅ stop after switching
	            }
	        }
	        
	    }
	    @Test
	    public void perform3()
	    {
	    	String defaultwindow = driver.getWindowHandle();
	    	driver.findElement(By.xpath("//button[normalize-space()='New Window Message']")).click();
	    	Set<String> allwindows = driver.getWindowHandles();
	    	for(String handle : allwindows)
	    	{
	    		if (!handle.equals(defaultwindow)) {
					driver.switchTo().window(handle);
					Assert.assertEquals(driver.getWindowHandles().size(), 2);
				}
	    	}
	    }
}
