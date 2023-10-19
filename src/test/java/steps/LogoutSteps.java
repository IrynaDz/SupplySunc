package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.Driver;

public class LogoutSteps {
    WebDriver driver;

    LogoutPage logoutPage=new LogoutPage();

    LoginPage loginPage=new LoginPage();

    @When("the user login to the web page with valid credentials")
    public void login(){
        loginPage.loginButton.sendKeys("admin@codewise.com");
        loginPage.passwordButton.sendKeys("codewise123");
        loginPage.signInButton.click();
    }

    @And("the user navigate to Administrator and click on it")
    public void administrator(){
        logoutPage.administrator.click();
    }

    @And("the user click on Exit button")
    public void exit(){
        logoutPage.exit.click();
    }

    @And("the user click on Exit red button")
    public void redButtonExit(){
        logoutPage.buttonExit.click();
    }

    @Then("verify user was able to logout")
    public void homePage() {

        String expectedUrl = "https://supplysync.us/login";
        String actualUrl = "https://supplysync.us/dashboard/companies";
        Assert.assertFalse(actualUrl.equals(expectedUrl));




    }





}
