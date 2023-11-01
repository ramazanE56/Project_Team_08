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


}

