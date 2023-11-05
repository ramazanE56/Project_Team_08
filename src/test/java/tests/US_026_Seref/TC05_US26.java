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

public class TC05_US26 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123         */

    @Test
    public void OrtaklikOnayDurumuTesti() throws IOException {

        extentTest = extentReports.createTest("Ortaklık Onay Durumunu (Approval Status) Görme Testi", "Admin, Affiliation Transactions sayfasında 'Onay Durmununu' (Approval Status) görmeli");

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

        // Admin panelinde Dashboard menu listesindeki "Uyelik İslemleri" (Affiliation Transactions) sekmesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.affiliationTransactionsElementi.click();
        extentTest.info("Dashboard menu listesindeki Uyelik İslemleri (Affiliation Transactions) sekmesini tıklar");

        // Ortaklık Onay Durumunun (Approval Status) görüldüğünü test ediniz
        Assert.assertTrue(aDashboardPage.approvalStatusYaziElementi.isDisplayed());
        extentTest.pass("Ortaklık Onay Durumunun (Approval Status) görüldüğünü test eder");

        ReusableMethods.getScreenshot("Ortaklık Onay Durumunun (Approval Status) Listesi");
        extentTest.info("Affiliation Transactions sayfasında Ortaklık Onay Durumunun (Approval Status) goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        extentTest.info("sayfayi kapatir");
    }
}

