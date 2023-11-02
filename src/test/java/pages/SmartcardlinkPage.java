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
    @FindBy(xpath = "//*[@id=\"selectLanguage\"]")
    public WebElement languageTextBoxElementi;
    @FindBy(xpath = "//*[@id='languageChangeBtn']")
    public WebElement languageSaveButtonElementi;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--selectable select2-results__option--selected']")
    public WebElement turkceDilElementi;
    @FindBy(xpath = "//a[text()='Aboneliği Yönet']")
    public WebElement dilDegisimOnayElementi;

    //sign out elementleri
    @FindBy(xpath = "(//a/span[2])[7]")
    public WebElement signOutElementi;
    @FindBy(xpath = "//div[@*='bg-white rounded-15 shadow-md width-540 px-5 px-sm-7 py-10 mx-auto']")
    public WebElement signInYaziElementi;

    //KAAN

    // Footer Elementleri
    @FindBy (xpath = "//*[@class= 'features-section bg-light pb-60 pt-80']")
    public WebElement footerElementi;


    @FindBy (xpath = "( //div[@class='col-4'])[1]")
    public WebElement footerCopyrightElementi;

    @FindBy (xpath = "//*[@title='Facebook']")
    public WebElement footerFacebookElementi;

    @FindBy (xpath = "//*[@title='Twitter']")
    public WebElement footerTwitterElementi;


    @FindBy (xpath = "//*[@title='Instagram']")
    public WebElement footerInstagramElementi;

    @FindBy (xpath = "//*[@title='Linkedin']")
    public WebElement footerLinkedinElementi;

    @FindBy (xpath = "//*[@title='Pinterest']")
    public WebElement footerPinterestElementi;

    @FindBy (xpath = "(//*[@target='_blank'])[6]")
    public WebElement footerTermsConditionsElementi;

    @FindBy (xpath = "(//*[@target='_blank'])[7]")
    public WebElement footerPrivacyPolicyElementi;

    @FindBy (xpath = "(//*[@target='_blank'])[8]")
    public WebElement footerFAQElementi;












    //**** sadık
    // Get Started Buton elementi
    @FindBy (xpath = "//a[@class='btn btn-orange ']")
    public WebElement getStartedButonu;

    // Choose plansdaki geri gitme  Buton elementi
    @FindBy (xpath = "//*[@aria-label='Previous']")
    public WebElement ChoosePreviousButonu;

    // Choose plansdaki ileri gitme  Buton elementi
    @FindBy (xpath = "//*[@aria-label='Next']")
    public WebElement ChooseNextButonu;

    // Choose plansdaki Standart Choose  Buton elementi
    @FindBy (xpath = "(//a[@class='btn btn-primary rounded-pill mx-auto  '])[3]")
    public WebElement StandartChoosePlanButonu;

    // Choose plansdaki Silver Choose  Buton elementi
    @FindBy (xpath = "(//a[@class='btn btn-primary rounded-pill mx-auto  '])[4]")
    public WebElement SilverChoosePlanButonu;

    // Choose plansdaki Gold Choose  Buton elementi
    @FindBy (xpath = "(//a[@class='btn btn-primary rounded-pill mx-auto  '])[5]")
    public WebElement GoldChoosePlanButonu;

    // Choose plansdakiUnlimited Choose  Buton elementi
    @FindBy (xpath = "(//a[@class='btn btn-primary rounded-pill mx-auto  '])[6]")
    public WebElement UnlimitChoosePlanButonu;

    // Choose plans Silvera Geçiş Buton elementi
    @FindBy (xpath = "//button[@id='slick-slide-control01']")
    public WebElement SilveragecisButonu ;

    // Choose plans Golda Geçiş Buton elementi
    @FindBy (xpath = "//button[@id='slick-slide-control02']")
    public WebElement GoldagecisButonu ;

    // Choose plans Unlimiteda Geçiş Buton elementi
    @FindBy (xpath = "//button[@id='slick-slide-control03']")
    public WebElement UnlimiteGecisButonu ;

    //  1. Stories From Buton  elementi
    @FindBy (xpath = "//button[@aria-controls='slick-slide10']")
    public WebElement StoriesFromButonu1 ;

    //  2. Stories From Buton  elementi
    @FindBy (xpath = "//button[@aria-controls='slick-slide11']")
    public WebElement StoriesFromButonu2 ;

    //  Sende message  elementi
    @FindBy (xpath = "//input[@id='submit']")
    public WebElement SendMessageButonu ;

    //  Subscribe  Buton  elementi
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement SubscribeButonu ;











}
