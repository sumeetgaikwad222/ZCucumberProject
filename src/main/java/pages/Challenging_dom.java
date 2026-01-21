package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenging_dom {
	@FindBy(xpath = "//a[normalize-space()='Challenging DOM']") private WebElement firstlink;
	private WebDriver driver;
	private WebDriverWait wait;

	public WebElement getFirstlink() {
		return firstlink;
	}

	public Challenging_dom(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void perform()
	{
		firstlink.click();
		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='large-2 columns']//a"));
		for (int i = 1; i <=buttons.size(); i++) {
			WebElement button = driver.findElement(By.xpath("//div[@class='large-2 columns']//a['"+i+"']"));
			wait.until(driver -> button.isDisplayed());
			String text = button.getText();
			System.out.println(text);
			break;
		}
	}
}
