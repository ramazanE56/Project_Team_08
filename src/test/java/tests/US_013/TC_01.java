package tests.US_013;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        //3-Signin butonuna click yapılır.
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email kutusuna kullanıcı email i yazılır
        //smartcardlinkPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        smartcardlinkPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("ozelemail"));
        extentTest.info("Email kutusuna kullanıcı email i yazılır");
        ReusableMethods.bekle(1);
        //5-Password kutusuna şifre yazılır.
        //smartcardlinkPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        smartcardlinkPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("ozelpassword"));
        extentTest.info("Password kutusuna şifre yazılır.");
        ReusableMethods.bekle(1);
        //6-login butonuna basılır.
        smartcardlinkPage.loginButtonu.click();
        extentTest.info("login butonuna basılır.");
        ReusableMethods.bekle(1);

        //7- kullanıcı isminin yazdığı dropdown menu acılır
        smartcardlinkPage.profildropdownMenuButton1.click();
        extentTest.info("kullanıcı isminin yazdığı dropdown menu acılır");
        ReusableMethods.bekle(1);
        //8-Account settings linkine click yapılır
        smartcardlinkPage.accountSettingsLinki.click();
        extentTest.info("Account settings linkine click yapılır");
        ReusableMethods.bekle(1);
        //9-"Profile Details" bölümüne ulaşıldığı test edilir.
        WebElement profileDetailsYazi= smartcardlinkPage.profileDetailsLinki;
        Assert.assertTrue(profileDetailsYazi.isDisplayed());
        extentTest.pass("profile bilgileri sayfasına erişim sağlandığı test edilir.");


    }
}
