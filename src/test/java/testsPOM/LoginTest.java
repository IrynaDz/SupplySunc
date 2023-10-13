package testsPOM;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pagesPOM.MainPage;
import utilities.Driver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginTest {
    static WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;


    @Before
    public void setup(){
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        driver.get(loginPage.loginUrl);
    }

    @Test
    public void a_testLoginFunctionality2() throws InterruptedException {
        loginPage.loginWithInvalidUsername();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }


    @Test
    public void b_testLoginFunctionality3() throws InterruptedException {
        loginPage.loginWithInvalidPassword();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }

    @Test
    public void c_testLoginFunctionality4() throws InterruptedException {
        loginPage.loginWithDifferentDomain();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }

    @Test
    public void d_testLoginFunctionality5() throws InterruptedException {
        loginPage.loginWithAllUpperCase();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }


    @Test
    public void e_testLoginFunctionality6() throws InterruptedException {
        loginPage.loginWithEmptyCredentials();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }


    @Test
    public void f_testLoginFunctionality7() throws InterruptedException {
        loginPage.loginWithoutAtSign();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }

    @Test
    public void g_testLoginFunctionality1() throws InterruptedException {
        loginPage.loginWithValidCredentials();
        mainPage.verifySuccessfulLogin();
        Thread.sleep(2000);
    }


    @AfterClass
    public static void close(){
        driver.close();
    }
}
