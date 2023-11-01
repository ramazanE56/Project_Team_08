package tests.US_020_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC04_US020 extends TestBaseRapor {

    @Test
    public void adminGecersizPaswordGirisTesti() {

        extentTest = extentReports.createTest
                ("Admin Geçersiz Password Testi",
                        "Sisteme kayıtlı  admin kullanıcı adı ve geçersiz şifreyle giriş yapılamamalıdır.");

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

        //Password kutusuna geçersiz admin password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("wrongPassword"));
        extentTest.info("Password kutusuna geçersiz admin password bilgisi girilir.");

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        //Geçersiz password ile giriş yapılamadığı test edilir.
        Assert.assertTrue(smartcardlinkPage.signInYaziElementi.isDisplayed());
        extentTest.pass("Geçersiz password ile giriş yapılamadığı test edilir.");

        extentTest.info("Sayfa kapatılır.");

    }
}