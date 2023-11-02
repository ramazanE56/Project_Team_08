package tests.US_019;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void test01() {
        ADashboardPage aDashboardPage = new ADashboardPage();
        LoginPage loginPage = new LoginPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        extentTest=extentReports.createTest("Kullanıcıların görünürlüğünü doğrulama testi",
                                           "Kullanıcı ilgili siteye kayıtlı bir kullanıcı \n" +
                                                    "bilgileri ile giriş yaparak kullanıcılar bölümünde  kayıtlı kullanıcıları," +
                                                    " toplam kullanıcı sayısını, aktiflik durumlarını, kullanıcı bilgilerini görüntüleyebilmelidir");

       extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        extentTest.info("Signin butonuna click yapılır.");
        smartcardlinkPage.signinButtonElementi.click();

        extentTest.info("Email kutusuna kullanıcı email i yazılır");
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

        extentTest.info("Password kutusuna şifre yazılır.");
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

        extentTest.info("login butonuna basılır.");
        loginPage.loginElementi.click();

        extentTest.info("Users linkine click yapılır");
        aDashboardPage.userMenuElementi.click();

        extentTest.pass("Kayıtlı kullanıcıların görüntülendiği test edilir");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(aDashboardPage.firstUserNameElementi.isDisplayed());

        extentTest.pass("Toplam Kullanıcı sayısının göründüğü test edilir");
        WebElement sonucyaziElementi = aDashboardPage.showing_to_of_resultsElementi;
        softAssert.assertTrue(sonucyaziElementi.isDisplayed());

        extentTest.pass("Kullanıcıların aktiflik durumlarının görüntülenebildiği test edilir");
        softAssert.assertTrue(aDashboardPage.ilkIsActiveElementi.isDisplayed());

        extentTest.pass("Kullanıcı bilgilerinin görüntülendiği test edilir.");
        String tbodyText = aDashboardPage.kullaniciBilgileriWebTables.getText();
        softAssert.assertTrue(!tbodyText.isEmpty());

        softAssert.assertAll();


    }
}
