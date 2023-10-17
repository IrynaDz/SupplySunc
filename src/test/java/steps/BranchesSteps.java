package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BranchesPage;
import utilities.ApplicationFlow;
import utilities.Driver;

public class BranchesSteps {
    WebDriver driver;
    Faker faker = new Faker();
    BranchesPage branchesPage= new BranchesPage();
    @Given("navigate to site")
    public void navigate_to_site() {
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/");
        driver.manage().window().maximize();
        ApplicationFlow.pause(2000);
        branchesPage.loginInput.sendKeys("admin@codewise.com");
        branchesPage.passwordInput.sendKeys("codewise123");
                ApplicationFlow.pause(2000);
        branchesPage.signInButton.click();
    }
    @When("navigate to the branches page")
    public void navigate_to_the_branches_page() {
        ApplicationFlow.pause(2000);
        branchesPage.branches.click();
    }
    @When("click on create branch button")
    public void click_on_create_branch_button() {
        ApplicationFlow.pause(2000);
        branchesPage.createBranchButton.click();
    }
    @When("fill all inputs")
    public void fill_all_inputs() {
        branchesPage.branchName.sendKeys(faker.company().name());
        branchesPage.branchEmail.sendKeys(faker.internet().emailAddress());
        branchesPage.branchAddress.sendKeys(faker.address().fullAddress());
        branchesPage.branchPhone.sendKeys("+996589973");
        branchesPage.branchCity.sendKeys(faker.address().city());
        branchesPage.branchRegion.click();
        WebElement inputRegion = driver.findElement(By.xpath("//li[.='Osh city']"));
                inputRegion.click();
        branchesPage.branchCities.click();
        WebElement inputCity = driver.findElement(By.xpath("//li[.='Гулчо']"));
                inputCity.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        branchesPage.selectCompany.click();
        actions.moveToElement(driver.findElement(By.xpath("//li[@role='option']"))).click().perform();
    }
    @When("click on button create branch")
    public void click_on_button_create_branch() {
        branchesPage.createButton.click();
    }
    @Then("verify user create new branch")
    public void verify_user_create_new_branch() {
        branchesPage.verifyNewBranchCreated.click();
        ApplicationFlow.pause(1000);
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[@tabindex='-1']"))).click().perform();
                ApplicationFlow.pause(2000);

    }


}
