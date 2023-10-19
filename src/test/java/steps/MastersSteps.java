package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MastersPage;
import utilities.Driver;

import java.util.List;

public class MastersSteps {
    WebDriver driver;
    MastersPage mastersPage = new MastersPage();
    @Given("login to the home page with valid credentials")
    public void login_to_the_home_page(){
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/");
        driver.manage().window().maximize();

        mastersPage.login.sendKeys("admin@codewise.com");
        mastersPage.password.sendKeys("codewise123");
        mastersPage.signInButton.click();
    }
    @When("navigate to Masters option and click on it")
    public void masters_option(){
        mastersPage.mastersOption.click();
    }
    @And("click on three dots on bottom right of the branch")
    public void three_dots(){
        mastersPage.threeDots.click();
    }
    @And("click on Delete from drop down")
    public void delete_from_dropdown(){
        mastersPage.deleteFromDropdown.click();
    }
    @And("click on Cancel button")
    public void cancel_button(){
        mastersPage.cancelButton.click();
    }
    @Then("verify user was able to cancel deleting a branch from Masters and branch is still in Masters")
    public void cancel_deleting(){
        String expectedEmail = driver.findElement(By.xpath("(//div[.='Email']/following::div[1])[1]")).getText();
        List<WebElement> branchEmail = driver.findElements(By.xpath("//div[.='Email']/following::div[1]"));
        for (WebElement i : branchEmail) {
            if (i.getText().equals(expectedEmail)) {
                String actualEmail = i.getText();
                Assert.assertEquals("deleted", expectedEmail, actualEmail);
            }
        }
    }
    @And("click on Delete red button")
    public void delete_red_button(){
        mastersPage.deleteRedButton.click();
    }
    @Then("verify user was able to delete a branch from Masters")
    public void branch_deleted(){
        String expectedEmail = driver.findElement(By.xpath("(//div[.='Email']/following::div[1])[1]")).getText();
        List<WebElement> branchEmail = driver.findElements(By.xpath("//div[.='Email']/following::div[1]"));
        for (WebElement i : branchEmail) {
            if (i.getText().equals(expectedEmail)) {
                String actualEmail = i.getText();
                Assert.assertEquals("not deleted", expectedEmail, actualEmail);
            }
        }
    }
}
