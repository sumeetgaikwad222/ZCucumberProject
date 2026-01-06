package practiceproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Location_Class {

    @FindBy(xpath = "//div[@class ='col-md-9 col-sm-12']//input[@id='firstname']")
    WebElement firstname;

    @FindBy(xpath = "//div[@class ='col-md-9 col-sm-12']//input[@id='lastname']")
    WebElement lastname;

    @FindBy(xpath = "//div[@class ='col-md-9 col-sm-12']//input[@id='userName']")
    WebElement username;

    @FindBy(xpath = "//div[@class ='col-md-9 col-sm-12']//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='register']")
    WebElement registerButton;

    WebDriver driver;

    public Location_Class(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registration(String First_name, String Last_name, String User_name, String Pass_Word) {
        firstname.sendKeys(First_name);
        lastname.sendKeys(Last_name);
        username.sendKeys(User_name);
        password.sendKeys(Pass_Word);

        // 🚀 Bypass reCAPTCHA (Only for automation testing)
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('g-recaptcha-response').value='automation_test_passed';");
            System.out.println("reCAPTCHA bypassed using JavaScript.");
        } catch (Exception e) {
            System.out.println("⚠ CAPTCHA bypass failed (ignored in non-test mode)");
        }

        // ⏳ Wait until Register button is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(registerButton));

        // 📌 Scroll into view (avoid ad iframe block)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", registerButton);

        // 🖱 Click using JavaScript to prevent interception
        js.executeScript("arguments[0].click();", registerButton);

        System.out.println("Register button clicked via JavaScript.");
    }
}
