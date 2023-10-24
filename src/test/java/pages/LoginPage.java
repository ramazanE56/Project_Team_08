package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "email")
    public WebElement emailKutusuElementi;
//
    @FindBy(name = "password")
    public WebElement passwordKutusuElementi;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginElementi;
}
