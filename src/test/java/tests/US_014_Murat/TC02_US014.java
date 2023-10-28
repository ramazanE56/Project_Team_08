package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02_US014 extends TestBaseRapor {


    @Test
    public void invalidUserEmailSignIn(){

        extentTest = extentReports.createTest
                ("Kayıtlı Olmayan Email ile Giriş Testi",
                        " Sisteme kayıtlı olmayan bir email ile sisteme giriş yapılamamalıdır.");

        // Browser açılır ilgili site URL'i girilerek siteye erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser açılır ilgili site URL'i girilerek siteye erişilir.");

        // Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In butonuna click yapılır.");

        // Email kutusuna sisteme kayıtlı olmayan bir email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("invalidUserEmail"));
        extentTest.info("Email kutusuna sisteme kayıtlı olmayan bir email bilgisi girilir.");

        // Password kutusuna geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys("user01Password");
        extentTest.info("Password kutusuna geçerli password bilgisi girilir.");

        // Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        // Sisteme kullanıcı girişi yapılamadığı doğrulanır.
        Assert.assertTrue(loginPage.notSignInElementi.isDisplayed());
        extentTest.pass("Sisteme kullanıcı girişi yapılamadığı test edilir.");

      // the end

    }
}
