package tests.AutomationPOM;

import com.github.javafaker.Faker;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ApplicationFlow;
import utilities.Driver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SupplySyncTest {
    SupplySyncPOM supplySyncPOM;
    WebDriver driver;
    @BeforeClass
    public void begining() {
        driver = Driver.getDriver();
        supplySyncPOM = new SupplySyncPOM();
        driver.get("https://supplysync.us/");
        driver.manage().window().maximize();
        ApplicationFlow.pause(3000);

        supplySyncPOM.loginField.sendKeys("admin@codewise.com");
        supplySyncPOM.passwordField.sendKeys("codewise123");
        ApplicationFlow.pause(3000);
        supplySyncPOM.signInButton.click();
    }
    @Test
    public void HappyPathTest1(){
        Faker faker = new Faker();
        ApplicationFlow.pause(3000);
        supplySyncPOM.companies.click();

        supplySyncPOM.dots.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(supplySyncPOM.edit).click().perform();

        String compName = faker.company().name();
        supplySyncPOM.companyName.sendKeys(Keys.COMMAND+"a");
        ApplicationFlow.pause(3000);
        supplySyncPOM.companyName.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.companyName.sendKeys(compName);

        String compEmail = faker.internet().emailAddress();
        supplySyncPOM.email.sendKeys(Keys.COMMAND+"a");
        supplySyncPOM.email.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.email.sendKeys(compEmail);

        String compAddress = faker.address().fullAddress();
        supplySyncPOM.address.sendKeys(Keys.COMMAND+"a");
        supplySyncPOM.address.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.address.sendKeys(compAddress);

        supplySyncPOM.phoneNumber.getText();
        String compPhoneNumber = faker.phoneNumber().cellPhone();
        supplySyncPOM.phoneNumber.sendKeys(Keys.COMMAND+"a");
        supplySyncPOM.phoneNumber.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.phoneNumber.sendKeys(compPhoneNumber);

        ApplicationFlow.pause(3000);

        supplySyncPOM.saveButton.click();

        Assert.assertNotEquals(supplySyncPOM.phoneNumber,compPhoneNumber);
    }
    @Test
    public void EmptyCompanyNameFieldTest2() {
        supplySyncPOM.companies.click();

        supplySyncPOM.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(supplySyncPOM.edit).click().perform();

        ApplicationFlow.pause(3000);
        supplySyncPOM.companyName.sendKeys(Keys.COMMAND + "a");
        supplySyncPOM.companyName.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.saveButton.click();

        if (supplySyncPOM.saveButton.isEnabled()) {
            supplySyncPOM.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Test
    public void emptyEmeilFieldTest3(){
        supplySyncPOM.companies.click();

        supplySyncPOM.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(supplySyncPOM.edit).click().perform();

        ApplicationFlow.pause(3000);
        supplySyncPOM.email.sendKeys(Keys.COMMAND + "a");
        supplySyncPOM.email.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.saveButton.click();

        if (supplySyncPOM.saveButton.isEnabled()){
            supplySyncPOM.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Test
    public void emptyAddressFieldTest4(){
        supplySyncPOM.companies.click();

        supplySyncPOM.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(supplySyncPOM.edit).click().perform();

        ApplicationFlow.pause(3000);
        supplySyncPOM.address.sendKeys(Keys.COMMAND + "a");
        supplySyncPOM.address.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.saveButton.click();

        if (supplySyncPOM.saveButton.isEnabled()){
            supplySyncPOM.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Test
    public void emptyPhoneNumberFieldTest5(){
        supplySyncPOM.companies.click();

        supplySyncPOM.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(supplySyncPOM.edit).click().perform();

        ApplicationFlow.pause(3000);
        supplySyncPOM.phoneNumber.sendKeys(Keys.COMMAND + "a");
        supplySyncPOM.phoneNumber.sendKeys(Keys.BACK_SPACE);
        supplySyncPOM.saveButton.click();

        if (supplySyncPOM.saveButton.isEnabled()){
            supplySyncPOM.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @AfterClass
    public void close(){
        Driver.closeDriver();
    }
}
