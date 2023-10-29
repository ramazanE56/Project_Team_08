package pages;

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

}

