package basePackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import filesRead.FileRead;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements Constant{
	protected WebDriver driver;
	@BeforeTest
	public void setup(@Optional("chrome") String browser) throws IOException
	{
		FileRead fr = new FileRead();
		String url = fr.readconfig(Config, "url");
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		}
		else if (browser.equals("edge")) {
			System.setProperty(MSEDGEKey, MSEDGEDriverPath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		}
		driver.get(url);
	}

	public void teardown()
	{
		if (driver !=null) {
			driver.quit();
		}
	}
}
