package tests.US_17_Mustafa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_01_US017 extends TestBaseRapor {

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
        Assert.assertTrue(aDashboardPage.totalAffiliationAmountElementi.isDisplayed());
        extentTest.pass("Total Affiliation Amount kısmı görüntülenir.");

        // Güncel tutarlar görüntülenir. --(//div[@class='d-flex align-items-center justify-content-center'])[2]
        Assert.assertTrue(aDashboardPage.currentAmountElementi.isDisplayed());
        extentTest.pass("Current Amount kısmı görüntülenir");

        // Davetiye gönderilir. --//a[@class='btn btn-primary sendInviteBtn']
        // //input[@aria-describedby='emailHelp']
        // //button[text()='Send Email']
        aDashboardPage.sendInviteElementi.click();
        aDashboardPage.sendMailElementi.isDisplayed();
        aDashboardPage.sendMailElementi.sendKeys("mustafa52anar@gmail.com");
        ReusableMethods.wait(1);
        aDashboardPage.sendEmailButonu.click();

        Assert.assertTrue(!aDashboardPage.serverErrorYazisi.isDisplayed());

    }


}
