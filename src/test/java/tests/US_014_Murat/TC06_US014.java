package tests.US_014_Murat;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class TC06_US014 extends TestBaseRapor {


@Test
    public void changeLanguage(){

    extentTest = extentReports.createTest
            ("Dil Ayarları Değişikliği Testi",
                    " Kullanıcı sisteme giriş yaptıktan sonra sitenin dil ayarlarını değiştirebilmelidir.");

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

    // Açılan menüde Change Language'e click yapılır.
    smartcardlinkPage.changeLanguageElementi.click();

    // Language textbox'ına click yapılır.
    smartcardlinkPage.languageTextBoxElementi.click();
   // smartcardlinkPage.languageTextBoxElementi2.click();

    // İstenen language textbox'a yazılıp click yapılır.
    smartcardlinkPage.languageTextBoxElementi.sendKeys(ConfigReader.getProperty("language"));

    //smartcardlinkPage.englishLanguageElementi.click();

    // Save butonuna click yapılır.
    smartcardlinkPage.languageSaveButtonElementi.click();

    // Sağ üstte Succes yazısı görülür.

    //DEVAM EDİLECEK

    }

}