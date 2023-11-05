package tests.US_014_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC04_US014 extends TestBaseRapor {


    @Test
    public void kullaniciCikisTesti(){

        extentTest = extentReports.createTest
                ("Kullanıcı Sistemden Çıkış Testi",
                        "Sisteme giriş yaptıktan sonra kullanıcı sistemden çıkış yapabilmelidir.");

        //Browser açılır, ilgili site URL'i girilerek siteye erişilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser açılır, ilgili site URL'i girilerek siteye erişilir.");

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

        //Profil dropdown ikonuna click yapılır.
        smartcardlinkPage.succesSignInElement.click();
        extentTest.info("Profil dropdown ikonuna click yapılır.");

        ReusableMethods.wait(1);

       // sign out elementine click yapılır.
        smartcardlinkPage.signOutElementi.click();
        extentTest.info("sign out elementine click yapılır.");

        //Sistemden çıkış yaptığı doğrulanır.
       Assert.assertTrue(smartcardlinkPage.signInYaziElementi.isDisplayed());
       extentTest.pass("Sistemden çıkış yaptığı test edilir");

       extentTest.info("Sayfa kapatılır.");

        // the end

    }
}
