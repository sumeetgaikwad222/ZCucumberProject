package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckboxSelection;

public class Stepdef_checkbox {
	WebDriver driver;
	CheckboxSelection cb;
	@Given("user opens browser")
	public void user_opens_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    cb = new CheckboxSelection(driver);
	}

	@When("user opens the website {string}")
	public void user_opens_the_website(String string) {
	    driver.get(string);
	}

	@When("user selects checkbox {string}")
	public void user_selects_checkbox(String string) {
		cb.perform(string);
	}
}
