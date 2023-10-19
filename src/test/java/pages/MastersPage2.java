package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;
import java.util.List;

public class MastersPage2 {

    public String UrlAfterCreatingMaster = "https://supplysync.us/dashboard/masters?showCreate=false";
    public String UrlBeforeCreatingMaster = "https://supplysync.us/dashboard/masters?showCreate=true";
    public MastersPage2(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div//span[.='Masters']")
    public WebElement mastersButton;

    @FindBy(xpath = "//button[.='Create Master']")
    public WebElement createMasterButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name='location']")
    public WebElement placeOfResidence;

    @FindBy(xpath = "//input[@name='number']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//div[contains(@id, 'branch')]")
    public WebElement branchInput;

    @FindBy(xpath = "//li[@role='option']")
    public List<WebElement> listOfOptions;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createButton;

    @FindBy(xpath = "(//div[@role='alert']//div)[2]")
    public WebElement positiveMessage;

}
