package Pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInForm {
	 WebDriver driver;
	@FindBy(xpath = "//input[@id='firstName']") private WebElement firstname;
	@FindBy(xpath = "//input[@id='lastName']") private WebElement lastname;
	@FindBy(xpath = "//input[@id='userEmail']") private WebElement email;
	@FindBy(xpath = "//input[@id='userNumber']") private WebElement mobilenumber;
	@FindBy(xpath = "//input[@id='dateOfBirthInput']") private WebElement dob;
	@FindBy(id = "subjectsInput") private WebElement subject;
	@FindBy(xpath = "//input[@id='uploadPicture']") private WebElement fileupload;
	@FindBy(xpath = "//textarea[@id='currentAddress']") private WebElement currentaddress;
	@FindBy(id = "state") private WebElement state;
	@FindBy(id = "city") private WebElement city;
	@FindBy(xpath = "//button[@id='submit']") private WebElement submit;
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getMobilenumber() {
		return mobilenumber;
	}
	public WebElement getDob() {
		return dob;
	}
	public WebElement getFileupload() {
		return fileupload;
	}
	public WebElement getCurrentaddress() {
		return currentaddress;
	}
	public WebElement getState() {
		return state;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public LogInForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void FirstName(String Firstname)
	{
		firstname.sendKeys(Firstname);
	}
	public void LastName(String Lastname)
	{
		lastname.sendKeys(Lastname);
	}
	public void Email(String Uemail)
	{
		email.sendKeys(Uemail);
	}
	public void Gender(String Ugender) {

	    WebElement gender = driver.findElement(By.xpath("//input[@name='gender' and @value='" + Ugender + "']/following-sibling::label"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);
	}
	public void MobileNumber(String Mobnumber) {
		mobilenumber.sendKeys(Mobnumber);
	}
	public void Date_Of_Birth(String Dataofbirth)
	{
		dob.click();
		dob.sendKeys(Keys.CONTROL+"a");
		dob.sendKeys(Dataofbirth);
		dob.sendKeys(Keys.ENTER);
	}
	public void SubjectS(String subjectName) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.getElementById('subjectsInput').scrollIntoView(true);");

	    WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
	    subjectInput.sendKeys(subjectName);
	    subjectInput.sendKeys(Keys.ENTER);
	}

	public void Hobbies(String hobby) {

	    String hobbyID = "";

	    switch (hobby.toLowerCase()) {
	        case "sports":
	            hobbyID = "hobbies-checkbox-1";
	            break;
	        case "reading":
	            hobbyID = "hobbies-checkbox-2";
	            break;
	        case "music":
	            hobbyID = "hobbies-checkbox-3";
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid hobby: " + hobby);
	    }

	    WebElement hobbyElement = driver.findElement(
	            By.xpath("//input[@id='" + hobbyID + "']/following-sibling::label"));

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView(true);", hobbyElement);

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();", hobbyElement);
	}

	public void upload_file(String File)
	{
		fileupload.sendKeys(File);
	}
	public void Curraddreess(String curradd)
	{
		currentaddress.sendKeys(curradd);
	}
	public void States(String stateName) {

	    WebElement stateInput = driver.findElement(By.id("react-select-3-input"));

	    stateInput.sendKeys(stateName);
	    stateInput.sendKeys(Keys.ENTER);
	}

	public void Cities(String cityName) {

	    WebElement cityInput = driver.findElement(By.id("react-select-4-input"));

	    cityInput.sendKeys(cityName);
	    cityInput.sendKeys(Keys.ENTER);
	}

	public void Submit()
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200);");
		submit.click();
	}
}
