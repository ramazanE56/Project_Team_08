package tests.US_026_Seref;

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

public class TC_07 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123         */

    @Test
    public void ortaklıkReddetmeTesti() throws IOException {

        extentTest = extentReports.createTest("Ortaklık Başvurusunun Reddedibildiğini Doğrulama Testi",
                "Admin, Ortaklık Başvurusunun Reddedibildiğini görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        ReusableMethods.wait(1);

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

        // Admin panelinde Dashboard menu listesindeki "Uyelik İslemleri" (Affiliation Transactions) sekmesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.affiliationTransactionsElementi.click();
        extentTest.info("Dashboard menu listesindeki Uyelik İslemleri (Affiliation Transactions) sekmesini tıklar");

        // Ortaklık Başvurusunun Onay Durumu (Approval Status) Buttonuna tıklayınız
        aDashboardPage.approvalStatusButtonElementi.click();
        extentTest.info("Uyelik İslemleri (Affiliation Transactions) sayfasında başvuruyu onaylamak için tıklar");

        // Ortaklık Başvurusunun Reddetmek için Reject yazısına tıklayınız
        aDashboardPage.rejectRedYaziElementi.click();
        extentTest.info("Uyelik İslemleri (Affiliation Transactions) sayfasında başvuruyu reddetmek Reject'i için tıklar");

        ReusableMethods.wait(2);

        // Ortaklık Başvurusunun Onaylanabildiğinin test ediniz
        Assert.assertTrue(aDashboardPage.approveRecectonayRedYaziElementi.isDisplayed());
        extentTest.pass("Ortaklık Başvurusunun reddedilebildiğini (Approve) görüldüğünü test eder");

        ReusableMethods.getScreenshot("Ortaklık Başvurusu Reddetme (Approve) penceresi");
        extentTest.info("Affiliation Transactions sayfasında Ortaklık Başvurusunun Reddedilebildiğinin goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        extentTest.info("sayfayi kapatir");
    }
}

