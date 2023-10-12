package pagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CompanyPage {
    public CompanyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[text()='Companies']")
    public WebElement companies;
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement dots;
    @FindBy(xpath = "//li[text()='Edit']")
    public WebElement edit;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement companyName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='address']")
    public WebElement address;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
    @FindBy(xpath = "//p[.='Edit Company']")
    public WebElement editCompany;
}
