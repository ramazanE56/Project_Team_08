package tests.US_030_Seref;

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

public class TC03_US30 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123
         */

    @Test
    public void sehirSayisiniGormeTesti() throws IOException {

        extentTest = extentReports.createTest("Şehir Sayısını Görme Testi", "Admin sitede kullanılan Şehir sayısını görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        ReusableMethods.wait(2);

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

        // Admin panelinde Dashboard menu listesindeki "Ülkeler" (Countries) ögesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.countriesElementi.click();
        extentTest.info("Dashboard menu listesindeki Ülkeler(Countries) ögesini tıklar");

        ReusableMethods.wait(2);

        // Ülkeler sayfasındaki "Şehirler" (Cities) sekmesini tıklayınız
        aDashboardPage.citiesSekmesiElementi.click();
        extentTest.info("Admin, Ülkeler sayfasındaki Şehirler (Cities) sekmesini tıklar");

        // Admin panelinde Şehirler (Cities) sayfasının en altına ininiz
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);

        aDashboardPage.sehirSayfaSayisi.click();

        ReusableMethods.wait(1);

        String SehirSayisi = aDashboardPage.sehirSayisiYaziElementi.getText();
        System.out.println("Şehir Sayısı :" + SehirSayisi);

        // Şehir (Cities) sayısının görüldüğünü test ediniz
        Assert.assertTrue(aDashboardPage.sehirSayisiYaziElementi.isDisplayed());
        extentTest.pass("Şehirler (Cities) sayısının görüldüğünü test eder");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);

        ReusableMethods.getScreenshot("Şehir (Cities) sayısının görüldüğü sayfa");
        extentTest.info("Şehir sayısının goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        // Browser'ı kapatımız.
        extentTest.info("sayfayi kapatir");
    }
}

