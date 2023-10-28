package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC05_US014 extends TestBaseRapor {


    @Test
    public void notChangePassword(){

        extentTest = extentReports.createTest
                ("Hatalı Şifre ile Şifre Değişikliği Testi",
                        "Kullanıcı sisteme giriş yaptıktan sonra, hatalı şifre ile şifresini değiştirememelidir.");

        //Browser açılır ilgili site URL'i girilerek Anasayfaya erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser açılır ilgili site URL'i girilerek Anasayfaya erişilir.");

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In butonuna click yapılır.");

        //Email kutusuna kayıtlı email bilgisi girilir.
        LoginPage loginPage =new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("user01Email"));
        extentTest.info("Email textbox'ına kayıtlı email bilgisi girilir.");

        //Password kutusuna geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("user01Password"));
        extentTest.info("Password textbox'ına geçerli password bilgisi girilir.");

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        //Profil dropdown ikonuna click yapılır.
        smartcardlinkPage.succesSignInElement.click();
        //Açılan menüde Change Password'e click yapılır.
        smartcardlinkPage.changePasswordElementi.click();
        //Current Password textbox'ına click yapılır.
        smartcardlinkPage.currentPasswordElementi.click();

        //Geçersiz password textbox'a yazılır.
        smartcardlinkPage.currentPasswordElementi.sendKeys(ConfigReader.getProperty("notUserPassword"));

        //New Password textbox'ına click yapılır.
        smartcardlinkPage.newPasswordElementi.click();
        //New password textbox'a yazılır.
        smartcardlinkPage.newPasswordElementi.sendKeys(ConfigReader.getProperty("changeNewPassword"));
        //Confirm Password textbox'ına click yapılır.
        smartcardlinkPage.confirmPasswordElementi.click();
        //New password textbox'a yazılır.
        smartcardlinkPage.confirmPasswordElementi.sendKeys(ConfigReader.getProperty("changeNewPassword"));
        //Save butonuna click yapılır.
        smartcardlinkPage.passwordChangeSaveButonElementi.click();
        ReusableMethods.wait(2);

        // Password değişmediğine dair Error yazısı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.passwordChangeErrorElementi.isDisplayed());

        // Sayfa kapatılır.
        Driver.closeDriver();

    }
}
