package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String loginUrl = "https://supplysync.us/login";

    @FindBy(id = "input")
    public WebElement loginButton;

    @FindBy(id = "password")
    public WebElement passwordButton;

    @FindBy(xpath = "//button[@class='sc-kfPuZi bvauHb']")
    public WebElement signInButton;


    public void loginWithValidCredentials(){
        loginButton.sendKeys("admin@codewise.com");
        passwordButton.sendKeys("codewise123");
        signInButton.click();
    }

    public void loginWithInvalidPassword(){
        loginButton.sendKeys("admin@codewise.com");
        passwordButton.sendKeys("codewiseeee");
        signInButton.click();
    }

    public void loginWithInvalidUsername(){
        loginButton.sendKeys("user@codewise.com");
        passwordButton.sendKeys("codewise123");
        signInButton.click();
    }

    public void loginWithDifferentDomain(){
        loginButton.sendKeys("admin@gmail.com");
        passwordButton.sendKeys("codewise123");
        signInButton.click();
    }

    public void loginWithoutAtSign(){
        loginButton.sendKeys("admincodewise.com");
        passwordButton.sendKeys("codewise123");
        signInButton.click();
    }

    public void loginWithAllUpperCase(){
        loginButton.sendKeys("ADMIN@CODEWISE.COM");
        passwordButton.sendKeys("CODEWISE123");
        signInButton.click();
    }


    public void loginWithEmptyCredentials(){
        loginButton.sendKeys("");
        passwordButton.sendKeys("");
        signInButton.click();
    }



}
