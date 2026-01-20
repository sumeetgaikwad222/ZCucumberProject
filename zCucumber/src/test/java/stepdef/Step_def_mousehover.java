package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.Mouse_Hover;

public class Step_def_mousehover {
	
	WebDriver driver;
	Mouse_Hover hover;
	@Given(": Setup browser")
	public void setup_browser() {
		driver = new ChromeDriver();
		hover = new Mouse_Hover(driver);
	}
	
	@When(": customer provided url {string}")
	public void customer_provided_url(String string) {
	   driver.get(string);
	}

	@Then(": find the button and hover on it")
	public void find_the_button_and_hover_on_it() {
	   hover.action();
	}

}
