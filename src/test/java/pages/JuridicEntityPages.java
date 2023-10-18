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

    @FindBy(xpath = "//li[@data-value='1'][1]")
    public WebElement branchField ;

    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
    public WebElement branchFieldParent;

    @FindBy(xpath = "//div[@id='menu-branchId']//li[4]")
    public WebElement branchFieldChild;

    @FindBy(xpath = "//input[@name='juridicalCompanyName']")
    public WebElement legalEtnityField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement clickButton ;
  



}


