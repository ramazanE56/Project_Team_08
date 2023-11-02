package tests.US_08_Ali;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {

    @Test
    public void TC_02() {

        extentTest=extentReports.createTest("VCard Sayisi Görüntüleme Testi",
                "Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek oluşturulmuş VCard Sayisi görüntülenir.");
        //"https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");

        //email ve Password değerlerini girip Login butonuna tıklayınız
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("yenimail"));
        extentTest.info("Email kutusuna email girilir.");

        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("yenipassword"));
        extentTest.info("Password kutusuna password girilir.");

        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tıklanır.");

        ADashboardPage aDashboardPage = new ADashboardPage();

        System.out.println("Toplam VCard Sayısı: "+aDashboardPage.totalActiveVCardSayisiElementi.getText());
        extentTest.info("Toplam VCard sayısı konsola yazdırılır.");

        Assert.assertTrue(aDashboardPage.totalActiveVCardSayisiElementi.isDisplayed());
        extentTest.pass("Oluşturulmuş VCard Sayisi görüntülenir.");









    }
}

