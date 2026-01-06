package practice_package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Class {
	@FindBy(xpath = "//input[@id='userName']") private WebElement fullname;
	@FindBy(xpath = "//input[@id='userEmail']") private WebElement email;
	@FindBy(xpath = "//textarea[@id='currentAddress']") private WebElement currentaddress;
	@FindBy(xpath = "//textarea[@id='permanentAddress']") private WebElement permantadd;
	@FindBy(xpath = "//button[@id='submit']") private WebElement submitbutton;
	public WebElement getFullname() {
		return fullname;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getCurrentaddress() {
		return currentaddress;
	}
	public WebElement getPermantadd() {
		return permantadd;
	}
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	public Page_Class(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void name(String name)
	{
		fullname.sendKeys(name);
	}
	public void email(String email)
	{
		this.email.sendKeys(email);
	}
	public void curraddress(String curraddress)
	{
		currentaddress.sendKeys(curraddress);
	}
	public void peradd(String peradd)
	{
		permantadd.sendKeys(peradd);
	}
	public void submit()
	{
		submitbutton.click();
	}
}
