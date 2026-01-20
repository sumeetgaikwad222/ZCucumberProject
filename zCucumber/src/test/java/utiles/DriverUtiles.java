package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtiles {
	public static WebDriver driver;
@Before
	public void setup() throws IOException
	{
		FileInputStream FIS = new FileInputStream("src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(FIS);
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	@After
	public void teardown()
	{
		if (driver != null) {
			driver.quit();
		}
	}
}
