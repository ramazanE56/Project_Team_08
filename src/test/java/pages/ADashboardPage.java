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

    @FindBy(xpath = "//a[text()='Cash Payments']")
    public WebElement cashPaymentsYazisi;

    @FindBy (xpath = "//span[text()='Payable Amount']")
    public WebElement payableAmountYazisi;


    @FindBy(xpath ="//tbody" )
    public WebElement cashPaymentsListesi;

@FindBy (xpath = "//div[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement cashPaymentsSayisi;

@FindBy (xpath = "//span[text()='User Name']")
    public WebElement userNameYazisi;

@FindBy(xpath = "//span[text()='Plan Name']")
    public WebElement planNameYazisi;

    @FindBy(xpath = "//span[text()='Plan Price']")
    public WebElement planPriceYazisi;


@FindBy (xpath = "//span[text()='Start Date']")
    public WebElement startDateYazisi;

    @FindBy (xpath = "//span[text()='End Date']")
    public WebElement endDateYazisi;

    @FindBy (xpath = "//tr/th[7]")
    public WebElement attachmentYazisi;

    @FindBy (xpath = "//tr/th[8]")
    public WebElement notesYazisi;

    @FindBy (xpath = "//tr/th[9]")
    public WebElement statusYazisi;

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
    //https://qa.smartcardlink.com/sadmin/users edit(kalem) elementi
    @FindBy (xpath = "(//*[@class=\"svg-inline--fa fa-pen-to-square\"])[1]")
    public WebElement edit_kalem_elementi;

    //https://qa.smartcardlink.com/sadmin/users/366/edit first name kutusu
    @FindBy(xpath = "//*[@name=\"first_name\"]")
    public WebElement firstNameKutusuUsers;

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
}

