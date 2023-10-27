package tests.US_014_Murat;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;


public class TC06_US014 {
    /*
    Kullanıcı sisteme giriş yaptıktan sonra,
    sitenin dil ayarlarını değiştirebildiği doğrulanır.
     */

@Test
    public void changeLanguage(){

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

}
}
