package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.MultipSelect;

public class Stepdef_multiselect {
	WebDriver driver;
	MultipSelect ms;
	@Given("browser setup and initials")
	public void browser_setup_and_initials() {
		driver = new ChromeDriver();
		ms = new MultipSelect(driver);
	}

	@When("user provides baseurl {string}")
	public void user_provides_baseurl(String string)  {
	  driver.get(string);
	}

	@Then("locate and select multiple options {string}")
	public void locate_and_select_multiple_options(String string){
	    ms.multi(string);
	}
}
