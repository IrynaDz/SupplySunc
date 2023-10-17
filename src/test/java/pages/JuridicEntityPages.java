package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JuridicEntityPages {
    public JuridicEntityPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="input")
    public WebElement loginField;
    @FindBy(id="password")
    public WebElement passwordField;
    @FindBy(tagName = "button")
    public WebElement signInButton;
    @FindBy(linkText = "Juridic Entity")
    public WebElement juridicEntityLink;

    @FindBy(linkText = "//button[@class='sc-ikJyIC idrUqC MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-gsNilK hofTdo sc-dFtzxp khbchy sc-cTAIfT dANijJ']")
    public  WebElement createLegalEntityButton;

    @FindBy(xpath = "//div[@id='mui-component-select-companyId']")
    public WebElement companiesField ;

    @FindBy(xpath = "//div[@id='mui-component-select-branchId']")
    public WebElement branchField ;

    @FindBy(xpath = "//input[@name='juridicalCompanyName']")
    public WebElement legalEntityName ;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement clickButton ;

    @FindBy(xpath = "//div[contains(text(),'Legal Entity successfully created')]")
    public static WebElement popUpMessage;

}


