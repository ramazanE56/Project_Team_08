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

public class TC01_US30 extends TestBaseRapor {

        /*
        URL= https://qa.smartcardlink.com
        Admin email1 = admin22@smartcardlink.com
        Admin email2 = admin23@smartcardlink.com
        Admin email3 = admin24@smartcardlink.com
        Admin password = 123123123
        */

    @Test
    public void ulkeSayisiniGormeTesti() throws IOException {

        extentTest = extentReports.createTest("Ulke Sayısını Görme Testi", "Admin panelde kullanılan Ulke Sayısını görmeli");

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

        // Admin panelinde Ülkeler (Countries) menu ögesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.countriesElementi.click();
        extentTest.info("Dashboard menu listesindeki Ulkeler ögesini tıklar");

        ReusableMethods.wait(1);

        // Admin panelinde Ülkeler (Countries) sayfasında Ulkeler (Countries) sekmesini tıklayınız
        aDashboardPage.countriesSekmesiElementi.click();
        extentTest.info("Dashboard menu listesindeki Ulkeler sekmesini tıklar");

        // Admin panelinde Ülkeler (Countries) sayfasının en altına ininiz
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String UlkeSayisi = aDashboardPage.ulkeSayisiYaziElementi.getText();
        System.out.println("Ülke Sayısı :" + UlkeSayisi);

        // Admin panelinde ülke sayısının görünür olduğunu test ediniz.
        Assert.assertTrue(aDashboardPage.ulkeSayisiYaziElementi.isDisplayed());
        extentTest.pass("Admin panelinde ülke sayısının görüldüğünü test eder");

        ReusableMethods.getScreenshot("Ülke sayısı sayfası");
        extentTest.info("Ülke sayısının goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        // Browser'ı kapatımız.

        extentTest.info("sayfayi kapatir");

    }

}


