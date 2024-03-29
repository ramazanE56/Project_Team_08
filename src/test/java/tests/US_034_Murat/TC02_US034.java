package tests.US_034_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02_US034 extends TestBaseRapor {


    @Test
    public void adminHaberAbonesiSilme(){

        extentTest = extentReports.createTest("Admin Haber Abonelerini Silme Testi",
                "Admin haber abonelerini silebilmelidir.");

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

        //Açılan sayfada Front CMS menüsüne click yapılır.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.frontCmsElementi2.click();
        extentTest.info("Açılan sayfada Front CMS menüsüne click yapılır.");

        ReusableMethods.wait(1);

        //Subscribers menüsüne click yapılır.
        aDashboardPage.subscribersElementi.click();
        extentTest.info("Subscribers menüsüne click yapılır.");

        //Adminin haber aboneleri için sil butonuna click yapabildiği doğrulanır.
        Assert.assertTrue( !(aDashboardPage.actionSilmeElementi.getText().isEmpty()) );
        aDashboardPage.actionSilmeElementi.click();
        extentTest.pass("Admin'in haber abonelerini silme butonuna click yapabildiği test edilir.");

        extentTest.info("Sayfa kapatılır.");

        // the end


    }
}
