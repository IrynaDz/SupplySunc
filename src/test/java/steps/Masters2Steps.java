package steps;

import com.github.javafaker.App;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MastersPage2;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import java.util.Random;

public class Masters2Steps {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    MastersPage2 mastersPage2 = new MastersPage2();
    Faker faker = new Faker();
    Random random = new Random();
    @Given("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("supplySyncUrl"));
        driver.manage().window().maximize();
    }
    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.loginButton.sendKeys(Config.getProperty("email"));
        loginPage.passwordButton.sendKeys(Config.getProperty("password"));
        loginPage.signInButton.click();
    }
    @Then("user clicks on masters")
    public void user_clicks_on_masters() {
        mastersPage2.mastersButton.click();

    }
    @Then("user clicks on create master button")
    public void user_clicks_on_create_master_button() {
        ApplicationFlow.pause(2000);
        mastersPage2.createMasterButton.click();
    }
    @Then("user fill out all fields")
    public void user_fill_out_all_fields() {
        mastersPage2.nameInput.sendKeys(faker.name().firstName());
        mastersPage2.lastNameInput.sendKeys(faker.name().lastName());
        mastersPage2.emailInput.sendKeys(faker.internet().emailAddress());
        mastersPage2.passwordInput.sendKeys(faker.internet().password());
        mastersPage2.placeOfResidence.sendKeys(faker.country().name());
        mastersPage2.phoneNumber.sendKeys(faker.phoneNumber().subscriberNumber(9));

    }
    @When("user chooses branch")
    public void user_chooses_branch() {
        ApplicationFlow.pause(3000);
        mastersPage2.branchInput.click();
        mastersPage2.listOfOptions.get(random.nextInt(mastersPage2.listOfOptions.size())).click();
    }
    @When("user clicks on create button")
    public void user_clicks_on_create_button() {
        ApplicationFlow.pause(3000);
        mastersPage2.createButton.click();
    }
    @Then("verify created master exists and user sees positive message")
    public void verify_created_master_exists_and_user_sees_positive_message() {
        ApplicationFlow.pause(2000);
        Assert.assertEquals("Wrong message", "Master added successfully", mastersPage2.positiveMessage.getText());
        Assert.assertEquals("Wrong Url", mastersPage2.UrlAfterCreatingMaster, driver.getCurrentUrl());
    }

    @When("user fills out {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_fills_out(String name, String lastName, String email, String password, String placeOfResidence, String phoneNumber) {
        mastersPage2.nameInput.sendKeys(name);
        mastersPage2.lastNameInput.sendKeys(lastName);
        mastersPage2.emailInput.sendKeys(email);
        mastersPage2.passwordInput.sendKeys(password);
        mastersPage2.placeOfResidence.sendKeys(placeOfResidence);
        mastersPage2.phoneNumber.sendKeys(phoneNumber);

    }

    @Then("verify user can't see the page with created masters")
    public void verify_user_can_t_see_the_page_with_created_masters() {
        ApplicationFlow.pause(3000);
        Assert.assertEquals("Some Error", mastersPage2.UrlBeforeCreatingMaster, driver.getCurrentUrl());
    }

}
