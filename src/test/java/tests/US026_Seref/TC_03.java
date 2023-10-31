package tests.US026_Seref;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_03 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123
         */

    @Test
    public void BagliKullanicilar() throws IOException {

        extentTest = extentReports.createTest("Kullanıcıların ortaklık tutarlarının görünür oldugu Testi", "Admin panelde kayıtlı kullanıcıların ortaklık tutarlarını görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tıklar");

        //Admin email ve Password bilgilerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        loginPage.loginElementi.click();
        extentTest.info("Admin email ve Password bilgilerini girip Login butonuna tıklar");

        // ADashboard menu listesindeki "ortaklık llanıcıları"(Affiliate Users) sekmesinin tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.bagliKullanicilarYaziElementi.click();
        extentTest.info("ADashboard menu listesindeki Ortaklık Kullanıcıları (Affiliate Users) sekmesinin tıklar");

        // Kaydedilen kullanıcıların ortaklık tutarının görünür olduğunu test ediniz
        Assert.assertTrue(aDashboardPage.sonuclariGormeYaziElementi.isDisplayed());
        extentTest.pass("Kaydedilen kullanıcıların ortaklık tutarının görünür olduğunu test eder");


        ReusableMethods.wait(3);

        ReusableMethods.getScreenshot("Kullanıcı Ortaklık Tutarları Listesi");
        extentTest.info("Kaydedilen kullanıcıların Ortaklık Tutarlarının goruldugu sayfanın fotografini ceker");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");

    }

}