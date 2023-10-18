package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ApplicationFlow;
import utilities.Driver;

public class LoginSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/");
        driver.manage().window().maximize();
    }
    @When("the user enters valid username {string}")
    public void the_user_enters_valid_username(String username) {
        loginPage.loginButton.sendKeys(username);
        System.out.println("The user enters username " + username);
    }
    @When("the user enters valid password {string}")
    public void the_user_enters_valid_password(String password) {
        loginPage.passwordButton.sendKeys(password);
        System.out.println("The user enters password " + password);
    }
    @When("the user clicks on signIn button")
    public void the_user_clicks_on_sign_in_button() {
        loginPage.signInButton.click();
    }
    @Then("the user should see the main page")
    public void the_user_should_see_the_main_page(){
        String expectedUrl = "https://supplysync.us/dashboard/companies";
        ApplicationFlow.pause(3000);
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        System.out.println("The user successfully logged in");
    }
    @When("the user enters username {string}")
    public void the_user_enters_username(String username) {
        loginPage.loginButton.sendKeys(username);
        System.out.println("The user enters username " + username);
    }
    @When("the user enters password {string}")
    public void the_user_enters_password(String password) {
        loginPage.passwordButton.sendKeys(password);
        System.out.println("The user enters password " + password);
    }
    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
        String expectedErrorMessage = "Incorrect login and/or password.";
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        System.out.println("The user couldn't login. " + actualErrorMessage);
    }
}
