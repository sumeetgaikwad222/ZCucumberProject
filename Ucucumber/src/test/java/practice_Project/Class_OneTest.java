package practice_Project;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class_OneTest {
	WebDriver driver;
	WebDriverWait driver1;

	@Test
	public void setup() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/upload-download");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File loc = new File("C:\\Users\\SUMEET GAIKWAD\\eclipse-workspace\\practiceproject\\data\\image3.png");
		Files.copy(src.toPath(), loc.toPath());
		Thread.sleep(4000);
		driver.quit();
	}
}
