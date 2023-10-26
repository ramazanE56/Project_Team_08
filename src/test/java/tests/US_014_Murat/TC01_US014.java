package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01_US014 {

    /*
    Sisteme kayitli datalarla, basarili bir sekilde giris yapilabildigi dogrulanir.
     */

    @Test
    public void UserSignIn() {

        //Browser açılır ilgili site URL'i girilerek Anasayfaya erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı email bilgisi girilir.
        LoginPage loginPage =new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("user01Email"));

        //Password textbox'ına geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("user01Password"));

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();

        //Başarılı bir şekilde kullanıcı girişi yapıldığı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.succesSignInElement.isDisplayed());

        //Sayfa kapatılır.
        Driver.closeDriver();


    }
}
