package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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




    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement visitorDashboard;

    //Admin Dasboard sayfasında üstteki Dashboard yazısının locate'i
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardYaziElementi;

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

}

