package pages;

import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ADashboardPage {
    public ADashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





































































































































































































































    //admin yan menu elementi
    @FindBy(xpath = "//div[@class='aside-menu-container']")
    public WebElement adminMenu;

    // admin yan menu search textbox elementi
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement adminSearchTextbox;

    //admin Coupon Codes linki elementi
    @FindBy(xpath = "(//span[@*='aside-menu-icon pe-3'])[15]")
    public WebElement adminCouponCodesLinki;

    // admin Coupon Codes sayfasi AddCouponCodes elementi
    @FindBy(xpath = "//a[@*='#couponCodeModal']")
    public WebElement adminAddCouponCodes;

    //  admin Coupon Codes sayfasi AddCouponCodes icindeki CouponNameTextbox elementi
    @FindBy(xpath = "//input[@id='couponName']")
    public WebElement adminAddCouponCodesCouponNameTextbox;

    //admin Coupon Codes sayfasi AddCouponCodes icindeki ExpireAt elementi
    @FindBy(xpath = "//input[@id='couponExpireAt']")
    public WebElement adminAddCouponCodesExpireAt;

    //admin Coupon Codes sayfasi AddCouponCodes icindeki ExpireAt deki RightArrow(sağ ok) elementi
    @FindBy(xpath = "(//span[@class='flatpickr-next-month'])[1]")
    public WebElement  adminAddCouponCodesExpireAtRightArrow;

    //admin Coupon Codes sayfasi AddCouponCodes icindeki ExpireAt deki 15. day elementi
    @FindBy(xpath = "(//span[@class='flatpickr-day'])[15]")
    public WebElement adminAddCouponCodesDay15;

    //admin Coupon Codes sayfasi AddCouponCodes icindeki Save button elementi
    @FindBy(xpath = "//button[@id='couponCodeSaveBtn']")
    public WebElement adminAddCouponCodesSave;

    //admin Coupon Codes sayfasinda cikan SaveSuccess yazisi elementi
    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement adminAddCouponCodesSaveSuccess;

    //admin Coupon Codes sayfasinda ki Coupon Name column elementi
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement adminFirstCouponName;

    //admin Coupon Codes sayfasinda ki Coupon Type column elementi
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement adminFirstCouponType;

    //admin Coupon Codes sayfasinda ki Coupon Discount column elementi
    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement adminFirstCouponDiscount;

    //admin Coupon Codes sayfasinda ki Coupon EXPIRE AT column elementi
    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement adminFirstCouponExpireAt;




    // user yan menu Settings linki elementi
    @FindBy(xpath = "(//a[@href='https://qa.smartcardlink.com/admin/user-settings'])[1]")
    public  WebElement userSettingsLinki;

    //user Settings 'e basinca gidilen Credential Sayfasi Basligi elementi
    @FindBy(xpath = "//*[h1='Credentials']")
    public WebElement userCredentialSayfaBasligi;

    //user Credential sayfasi stripe checkbox elementi
    @FindBy(xpath = "//input[@name='stripe_enable']")
    public WebElement userCredential_stripeCheckbox;

    //user Credential sayfasi paypal checkbox elementi
    @FindBy(xpath = "//input[@name='paypal_enable']")
    public WebElement userCredential_paypalCheckbox;

    //user Credential sayfasi stripeKey textbox elementi
    @FindBy (xpath = "//input[@id='stripeKey']")
    public WebElement userCredential_stripeKeyTextbox;

    //user Credential sayfasi stripeSecret textbox elementi
    @FindBy (xpath = "//input[@id='stripeSecret']")
    public WebElement userCredential_stripeSecretTextbox;

    //user Credential sayfasi paypalSecret textbox elementi
    @FindBy (xpath = "//input[@id='paypalSecret']")
    public WebElement userCredential_paypalSecretTextbox;

    //user Credential sayfasi paypalClientId textbox elementi
    @FindBy (xpath = "//input[@id='paypalKey']")
    public WebElement userCredential_paypalClientIdTextbox;

    //user Credential sayfasi paypalMode textbox elementi
    @FindBy (xpath = "//input[@id='paypalMode']")
    public WebElement userCredential_paypalModeTextbox;

    //user Credential sayfasi currency list elementi
    @FindBy (xpath = "(//span[@role='combobox'])[1]")
    public WebElement userCredential_currencyList;

    //user Credential sayfasi Save button elementi
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement userCredential_saveButton;

    //user Credential sayfasi enable Contact Checkbox elementi
    @FindBy (xpath = "//input[@name='enable_contact']")
    public WebElement userCredential_enableContactCheckbox;

    //user Credential sayfasi hide Stickybar Checkbox elementi
    @FindBy (xpath = "//input[@name='hide_stickybar']")
    public WebElement userCredential_hideStickybarCheckbox;

    //user Credential sayfasi enable whatsapp Share Checkbox elementi
    @FindBy (xpath = "//input[@name='whatsapp_share']")
    public WebElement userCredential_whatsappShareCheckbox;

    //user Credential sayfasi basarili save yapinca gelen success uyarisi
    @FindBy (xpath = "//div[@role='alert']")
    public WebElement userCredential_saveSuccesss;

    //user Credential sayfasi hatali save yapinca gelen error uyarisi
    @FindBy (xpath = "//*[@class='toast toast-error']")
    public WebElement userCredential_saveError;

}

