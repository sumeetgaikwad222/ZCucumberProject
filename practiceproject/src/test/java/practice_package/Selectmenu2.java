package practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectmenu2 {
	static WebDriver driver;
    static WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void selectAndDeselectMenuItems() {

        // Open dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'mbsc-select')]")
        )).click();

        // ---------- SELECT ----------
        clickOption("Books");
        clickOption("Toys, Kids & Baby");
        clickOption("Clothing & Jewelry");

        // ---------- DESELECT ----------
        clickOption("Toys, Kids & Baby");
        clickOption("Clothing & Jewelry");
    }

    // Reusable click method (industry-safe)
    private void clickOption(String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[normalize-space()='" + optionText + "']")
        )).click();


    }

}
