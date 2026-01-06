package practice_package;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Class implements Contant_Interfface{
static WebDriver driver;
@BeforeTest
	public void setup() throws IOException
	{
		File_Class FC = new File_Class();
		String browser = FC.readconfig(Config, "browser");
		String URL = FC.readconfig(Config, "url");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 200);");
		}
		else
		{
			Reporter.log("Broswer not found " , true);
		}
	}
	public void screenshot(String methodname) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File loc = new File(ScreenShot + "png");
		Files.copy(src.toPath(), loc.toPath());
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
