package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC01_US014 extends TestBaseRapor {

    @Test
    public void kullaniciGirisTesti() {

        extentTest = extentReports.createTest
                ("Kullanıcı Hesabına Giriş",
                        "Sisteme kayıtlı datalarla, başarılı bir sekilde  sisteme giriş yapılabilmelidir.");

        //Browser açılır ilgili site URL'i girilerek siteye erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser açılır ilgili site URL'i girilerek siteye erişilir.");

        //Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
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

        //Başarılı bir şekilde kullanıcı girişi yapıldığı doğrulanır.
        Assert.assertTrue(smartcardlinkPage.succesSignInElement.isDisplayed());
        extentTest.pass("Başarılı bir şekilde kullanıcı girişi yapılabildiği test edilir.");

        extentTest.info("Sayfa kapatılır.");

        // the end
    }
}
