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
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {

    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;


    @Test
    public void cashPaymentUrl (){

        extentTest=extentReports.createTest("Admin bilgileri ile Cash Payments sayfasına  Giriş ",
                "Cash Payments sayfası URL'sinin https://qa.smartcardlink.com/sadmin/cashPayments oldugu doğrulanmali");

        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna admin email adresi giriniz
        loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));
        extentTest.info("Email kutusuna admin email adresi girilir");

        //Password kutusuna  admin password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna admin password girilir");

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Admin Dashboard sayfasına giriş yapıldığı doğrulanır.

        aDashboardPage=new ADashboardPage();

        Assert.assertTrue(aDashboardPage.dashboardYaziElementi.isDisplayed());
        extentTest.pass("Giriş yapildigini doğrulanir");

        //Cash Payments butonun görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.cashPaymentsButton.isDisplayed());
        extentTest.pass("Cash Payments butonun görünür olduğu doğrulanır");

        //Cash Payments butonu  tıklanır
        aDashboardPage.cashPaymentsButton.click();
        extentTest.info("Cash Payments butonu  tıklanır");

        //Cash Payments sayfası URL'si (https://qa.smartcardlink.com/sadmin/cashPayments) doğrulanır

        String expectedCashPayUrl="https://qa.smartcardlink.com/sadmin/cashPayments";
        String actualCashPayUrl= Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualCashPayUrl,expectedCashPayUrl);
        extentTest.pass("Cash Payments sayfası URL'si (https://qa.smartcardlink.com/sadmin/cashPayments) doğrulanır");

        //Sayfa kapatilir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");







    }
}
