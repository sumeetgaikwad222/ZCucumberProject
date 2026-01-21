package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadFile {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//a[normalize-space()='File Upload']") private WebElement firstlink;
	@FindBy(xpath = "//input[@id='file-upload']") private WebElement uploadbutton;
	@FindBy(xpath = "(//input[@id='file-submit'])[1]") private WebElement uploadbutton1;
	@FindBy(id = "uploaded-files") private WebElement checkhere;
	public UploadFile(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void perform()
	{
		firstlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(uploadbutton));
		
		uploadbutton.sendKeys("C:\\Users\\SUMEET GAIKWAD\\Downloads\\samplefile.JPEG");
		
		wait.until(ExpectedConditions.elementToBeClickable(uploadbutton1));
		uploadbutton1.click();
		wait.until(driver -> checkhere.isDisplayed());
		Assert.assertTrue(checkhere.isDisplayed(), "Message not displayed, the file not uploaded");
	}
}
