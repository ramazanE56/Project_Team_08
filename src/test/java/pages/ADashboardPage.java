package pages;


import com.sun.jna.Structure;
import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

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




    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement visitorDashboard;

    //Admin Dasboard sayfasında üstteki Dashboard yazısının locate'i
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardYaziElementi;


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

    //Osman Admin Dasboard sayfasında Front CMS  sekmesinin locateler'i
    @FindBy(xpath = "//*[@ class ='nav-item active']")
    public WebElement frontCmsElementi;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement frontCmsTitleElementi;

    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement frontCmsSubTitleElementi;

    @FindBy(xpath = "//a[@href='https://qa.smartcardlink.com/sadmin/features']")
    public WebElement frontCmsFeaturesElementi;

    @FindBy(xpath = "//*[@*='col-12 text-muted pagination-record ms-sm-3']")
    public WebElement frontCmsFeaturesYaziElementi;

    @FindBy(xpath = "//a[@href='https://qa.smartcardlink.com/sadmin/about-us']")
    public WebElement frontCmsAboutUsElementi;



}

