package tests.US_17_Mustafa;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_03_US017 extends TestBaseRapor {
    @Test
    public void TC01(){

        extentTest = extentReports.createTest("Toplam ve güncel tutarları görüntüleyebilme, " +
                        "davatiye gönderebilme ve para çekme işlemlerini yapabilme",
                "Sınırsız özellikli kullanıcı olarak giriş yapıp işlemleri yapma.");
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        LoginPage loginPage = new LoginPage();
        ADashboardPage aDashboardPage = new ADashboardPage();

        // Browser açılır
        //URL'le (https://qa.smartcardlink.com/) gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sing in butonu tıklanır.
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sing in butonuna click yapılır.");

        //Sınırsız kullanıcı e-maili girilir.
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("Sinemail"));
        extentTest.info("Sınırsız kullanıcı e-maili girilir.");
        ReusableMethods.wait(1);

        //Sınırsız kullanıcı passwordu girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("Sinpassword"));
        extentTest.info("Sınırsız kullanıcı passwordu girilir.");
        ReusableMethods.wait(1);

        //Login butonu tıklanır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonu tıklanır.");

        // Panodan Affilation menüsüne tıklanır. -- (//a[@class='nav-link d-flex align-items-center py-3'])[6]
        aDashboardPage.affiliationsButonu.click();
        extentTest.info("Dashboard'daki Affiliations butonuna tıklanır.");

        // Toplam tutarlar görüntülenir. --(//div[@class='d-flex align-items-center justify-content-center'])[1]
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(aDashboardPage.totalAffiliationAmountElementi.isDisplayed());
        extentTest.pass("Total Affiliation Amount kısmı görüntülenir.");

        // Güncel tutarlar görüntülenir. --(//div[@class='d-flex align-items-center justify-content-center'])[2]
        softAssert.assertTrue(aDashboardPage.currentAmountElementi.isDisplayed());
        extentTest.pass("Current Amount kısmı görüntülenir");

        // Davetiye gönderilir. --//a[@class='btn btn-primary sendInviteBtn']
        // //input[@aria-describedby='emailHelp']
        // //button[text()='Send Email']
        aDashboardPage.sendInviteElementi.click();
        aDashboardPage.sendMailElementi.isDisplayed();
        aDashboardPage.sendMailElementi.sendKeys("mustafa52anar@gmail.com");
        ReusableMethods.wait(1);
        aDashboardPage.sendEmailButonu.click();


        softAssert.assertTrue(aDashboardPage.serverErrorYazisi.isDisplayed());
        extentTest.fail("mail gönderme işlemi gerçekleştirilemedi.");
        extentTest.info("Mail gönderme işlemi gerçekleştirilemedi. İlgili server 500 Server Error hatası vermektedir.");

        Driver.getDriver().navigate().back();
        ReusableMethods.wait(1);
        aDashboardPage.affiliationsButonu.click();
        extentTest.info("Dashboard kısmına geri dönülür.");


        // Para çekme işlemi yapılır.
        aDashboardPage.withdrawalBotonu.click();
        aDashboardPage.withdrawalAmountElementi.click();
        aDashboardPage.enterAmountElementi.sendKeys("1");
        aDashboardPage.paypalEmailElementi.sendKeys(ConfigReader.getProperty("Sinemail"));
        ReusableMethods.wait(1);
        aDashboardPage.saveElementi.click();
        extentTest.info("para çekme talebi gerçekleştirildi, transfer için admin onayı bekliyor");

        softAssert.assertAll();


    }
}
