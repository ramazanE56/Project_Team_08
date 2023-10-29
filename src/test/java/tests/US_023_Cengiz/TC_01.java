package tests.US_023_Cengiz;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01 {

    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;


    @Test
    public void cashPaymentUrl(){

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

        //Cash Payments sayfası URL'si (https://qa.smartcardlink.com/sadmin/cashPayments) doğrulanır

        String expectedCashPayUrl="https://qa.smartcardlink.com/sadmin/cashPayments";
        String actualCashPayUrl= Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualCashPayUrl,expectedCashPayUrl);

        //Sayfa kapatilir
        Driver.closeDriver();







    }
}
