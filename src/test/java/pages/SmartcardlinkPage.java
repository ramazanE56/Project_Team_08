package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SmartcardlinkPage {
    public SmartcardlinkPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signinButtonElementi;
    @FindBy(name = "email")
    public WebElement emailKutusuElementi;

    @FindBy(name = "password")
    public WebElement passwordKutusuElementi;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginElementi;




}
