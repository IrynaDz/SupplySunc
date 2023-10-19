package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MastersPage {
    public MastersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "input")
    public WebElement login;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;
    @FindBy(xpath = "//span[text()='Masters']")
    public WebElement mastersOption;
    @FindBy(xpath = "//img[@alt='MenuIcon']")
    public WebElement threeDots;
    @FindBy(xpath = "//li[@role='menuitem' and text()='Delete']")
    public WebElement deleteFromDropdown;
    @FindBy(xpath = "//button[@type='button' and text()='Delete']")
    public WebElement deleteRedButton;
    @FindBy(xpath = "//button[@type='button' and text()='Cancer']")
    public WebElement cancelButton;
}
