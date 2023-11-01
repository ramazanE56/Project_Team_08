package tests.US_020_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC05_US020 extends TestBaseRapor {

    @Test
    public void hataliAdminGirisTesti() {

        extentTest = extentReports.createTest
                ("Hatalı Admin Giriş Testi",
                        "Admin hatalı kullanıcı adı ve geçerli şifreyle sisteme giris yapılamamalıdır.");

        //Browser ile ilgili URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser ile ilgili URL'e gidilir.");

        //Sign in butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign in butonuna click yapılır.");

        //Email kutusuna hatalı admin email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("wrongEmail"));
        extentTest.info("Email kutusuna hatalı admin email bilgisi girilir.");

        //Password kutusuna geçerli admin password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna geçerli admin password bilgisi girilir.");

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        //Hatalı admin ile giriş yapılamadığı test edilir.
        Assert.assertTrue(smartcardlinkPage.signInYaziElementi.isDisplayed());
        extentTest.pass("Hatalı admin ile giriş yapılamadığı test edilir.");

        extentTest.info("Sayfa kapatılır.");

    }
}
