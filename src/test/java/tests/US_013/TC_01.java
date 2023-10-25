package tests.US_013;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Profil Bilgileri Sayfasına Erişim","Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek profil bilgileri sayfasına ulaşabilmeli ");
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        LoginPage loginPage=new LoginPage();
        ADashboardPage aDashboardPage=new ADashboardPage();
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        //3-Signin butonuna click yapılır.
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email kutusuna kullanıcı email i yazılır
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna kullanıcı email i yazılır");
        ReusableMethods.wait(1);
        //5-Password kutusuna şifre yazılır.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna şifre yazılır.");
        ReusableMethods.wait(1);
        //6-login butonuna basılır.
        loginPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");
        ReusableMethods.wait(1);

        //7- kullanıcı isminin yazdığı dropdown menu acılır
        aDashboardPage.profildropdownMenuButton1.click();
        extentTest.info("kullanıcı isminin yazdığı dropdown menu acılır");
        ReusableMethods.wait(1);
        //8-Account settings linkine click yapılır
        aDashboardPage.accountSettingsLinki.click();
        extentTest.info("Account settings linkine click yapılır");
        ReusableMethods.wait(1);
        //9-"Profile Details" bölümüne ulaşıldığı test edilir.
        WebElement profileDetailsYazi= aDashboardPage.profileDetailsLinki;
        Assert.assertTrue(profileDetailsYazi.isDisplayed());
        extentTest.pass("profile bilgileri sayfasına erişim sağlandığı test edilir.");


    }
}
