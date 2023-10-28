package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01_US014 extends TestBaseRapor {


    @Test
    public void UserSignIn() {

        extentTest = extentReports.createTest
                ("Kullanıcı Hesap Girişi",
                        "Sisteme kayıtlı datalarla, başarılı bir sekilde  sisteme giriş yapılabilmelidir.");

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

        //Başarılı bir şekilde kullanıcı girişi yapıldığı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.succesSignInElement.isDisplayed());
        extentTest.pass("Başarılı bir şekilde kullanıcı girişi yapılabildiği test edilir.");

        //Sayfa kapatılır.
        Driver.closeDriver();
        extentTest.info("Sayfa kapatılır.");


    }
}
