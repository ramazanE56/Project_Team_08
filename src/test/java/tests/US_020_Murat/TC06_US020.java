package tests.US_020_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC06_US020 extends TestBaseRapor {

    @Test
    public void adminYetkisizAbonelikPlanlariGoruntulenmesi(){

    extentTest = extentReports.createTest
            ("Admin Yetkisiz Kullanıcının Abonelik Planlarını Görüntülemesi Testi",
            "Admin yetkisi olmayan bir kullanıcı abonelik planlarını görüntüleyememelidir.");

    //Browser ile ilgili URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser ile ilgili URL'e gidilir.");

    //Sign in butonuna click yapılır.
    SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign in butonuna click yapılır.");

    //Email kutusuna kayıtlı kullanıcı email bilgisi girilir.
    LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna kayıtlı admin email bilgisi girilir.");

    //Password kutusuna geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty(""));
        extentTest.info("Password kutusuna geçersiz admin password bilgisi girilir.");

    //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");



        extentTest.info("Sayfa kapatılır.");


        // DEVAM ET
}
}
