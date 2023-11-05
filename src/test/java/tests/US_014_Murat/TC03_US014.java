package tests.US_014_Murat;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.TestBaseRapor;


public class TC03_US014 extends TestBaseRapor {

    @Test
    public void kullaniciDilDegistirmeTesti(){

    extentTest = extentReports.createTest
            ("Dil Ayarları Değişikliği Testi",
                    " Kullanıcı sisteme giriş yaptıktan sonra sitenin dil ayarlarını değiştirebilmelidir.");

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

    //Profil dropdown ikonuna click yapılır.
    smartcardlinkPage.succesSignInElement.click();
    extentTest.info("Profil dropdown ikonuna click yapılır.");

    // Açılan menüde Change Language'e click yapılır.
    smartcardlinkPage.changeLanguageElementi.click();
    extentTest.info("Açılan menüde Change Language'e click yapılır.");

    // Language textbox'ına click yapılır.
        Select select = new Select(smartcardlinkPage.languageTextBoxElementi);

        select.selectByIndex(8);
    // extentTest.info("Language textbox'ına click yapılır.");

    // Save butonuna click yapılır.
    smartcardlinkPage.languageSaveButtonElementi.click();
    extentTest.info("Save butonuna click yapılır.");


    // Dilin Türkçe olarak değiştiği test edilir.
        String expectedYazi = "Aboneliği Yönet";
        String actualYazi = smartcardlinkPage.dilDegisimOnayElementi.getText();
    Assert.assertTrue(actualYazi.equals(expectedYazi));
    extentTest.pass("Dilin Türkçe olarak değiştiği test edilir.");


    }

}
