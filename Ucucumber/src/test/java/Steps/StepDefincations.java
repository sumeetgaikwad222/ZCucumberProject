package Steps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Pages.LogInForm;
import io.cucumber.java.en.*;
import utiles.DriverFactory;
import utiles.JavaScriptUtiles;

public class StepDefincations {
	
	WebDriver driver;
	LogInForm LG;
	@Given("The customer provided url {string}")
	public void the_customer_provided_url(String url) {
		driver = DriverFactory.getbrowser();
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    LG = new LogInForm(driver);
	}

	@When("customer enter an first {string} and the {string}")
	public void customer_enter_an_first_and_the(String Firstnames, String Lastnames) {
	    LG.FirstName(Firstnames);
	    LG.LastName(Lastnames);
	}

	@When("customet enter an {string}")
	public void customet_enter_an(String Emails) {
	    LG.Email(Emails);
	}

	@When("select gender a {string}")
	public void select_gender_a(String Genders) {
	    LG.Gender(Genders);
	}

	@When("customer enter mobile an{string}")
	public void customer_enter_mobile_an(String mobileNumber) {
	    LG.MobileNumber(mobileNumber);
	}

	@When("select DOB the {string}")
	public void select_dob_the(String DateoB) {
	    LG.Date_Of_Birth(DateoB);
	}

	@When("enter subject the {string}")
	public void enter_subject_the(String SUBJECT) {
	    LG.SubjectS(SUBJECT);
	}

	@When("user selects hobby a{string}")
	public void user_selects_hobby_a_sports(String HOBBIES) {
	    LG.Hobbies(HOBBIES);
	}

	@When("Select filepath {string}")
	public void select_filepath(String IMAGES) {
	    LG.upload_file(IMAGES);
	}

	@When("Enter current address {string}")
	public void enter_current_address(String CURRENTADDRESS) {
	    LG.Curraddreess(CURRENTADDRESS);
	}

	@When("Select current state {string}")
	public void select_current_state(String STATES) {
	    LG.States(STATES);
	}

	@When("Select current city {string}")
	public void select_current_city(String CITIES) {
	    LG.Cities(CITIES);
	}

	@When("click on the submit button")
	public void click_on_the_submit_button() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    LG.Submit();
	}

}
