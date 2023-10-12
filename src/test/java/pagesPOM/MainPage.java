package pagesPOM;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    public String mainPageUrl = "https://supplysync.us/dashboard/companies";
    public String expectedErrorMessage = "Incorrect login and/or password.";

    @FindBy(xpath = "//div[@class='sc-dJjYzT dndVRq'][2]//following::p")
    public WebElement errorMessage;


    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void verifySuccessfulLogin() throws InterruptedException {
        driver = Driver.getDriver();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current page: " + actualUrl);
        Assert.assertEquals("Login failed", mainPageUrl, actualUrl);
    }

    public void verifyErrorMessage() {
        driver = Driver.getDriver();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current page: " + actualUrl);
        Assert.assertEquals("Error message failed", expectedErrorMessage, errorMessage.getText());
        System.out.println("Actual message " + errorMessage.getText());
    }
}

