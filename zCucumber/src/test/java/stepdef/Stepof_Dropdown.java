package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Dropdown;
import utiles.DriverUtiles;

public class Stepof_Dropdown {
	WebDriver driver;
	Dropdown dropdown;

    @Given("user opens url of website {string}")
    public void user_opens_url_of_website(String url) {
driver =     	new ChromeDriver();
        driver.get(url);
        dropdown = new Dropdown(driver);
    }

    @When("user selects a correct dropdown {string}")
    public void user_selects_a_correct_dropdown(String option) {
        dropdown.dropdown(option);
    }
}
