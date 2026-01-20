package practice_package;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	static WebDriver driver;
	@BeforeMethod
	public void runalways()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}
	@Test
	public void accept(){
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
		driver.switchTo().alert().accept();
	}
	@Test
	public void cancelandOk()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']")).click();
		driver.switchTo().alert().dismiss();
	}
	@Test
	public void inputalert() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("sumeet gaikwad");
		Thread.sleep(5000);
		alert.accept();
	}

}
