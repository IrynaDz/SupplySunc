package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.JuridicEntityPages;
import utilities.ApplicationFlow;
import utilities.Driver;

import java.util.List;

public class JuridicEntitySteps {
    WebDriver driver;
    Faker faker = new Faker();

    JuridicEntityPages juridicEntityPages = new JuridicEntityPages();


    @Given("Given login to the site")
    public void given_login_to_the_site() {
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/");
        driver.manage().window().maximize();
        ApplicationFlow.pause(2000);

        juridicEntityPages.loginField.sendKeys("admin@codewise.com");
        juridicEntityPages.passwordField.sendKeys("codewise123");
        ApplicationFlow.pause(2000);
        juridicEntityPages.signInButton.click();
    }

    @When("navigate to the Juridic Entity page")
    public void navigate_to_the_juridic_entity_page() {
        ApplicationFlow.pause(2000);
        juridicEntityPages.juridicEntityLink.click();
    }

    @When("click on create Legal Entity")
    public void click_on_create_legal_entity() {
        ApplicationFlow.pause(2000);
        Actions actions = new Actions(driver);
        ApplicationFlow.pause(2000);
        actions.moveToElement(juridicEntityPages.createLegalEntityButton).click().perform();
    }
    @When("fill out all fields in box")
    public void fill_out_all_fields_in_box() {

        ApplicationFlow.pause(2000);
        juridicEntityPages.companiesField.click();
        ApplicationFlow.pause(2000);

        juridicEntityPages.branchField.click();

        WebElement companiesFieldChild = driver.findElement(By.xpath("//li[@data-value='1'][1]"));
        companiesFieldChild.click();

        ApplicationFlow.pause(2000);
        juridicEntityPages.branchFieldParent.click();
        juridicEntityPages.branchFieldChild.click();

        ApplicationFlow.pause(2000);
        juridicEntityPages.legalEtnityField.sendKeys("Nurlan");

    }

    @When("click on button create Legal Entity")
    public void click_on_button_create_Legal_Entity() {
        juridicEntityPages.clickButton.click();
    }

    @Then("verify user create new Legal Entity")
    public void verify_user_create_new_legal_entity() {
        ApplicationFlow.pause(2000);
        List<WebElement> legalEntityNames = driver.findElements(By.xpath("//div[.='Legal entity name']/following::div[1]"));
        for (WebElement name: legalEntityNames){
            String createdName = name.getText().toString();
            Assert.assertEquals("No such legal entity", "Nurlan", createdName);
            System.out.println("Actual name:" + createdName);

        }
    }

}

