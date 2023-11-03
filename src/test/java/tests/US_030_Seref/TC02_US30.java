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

public class TC02_US30 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123
         */

    @Test
    public void eyaletSayisiniGormeTesti() throws IOException {

        extentTest = extentReports.createTest("Eyalet Sayısını Görme Testi", "Admin sitede kullanılan Eyalet sayısını görmeli");

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

        ReusableMethods.wait(1);

        // Ülkeler sayfasındaki "Eyaletler" (States) sekmesini tıklayınız
        aDashboardPage.statesSekmesiElementi.click();
        extentTest.info("Admin, Ülkeler sayfasındaki Eyaletler (States) sekmesini tıklar");

        // Admin panelinde Eyaletler (States) sayfasının en altına ininiz
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(2);

        aDashboardPage.eyaletSayfaSayisi.click();

        ReusableMethods.wait(2);

        String EyaletSayisi = aDashboardPage.eyaletSayisiYaziElementi.getText();
        System.out.println("Eyalet Sayısı :" + EyaletSayisi);

        // Eyalet (States) sayısının görüldüğünü test ediniz
        Assert.assertTrue(aDashboardPage.eyaletSayisiYaziElementi.isDisplayed());
        extentTest.pass("Eyalet (States) sayısının görüldüğünü test eder");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.getScreenshot("Eyalet (States) sayısının görüldüğü sayfa");
        extentTest.info("Eyalet sayısının goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        // Browser'ı kapatımız.
        extentTest.info("sayfayi kapatir");
    }
}

