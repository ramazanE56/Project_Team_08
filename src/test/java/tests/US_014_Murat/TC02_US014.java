package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC02_US014 {

    /*
        URL= https://qa.smartcardlink.com
        NotUser email = NotUserMail@wq.com
        User01 password = Password.01
     */

    @Test
    public void notUserEmailSignIn(){

        // Browser açılır ilgili site URL'i girilerek Anasayfaya erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        // Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        // Email textbox'ına sisteme kayıtlı olmayan bir email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("notUserEmail"));

        // Password textbox'ına geçerli password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys("user01Password");

        // Login butonuna click yapılır.
        loginPage.loginElementi.click();

        // Sisteme kullanıcı girişi yapılamadığı doğrulanır.
        Assert.assertTrue(loginPage.notSignInElementi.isDisplayed());

        //Sayfa kapatılır.
        Driver.closeDriver();

    }


}
