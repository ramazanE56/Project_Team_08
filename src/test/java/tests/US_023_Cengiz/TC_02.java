package tests.US_023_Cengiz;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TC_02 {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;
    @Test
    public void cashPaymentsTableElements(){

        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email kutusuna admin email adresi giriniz
        loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));

        //Password kutusuna  admin password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();

        //Admin Dashboard sayfasına giriş yapıldığı doğrulanır.

        aDashboardPage=new ADashboardPage();
        aDashboardPage.dashboardYaziElementi.isDisplayed();

        //Cash Payments butonun görünür olduğu doğrulanır
        aDashboardPage.cashPaymentsButton.isDisplayed();

        //Cash Payments butonu  tıklanır Cash Payments sayfasına giriş yapılır.
        aDashboardPage.cashPaymentsButton.click();

        //Cash Payments yazisi görüntülenir
        aDashboardPage.cashPaymentsYazisi.isDisplayed();

        //USER NAME basligi görüntülenir
        aDashboardPage.userNameYazisi.isDisplayed();

        //PLAN NAME basligi görüntülenir
        aDashboardPage.planNameYazisi.isDisplayed();

        //PLAN PRICE basligi görüntülenir
        aDashboardPage.planPriceYazisi.isDisplayed();

        //PAYABLE AMOUNT basligi görüntülenir
        aDashboardPage.payableAmountYazisi.isDisplayed();

        //START DATE basligi görüntülenir
        aDashboardPage.startDateYazisi.isDisplayed();

        //END DATE basligi görüntülenir
        aDashboardPage.endDateYazisi.isDisplayed();

        //ATTACHMENT basligi görüntülenir
        aDashboardPage.attachmentYazisi.isDisplayed();

        //NOTES basligi görüntülenir
        aDashboardPage.notesYazisi.isDisplayed();

        //STATUS basligi görüntülenir
        aDashboardPage.statusYazisi.isDisplayed();

        //Sirala butonu(Asagi-yukari oklari) görüntülenir
        aDashboardPage.siralamaButonu.isDisplayed();


        //Sayfa kapatilir
        Driver.closeDriver();


    }
}
