package tests.US_023_Cengiz;

import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_03 {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;

    @Test
    public void cashPaymentsList() {

        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email kutusuna admin email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));

        //Password kutusuna  admin password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();

        //Admin Dashboard sayfasına giriş yapıldığı doğrulanır.

        aDashboardPage = new ADashboardPage();
        aDashboardPage.dashboardYaziElementi.isDisplayed();

        //Cash Payments butonun görünür olduğu doğrulanır
        aDashboardPage.cashPaymentsButton.isDisplayed();

        //Cash Payments butonu  tıklanır Cash Payments sayfasına giriş yapılır.
        aDashboardPage.cashPaymentsButton.click();

        //USER NAME basligi görüntülenir
        aDashboardPage.userNameYazisi.isDisplayed();

        //Yapılan manuel ödemelerin görüntülenebildiği test edilir

        aDashboardPage.cashPaymentsListesi.isDisplayed();

        System.out.println("Cash Payments 1. Sayfa Odeme Listesi\n"+ aDashboardPage.cashPaymentsListesi.getText());

        //Sayfa kapatilir
        Driver.closeDriver();
    }
}