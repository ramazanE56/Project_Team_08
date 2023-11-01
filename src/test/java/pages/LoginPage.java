package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class
LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "email")
    public WebElement emailKutusuElementi;

    @FindBy(name = "password")
    public WebElement passwordKutusuElementi;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginElementi;

    //@FindBy(className = "mt-1")
    public WebElement notSignInElementi;

    @FindBy (xpath = "//span[@class='mt-1']")
    public  WebElement failedLoginText;

    // kaan ilave locatler
    @FindBy(xpath = "/html/body/div/div[2]/div[3]/form/div[5]/a")
    public WebElement createAnAccountElementi;

    @FindBy (xpath = "//*[@id=\"first_name\"]")
    public WebElement firstNameElementi;

    @FindBy (xpath = "//*[@id=\"privacyPolicyCheckbox\"]")
    public WebElement priPolCheckboxElementi;

    @FindBy (xpath = "//*[@id=\"UserRegisterForm\"]/div[5]/button")
    public WebElement NewUserSubmitElementi;


    @FindBy (xpath = "/html/body/div/div[2]/div[2]/div")
    public WebElement succesedElementi;
}
