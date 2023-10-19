package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TariffPage {
    public TariffPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="input")
    public WebElement loginField;
    @FindBy(id="password")
    public WebElement passwordField;
    @FindBy(tagName = "button")
    public WebElement signInButton;
    @FindBy(xpath = "//span[.='Tariffs']")
    public WebElement tariffs;
    @FindBy(xpath = "//button[.='Create tariff']")
    public WebElement createTariffButton;
    @FindBy(id = "mui-component-select-branchId")
    public WebElement chooseBranch;
    @FindBy(xpath = "//li[text()='CodeWise']")
    public WebElement branch;
    @FindBy(name = "name")
    public WebElement fieldNameTariff;
    @FindBy(name = "time")
    public WebElement fieldDeliveryTime;
    @FindBy(id = "mui-component-select-type")
    public WebElement typeDelivery;
    @FindBy(xpath = "//*[@id='menu-type']//li[2]")
    public WebElement cityExpress;
    @FindBy(name = "price")
    public WebElement deliveryCost;
    @FindBy(name = "coordinates")
    public WebElement coordinates;
    @FindBy(name = "additionalInformation")
    public WebElement additionalInformation;
    @FindBy(xpath = "//button[2]")
    public WebElement createButton;
    @FindBy(xpath = "//div[contains(text(),'Tariff created successfully')]")
    public WebElement popUpMessage;


    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement row;
    @FindBy(xpath = "//button/img")
    public WebElement menuIcon;
    @FindBy(xpath = "//li[text()='Delete']")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[2]")
    public WebElement actionPerform;
    @FindBy(xpath = "//div[contains(text(),'Tariff removed successfully')]")
    public WebElement findPopUpMessage;

}
