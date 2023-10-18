package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BranchesPage {
    public BranchesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="input")
    public WebElement loginInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(tagName = "button")
    public WebElement signInButton;
    @FindBy(xpath = "//a[@href='/dashboard/branches' ]")
    public WebElement branches;
    @FindBy (xpath = "//button[contains(text(),'Create Branch')]")
    public WebElement createBranchButton;
    @FindBy (xpath = "//input[@name='name']")
    public  WebElement branchName;
    @FindBy (name = "email")
    public WebElement branchEmail;
    @FindBy (name = "address")
     public WebElement branchAddress;
    @FindBy (name = "phoneNumber")
    public WebElement branchPhone;
    @FindBy (name = "city")
    public WebElement branchCity;
    @FindBy (id = "mui-component-select-regionId")
    public WebElement branchRegion;
    @FindBy (id = "mui-component-select-cities")
    public WebElement branchCities;
    @FindBy (xpath = "//div[@class='sc-iIUQWv hFxtbj'][8]")
    public WebElement selectCompany;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createButton;
    @FindBy(xpath = "//div[@tabindex='0']")
    public WebElement verifyNewBranchCreated;
}
