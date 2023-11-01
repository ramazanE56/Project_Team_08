package tests.US_27_Cengiz;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_02 extends TestBaseRapor {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;


    @Test
    public void affiliationTransactionsAmount() throws IOException {

        extentTest = extentReports.createTest("Admin bilgileri ile Affiliation Transactions bilgilerine ulasilir ",
                "Affiliation Transactions sayfası ortaklik tutari bilgilerinin görüntülenebildigi doğrulanmali");

        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna admin email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));
        extentTest.info("Email kutusuna admin email adresi girilir");

        //Password kutusuna  admin password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna admin password girilir");

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Admin Dashboard sayfasına giriş yapıldığı doğrulanır.

        aDashboardPage = new ADashboardPage();

        Assert.assertTrue(aDashboardPage.dashboardYaziElementi.isDisplayed());
        extentTest.pass("Giriş yapildigini dogrulanir");

        //Affiliation Transactions butonun görünür olduğu doğrulanr


        Assert.assertTrue(aDashboardPage.affiliationTransactionsButton.isDisplayed());
        extentTest.pass("Affiliation Transactions butonun gorunur oldugu dogrulanir");

        //Affiliation Transactions butonu  tıklanır
        aDashboardPage.affiliationTransactionsButton.click();
        extentTest.info("Affiliation Transactions butonu  tiklanir");

        ReusableMethods.wait(1);

        //Ortaklık kullanıcıları sayfasi  Affiliation Transactions tablosunun görünür olduğu doğrulanir
        Assert.assertTrue(aDashboardPage.affiliationTransactionsTumTablo.isDisplayed());
        extentTest.pass("Ortaklik tablosundaki tum görüntülenebildigi dogrulanir");


        //Amount yazisinin görüntülenebildigi dogrulanir.
        Assert.assertTrue(aDashboardPage.amountYazisi.isDisplayed());
        extentTest.pass("Amount yazisinin gorunur oldugu dogrulanir");

        //Ortaklık tutarlarinin görüntülenebildiği doğrulanır.
        Assert.assertTrue(aDashboardPage.affiliationTransactionsAmount.isDisplayed());
        extentTest.pass("Ortaklik tutarlarinin görüntülenebildigi dogrulanir");

        //Ortaklik tutarlarinin fotoğrafi cekilir
        ReusableMethods.getScreenshot("Ortaklik tutarlarinin");
        extentTest.info("Ortaklik tutarlarinin fotoğrafi cekilir");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");

    }
    }
