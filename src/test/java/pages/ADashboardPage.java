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

    //Admin Dasboard sayfasında menudeki "Affiliate Users" yazısının locate'i
    @FindBy (xpath = "//*[@id=\"sidebar\"]/div[2]/ul/li[9]/a/span[2]")
    public WebElement affiliateUsersYaziElementi;

 }

