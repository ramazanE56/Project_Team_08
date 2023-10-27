package tests.US_014_Murat;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC07_US014 {

    /*
    Sisteme giriş yaptıktan sonra kullanıcının sistemden çıkışı yapabildiği doğrulanır.
     */

    @Test
    public void SignOut(){

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
    }

}
