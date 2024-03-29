package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02_US014 extends TestBaseRapor {

    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;

      @Test(priority = -2)
       public void sifreSifirlama() {

        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("userEmail"));
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("changeNewPassword"));
        loginPage.loginElementi.click();

        smartcardlinkPage.succesSignInElement.click();
        smartcardlinkPage.changePasswordElementi.click();
        smartcardlinkPage.currentPasswordElementi.click();
        smartcardlinkPage.currentPasswordElementi.sendKeys(ConfigReader.getProperty("changeNewPassword"));
        smartcardlinkPage.newPasswordElementi.click();
        smartcardlinkPage.newPasswordElementi.sendKeys(ConfigReader.getProperty("userPassword"));
        smartcardlinkPage.confirmPasswordElementi.click();
        smartcardlinkPage.confirmPasswordElementi.sendKeys(ConfigReader.getProperty("userPassword"));
        smartcardlinkPage.passwordChangeSaveButonElementi.click();
        Driver.closeDriver();

    }

//(dependsOnMethods = "sifreSifirlama")
        @Test
        public void kullaniciSifreDegistirmeTesti () {

            extentTest = extentReports.createTest
                    ("Kullanıcı Şifre Değiştirme Testi",
                            "Kullanıcının sisteme giriş yaptıktan sonra, şifresini değiştirebildiği doğrulanır.");

            //Browser açılır ilgili site URL'i girilerek siteye erişilir.
            Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
            extentTest.info("Browser açılır ilgili site URL'i girilerek siteye erişilir.");

            //Sign In butonuna click yapılır.
            smartcardlinkPage = new SmartcardlinkPage();
            smartcardlinkPage.signinButtonElementi.click();
            extentTest.info("Sign In butonuna click yapılır.");

            //Email kutusuna kayıtlı email bilgisi girilir.
            loginPage = new LoginPage();
            loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("userEmail"));
            extentTest.info("Email kutusuna kayıtlı email bilgisi girilir.");

            //Password kutusuna geçerli password bilgisi girilir.
            loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("userPassword"));
            extentTest.info("Password kutusuna geçerli password bilgisi girilir.");

            //Login butonuna click yapılır.
            loginPage.loginElementi.click();
            extentTest.info("Login butonuna click yapılır.");

            //Profil dropdown ikonuna click yapılır.
            smartcardlinkPage.succesSignInElement.click();
            extentTest.info("Profil dropdown ikonuna click yapılır.");

            //Açılan menüde Change Password'e click yapılır.
            smartcardlinkPage.changePasswordElementi.click();
            extentTest.info("Açılan menüde Change Password'e click yapılır.");

            //Current Password kutusuna click yapılır.
            smartcardlinkPage.currentPasswordElementi.click();
            extentTest.info("Current Password kutusuna click yapılır.");

            //Mevcut geçerli şifre password  kutusuna yazılır.
            smartcardlinkPage.currentPasswordElementi.sendKeys(ConfigReader.getProperty("userPassword"));
            extentTest.info("Mevcut geçerli şifre password kutusuna yazılır.");

            //New Password kutusuna click yapılır.
            smartcardlinkPage.newPasswordElementi.click();
            extentTest.info("New Password kutusuna click yapılır.");

            //New password kutusuna yeni şifre yazılır.
            smartcardlinkPage.newPasswordElementi.sendKeys(ConfigReader.getProperty("changeNewPassword"));
            extentTest.info("New password kutusuna yeni şifre yazılır.");

            //Confirm Password kutusuna click yapılır.
            smartcardlinkPage.confirmPasswordElementi.click();
            extentTest.info("Confirm Password kutusuna click yapılır.");

            //Confirm Password kutusuna yeni şifre yazılır.
            smartcardlinkPage.confirmPasswordElementi.sendKeys(ConfigReader.getProperty("changeNewPassword"));
            extentTest.info("Confirm Password kutusuna yeni şifre yazılır.");

            //Save butonuna click yapılır.
            smartcardlinkPage.passwordChangeSaveButonElementi.click();
            extentTest.info("Save butonuna click yapılır.");

            //Password değiştiğine dair Success yazısı doğrulanır.
            Assert.assertTrue(smartcardlinkPage.passwordChangeSuccessElementi.isDisplayed());
            extentTest.pass("Password değiştiğine dair Success yazısı test edilir.");


            extentTest.info("Sayfa kapatılır.");

            // the end

        }
}
