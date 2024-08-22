Feature: Account Creation

 Scenario Outline: User registers with valid details and SignIn successfully
    Given The user is on the registration page
    When The user fills in the registration form with "<firstName>", "<lastName>", "<email>", "<password>"
    And Submits the form
    Then The user should be redirected to the account dashboard
    And The user quits the browser
    And The user is on the login page
    When The user enters email "<email>" in the login page
    And The user enters password "<password>" in the login page
    And The user clicks on the Login button

    Examples:
    | firstName | lastName | email               | password       |
    | Viraj     | Sangale  | viraj111@example.com  | Password@12345678 |