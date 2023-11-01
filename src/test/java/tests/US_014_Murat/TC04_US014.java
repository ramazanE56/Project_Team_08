package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC04_US014 extends TestBaseRapor {

    @Test
    public void kullaniciSifreDegistirmeTesti() {

        extentTest = extentReports.createTest
                ("Kullanıcı Şifre Değiştirme Testi",
                        "Kullanıcının sisteme giriş yaptıktan sonra, şifresini değiştirebildiği doğrulanır.");

        //Browser açılır ilgili site URL'i girilerek siteye erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser açılır ilgili site URL'i girilerek siteye erişilir.");

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In butonuna click yapılır.");

        //Email kutusuna kayıtlı email bilgisi girilir.
        LoginPage loginPage =new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("user01Email"));
        extentTest.info("Email kutusuna kayıtlı email bilgisi girilir.");

        //Password kutusuna geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("user01Password"));
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
        smartcardlinkPage.currentPasswordElementi.sendKeys(ConfigReader.getProperty("user02Password"));
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
