package tests.US_026_Seref;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

import java.io.IOException;

public class TC02_US26 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123
         */

    @Test
    public void KayitliKullanicilarTesti() throws IOException {

        extentTest = extentReports.createTest("Kaydedilen Kullanıcıları (User) Görme Testi", "Admin, Affiliate Users sayfasında 'Kaydedilen Kullanıcıları' (User) görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        ReusableMethods.wait(1);

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signInButtonElementi.click();
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

        // Admin panelinde Dashboard menu listesindeki "Ortaklık Kullanıcıları" (Affiliate Users) sekmesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.affiliateUsersElementi.click();
        extentTest.info("Dashboard menu listesindeki Ortaklık Kullanıcıları(Affiliate Users) sekmesini tıklar");

        // Kaydedilen Kullanıcıların (User) görüldüğünü test ediniz
        Assert.assertTrue(aDashboardPage.userYaziElementi.isDisplayed());
        extentTest.pass("Kaydedilen Kullanıcıların (User) görüldüğünü test eder");

        ReusableMethods.getScreenshot("Kaydedilen Kullanıcılar (User) Listesi");
        extentTest.info("Affiliate Users sayfasında Kaydedilen Kullanıcıların (User) goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        extentTest.info("sayfayi kapatir");
    }
}

