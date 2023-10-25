package tests.US_006_Cengiz;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01_02_03_04 {

    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;

    @Test
    public void trueEmailTruePassword() {


        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tıklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email kutusuna doğru email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));

        //Password kutusuna doğru password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();

        //Giriş yapildigini doğrulayiniz.
        aDashboardPage = new ADashboardPage();
        Assert.assertTrue(aDashboardPage.visitorDashboard.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void trueEmailWrongPassword() {
        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tiklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email kutusuna doğru email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));

        //Password kutusuna yanlıs password giriniz.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("wrongPassword"));

        //Login butonuna tıklayınz.
        loginPage.loginElementi.click();

        //Giriş yapılamadıgını doğrulayınız.(These credentials do not match our records.)

        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void wrongEmailTruePassword() {
        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tıklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email kutusuna yanlis email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("wrongEmail"));

        //Password kutusuna dogru password giriniz.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));

        //Login butonuna tıklayınz.
        loginPage.loginElementi.click();

        //Giriş yapılamadıgını doğrulayınız.(These credentials do not match our records.)

        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());

        Driver.closeDriver();
    }
    @Test
    public void wrongEmailWrongPassword() {

        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tıklayınız
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Email kutusuna yanlis email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("wrongEmail"));

        //Password kutusuna yanlis password giriniz.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("wrongPassword"));

        //Login butonuna tıklayınz.
        loginPage.loginElementi.click();

        //Giriş yapılamadıgını doğrulayınız.(These credentials do not match our records.)

        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());

        Driver.closeDriver();
    }

}