package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SmartcardlinkPage {

    public SmartcardlinkPage(){  PageFactory.initElements(Driver.getDriver(),this);    }

    @FindBy(xpath = "//a[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signinButtonElementi;

    //Dashboard profil elementi
    @FindBy(xpath = "//button[@id='dropdownMenuButton1']")
    public WebElement succesSignInElement;

    //pasword change elementleri
    @FindBy(xpath = "//a[@id='changePassword']")
    public WebElement changePasswordElementi;
    @FindBy(xpath = "//input[@*='current_password']")
    public WebElement currentPasswordElementi;
    @FindBy(xpath = "//input[@*='new_password']")
    public WebElement newPasswordElementi;
    @FindBy(xpath = "//input[@*='confirm_password']")
    public WebElement confirmPasswordElementi;
    @FindBy (id = "passwordChangeBtn")
    public WebElement passwordChangeSaveButonElementi;
    @FindBy(xpath = "//div[text()='Error']")
    public WebElement passwordChangeErrorElementi;
    @FindBy(xpath = "//div[text()='Success']")
    public WebElement passwordChangeSuccessElementi;

    //language change elementleri
    @FindBy(xpath = "//a[@id='changeLanguage']")
    public WebElement changeLanguageElementi;
    @FindBy(xpath = "//*[@id='select2-selectLanguage-container']")
    public WebElement languageTextBoxElementi;
    @FindBy(xpath = "//*[@id='languageChangeBtn']")
    public WebElement languageSaveButtonElementi;

    //sign out elementleri
    @FindBy(xpath = "//form[@id='logout-form']")
    public WebElement signOutElementi;
    @FindBy(xpath = "//div[@*='bg-white rounded-15 shadow-md width-540 px-5 px-sm-7 py-10 mx-auto']")
    public WebElement signInYaziElementi;

    // Choose A Plan elementleri

    @FindBy (xpath = "//button[@class='slick-next slick-arrow']")
    public WebElement choosePlanNextButonu;

    @FindBy (xpath = "//a[@href='https://qa.smartcardlink.com/admin/choose-payment-type/4']")
    public WebElement unlimitedPlanSwitchButonu;















}
