package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class RegistrationPage {
	private WebDriver driver;
	SeleniumUtils utils;
	
	private By createNewAccountButton = By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By registerButton = By.xpath("//button[@title = 'Create an Account']");
    private By myAccountField = By.xpath("//span[text()='My Account']");
    

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        utils = new SeleniumUtils(driver, 10);
    }
    public void clickCreateNewAccountButton() {
        utils.click(createNewAccountButton);
    }
    
    public void enterFirstName(String firstName) {
    	utils.type(firstNameField, firstName);
    }
    
    public void enterLastName(String lastName) {
    	utils.type(lastNameField, lastName);
    }
    
    public void enterEmail(String email) {
    	utils.type(emailField, email);
    }

    public void enterPassword(String password) {
    	utils.type(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
    	utils.type(confirmPasswordField, confirmPassword);
    }

    public void clickRegister() {
    	utils.click(registerButton);
    }
    
    public void registrationConfirmation() {
    	boolean flag = utils.isDisplayed(myAccountField);
    	if(flag) {
    		System.out.println("Registration is successful!");
    	}
    }
}
