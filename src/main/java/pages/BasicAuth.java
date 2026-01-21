package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicAuth {
	@FindBy(xpath = "//a[normalize-space()='Basic Auth']") private WebElement firstlink;
	
	private WebDriver driver;
	private WebDriverWait wait;
	public BasicAuth(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void perform() throws AWTException, InterruptedException {
        // Click on the link that triggers auth popup
        firstlink.click();
        
        // Wait for 2 seconds for popup to appear
        Thread.sleep(2000);
        
        // Create Robot instance
        Robot rb = new Robot();
        
        // Type username (example: "SU" or your username)
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        Thread.sleep(100);
        
        rb.keyPress(KeyEvent.VK_U);
        rb.keyRelease(KeyEvent.VK_U);
        Thread.sleep(100);
        
        // Press TAB to move to password field
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(100);
        
        // Type password (example: "SU" or your password)
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        Thread.sleep(100);
        
        rb.keyPress(KeyEvent.VK_U);
        rb.keyRelease(KeyEvent.VK_U);
        Thread.sleep(100);
        
        // Press ENTER to submit
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        
        // Wait for page to load after authentication
        Thread.sleep(2000);
    }
    
}
