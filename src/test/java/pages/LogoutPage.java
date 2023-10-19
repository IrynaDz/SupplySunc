package pages;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogoutPage {
    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//p[text()='Administrator']")
    public WebElement administrator;

    @FindBy(xpath = "//li[text()='Exit']")
    public WebElement exit;

    @FindBy(xpath = "//button[text()='Exit']")
    public WebElement buttonExit;


}
