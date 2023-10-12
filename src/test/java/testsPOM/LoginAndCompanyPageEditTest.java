package testsPOM;

import com.github.javafaker.Faker;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pagesPOM.CompanyPage;
import pagesPOM.LoginPage;
import pagesPOM.MainPage;
import utilities.ApplicationFlow;
import utilities.Driver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginAndCompanyPageEditTest {
    LoginPage loginPage;
    MainPage mainPage;

    CompanyPage companyPage;
    WebDriver driver;
    @Before
    public void setup(){
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        companyPage = new CompanyPage();
        driver.get(loginPage.loginUrl);
    }

    @Test
    public void a_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithInvalidUsername();
        mainPage.verifyErrorMessage();
        Thread.sleep(2000);
    }


    @Test
    public void b_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithInvalidPassword();
        mainPage.verifyErrorMessage();
        Thread.sleep(2000);
    }

    @Test
    public void c_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithDifferentDomain();
        mainPage.verifyErrorMessage();
        Thread.sleep(2000);
    }

    @Test
    public void d_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithAllUpperCase();
        mainPage.verifyErrorMessage();
        Thread.sleep(2000);
    }


    @Test
    public void e_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithEmptyCredentials();
        mainPage.verifyErrorMessage();
        Thread.sleep(2000);
    }


    @Test
    public void f_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithoutAtSign();
        mainPage.verifyErrorMessage();
        Thread.sleep(2000);
    }

    @Test
    public void g_testLoginFunctionality() throws InterruptedException {
        loginPage.loginWithValidCredentials();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }

    @Test
    public void h_HappyPathTest1(){
        Faker faker = new Faker();
        ApplicationFlow.pause(3000);
        companyPage.companies.click();

        companyPage.dots.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(companyPage.edit).click().perform();

        String compName = faker.company().name();
        companyPage.companyName.sendKeys(Keys.COMMAND+"a");
        ApplicationFlow.pause(3000);
        companyPage.companyName.sendKeys(Keys.BACK_SPACE);
        companyPage.companyName.sendKeys(compName);

        String compEmail = faker.internet().emailAddress();
        companyPage.email.sendKeys(Keys.COMMAND+"a");
        companyPage.email.sendKeys(Keys.BACK_SPACE);
        companyPage.email.sendKeys(compEmail);

        String compAddress = faker.address().fullAddress();
        companyPage.address.sendKeys(Keys.COMMAND+"a");
        companyPage.address.sendKeys(Keys.BACK_SPACE);
        companyPage.address.sendKeys(compAddress);

        companyPage.phoneNumber.getText();
        String compPhoneNumber = faker.phoneNumber().cellPhone();
        companyPage.phoneNumber.sendKeys(Keys.COMMAND+"a");
        companyPage.phoneNumber.sendKeys(Keys.BACK_SPACE);
        companyPage.phoneNumber.sendKeys(compPhoneNumber);

        ApplicationFlow.pause(3000);

        companyPage.saveButton.click();

        Assert.assertNotEquals(companyPage.phoneNumber,compPhoneNumber);

    }
    @Test
    public void i_EmptyCompanyNameFieldTest2() {
        companyPage.companies.click();

        companyPage.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(companyPage.edit).click().perform();

        ApplicationFlow.pause(3000);
        companyPage.companyName.sendKeys(Keys.COMMAND + "a");
        companyPage.companyName.sendKeys(Keys.BACK_SPACE);
        companyPage.saveButton.click();

        if (companyPage.saveButton.isEnabled()) {
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Test
    public void j_emptyEmeilFieldTest3(){
        companyPage.companies.click();

        companyPage.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(companyPage.edit).click().perform();

        ApplicationFlow.pause(3000);
        companyPage.email.sendKeys(Keys.COMMAND + "a");
        companyPage.email.sendKeys(Keys.BACK_SPACE);
        companyPage.saveButton.click();

        if (companyPage.saveButton.isEnabled()){
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Test
    public void k_emptyAddressFieldTest4(){
        companyPage.companies.click();

        companyPage.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(companyPage.edit).click().perform();

        ApplicationFlow.pause(3000);
        companyPage.address.sendKeys(Keys.COMMAND + "a");
        companyPage.address.sendKeys(Keys.BACK_SPACE);
        companyPage.saveButton.click();

        if (companyPage.saveButton.isEnabled()){
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @Test
    public void l_emptyPhoneNumberFieldTest5(){
        companyPage.companies.click();

        companyPage.dots.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(companyPage.edit).click().perform();

        ApplicationFlow.pause(3000);
        companyPage.phoneNumber.sendKeys(Keys.COMMAND + "a");
        companyPage.phoneNumber.sendKeys(Keys.BACK_SPACE);
        companyPage.saveButton.click();

        if (companyPage.saveButton.isEnabled()){
            companyPage.editCompany.getText();
            System.out.println("Change does not allow the field to be left blank");
        }
    }
    @AfterClass
    public static void close(){
        Driver.closeDriver();
    }
}
