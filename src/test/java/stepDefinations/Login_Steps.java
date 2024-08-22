package stepDefinations;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login_Steps extends BaseTest{
	
	LoginPage loginPage;
	Registration_Steps registrationSteps;
	
//	String email = registrationSteps.getEmail();
//	String password = registrationSteps.getPassword();
//	
	@And("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		openBrowser();
		loginPage = new LoginPage(driver);
		loginPage.clickOnSignInButton();
	}
	@When("The user enters email {string} in the login page")
	public void the_user_enters_email_in_the_login_page(String email) {
	    loginPage.enterEmail(email);
	}
	@When("The user enters password {string} in the login page")
	public void the_user_enters_password_in_the_login_page(String password) {
		loginPage.enterPassword(password);
	}
	@When("The user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	    loginPage.clickLogin();
	}
}
