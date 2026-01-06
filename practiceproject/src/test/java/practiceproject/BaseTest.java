package practiceproject;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListeners.class)
public class BaseTest implements Constant{
	public static WebDriver driver;  // ✅ Keep only this
	@BeforeTest
	public void setup() throws IOException
	{
		FLIB_Class FC = new FLIB_Class();
		String browser = FC.readconfig(Config, "browser");
		String url = FC.readconfig(Config, "url");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(ChromeDriverPath, ChromDriverKey);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EXPLICIT_WAIT));
			driver.get(url);
			}
		else
		{
			Reporter.log("Broswer not found", true);
		}
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	public void takescreenshot(String methodname) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File loc = new File(ScreenShot + "png");
		Files.copy(src.toPath(), loc.toPath());
	}
	@Test
	public void failed()
	{
		assertTrue(false);
	}
	
}
