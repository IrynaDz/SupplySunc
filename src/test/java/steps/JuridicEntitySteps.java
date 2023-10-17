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

    JuridicEntityPages juridicEntityPages=new JuridicEntityPages();


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
        WebElement createLegalEntity = driver.findElement(By.xpath("//button[@class='sc-ikJyIC idrUqC MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-gsNilK hofTdo sc-dFtzxp khbchy sc-cTAIfT dANijJ']"));
        ApplicationFlow.pause(2000);
        actions.moveToElement(createLegalEntity).click().perform();
    }
    @When("fill out all fields in box")
    public void fill_out_all_fields_in_box() {

        ApplicationFlow.pause(2000);
        WebElement companiesFieldParent = driver.findElement(By.id("mui-component-select-companyId"));
        companiesFieldParent.click();
        ApplicationFlow.pause(2000);
        WebElement companiesFieldChild = driver.findElement(By.xpath("//li[.='Steuber-Hirthe']"));
        companiesFieldChild.click();


        ApplicationFlow.pause(2000);
        WebElement branchFieldParent = driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[2]"));
        branchFieldParent.click();
        WebElement branchFieldChild = driver.findElement(By.xpath("//div[@id='menu-branchId']//li[4]"));
        branchFieldChild.click();

        ApplicationFlow.pause(2000);
        WebElement legalEtnityField = driver.findElement(By.xpath("//input[@name='juridicalCompanyName']"));
        legalEtnityField.sendKeys("Nurlan");


    }

    @When("click on button create Legal Entity")
    public void click_on_button_create_Legal_Entity() {
        WebElement clickButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
    }

    @Then("verify user create new Legal Entity")
    public void verify_user_create_new_legal_entity() {
        List<WebElement> legalEntityNames = driver.findElements(By.xpath("//div[.='Legal entity name']/following::div[1]"));
        for (WebElement name: legalEntityNames){
            String createdName = name.getText().toString();
            Assert.assertEquals("No such legal entity", "Nurlan", createdName);
            System.out.println("Actual name:" + createdName);

        }
    }

}

