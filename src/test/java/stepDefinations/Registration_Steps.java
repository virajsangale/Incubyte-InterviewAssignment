package stepDefinations;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.CredentialUtils;

public class Registration_Steps extends BaseTest {
	private RegistrationPage registrationPage;
	private LoginPage login;
	
//	private String firstName = CredentialUtils.generateFirstName();
//	private String lastName= CredentialUtils.generateLastName();
//	private String email = CredentialUtils.generateEmail();
//	private String password = CredentialUtils.generatePassword();

	@Given("The user is on the registration page")
	public void the_user_is_on_the_registration_page() {
		openBrowser();
		registrationPage = new RegistrationPage(driver);
		registrationPage.clickCreateNewAccountButton();
	}

	@When("The user fills in the registration form with {string}, {string}, {string}, {string}")
	public void the_user_fills_in_the_registration_form_with(String firstName, String lastName, String email, String password) {
		System.out.println(firstName+" "+ lastName);
		registrationPage.enterFirstName(firstName);
		registrationPage.enterLastName(lastName);
		registrationPage.enterEmail(email);
		registrationPage.enterPassword(password);
		registrationPage.enterConfirmPassword(password);
	}

	@When("Submits the form")
	public void submits_the_form() {
		registrationPage.clickRegister();
	}

	@Then("The user should be redirected to the account dashboard")
	public void the_user_should_be_redirected_to_the_account_dashboard() {
		registrationPage.registrationConfirmation();
	}

	@Then("The user quits the browser")
	public void the_user_signs_out_of_the_application() {
		closeBrowser();
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
}
