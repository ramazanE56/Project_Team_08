package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03_US014 {

    /*
        URL= https://qa.smartcardlink.com
        User01 email = UserEmail01@wq.com
        NotUser Password = 123456
     */

    @Test
    public void notUserPasswordSignIn(){

        //Browser açılır ilgili site URL'i girilerek Anasayfaya erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("user01Email"));

        //Password textbox'ına geçersiz password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("notUserPassword"));

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();

        //Kullanıcı girişi yapılamadığı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.succesSignInElement.isDisplayed());

        //Sayfa kapatılır.
        Driver.closeDriver();


       // Password textbox'ına geçersiz password bilgisi girilir.
       // Login butonuna click yapılır.
       // Sisteme kullanıcı girişi yapılamadığı doğrulanır."

    }
}
