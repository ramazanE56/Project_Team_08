package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC04_US014 {

    /*
    Kullanıcının sisteme giriş yaptıktan sonra, şifresini değiştirebildiği doğrulanır.
    */

    @Test
    public void ChangePassword() {

        //Browser açılır ilgili site URL'i girilerek Anasayfaya erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı email bilgisi girilir.
        LoginPage loginPage =new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("user01Email"));

        //Password textbox'ına geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("user01Password"));

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();

        //Profil dropdown ikonuna click yapılır.
        smartcardlinkPage.succesSignInElement.click();

        //Açılan menüde Change Password'e click yapılır.
        smartcardlinkPage.changePasswordElementi.click();

        //Current Password textbox'ına click yapılır.
        smartcardlinkPage.currentPasswordElementi.click();

        //Mevcut geçerli password  textbox'a yazılır.
        smartcardlinkPage.currentPasswordElementi.sendKeys(ConfigReader.getProperty("user02Password"));

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

        //Password değiştiğine dair Success yazısı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.passwordChangeSuccessElementi.isDisplayed());

        // Sayfa kapatılır
        Driver.closeDriver();

    }
}
