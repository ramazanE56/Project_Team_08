package tests.US_020_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02_US020 extends TestBaseRapor {


    @Test
    public void abonelikPlanlariGoruntulemeTesti(){

        extentTest=extentReports.createTest(
                "Abonelik Planlarını Görüntüleme Testi",
                    "Admin olarak kullanıcılar bölümünde kayıtlı kullanıcıların " +
                              "abonelik planları görüntülenebilmelidir.");

        //Browser ile ilgili URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser ile ilgili URL'e gidilir.");

        //Sign in butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign in butonuna click yapılır.");

        //Email kutusuna kayıtlı admin email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna kayıtlı admin email bilgisi girilir.");

        //Password kutusuna geçerli admin password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna geçerli admin password bilgisi girilir.");

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        // Subscribed User Plans menusune click yapılır.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.subscribedUserPlansElementi.click();
        extentTest.info("Subscribed User Plans menusune click yapılır.");

        // Abonelik planları görüntüleme ikonuna click yapılır.
        aDashboardPage.SubscribedUserPlansViewElementi.click();
        ReusableMethods.wait(1);
        extentTest.info("Abonelik planları görüntüleme ikonuna click yapılır.");

        //Kullanıcıların abonelik planlarının görüntülenebidiği doğrulanır.
        Assert.assertTrue(aDashboardPage.SubscribedUserPlansTestElementi.isDisplayed());
        extentTest.pass("Kullanıcıların abonelik planlarının görüntülenebidiği test edilir.");

        extentTest.info("Sayfa kapatılır.");

    }
}
