package tests.US_006_Cengiz;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_01_02_03_04 extends TestBaseRapor {

    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;

    @Test
    public void trueEmailTruePassword() {

        extentTest=extentReports.createTest("Ziyaretçi sayfasına sadece doğru bilgilerle giriş",
                "Kullanıcı sadece doğru Email ve doğru Password bilgilerini girerek profil bilgileri sayfasına ulaşabilmeli");

        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna doğru email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));
        extentTest.info("Email kutusuna doğru email adresi girilir");

        //Password kutusuna doğru password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));
        extentTest.info("Password kutusuna doğru password girilir");

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Giriş yapildigini doğrulayiniz.
        aDashboardPage = new ADashboardPage();
        Assert.assertTrue(aDashboardPage.visitorDashboardYaziElementi.isDisplayed());
        extentTest.info("Giriş yapildigini doğrulanir");

        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }

    @Test
    public void trueEmailWrongPassword() {
        extentTest=extentReports.createTest("Ziyaretçi sayfasına sadece doğru bilgilerle giriş",
                "Kullanıcı doğru Email ve yanlis Password bilgilerini girerek profil bilgileri sayfasına ulaşamamali");

        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tiklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna doğru email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));
        extentTest.info("Email kutusuna doğru email adresi girilir");

        //Password kutusuna yanlıs password giriniz.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("wrongPassword"));
        extentTest.info("Password kutusuna yanlis password girilir");

        //Login butonuna tıklayınz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Giriş yapılamadıgını doğrulayınız.(These credentials do not match our records.)

        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());
        extentTest.info("Giriş yapilamadigi doğrulanir");

        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }

    @Test
    public void wrongEmailTruePassword() {
        extentTest=extentReports.createTest("Ziyaretçi sayfasına sadece doğru bilgilerle giriş",
                "Kullanıcı yanlis Email ve dogru Password bilgilerini girerek profil bilgileri sayfasına ulaşamamali");

        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tıklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna yanlis email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("wrongEmail"));
        extentTest.info("Email kutusuna yanlis email adresi girilir");

        //Password kutusuna dogru password giriniz.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));
        extentTest.info("Password kutusuna dogru password girilir");

        //Login butonuna tıklayınz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Giriş yapılamadıgını doğrulayınız.(These credentials do not match our records.)

        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());
        extentTest.info("Giriş yapilamadigi doğrulanir");

        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }
    @Test
    public void wrongEmailWrongPassword() {

        extentTest=extentReports.createTest("Ziyaretçi sayfasına sadece doğru bilgilerle giriş",
                "Kullanıcı yanlis Email ve yanlis Password bilgilerini girerek profil bilgileri sayfasına ulaşamamali");

        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tıklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna yanlis email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("wrongEmail"));
        extentTest.info("Email kutusuna yanlis email adresi girilir");

        //Password kutusuna yanlis password giriniz.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("wrongPassword"));
        extentTest.info("Password kutusuna yanlis password girilir");

        //Login butonuna tıklayınz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Giriş yapılamadıgını doğrulayınız.(These credentials do not match our records.)

        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());
        extentTest.info("Giriş yapilamadigi doğrulanir (These credentials do not match our records.)");


        //Sayfa kapatilir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }

}