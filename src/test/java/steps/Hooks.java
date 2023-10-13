package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.CompanyPage;
import pages.LoginPage;
import pagesPOM.MainPage;
import utilities.Driver;

public class Hooks {
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
    @After
    public static void close(){
        Driver.closeDriver();
    }

}
