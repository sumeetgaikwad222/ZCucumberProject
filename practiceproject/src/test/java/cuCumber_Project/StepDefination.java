package cuCumber_Project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class StepDefination {

    WebDriver driver;
    Pages_Class pages;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            // Add a small wait to see the result before closing
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

    @Given("The customer opening url {string}")
    public void the_customer_opening_url(String url) {
        driver.get(url);
        pages = new Pages_Class(driver);

        // Scroll down 200 pixels after page loads
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");
        
        // Small wait for page to settle
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("customer enter first {string} and {string}")
    public void customer_enter_first_and_last(String firstname, String lastname) {
        pages.FirstName(firstname);
        pages.LName(lastname);
    }

    @When("customet enter {string}")
    public void customet_enter_email(String email) {
        pages.Email(email);
    }

    @When("select gender {string}")
    public void select_gender(String gender) {
        pages.gender(gender);
    }

    @When("customer enter mobile {string}")
    public void customer_enter_mobile(String mobile) {
        pages.getMobilenumber().sendKeys(mobile);
    }

    @When("select DOB {string}")
    public void select_dob(String dob) {
        pages.selectDOB(dob);
    }

    @When("enter subject {string}")
    public void enter_subject(String subject) {
        pages.Subjects(subject);
    }

    @When("user selects hobby {string}")
    public void user_selects_hobby(String hobby) {
        pages.Hobbies(hobby);
        
    }

    @When("Select file {string}")
    public void select_file(String filepath) {
        pages.FileUpload(filepath);
    }

    @When("Enter address {string}")
    public void enter_address(String address) {
        pages.Address(address);
    }

    @When("Select state {string}")
    public void select_state(String state) {
        pages.State(state);
    }

    @When("Select city {string}")
    public void select_city(String city) {
        pages.Cities(city);
    }

    @When("click on submit button")
    public void click_on_submit_button() {
        // Scroll to submit button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", pages.getSubmit());
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        pages.Submitform();
    }
}