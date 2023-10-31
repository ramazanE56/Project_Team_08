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


    @FindBy(xpath = "//*[@id=\"dropdownMenuButton1\"]")
    public WebElement profildropdownMenuButton1;
    @FindBy(xpath = "(//a[@class=\"dropdown-item text-gray-900\"])[1]")
    public WebElement accountSettingsLinki;
    @FindBy (xpath = "//*[text()=\"Profile Details\"]")
    public WebElement profileDetailsLinki;
    ////https://qa.smartcardlink.com/profile/edit altındaki firstName kutusu
    @FindBy(xpath = "//*[@id=\"editProfileFirstName\"]")
    public WebElement firstNameKutusu;

    //https://qa.smartcardlink.com/profile/edit altınadaki save buttonu
    @FindBy(xpath = "//*[@class=\"btn btn-primary me-2\"]")
    public  WebElement saveButtonProfile;


    //Ziyaretci Dashboard sayfasında üstteki Dashboard yazısının locate'i
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement visitorDashboardYaziElementi;

    //Admin Dasboard sayfasında üstteki Dashboard yazısının locate'i
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardYaziElementi;


    //Admin Dashboard sayfasi sol taraftaki Cash Payments butonunun locate'i
    @FindBy (xpath = "//span[text()='Cash Payments']")
    public  WebElement cashPaymentsButton;

    //Cash Payments  sayfasi ust taraftaki Cash Payments yazisi locate
    @FindBy(xpath = "//a[text()='Cash Payments']")
    public WebElement cashPaymentsYazisi;

    //Cash Payments  sayfasi Payable Amount yazisi locate
    @FindBy (xpath = "//span[text()='Payable Amount']")
    public WebElement payableAmountYazisi;

    //Cash Payments  sayfasi ödeme yapanlar tablosu locate
    @FindBy(xpath ="//tbody" )
    public WebElement cashPaymentsListesi;

    //Cash Payments  sayfasi ödeme yapanlar sayisi locate
    @FindBy (xpath = "//div[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement cashPaymentsSayisi;

    //Cash Payments  sayfasi User Name yazisi locate
    @FindBy (xpath = "//span[text()='User Name']")
    public WebElement userNameYazisi;

    //Cash Payments  sayfasi Plan Name  yazisi locate
    @FindBy(xpath = "//span[text()='Plan Name']")
    public WebElement planNameYazisi;

    //Cash Payments  sayfasi Plan Price  yazisi locate
    @FindBy(xpath = "//span[text()='Plan Price']")
    public WebElement planPriceYazisi;

    //Cash Payments  sayfasi Start Date  yazisi locate
    @FindBy (xpath = "//span[text()='Start Date']")
    public WebElement startDateYazisi;

    //Cash Payments  sayfasi End Date  yazisi locate
    @FindBy (xpath = "//span[text()='End Date']")
    public WebElement endDateYazisi;

    //Cash Payments  sayfasi Attachment  yazisi locate
    @FindBy (xpath = "//tr/th[7]")
    public WebElement attachmentYazisi;

    //Cash Payments  sayfasi Notes  yazisi locate
    @FindBy (xpath = "//tr/th[8]")
    public WebElement notesYazisi;

    //Cash Payments  sayfasi Status  yazisi locate
    @FindBy (xpath = "//tr/th[9]")
    public WebElement statusYazisi;

    //Cash Payments  sayfasi Siralama Butonu (asagi-yukari isareti) locate
    @FindBy(xpath = "(//span[@class='relative d-flex align-items-center'])[1]")
    public WebElement siralamaButonu;

    //Admin Dasboard sayfasında menudeki "Affiliate Users" yazısının locate'i
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[9]")
    public WebElement bagliKullanicilarYaziElementi;

    //Admin Dasboard sayfasında ortaklığı kimlerin yaptığının görüldüğü show locate'i
    @FindBy (xpath = "//div[@class='row']")
    public WebElement sonuclariGormeYaziElementi;

    //Admin Dasboard sayfasında üyelik işlemlerinin görüldüğü locate
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[10]")
    public WebElement uyelikİslemleriYaziElementi;

    //Admin Dasboard sayfasında üyelik onay durumunun görüldüğü locate
    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-eye text-info'])[1]")
    public WebElement uyelikOnayDurumuYaziElementi;

    //Admin Dasboard sayfasında sitede kullanılan ulklerin sayısının görüldüğü locate
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[13]")
    public WebElement ulkelerYaziElementi;

    //Admin Dasboard sayfasında sitede kullanılan eyaletlerin sayısının görüldüğü locate
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement eyaletlerYaziElementi;

    //Admin Dasboard sayfasında Total Active Users sayısının locate'i
    @FindBy(xpath = "(//h2[@class='fs-1-xxl fw-bolder text-white'])[1]")
    public WebElement totalActiveUsersElementi;

    //Admin Dasboard sayfasında Total Active VCards sayısının locate'i
    @FindBy(xpath = "(//h2[@class='fs-1-xxl fw-bolder text-white'])[2]")
    public WebElement totalActiveVcardsElementi;

    //Admin Dasboard sayfasında Total DeActive Users sayısının locate'i
    @FindBy(xpath = "(//h2[@class='fs-1-xxl fw-bolder text-white'])[3]")
    public WebElement totalDeActiveUsersElementi;

    //Admin Dasboard sayfasında Total DeActive VCards sayısının locate'i
    @FindBy(xpath = "(//h2[@class='fs-1-xxl fw-bolder text-white'])[4]")
    public WebElement totalDeActiveVcardsElementi;

    //Admin Dasboard sayfasında Plan oranları tablosunun locate'i
    @FindBy(xpath = "//canvas[@id='dashboardPlanPieChart']")
    public WebElement plansbyUsersElementi;

    //Admin Dasboard sayfasında kullanıcı gelir grafiğinin locate'i
    @FindBy(xpath = "//canvas[@id='dashboardIncomeChart']")
    public WebElement graficElementi;

    //Admin Dasboard sayfasında günlük kullanıcı kayıtlarının locate'i
    @FindBy(xpath = "//button[@class='nav-link active p-0']")
    public WebElement gunlukElementi;

    //Admin Dasboard sayfasında haftalık kullanıcı kayıtlarının locate'i
    @FindBy(xpath = "//button[@id='vweekData']")
    public WebElement haftalikElementi;

    //Admin Dasboard sayfasında haftalık kullanıcı kayıtlarının locate'i
    @FindBy(xpath = "//button[@id='monthData']")
    public WebElement aylikElementi;

    //Admin Dasboard sayfasında Vcard Templates sekmesinin locate'i
    @FindBy(xpath = "(//span[@class='aside-menu-title'])[5]")
    public WebElement vcardTemplatesElementi;


    //Admin Dasboard sayfasında 3 çizginin yanındaki yazının locate'i
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")
    public WebElement sekmeBasligiYaziElementi;



    //Abone olunan kullanıcı planları elementi
    @FindBy(xpath = "//span[text()='Subscribed User Plans']")
    public WebElement subscribedUserPlansElementi;

    //Abonelik planlarını görüldü test elementi
    @FindBy(xpath = "//h5[text()='Subscribed Plan Details']")
    public WebElement SubscribedUserPlansTestElementi;

    //Abonelik planlarını görüntüleme elementi
    @FindBy(xpath = "(//a[@data-id='330'])[1]")
    public WebElement SubscribedUserPlansViewElementi;

    //User menu elementi
    @FindBy(xpath = "(//*[@data-icon='users'])[1]")
    public WebElement userMenuElementi;

    //Users menusu Impersonate(kimliğe bürün) elementi
    @FindBy(xpath = "//div[@class='d-flex justify-content-center']")
    public WebElement impersonateElementi;

    //Kullanıcıdan admin hesabına geçiş ikonu elementi
    @FindBy(xpath = "//span[@class='text-primary']")
    public WebElement adminHesabaGecisElementi;

    //admin kullanıcı profil ismi elementi
    @FindBy(xpath ="//button[@id='dropdownMenuButton1']")
    public WebElement kullaniciProfilIsimElementi;

    // Admin Dasboard sayfasında Affiliation Transactions Butonu locate
    @FindBy (xpath = "//span[text()='Affiliation Transactions']")
    public  WebElement affiliationTransactionsButton;

    //Affiliation Transactions sayfasinda üst taraftaki Affiliation Transactions yazisi locate
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement affiliationTransactionsYazisi;

    //Affiliation Transactions sayfasinda User yazisi locate
    @FindBy (xpath = "//span[text()='User']")
    public  WebElement userYazisi;

    //Affiliation Transactions sayfasinda Amount yazisi locate
    @FindBy(xpath = "//span[text()='Amount']")
    public WebElement amountYazisi;

    //Affiliation Transactions sayfasinda Approval Status yazisi locate
    @FindBy(xpath = "//span[text()='Approval Status']")
    public WebElement approvalStatusYazisi;

    //Affiliation Transactions sayfasinda Date yazisi locate
    @FindBy(xpath = "//span[text()='Date']")
    public WebElement dateYazisi;

    //Affiliation Transactions sayfasinda Action yazisi locate
    @FindBy(xpath = "//tr/th[5]")
    public WebElement actionYazisi;

    //Affiliation Transactions sayfasinda Ortaklık kullanıcıları locate
    @FindBy (xpath = "//tbody/tr/td[1]")
    public WebElement affiliationTransactionsUsers;

    @FindBy (xpath = "//tbody/tr/td[2]")
    public WebElement affiliationTransactionsAmount;

    @FindBy (xpath = "//tbody/tr/td[3]")
    public WebElement affiliationTransactionsApprovalStatus;


    @FindBy (xpath = "//tbody/tr/td[4]")
    public WebElement affiliationTransactionsDate;



    @FindBy (xpath = "(//span[@id='showAffiliationWithdrawBtn'])[1]")
    public WebElement affiliationTransactionsActionEyeIkon;

    @FindBy (xpath = "//h5[@id='showAffiliationWithdrawModalBtn']")
    public  WebElement affiliationTransactionsOrtaklikBilgileri;

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

    //admin Coupon Codes sayfasi ilk siradaki coupon Status buton elementi
    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    public WebElement adminFirstCouponStatusButton;


}

