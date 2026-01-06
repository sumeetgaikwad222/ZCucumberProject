package cuCumber_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages_Class {
    WebDriver driver;
    
    @FindBy(xpath = "//input[@id='firstName']") private WebElement firstname;
    @FindBy(xpath = "//input[@id='lastName']") private WebElement lastname;
    @FindBy(xpath = "//input[@id='userEmail']") private WebElement email;
    @FindBy(xpath = "//input[@id='userNumber']") private WebElement mobilenumber;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']") private WebElement dobfield;
    @FindBy(id = "subjectsInput") private WebElement subject;
    @FindBy(xpath = "//input[@id='uploadPicture']") private WebElement file;
    @FindBy(xpath = "//textarea[@id='currentAddress']") private WebElement currentaddress;
    @FindBy(id = "state") private WebElement states;
    @FindBy(id = "city") private WebElement cities;
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
    
    public WebElement getDobfield() {
        return dobfield;
    }
    
    public WebElement getSubject() {
        return subject;
    }
    
    public WebElement getFile() {
        return file;
    }
    
    public WebElement getCurrentaddress() {
        return currentaddress;
    }
    
    public WebElement getStates() {
        return states;
    }
    
    public WebElement getCities() {
        return cities;
    }
    
    public WebElement getSubmit() {
        return submit;
    }
    
    public Pages_Class(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void FirstName(String name) {
        firstname.sendKeys(name);
    }
    
    public void LName(String Lastname) {
        lastname.sendKeys(Lastname);
    }
    
    public void Email(String emailText) {
        this.email.sendKeys(emailText);
    }
    public void Mobile_Number(String mobnumber)
    {
    	mobilenumber.sendKeys(mobnumber);
    }
    public void gender(String gender) {
        driver.findElement(By.xpath("//input[@name='gender' and @value='" + gender + "']/following-sibling::label")).click();
    }
    
    public void selectDOB(String DOB) {
        dobfield.click();
        dobfield.sendKeys(Keys.CONTROL + "a");
        dobfield.sendKeys(DOB);
        dobfield.sendKeys(Keys.ENTER);
    }
    
    public void Subjects(String Subjects) {
        subject.sendKeys(Subjects);
        subject.sendKeys(Keys.ENTER);
    }
    
    public void Hobbies(String hobbie) {
        String hobbyId = "";
        switch(hobbie.toLowerCase()) {
            case "sports":
                hobbyId = "hobbies-checkbox-1";
                break;
            case "reading":
                hobbyId = "hobbies-checkbox-2";
                break;
            case "music":
                hobbyId = "hobbies-checkbox-3";
                break;
            default:
                throw new IllegalArgumentException("Invalid hobby: " + hobbie);
        }
        driver.findElement(By.xpath("//input[@id='" + hobbyId + "']/following-sibling::label")).click();
    }
    
    public void FileUpload(String filepath) {
        file.sendKeys(filepath);
    }
    
    public void Address(String add) {
        currentaddress.sendKeys(add);
    }
    
    public void State(String state) {
        states.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[contains(@id,'react-select') and text()='" + state + "']")).click();
    }
    
    public void Cities(String city) {
        cities.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[contains(@id,'react-select') and text()='" + city + "']")).click();
    }
    
    public void Submitform() {
        submit.click();
    }
}