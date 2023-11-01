package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03_US014 extends TestBaseRapor {

    @Test
    public void gecersizSifreIleKullaniciGirisiTesti(){

        extentTest = extentReports.createTest
                ("Kayıtlı Email ve geçersiz password ile Giriş Testi",
                        " Sisteme kayıtlı bir email ve geçersiz bir password ile sisteme giriş yapılamamalıdır.");

        //Browser açılır ilgili site URL'i girilerek siteye erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser açılır ilgili site URL'i girilerek siteye erişilir.");

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In butonuna click yapılır.");

        //Email kutusuna kayıtlı email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("user01Email"));
        extentTest.info("Email kutusuna kayıtlı email bilgisi girilir.");

        //Password kutusuna geçersiz password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("invalidUserPassword"));
        extentTest.info("Password kutusuna geçersiz password bilgisi girilir.");

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        //Kullanıcı girişi yapılamadığı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.succesSignInElement.isDisplayed());
        extentTest.pass("Kullanıcı girişi yapılamadığı test edilir.");


        extentTest.info("Sayfa kapatılır.");

        // the end

    }
}
