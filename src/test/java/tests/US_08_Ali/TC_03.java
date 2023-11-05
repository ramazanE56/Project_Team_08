package tests.US_08_Ali;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC_03 extends TestBaseRapor {

    @Test
    public void TC_03() {

        extentTest = extentReports.createTest("Vcard işlem butonlarının aktif olmasını sorgulama Testi",
                "Önceden oluşturulmuş VCardların işlem butonlarının aktif olduğu test edilir.");
        //"https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Homepage sayfasindaki Sign In Butonu tıklanır.");

        //email ve Password değerlerini girip Login butonuna tıklayınız
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("yenimail"));
        extentTest.info("Email kutusuna email girilir.");

        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("yenipassword"));
        extentTest.info("Password kutusuna password girilir.");
        ReusableMethods.wait(2);

        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tıklanır.");

        // Dashboard sayfasından soldaki menuden VCards elementi tiklanir.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.dashboardVCardsElementi.click();
        extentTest.info("Dashboard sayfasından soldaki menuden VCards elementi tıklanır. ");
        ReusableMethods.wait(2);

        //??? Linkin kopyalandığı nasıl test edilir???--------------------
        aDashboardPage.vCardCopyButonu.click();
        Assert.assertTrue(aDashboardPage.vCardSuccessCopied.isDisplayed());



        // Dashboard sayfasından VCard işlem butonlarından Stats'ın çalışıp çalışmadığı test edilir.
        aDashboardPage.vCardStatsButonu.click();
        Assert.assertTrue(aDashboardPage.vCardAnalyticsSayfasi.isDisplayed());
        aDashboardPage.vCardBackButonu.click();
        extentTest.info("VCard işlem butonlarından Stats'ın çalışıp çalışmadığı test edilir.");
        ReusableMethods.wait(2);

        // ??? Status checkbox nasıl test edilecek???------------------------

        //System.out.println(Driver.getDriver().switchTo().alert().getText());
        aDashboardPage.vCardCheckboxButonu.click();
         Assert.assertTrue(aDashboardPage.vCardStatusUpdatedAlerti.isDisplayed());
        //extentTest.info("// Dashboard sayfasından VCard işlem butonlarından Status'ün çalışıp çalışmadığı test edilir.");


        // Dashboard sayfasından VCard işlem butonlarından QR Code'un çalışıp çalışmadığı test edilir.
        aDashboardPage.vCardQRCodeDownloadButonu.click();
        String qrQrKoduDownloadDosyaYolu = "C:\\Users\\dell\\Downloads\\qr_code.png";
        Assert.assertTrue(Files.exists(Paths.get(qrQrKoduDownloadDosyaYolu)));
        extentTest.info("QR kodunun bilgisayara download edildiği test edilir.");
        ReusableMethods.wait(2);

        // Dashboard sayfasından VCard işlem butonlarından Download Vcard'ın çalışıp çalışmadığı test edilir.
        aDashboardPage.vCardDownloadButonu.click();
        String vCardDownloadDosyaYolu = "C:\\Users\\dell\\Downloads\\unknown.vcf";
        Assert.assertTrue(Files.exists(Paths.get(vCardDownloadDosyaYolu)));
        extentTest.info("VCardın bilgisayara download edildiği test edilir.");
        ReusableMethods.wait(2);

        // Dashboard sayfasından VCard işlem butonlarından Dublicate butonun çalışıp çalışmadığı test edilir.
        aDashboardPage.vCardDublicateButonu.click();
        aDashboardPage.vCardDuplicateYesButonu.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(aDashboardPage.vCardDublicateTestLinki.isDisplayed());
        extentTest.info("VCardın dublicate edilip edilmediği test edilir.");
        ReusableMethods.wait(2);

        // Dashboard sayfasından VCard işlem butonlarından Edit butonun çalışıp çalışmadığı test edilir.
        aDashboardPage.vCardEditButonu.click();
        Assert.assertTrue(aDashboardPage.vCardEditSayfasiElementi.isDisplayed());
        aDashboardPage.vCardBackButonu.click();
        extentTest.info("VCard işlem butonlarından Edit butonun çalışıp çalışmadığı test edilir");
        ReusableMethods.wait(2);

        // Dashboard sayfasından VCard işlem butonlarından Delete butonun çalışıp çalışmadığı test edilir.

        String dublicateEdilenVcard = aDashboardPage.vCardDublicateButonu.getText();

        aDashboardPage.vCardDeleteButonu.click();
        aDashboardPage.vCardYesDeleteButonu.click();
        Assert.assertFalse(aDashboardPage.vCardDublicateTestLinki.equals(dublicateEdilenVcard));
        extentTest.info("VCardın dublicate edilip edilmediği test edilir.");
        ReusableMethods.wait(2);





































    }
}
