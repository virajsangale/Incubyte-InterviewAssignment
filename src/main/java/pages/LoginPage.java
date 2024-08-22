package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumUtils;

public class LoginPage {
    WebDriver driver;
    SeleniumUtils utils;

    private By signInButtonField = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButtonField = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    private By loginConfirmFiled = By.xpath("//div[@class='panel header']//span[@class='logged-in']");
    private By signOutDropdownField = By.xpath("//span[@class='customer-name active']//button[@type='button']");
    private By signOutField = By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        utils = new SeleniumUtils(driver, 15);
    }
    
    public void clickOnSignInButton() {
        utils.click(signInButtonField);
    }

    public void enterEmail(String email) {
    	utils.type(emailField, email);
    }

    public void enterPassword(String password) {
    	utils.type(passwordField, password);
    }

    public void clickLogin() {
    	utils.click(loginButtonField);
    }
    
    public void confirmLogin(String firstName, String lastName) {
    	String loginConfirmText = utils.getText(loginConfirmFiled);
    	if(loginConfirmText.contains("Welcome, "+" "+ firstName+" "+ lastName)) {
    		System.out.println("Login Successfully...!");
    	}
    }
    
    public void signOut() {
    	utils.click(signOutDropdownField);
    	utils.click(signOutField);
    }
}
