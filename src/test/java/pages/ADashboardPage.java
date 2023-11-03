package pages;

import com.sun.jna.Structure;
import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;


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

    @FindBy (xpath = "(//*[text()='Languages'])[1]")
    public WebElement dashboardLanguages;
    @FindBy(xpath = "//div[@class='col-12 text-muted pagination-record ms-sm-3']")
    public WebElement languagesYaziElementi;

    @FindBy(xpath = "(//span[text()='Withdraw Transactions'])[1]")
    public WebElement withdrawElementi;

    @FindBy(xpath = "(//div[@class='d-flex align-items-center'])[2]")
    public WebElement paidUsers;

    @FindBy(xpath = "(//span[@class='badge bg-success me-2'])[1]")
    public WebElement amountElementi;

    @FindBy(xpath = "(//td[@class='whitespace-nowrap px-3 py-2 md:px-6 md:py-4 text-sm leading-5 text-gray-900 dark:text-white'])[3]")
    public WebElement paymentElementi;

    @FindBy(xpath = "(//td[@class='whitespace-nowrap px-3 py-2 md:px-6 md:py-4 text-sm leading-5 text-gray-900 dark:text-white'])[4]")
    public WebElement dateElementi;


    @FindBy(xpath = "(//tbody/tr)[1]")
    public WebElement webTableIlkSatirElementi;


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
    public WebElement uyelikislemleriYaziElementi;

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
    @FindBy(xpath = "(//a[@class='btn px-1 text-info fs-3 subscribed-user-plan-view-btn'])[1]")
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
    //https://qa.smartcardlink.com/sadmin/users edit(kalem) elementi
    @FindBy (xpath = "(//*[@class=\"svg-inline--fa fa-pen-to-square\"])[1]")
    public WebElement edit_kalem_elementi;

    //https://qa.smartcardlink.com/sadmin/users/366/edit first name kutusu
    @FindBy(xpath = "//*[@name=\"first_name\"]")
    public WebElement firstNameKutusuUsers;


    //dashboard sayfasındaki VCards butonu elementi
    @FindBy(xpath = "//*[@class=\"svg-inline--fa fa-id-card\"]")
    public WebElement vCardsElementi;
        ////a[@class="nav-link d-flex align-items-center py-3"]
    @FindBy(xpath = "(//a[@class=\"nav-link d-flex align-items-center py-3\"])[3]")
    public WebElement enquiriesElementi;

    @FindBy(xpath = "(//a[@class=\"nav-link d-flex align-items-center py-3\"])[4]")
    public WebElement appointmentsElementi;

    @FindBy(xpath = "(//a[@class=\"nav-link d-flex align-items-center py-3\"])[5]")
    public WebElement virtualBackgroundsElementi;
    @FindBy(xpath = "(//a[@class=\"nav-link d-flex align-items-center py-3\"])[6]")
    public WebElement settingsElementi;

    //BHDR Vcard butonu altındaki elementkerin locateleri
    @FindBy(xpath = "(//*[@class=\"svg-inline--fa fa-chart-line fs-2\"])[1]")
    public WebElement statsAltindakiButonElementi;

    @FindBy(xpath = "//input[@class=\"form-control ps-8\"]")
    public WebElement vCardSearchButonuElementi;
    @FindBy(xpath = "(//div[@class=\"d-flex align-items-center\"])[2]")
    public WebElement userNameButonuElementi;
    @FindBy(xpath = "(//div[@class=\"bg-overlay\"])[1]")
    public WebElement searchFrontButonu;
    @FindBy(xpath = "(//*[@class=\"nav-item \"])[14]")
    public WebElement frontCmsButonuElementi;

    @FindBy(xpath = "//*[@href=\"https://qa.smartcardlink.com/sadmin/frontTestimonials\"]")
    public WebElement testimonialsButonElementi;
    @FindBy(xpath = "(//*[@class=\"justify-content-center d-flex\"])[1]")
    public WebElement actionButonElementi;
    @FindBy(xpath = "(//a[@class=\"btn px-1 text-info fs-3 view-testimonial-btn \"])[1]")
    public WebElement viewButonuElementi;
    @FindBy(xpath = "(//*[@class=\"modal-title\"])[3]")
    public WebElement testimonialDetailsElementi;
    @FindBy(xpath = "(//a[@title=\"Delete\"])[1]")
    public WebElement deleteButonuElementi;
    @FindBy(xpath = "//button[@class=\"swal-button swal-button--confirm\"]")
    public WebElement yesDeleteButonuElementi;

    @FindBy(xpath = "//a[@id=\"addTestimonialBtn\"]")
    public WebElement addTestimonialButonuElementi;
    @FindBy(xpath = "(//input[@class=\"form-control\"])[2]")
    public WebElement nameTextKutusuElementi;
    @FindBy(xpath = "//*[@id=\"description\"]")
    public WebElement descriptionButonuElementi;
    @FindBy(xpath = "(//*[@id=\"profileImageIcon\"])[1]")
    public WebElement imageKalemButonu;

    @FindBy(xpath = "/*[@id=\"testimonialSave\"]")
    public WebElement testtimonialSaveBUtonuElementi;

    @FindBy(xpath = "//*[@class=\"toast-title\"]")
    public WebElement successElementi;


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

    //Affiliation Transactions sayfasinda Ortaklık miktari locate
    @FindBy (xpath = "//tbody/tr/td[2]")
    public WebElement affiliationTransactionsAmount;

    //Affiliation Transactions sayfasinda Ortaklık onay durumu locate
    @FindBy (xpath = "//tbody/tr/td[3]")
    public WebElement affiliationTransactionsApprovalStatus;

    //Affiliation Transactions sayfasinda tarihi locate
    @FindBy (xpath = "//tbody/tr/td[4]")
    public WebElement affiliationTransactionsDate;


    //Affiliation Transactions sayfasinda Eye İkon locate
    @FindBy (xpath = "(//span[@id='showAffiliationWithdrawBtn'])[1]")
    public WebElement affiliationTransactionsActionEyeIkon;

    //Affiliation Transactions sayfasinda Ortaklık bilgileri locate
    @FindBy (xpath = "//h5[@id='showAffiliationWithdrawModalBtn']")
    public  WebElement affiliationTransactionsOrtaklikBilgileri;


    //Affiliation Transactions sayfasinda tum tablo bilgileri locate
    @FindBy (xpath = "//tbody")
    public  WebElement affiliationTransactionsTumTablo;

    //Osman Admin Dasboard sayfasında Front CMS  sekmesinin locateler'i
    @FindBy(xpath = "(//a[@href='https://qa.smartcardlink.com/sadmin/front-cms'])[1]")
    public WebElement frontCmsElementi;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement frontCmsTitleElementi;

    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement frontCmsSubTitleElementi;

    @FindBy(xpath = "//a[@href='https://qa.smartcardlink.com/sadmin/features']")
    public WebElement frontCmsFeaturesElementi;

    @FindBy(xpath = "//td[contains(text(),'Easily share your digital business cards (VCards) ')]")
    public WebElement frontCmsFeaturesYaziElementi;

    @FindBy(xpath = "(//a[@class='nav-link p-0 '])[20]")
    public WebElement frontCmsAboutUsElementi;





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


    @FindBy (xpath = "//span[text()='VCards']")
    public WebElement dashboardVCardsElementi;

    @FindBy (xpath = "//a[text()='New VCard']")
    public WebElement dashboardNewVcardButonu;

    @FindBy (xpath = "//button[@id='generate-url-alias']")
    public WebElement newVCardUrlAliasGenerateButonu;

    @FindBy (xpath = "//input[@placeholder='Enter VCard Name']")
    public WebElement newVCardNameKutusu;

    @FindBy (xpath = "//input[@placeholder='Enter Occupation']")
    public WebElement newVCardOccupationKutusu;

    @FindBy (xpath = "//div[@class='ql-editor ql-blank']")
    public WebElement newVCardDescriptionKutusu;

    @FindBy (xpath = "//input[@id='vcardSaveBtn']")
    public WebElement newVCardSaveButonu;

    @FindBy (xpath = "//div[@role='alert']")
    public WebElement vcardCreatedSuccesfullyAlerti;

    @FindBy (xpath = "//h2[@class='fs-1-xxl fw-bolder text-white']")
    public WebElement totalActiveVCardSayisiElementi;

    @FindBy (xpath = "//button[@class='btn px-2 text-primary fs-2 user-edit-btn copy-clipboard'][1]")
    public WebElement vCardCopyButonu;

    @FindBy (xpath = "//*[@data-icon='chart-line']")
    public WebElement vcardAnalyticsButonu;

    @FindBy (xpath = "//*[@data-icon='chart-line']")
    public WebElement vCardStatsButonu;

    @FindBy (xpath = "//div[@class='d-md-flex align-items-center justify-content-between mb-5']")
    public WebElement vCardAnalyticsSayfasi;

    @FindBy (xpath = "//*[@*='checkbox']")
    public WebElement vCardCheckboxButonu;

    @FindBy (xpath="//div[@class='toast-progress']")
    public WebElement vCardStatusUpdatedAlerti;

    @FindBy (xpath = "//a[text()='Back']")
    public WebElement vCardBackButonu;

    @FindBy (xpath = "//a[@title='QR Code']")
    public WebElement vCardQRCodeDownloadButonu;

    @FindBy (xpath = "//a[@title='Download VCard']")
    public WebElement vCardDownloadButonu;

    @FindBy (xpath = "//a[@title='Duplicate VCard']")
    public WebElement vCardDublicateButonu;

    @FindBy (xpath = "//button[text()='Yes']")
    public WebElement vCardDuplicateYesButonu;

    @FindBy (xpath = "//a[@class='text-decoration-none fs-6'][1]")
    public WebElement vCardDublicateTestLinki;

    @FindBy (xpath = "//a[@title='Edit']")
    public WebElement vCardEditButonu;

    @FindBy (xpath = "//h1[text()='Edit VCard']")
    public WebElement vCardEditSayfasiElementi;

    @FindBy (xpath = "//a[@title='Delete']")
    public WebElement vCardDeleteButonu;

    @FindBy (xpath = "//button[text()='Yes, Delete!']")
    public WebElement vCardYesDeleteButonu;

    @FindBy (xpath = "//div[@class='toast-message']")
    public WebElement vCardSuccessCopied;

    @FindBy (xpath = "//span[text()='Appointments']")
    public WebElement dashboardAppointmentsElementi;

    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardAppointmentsSayfasi;

    //admin Coupon Codes sayfasi ilk siradaki coupon Status buton elementi
    @FindBy(xpath = "(//input[@id='changeCouponStatus'])[1]")
    public WebElement adminFirstCouponStatusButton;

    //Admin Dasboard sayfasında menudeki (Affiliate Users) sekmesinin locate'i
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[9]")
    public WebElement affiliateUsersElementi;

    //Admin "Affiliate Users" sayfasında ortaklığın kim tarafından yapıldığı yazısının (Affiliated By) locate'i
    @FindBy (xpath = "(//div[@class='d-flex align-items-center'])[1]")
    public WebElement affiliatedByYaziElementi;

    //Admin "Affiliate Users" sayfasında "Kaydedilen Kullanıcılar" (User) yazısının locate'i
    @FindBy (xpath = " (//div[@class='d-flex align-items-center'])[2]")
    public WebElement userYaziElementi;

    //Admin "Affiliate Users" sayfasındaki "Ortaklık Tutarı" (Affiliation Amount) yazısının locate'i
    @FindBy (xpath = " (//div[@class='d-flex align-items-center'])[3]")
    public WebElement affiliationAmountYaziElementi;

    //Admin "Affiliate Users" sayfasındaki "Ortaklık Tarihi" (Date) yazısının locate'i
    @FindBy (xpath = " (//div[@class='d-flex align-items-center'])[3]")
    public WebElement dateYaziElementi;

    // Admin panelinde menu listesindeki "Üyelik İşlemleri" (Affiliation Transactions) menu ögesi locate'i
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[10]")
    public  WebElement affiliationTransactionsElementi;

    // "Affiliation Transactions" sayfasinda "Onay Durumu" (Approval Status) yazisi locate'i
    @FindBy(xpath = "//span[text()='Approval Status']")
    public WebElement approvalStatusYaziElementi;

    // "Affiliation Transactions" sayfasinda onay bekleyen başvurucnun (Approval Status) Button locate'i
    @FindBy (xpath = "//button[@class='btn btn-success dropdown-toggle']")
    public WebElement approvalStatusButtonElementi;


    // "Affiliation Transactions" sayfasinda başvurucnun onaylama (Approve) yazı locate'i
    @FindBy (xpath = "(//a[@class=\"dropdown-item\"])[1]")
    public WebElement approveOnayYaziElementi;

    // "Affiliation Transactions" sayfasinda başvurucnun reddetme (Approve) yazı locate'i
    @FindBy (xpath = "(//a[@class=\"dropdown-item\"])[2]")
    public WebElement rejectRedYaziElementi;

    // "Affiliation Transactions" sayfasinda başvurucnun onaylama/Reddetme (Approve/Reject) yazı locate'i
    @FindBy (xpath = "(//*[@class='modal-title'])[3]")
    public WebElement approveRecectonayRedYaziElementi;

    //Admin panelinde menu listesindeki Ülkeler (Countries) menu ögesinin locate'i
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[13]")
    public WebElement countriesElementi;

    // Admin panelinde menudeki Ülkeler (Countries) sayfasındaki Ulkeler(Countries) sekmesi locate'i
    @FindBy (xpath = "(//a[@href='https://qa.smartcardlink.com/sadmin/countries'])[2]")
    public WebElement countriesSekmesiElementi;

    // Ülkeler sayısı elementi locate'i
    @FindBy(xpath = "//strong[3]")
    public WebElement ulkeSayisiYaziElementi;

    // Admin panelinde Eyaletler (States) sayısının görülüdüğü yazı locate'i
    @FindBy (xpath = "//strong[3]")
    public WebElement eyaletSayisiYaziElementi;

    // Admin panelinde Şehirler (Cities) sayısının görülüdüğü yazı locate'i
    @FindBy (xpath = "//strong[3]")
    public WebElement sehirSayisiYaziElementi;

    // Admin panelinde menudeki Ülkeler (Countries) sayfasındaki Eyaletler (States) sekmesi locate'i
    @FindBy (xpath = "//*[text()=\"States\"]")
    public WebElement statesSekmesiElementi;

    // Admin panelinde menudeki Ülkeler (Countries) sayfasındaki Şehirler (Cities) sekmesi locate'i
    @FindBy (xpath = "//*[text()=\"Cities\"]")
    public WebElement citiesSekmesiElementi;

    // Admin panelinde menudeki Ülkeler (Countries) sayfasındaki Yeni Ülke (New Country) Button locate'i
    @FindBy (xpath = "//a[@class='btn btn-primary ms-auto']")
    public WebElement newCountryButtonElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Ülke (New Country) Eklemek için ülke adı kutusu locate'i
    @FindBy (xpath = "(//input[@class='form-control'])[2]")
    public WebElement countryNameBoxElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Ülke (New Country) kayıt (Save) elementi locate'i
    @FindBy (xpath = "(//button[@class='btn btn-primary m-0'])[1]")
    public WebElement saveCountryButtonElementi;

    // Eyaletler (States) sayfasındaki Yeni Eyalet (New State) Eklemek için Ülke seçme elementi locate'i
    @FindBy(xpath = "(//*[@class=\"form-select select2-hidden-accessible\"])[1]")
    public WebElement stateCountrySecmeElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Eyalet (New Satate) Eklemek için Eyalet adı kutusu locate'i
    @FindBy (xpath = "(//input[@class='form-control'])[2]")
    public WebElement stateNameBoxElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Eyalet (New State) Button locate'i
    @FindBy (xpath = "//a[@class=\"btn btn-primary ms-auto\"]")
    public WebElement newStateButtonElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Ülke (New Country) kayıt (Save) elementi locate'i
    @FindBy (xpath = "(//button[@class='btn btn-primary m-0'])[1]")
    public WebElement saveStateButtonElementi;

    // Yeni Eyalet (New State) Eklemdikten sonraki ilk State elementi locate'i
    @FindBy (xpath = "(//tbody/tr/td)[1]")
    public WebElement sonEklenenStateElementi;

    // Yeni Eyalet (New State) Eklemdikten sonraki ilk Country elementi locate'i
    @FindBy (xpath = "(//tbody/tr/td)[2]")
    public WebElement sonEklenenCountryElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Şehir (New City) Button locate'i
    @FindBy (xpath = "//*[@class=\"btn btn-primary ms-auto\"]")
    public WebElement newCityButtonElementi;

    // Ülkeler (Countries) sayfasında Yeni Şehir (New City) Eklemek için Şehir adı kutusu locate'i
    @FindBy (xpath = "(//input[@class='form-control'])[2]")
    public WebElement cityNameBoxElementi;

    // Yeni Eyalet (New State) Eklemdikten sonraki ilk State elementi locate'i
    @FindBy (xpath = "(//tbody/tr/td)[1]")
    public WebElement sonEklenenCityElementi;

    // Eyaletler (States) sayfasındaki Yeni Eyalet (New State) Eklemek için Ülke seçme elementi locate'i
    @FindBy(xpath = "(//*[@class=\"form-select select2-hidden-accessible\"])[1]")
    public WebElement cityStateSecmeElementi;

    // Ülkeler (Countries) sayfasındaki Yeni Ülke (New Country) kayıt (Save) elementi locate'i
    @FindBy (xpath = "(//button[@class='btn btn-primary m-0'])[1]")
    public WebElement saveCityButtonElementi;

    // Eyaletler (States) sayfasının altında sayfa numaraları locate'i
    @FindBy (xpath = "//*[@class='page-item active']")
    public WebElement eyaletSayfaSayisi;

    // Eyaletler (States) sayfasının altında sayfa numaraları locate'i
    @FindBy (xpath = "(//*[@class='page-link'])[8]")
    public WebElement sehirSayfaSayisi;

    // admin Coupon Codes sayfasi search textbox elementi
    @FindBy (xpath = "//input[@class='form-control ps-8']")
    public WebElement adminCouponSearchTextbox;

//KAAN
    // vcards edit elementleri


    // dashboard sayfasindeki vcard elementi
    @FindBy (xpath = "(//*[@class='aside-menu-title'])[2]")
    public WebElement vcardsElementi;

    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-pen-to-square'])[1]")
    public WebElement editIconElementi;

    @FindBy (xpath = "//*[text()='Edit VCard']")
    public WebElement editVcardsElementi;

    @FindBy(xpath = "//div[@class='d-flex flex-column flex-root vh-100']")
    public WebElement urlAliasElementi;

    @FindBy (xpath = "//input[@placeholder=\"Enter VCard Name\"]")
    public WebElement vcardsEditFirstNameElementi;

    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-pen'])[1]")
    public WebElement logoDegistirmeKalemElementi;

    @FindBy (xpath = "//div[@class='iti__selected-flag'][1]")
    public WebElement ulkeTlf1Elementi;

    @FindBy (xpath = "//div[@class='iti__selected-flag'][2]")
    public WebElement ulkeTlf2Elementi;

    @FindBy (xpath = "//*[@id='location_url']")
    public WebElement location_UrlElementi;

    @FindBy (xpath = "//*[@id=\"select2-default_language-container\"]")
    public WebElement defLanEngElementi;

    @FindBy (xpath = "(//span[@class='select2-selection__rendered'])[1]")
    public WebElement defLanTrElementi;

    @FindBy (xpath = "//*[@id=\"languageEnable\"]")
    public WebElement languageEnableElementi;

    @FindBy (xpath = "//*[@id=\"enableEnquiryForm\"]")
    public WebElement enableEnquiryFormElementi;

    @FindBy (xpath = "//input[@id='enableDownloadQrCode']")
    public WebElement enableDownloadQrCodeElementi;

    @FindBy (xpath = "//*[@class='form-range w-50 mx-2']")
    public WebElement qrCodeDownloadSizeElementi;

    @FindBy (xpath = "//input[@id='vcardSaveBtn']")
    public WebElement vcardSaveBtnElementi;

    @FindBy (xpath = "//*[@class='alert alert-success']")
    public WebElement vcardsEditSuccesfullSaveElementi;

    @FindBy (xpath = "//*[@class='btn btn-outline-primary float-end']")
    public WebElement vcardsEditBackElementi;

    @FindBy (xpath = "(//*[@class='mb-1 text-decoration-none fs-6'])[1]")
    public WebElement vcardNameElementi;

    @FindBy (xpath = "//*[@id=\"vcardUrl200\"]")
    public WebElement vcardPreviewElementi;

    @FindBy(xpath = "//h4[1]")
    public WebElement previewYenisayfaElementi;

    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-copy fs-2'])[1]")
    public WebElement previewUrlLinkiKopyalamaElementi;

    @FindBy (xpath = "//div[@class='toast-message']")
    public WebElement previewUrlLinkiKopyalamaSuccessElementi;

    @FindBy (xpath = "//*[@class='svg-inline--fa fa-chart-line fs-2']")
    public WebElement vcardsEditStatsElementi;

    @FindBy (xpath = "(//*[@fill='currentColor'])[18]")
    public WebElement vcardsEditQRCodeElementi;

    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-download'])[1]")
    public WebElement vcardsEditDownloadElementi;

    @FindBy (xpath = "(//*[@class='svg-inline--fa fa-clipboard-question'])[1]")
    public WebElement vcardsEnquiresElementi;

    @FindBy (xpath = "(//*[@fill='currentColor'])[21]")
    public WebElement vcardsCopyCardElementi;

    @FindBy (xpath = "(//*[@fill='currentColor'])[22]")
    public WebElement vcardsEditIconElementi;

    @FindBy (xpath = "(//*[@fill='currentColor'])[23]")
    public WebElement vcardsTrashElementi;

//murat
    //Front CMS elementleri


    // osman About Us locate
    @FindBy (xpath = "(//div[@class='mb-5'])[1]")
    public WebElement aboutUsTitle1Elementi;

    @FindBy (xpath = "(//div[@class='mb-5'])[2]")
    public WebElement aboutUsDescription1Elementi;

    @FindBy (xpath = "(//div[@class='mb-5'])[3]")
    public WebElement aboutUsTitle2Elementi;

    @FindBy (xpath = "(//div[@class='mb-5'])[4]")
    public WebElement aboutUsDescription2Elementi;

    @FindBy (xpath = "(//div[@class='mb-5'])[5]")
    public WebElement aboutUsTitle3Elementi;

    @FindBy (xpath = "(//div[@class='mb-5'])[6]")
    public WebElement aboutUsDescription3Elementi;



    //Admib Dashboard Front CMS Elementi
    @FindBy(xpath = "//span[text()='Front CMS']")
    public WebElement frontCmsElementi2;

    //Front CMS menüsü Subscribers elementi
    @FindBy (xpath = "//a[@href='https://qa.smartcardlink.com/sadmin/email-subscriptions']")
    public WebElement subscribersElementi;

    // Subscribers Görünürlük Sonuç Elementi
    @FindBy (xpath = "//strong[3]")
    public WebElement subscribersGorunurlukSonucElementi;

    //Action 1.satır 2.sutun elementi
    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    public WebElement actionSilmeElementi;





    //****** sadık

    //Subscribed User Plansda sayfasındaki search butonu
    @FindBy (xpath = "//input[@type='search']")
    public WebElement SubscribedPlanssearchButonu;

    //Subscribed User Plansda sayfasındakiSecilen kullanıcı için View butonu
    @FindBy (xpath = "(//a[@data-id='151'])[1]")
    public WebElement seciliViewElementi;

    //Subscribed User Plansda sayfasındaki Secilen kullanıcı için Edit butonu
    @FindBy (xpath = "(//a[@data-id='151'])[2]")
    public WebElement seciliEditElementi;

    //Subscribed User Plansda sayfasındaki End Date  kutusu
    @FindBy (xpath = "//input[@id='EndDate']")
    public WebElement EndDateKutusu;

    //Subscribed User Plansda sayfasındaki End Date'de yıl arttırma butonu
    @FindBy (xpath = "//span[@class='arrowUp']")
    public WebElement EndDateYilArttir;

    //Subscribed User Plansda sayfasındaki End Date  ay seçme
    @FindBy (xpath = "//select[@aria-label='Month']")
    public WebElement EndDateAySEC  ;

    //Subscribed User Plansda sayfasındaki End Date Gün seçme
    @FindBy (xpath = "(//span[@class='flatpickr-day'])[15]")
    public WebElement EndDateGun  ;

    //Kullanıcı yeni End Date kaydetme butonu
    @FindBy (xpath = "(//button[text()='Save'])[1]")  //button[@type='submit']
    public WebElement  EndDateSave  ;

    //Kullanıcı yeni End Date başarılı bir şekilde kaydedildi yazısı
    @FindBy (xpath = "//div[@class='toast-message']")
    public WebElement  DateDegistiSuccesfullyYazisi  ;






















    // admin Coupon Codes sayfasi ilk sıradaki coupon edit kalem butonu elementi
    @FindBy(xpath = "(//a[@class='btn px-1 text-info fs-3 edit-coupon-code'])[1]")
    public WebElement adminFirstCouponEditButton;

    // admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası couponName textbox elementi
    @FindBy(xpath ="//input[@id='editCouponName']")
    public WebElement adminEditCouponNameTextbox;

    // admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası save button elementi
    @FindBy(xpath = "//button[@id='editCouponCodeSaveBtn']")
    public WebElement adminEditCouponSaveButton;

    // admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası Status button elementi
    @FindBy(xpath = "//input[@id='editCouponStatus']")
    public WebElement adminEditCouponStatusButton;

    // admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası Status button elementi
    @FindBy(xpath = "//input[@id='couponStatus']")
    public WebElement adminAddCouponStatusButton;

    // admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası Expire At elementi (//input[@*='YYYY-MM-DD'])[2]
    @FindBy(xpath = "//input[@id='editCouponExpireAt']")
    public WebElement adminEditCouponExpireAt;

    // admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası Expire At deki rightArrow elementi
    @FindBy(xpath = "(//span[@class='flatpickr-next-month'])[2]")
    public WebElement adminEditCouponExpireAtRightArrow;

    //admin Coupon Codes sayfasi, edit kalem butonuna click yapılınca açılan edit sayfası Expire At deki gün elementi
    @FindBy(xpath = "(//span[@class='flatpickr-day'])[35]")
    public WebElement adminEditCouponCodesDay;

    //admin Coupon Codes sayfasi, add coupon codes deki  expireat  takviminde sonraki ayın ilk günü elementi
    @FindBy(xpath = "(//span[@*='flatpickr-day nextMonthDay'])[2]")
    public WebElement adminAddCouponCodesNextMountSecondDay;

    // admin Coupon Codes sayfasi ilk sıradaki coupon Delete butonu elementi
    @FindBy(xpath = "(//a[@class='btn px-1 text-danger fs-3 delete-coupon-code'])[1]")
    public WebElement adminFirstCouponDeleteButton;

    // admin Coupon Codes sayfasi  coupon Delete deki Confirm butonu elementi
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement adminCouponDeleteConfirmButton;

    // admin Coupon Codes sayfasi  coupon delet yapilinca Deleted yazisi  elementi
    @FindBy(xpath = "//div[@class='swal-title']")
    public WebElement adminCouponDeletedAlert;

    // admin Coupon Codes sayfasi  coupon delet yapilinca Deleted alert OK buton  elementi
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement adminCouponDeletedAlertOkButton;







    // KAHRAMAN
    @FindBy(xpath = "//a[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signinButtonElementi;
    @FindBy(name = "email")
    public WebElement emailKutusuElementi;
    //
    @FindBy(name = "password")
    public WebElement passwordKutusuElementi;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginElementi;

    @FindBy(xpath = "//*[@id='sidebar']/div[2]/ul/li[8]")
    public WebElement planlarElementi;

    @FindBy(xpath = "//*[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement planlarinSayisiElementi;

    @FindBy(xpath = "//*[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement paraBirimleriSayisi;

    @FindBy(xpath = "//*[@class='btn btn-primary ms-auto']")
    public WebElement yeniPlanElementi;
    @FindBy(xpath = "//*[@class='form-control select2-hidden-accessible']")
    public WebElement planSure;
    @FindBy(xpath = "(//div[@class='row'])[2]")
    public WebElement templeteElementi;

    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[1]")
    public WebElement templete1;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[2]")
    public WebElement templete2;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[3]")
    public WebElement templete3;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[4]")
    public WebElement templete4;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[5]")
    public WebElement templete5;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[6]")
    public WebElement templete6;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[7]")
    public WebElement templete7;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[8]")
    public WebElement templete8;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[9]")
    public WebElement templete9;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[10]")
    public WebElement templete10;
    @FindBy(xpath = "(//div[@class='col-lg-3 img-box mb-2'])[11]")
    public WebElement templete11;



    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBoxListesi;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement yeniPlanIsim;
    @FindBy(xpath = "//*[@class='form-control select2Selector select2-hidden-accessible']")
    public WebElement paraSecimi;
    @FindBy(xpath = "//*[@class='form-control price-format-input']")
    public WebElement fiyatGiris;
    @FindBy(xpath = "(//*[@class='form-control'])[3]")
    public WebElement vCardSayisi;
    @FindBy(xpath = "(//*[@class='form-control'])[4]")
    public WebElement denemeSuresi;
    @FindBy(xpath = "//*[@class='btn btn-primary me-3']")
    public WebElement kaydetbutonu;

    @FindBy(xpath="//*[@id='sidebar']/div[2]/ul/li[5]/a")
    public  WebElement sanalArkaPlan;

    @FindBy(xpath="//*[@id='sidebar']/div[2]/ul/li[12]")
    public  WebElement paraBirimleri;




    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[1]")
    public WebElement sanalKart1;
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[2]")
    public WebElement sanalKart2;
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[3]")
    public WebElement sanalKart3;
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[4]")
    public WebElement sanalKart4;
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[5]")
    public WebElement sanalKart5;
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[6]")
    public WebElement sanalKart6;
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[7]")
    public WebElement sanalKart7;
    @FindBy(xpath = "(//*[@class='flip-box-vertical col-lg-4 col-md-6 my-5'])[1]")
    public WebElement sanalKart8;
    @FindBy(xpath = "(//*[@class='flip-box-vertical col-lg-4 col-md-6 my-5'])[2]")
    public WebElement sanalKart9;
    @FindBy(xpath = "(//*[@class='flip-box-vertical col-lg-4 col-md-6 my-5'])[3]")
    public WebElement sanalKart10;
    @FindBy(xpath = "(//*[@class='flip-box-vertical col-lg-4 col-md-6 my-5'])[4]")
    public WebElement sanalKart11;
    @FindBy(xpath = "(//*[@class='flip-box-vertical col-lg-4 col-md-6 my-5'])[5]")
    public WebElement sanalKart12;
    @FindBy(xpath = "(//*[@class='flip-box-vertical col-lg-4 col-md-6 my-5'])[6]")
    public WebElement sanalKart13;


    @FindBy(xpath = "//*[@id='e-vcard-id']")
    public WebElement kayitliKartIsmi;
    @FindBy(xpath = "//*[@id='e-card-first-name']")
    public WebElement VkartIsim;
    @FindBy(xpath = "//*[@id='e-card-last-name']")
    public WebElement VkartSoyisim;
    @FindBy(xpath = "//*[@id='e-card-email']")
    public WebElement VkartEmail;
    @FindBy(xpath = "//*[@id='e-card-occupation']")
    public WebElement VkartMeslek;
    @FindBy(xpath = "//*[@id='e-card-location']")
    public WebElement VkartSehir;
    @FindBy(xpath = "//*[@id='e-card-website']")
    public WebElement VkartUrl;
    @FindBy(xpath = "//div[@role='combobox']")
    public  WebElement UlkeKombosuElementi;
    @FindBy(xpath = "//div[@class='iti__flag iti__tr']")
    public WebElement TurkiyeElementi;
    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement Telefon;
    @FindBy(xpath = "//*[@id='profileImageIcon']")
    public WebElement ProfilLogo;

    @FindBy(xpath = "//*[@class='btn btn-primary me-3']")
    public WebElement kaydet;
    @FindBy(xpath = "(//*[@class ='btn px-1 text-danger fs-3 plan-delete-btn'])[1]")
    public WebElement planSil;
    @FindBy(xpath = "//*[@class='swal-button swal-button--confirm']")
    public WebElement silmeOnay;


    //Kaan
    @FindBy(xpath = "//a[@class='vcard1-sticky-btn bars-btn d-flex justify-content-center text-white me-5 align-items-center rounded-0 px-5 mb-3 text-decoration-none py-1 rounded-pill justify-content-center']")
    public WebElement ikinciSayfaKartElementi;

    @FindBy (xpath = "//h1[text()='Vcard Analytic']")
    public WebElement vcardAnalyticYaziElementi;

    @FindBy (xpath = "//a[@class='btn btn-outline-primary']")
    public WebElement vcardAnalyticBackTusuElementi;

    @FindBy (xpath = "//input[@class='form-check-input vcardStatus']")
    public WebElement statusButonElementi;


    @FindBy (xpath = "//*[@class='mb-0']")
    public WebElement enquiriesYaziElementi;

    @FindBy (xpath = "//*[@class='btn btn-outline-primary']")
    public WebElement enquiriesYazibackElementi;


    @FindBy (xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement vcardEditDublicateYesButonuElementi;


    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[4]")
    public WebElement vcardEditYesdenSonraCikanOKElementi;


    @FindBy (xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement vcardEditTrashYesDeleteButonElementi;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[4]")
    public WebElement vcardEditTrashDeleteOKButonElementi;



    @FindBy (xpath = "(//span[@class='picker-edit rounded-circle text-gray-500 fs-small'])[2]")
    public WebElement coverLogoKalemElementi;

    @FindBy (xpath = "//*[@class='text-decoration-none fs-6']")
    public WebElement vcardPreviewUrlElementi;

    @FindBy(xpath = "//input[@class='form-control ms-1 vcard-url-alias']")
    public WebElement urlAliaselementi;








    //https://qa.smartcardlink.com/sadmin/users/366/edit  save butonu
    @FindBy(xpath = "//*[@class=\"btn btn-primary me-3\"]")
    public WebElement usersSaveButtonu;
    //https://qa.smartcardlink.com/sadmin/users user uptated succesfully. yazısı
    @FindBy (xpath = "//div[@role=\"alert\"]")
    public WebElement userUpdatedSuccesfullyYaziElementi;
   // https://qa.smartcardlink.com/sadmin/users  ilk kullanıcı isim elementi
    @FindBy(xpath = "(//*[@class=\"mb-1 text-decoration-none fs-6\"])[1]")
    public WebElement firstUserNameElementi;
    //https://qa.smartcardlink.com/sadmin/users   Showing to of results Elementi;
    @FindBy(xpath = "//*[@class=\"text-muted ms-sm-3 pagination-record\"]")
    public WebElement showing_to_of_resultsElementi;

    //https://qa.smartcardlink.com/sadmin/users  add user butonu
    @FindBy(xpath = "//*[@class=\"btn btn-primary ms-auto\"]")
    public WebElement addUserButonu;

    //https://qa.smartcardlink.com/sadmin/users isactive elementi
    @FindBy (xpath = "(//*[@name=\"is_active\"])[1]")
    public WebElement ilkIsActiveElementi;
    @FindBy (xpath = "//tbody")
    public WebElement kullaniciBilgileriWebTables;

   //https://qa.smartcardlink.com/sadmin/users/create  first name kutusu
    @FindBy (xpath = "//*[@placeholder=\"First Name\"]")
    public WebElement firstNameKutusuAddUser;

    //https://qa.smartcardlink.com/sadmin/users/create  save butonu
    @FindBy (xpath = "//*[@class=\"btn btn-primary me-3\"]")
    public WebElement saveButtonAddUser;

    //https://qa.smartcardlink.com/sadmin/users/
    @FindBy(xpath = "//*[@role=\"alert\"]")
    public WebElement userCreatedSuccesfullyAddUser;

    //https://qa.smartcardlink.com/sadmin/users/
    @FindBy (xpath = "(//*[@class=\"btn px-1 text-danger fs-3 user-delete-btn\"])[1]")
    public WebElement deleteUserButton;

    @FindBy (xpath = "//*[text()=\"Yes, Delete!\"]")
    public WebElement yesDeleteButton;

    @FindBy (xpath = "//tbody/tr[1]/td[1]")
    public WebElement sonEklenenUser;

    @FindBy (xpath = "//div[@class='toast-message']")
    public WebElement passwordUpdatedSuccesfully;
    @FindBy(xpath = "(//*[@title=\"Change Password\"])[1]")
    public WebElement passwordAnahtarElementi;
    @FindBy (xpath = "(//*[@class=\"form-control\"])[5]")
    public WebElement newPasswordkutusu;

    @FindBy(xpath = "(//*[@class=\"form-control\"])[6]")
    public WebElement confirmPasswordKutusu;

    @FindBy(xpath = "(//*[@class=\"btn btn-primary m-0\"])[3]")
    public WebElement saveButonuPassword;
    @FindBy (xpath = "//*[@id=\"profileImageIcon\"]")
    public WebElement profileImageIcon;
    @FindBy (xpath = "//*[@placeholder=\"Phone Number\"]")
    public WebElement phoneNumberProfile;



    ///BURHAN
    //Kayıtlı kullanici Dashboard sayfasi üstteki dashboard yazisi
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardYazisi;
    //Kayıtlı kullanici Dashboard sayfasi soldaki dashboard butonu
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[1]")
    public WebElement dashboardButon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki dashboard butonu ikonu
    @FindBy (xpath = "(//span[@class='aside-menu-icon pe-3'])[1]")
    public WebElement dashboardButonIkon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Vcards butonu
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[2]")
    public WebElement vcardsButon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Vcards butonu ikonu
    @FindBy (xpath = "(//span[@class='aside-menu-icon pe-3'])[2]")
    public WebElement vcardsButonIkon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Enquiries butonu
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[3]")
    public WebElement enquiriesButon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Enquiries butonu ikonu
    @FindBy (xpath = "(//span[@class='aside-menu-icon pe-3'])[3]")
    public WebElement enquiriesButonIkon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Appointments butonu
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[4]")
    public WebElement appointmentsButon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Appointments butonu ikonu
    @FindBy (xpath = "(//span[@class='aside-menu-icon pe-3'])[4]")
    public WebElement appointmentsButonIkon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Virtual Backgrounds butonu
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[5]")
    public WebElement virtualBackgroundsButon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Virtual Backgrounds butonu ikonu
    @FindBy (xpath = "(//span[@class='aside-menu-icon pe-3'])[5]")
    public WebElement virtualBackgroundsButonIkon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Settings butonu
    @FindBy (xpath = "(//span[@class='aside-menu-title'])[6]")
    public WebElement settingsButon;
    //Kayıtlı kullanici Dashboard sayfasi soldaki Settings butonu ikonu
    @FindBy (xpath = "(//span[@class='aside-menu-icon pe-3'])[6]")
    public WebElement settingsButonIkon;
    //Kayıtlı kullanici Dashboard sayfasi  Total Active VCards
    @FindBy (xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[1]")
    public WebElement totalActiveVCards;
    //Kayıtlı kullanici Dashboard sayfasi  Total DeActive VCards
    @FindBy (xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[2]")
    public WebElement totalDeActiveVCards;
    //Kayıtlı kullanici Dashboard sayfasi  Today Enquiries
    @FindBy (xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[3]")
    public WebElement todayEnquiries;
    //Kayıtlı kullanici Dashboard sayfasi  Today Appointments
    @FindBy (xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[4]")
    public WebElement todayAppointments;
    //Kayıtlı kullanici Dashboard sayfasi  Vcard Analytic yazisi
    @FindBy(xpath = "//h3[@class='mb-0']")
    public WebElement vcardAnalyticYazisi;
    //Kayıtlı kullanici Dashboard sayfasi  Grafik Degistirme Butonu
    @FindBy(xpath = "//button[@title='Switch Chart']")
    public WebElement grafikButon;
    //Kayıtlı kullanici Dashboard sayfasi Cizgi ve Sutun  Grafik Locate
    @FindBy (xpath = "//div[@id='dashboardWeeklyUserBarChartContainer']")
    public WebElement tabloGrafik;
    //Kayıtlı kullanici Dashboard sayfasi Takvim Butonu (tarih araligi seçme) Locate
    @FindBy (xpath = "//div[@id='dashboardTimeRange']")
    public WebElement dateButon;
    //Takvim butonu tıklandıktan sonra acilan This Week Butonu
    @FindBy(xpath = "//*[text()='This Week']")
    public WebElement dateThisWeekButon;
    //Takvim butonu tıklandıktan sonra acilan Last Week Butonu
    @FindBy(xpath = "//*[text()='Last Week']")
    public WebElement dateLastWeekButon;
    //Takvim butonu tıklandıktan sonra acilan Custom Butonu
    @FindBy(xpath = "//*[text()='Custom']")
    public WebElement dateCustomButon;
    //Takvim butonu tıklandıktan sonra acilan Cncel Butonu
    @FindBy(xpath = "//button[@class='cancelBtn btn btn-sm btn-default']")
    public WebElement dateCancelButon;
    //Takvim butonu tıklandıktan sonra acilan Apply Butonu
    @FindBy(xpath = "//button[@class='applyBtn btn btn-sm btn-primary']")
    public WebElement dateApplyButon;
    //Takvim butonu tıklandıktan sonra acilan seçili tarih araligi
    @FindBy(xpath = "//span[@class='drp-selected']")
    public WebElement dateSelected;
    //Takvim butonu tıklandıktan sonra acilan sol takvim tablosu
    @FindBy (xpath = "//div[@class='drp-calendar left']")
    public WebElement dateTableLeft;
    //Takvim butonu tıklandıktan sonra acilan sag takvim tablosu
    @FindBy (xpath = "//div[@class='drp-calendar right']")
    public WebElement dateTableRight;
    //Kayıtlı kullanici Dashboard sayfasi alt taraftaki Today Appointments yazisi
    @FindBy(xpath = "//div[@class='mt-3 mb-5']")
    public WebElement todayAppointmentsYazisi;
    //Kayıtlı kullanici Dashboard sayfasi alt taraftaki Today Appointments tablosundaki VCARD NAME yazisi
    @FindBy (xpath = "(//tr/th[1])[1]")
    public WebElement vcardNameYazisi;
    //Kayıtlı kullanici Dashboard sayfasi alt taraftaki Today Appointments tablosundaki NAME yazisi
    @FindBy (xpath = "(//tr/th[2])[1]")
    public WebElement nameYazisi;
    //Kayıtlı kullanici Dashboard sayfasi alt taraftaki Today Appointments tablosundaki PHONE yazisi
    @FindBy (xpath = "(//tr/th[3])[1]")
    public WebElement phoneYazisi;
    //Kayıtlı kullanici Dashboard sayfasi alt taraftaki Today Appointments tablosundaki EMAİL yazisi
    @FindBy (xpath = "(//tr/th[4])[1]")
    public WebElement emailYazisi;
    //Kayıtlı kullanici Dashboard sayfasi alt taraftaki Today Appointments tablosu TUM BİLGİLER LOCATE
    @FindBy (xpath = "//tbody[1]")
    public WebElement appointmentReport;
    // Enquiries sayfasi üstteki Enquiries yazisi
    @FindBy (xpath = "//div[@class='navbar-collapse']")
    public WebElement enquiriesYazisi;
    // Enquiries sayfasi tablodaki VCARD NAME butonu
    @FindBy (xpath = "//span[text()='VCard Name']")
    public  WebElement enquiriesVcardNameButon;
    // Enquiries sayfasi tablodaki  NAME butonu
    @FindBy (xpath = "//span[text()='Name']")
    public  WebElement enquiriesNameButon;
    // Enquiries sayfasi tablodaki EMAIL butonu
    @FindBy (xpath = "//span[text()='Email']")
    public  WebElement enquiriesEmailButon;
    // Enquiries sayfasi tablodaki PHONE yazisi
    @FindBy (xpath = "//tr/th[4]")
    public  WebElement enquiriesPhoneButon;
    // Enquiries sayfasi tablodaki CREATED ON butonu
    @FindBy (xpath = "//span[text()='Created on']")
    public  WebElement enquiriesCreatedOnButon;
    // Enquiries sayfasi tablodaki ACTION yazisi
    @FindBy (xpath = "//tr/th[6]")
    public  WebElement enquiriesActionYazisi;
    // Enquiries sayfasi tablodaki 1.satirdaki EYE (göz) İkonu
    @FindBy (xpath = "(//a[@class='btn px-1 text-info fs-3 enquiries-view-btn'])[1]")
    public WebElement enquiriesEyeIkon;
    // Enquiries sayfasi tablodaki 1.satirdaki Mesaj Bilgileri (Enquiry Details)
    @FindBy (xpath = "//h2[@class='modal-title']")
    public WebElement enquiriesDetails;
    // Enquiries sayfasi tablodaki 1.satirdaki Mesaj Bilgileri (Enquiry Details) close (X) ikonu
    @FindBy (xpath = "(//button[@class='btn-close'])[1]")
    public WebElement enquiriesDetailsClose;
    // Enquiries sayfasi tablodaki 1.satirdaki Delete (Çöp Kutusu) İkonu
    @FindBy(xpath = "(//a[@class='btn px-1 text-danger fs-3 enquiries-delete-btn'])[1]")
    public WebElement enquiriesDeleteIkon;
    // Enquiries sayfasi tablodaki 1.satirdaki Delete (Çöp Kutusu) İkonuna tikladiktan sonra çıkan Yes Delete Butonu
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement enquiriesYesDeleteButton;
    //Yes Delete Butonuna bastiktan sonraki Deleted Yazisi
    @FindBy (xpath = "//div[@class='swal-title']")
    public WebElement enquiriesDeleted;


}

