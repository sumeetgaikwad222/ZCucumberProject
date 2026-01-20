package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login_page;
public class Stepdefination {
	WebDriver driver;
	Login_page LP ;
	@Given("user lauch a chrome browser")
	public void user_lauch_a_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		LP = new Login_page(driver);
		
	}

	@When("user opens url {string}")
	public void user_opens_url(String string) {
	   driver.get(string);
	}

	@Then("user selects radio button {string}")
	public void user_selects_radio_button(String option) {
	    LP.selectRadio(option);
	}

}
