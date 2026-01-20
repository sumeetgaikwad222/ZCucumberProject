package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Accordion {
static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Accordion.html");
		driver.findElement(By.xpath("//b[normalize-space()='Collapsible Group 1 - Readability']")).click();
		driver.findElement(By.partialLinkText("Collapsible Group 2 - Single Line Coding")).click();
		driver.findElement(By.xpath("//div[@class='panel-heading']//a//b[text()='Collapsible Group 3 - Methhod Chaining']")).click();
	}
}
