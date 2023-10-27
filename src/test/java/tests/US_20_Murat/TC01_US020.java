package tests.US_20_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01_US020 {
    /*
    Sisteme kayitli  Admin kullanıcı adı ve şifresiyle basarili bir sekilde giris yapilabildigi dogrulanir.
     */

    @Test
    public void adminLogin(){

        //Browser ile ilgili URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign in butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email textbox'ına kayıtlı admin email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

        //Password textbox'ına geçerli admin password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();

        //Başarılı bir şekilde kullanıcı girişi yapıldığı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.succesSignInElement.isDisplayed());


    }
}
