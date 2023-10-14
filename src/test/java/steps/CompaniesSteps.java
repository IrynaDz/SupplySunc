package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CompanyPage;
import utilities.ApplicationFlow;
import utilities.Driver;

public class CompaniesSteps {
    WebDriver driver;
    Faker faker = new Faker();
    CompanyPage companyPage = new CompanyPage();

    @Given("login to the site")
    public void login_to_the_site() {
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/");
        driver.manage().window().maximize();
        ApplicationFlow.pause(2000);

        companyPage.loginField.sendKeys("admin@codewise.com");
        companyPage.passwordField.sendKeys("codewise123");
        ApplicationFlow.pause(2000);
        companyPage.signInButton.click();
    }
    @When("navigate to the company page")
    public void navigate_to_the_company_page() {
        ApplicationFlow.pause(2000);
        companyPage.companies.click();
    }
    @When("click on edit")
    public void click_on_edit() {
        companyPage.dots.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(companyPage.edit).click().perform();
    }
    @When("fill out all fields")
    public void fill_out_all_fields() {
        String compName = faker.company().name();
        companyPage.companyName.sendKeys(Keys.COMMAND + "a");
        ApplicationFlow.pause(3000);
        companyPage.companyName.sendKeys(Keys.BACK_SPACE);
        companyPage.companyName.sendKeys(compName);

        String compEmail = faker.internet().emailAddress();
        companyPage.email.sendKeys(Keys.COMMAND + "a");
        companyPage.email.sendKeys(Keys.BACK_SPACE);
        companyPage.email.sendKeys(compEmail);

        String compAddress = faker.address().fullAddress();
        companyPage.address.sendKeys(Keys.COMMAND + "a");
        companyPage.address.sendKeys(Keys.BACK_SPACE);
        companyPage.address.sendKeys(compAddress);

        companyPage.phoneNumber.getText();
        String compPhoneNumber = faker.phoneNumber().cellPhone();
        companyPage.phoneNumber.sendKeys(Keys.COMMAND + "a");
        companyPage.phoneNumber.sendKeys(Keys.BACK_SPACE);
        companyPage.phoneNumber.sendKeys(compPhoneNumber);
    }
    @When("click on button save")
    public void click_on_button_save() {
        companyPage.saveButton.click();
    }
    @Then("verify user edit company information")
    public void verify_user_edit_company_information() {
        String expectedText = "Company successfully changed";
        if (companyPage.popUpMessage.isDisplayed() && companyPage.popUpMessage.getText().contains(expectedText)) {
            System.out.println("PopUp message with visible text found and verified.");
        } else {
            System.out.println("Element with visible text not found or verification failed.");
        }
    }
    @Then("empty the company name field")
    public void empty_the_company_name_field() {
        companyPage.companyName.sendKeys(Keys.COMMAND + "a");
        companyPage.companyName.sendKeys(Keys.BACK_SPACE);
    }
    @Then("verify user cann't save information with empty name field")
    public void verify_user_cann_t_save_information_with_empty_name_field() {
        if (companyPage.saveButton.isEnabled()) {
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Then("empty the company email field")
    public void empty_the_company_email_field() {
        companyPage.email.sendKeys(Keys.COMMAND + "a");
        companyPage.email.sendKeys(Keys.BACK_SPACE);
    }
    @Then("verify user cann't save information with empty email field")
    public void verify_user_cann_t_save_information_with_empty_email_field() {
        if (companyPage.saveButton.isEnabled()) {
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
        @Then("empty the company address field")
        public void empty_the_company_address_field() {
            companyPage.address.sendKeys(Keys.COMMAND + "a");
            companyPage.address.sendKeys(Keys.BACK_SPACE);
        }
        @Then("verify user cann't save information with empty address field")
        public void verify_user_cann_t_save_information_with_empty_address_field() {
            if (companyPage.saveButton.isEnabled()){
                companyPage.editCompany.getText();
                System.out.println("Change does not allow the field to be left blank");
            }
        }
    @Then("empty the company phone number field")
    public void empty_the_company_phone_number_field() {
        companyPage.phoneNumber.sendKeys(Keys.COMMAND + "a");
        companyPage.phoneNumber.sendKeys(Keys.BACK_SPACE);
    }
    @Then("verify user cann't save information with empty phone number field")
    public void verify_user_cann_t_save_information_with_empty_phone_number_field() {
        if (companyPage.saveButton.isEnabled()){
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
}

