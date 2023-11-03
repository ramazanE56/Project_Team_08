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
public class TC_01_02_03_04 extends TestBaseRapor {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;
    @Test
    public void mesajBilgileri() throws IOException {
        extentTest = extentReports.createTest("Vcard üzerinden gönderilen mesaj bilgileri",
                "Vcard üzerinden gönderilen mesajların, gönderen bilgilerinin ve soru içeriğinin görüntülenebildiğini ve sorunun silinebildiğini doğrulayabilir");
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
        aDashboardPage=new ADashboardPage();
        //Dashboard sayfasi soldaki Enquiries butonu dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki Enquiries butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki Enquiries butonu tiklanir
        aDashboardPage.enquiriesButon.click();
        extentTest.info("Dashboard sayfasi soldaki Enquiries butonu tiklanir");
        //Enquiries sayfasi Enquiries yazisi goruntulenebildigi dogrulanir
        aDashboardPage.enquiriesYazisi.isDisplayed();
        extentTest.pass("Enquiries sayfasi ustteki Enquiries yazisi goruntulenebildigi dogrulanir");
        //Enquiries sayfasi vcard Name Butonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesVcardNameButon.isDisplayed());
        extentTest.pass("Enquiries sayfasi vcard Name butonu goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  Name Butonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesNameButon.isDisplayed());
        extentTest.pass("Enquiries sayfasi Name butonu goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  EMAİL Butonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesEmailButon.isDisplayed());
        extentTest.pass("Enquiries sayfasi Email butonu goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  PHONE Butonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesPhoneButon.isDisplayed());
        extentTest.pass("Enquiries sayfasi Phone butonu goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  CREATED ON Butonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesCreatedOnButon.isDisplayed());
        extentTest.pass("Enquiries sayfasi CREATED ON butonu goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  ACTION yazisi goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesActionYazisi.isDisplayed());
        extentTest.pass("Enquiries sayfasi ACTION yazisi goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  1.satir Eye Ikonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesEyeIkon.isDisplayed());
        extentTest.pass("Enquiries sayfasi 1.satir Eye Ikonu  goruntulenebildigi dogrulanir");
        //Enquiries sayfasi  1.satir Eye Ikonu tiklanir
        aDashboardPage.enquiriesEyeIkon.click();
        extentTest.info("Enquiries sayfasi 1.satir Eye Ikonu  tiklanir");
        ReusableMethods.wait(2);
        //Enquiries sayfasi  1.satir mesaj bilgileri(Enquiry Details) goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesDetails.isDisplayed());
        extentTest.pass("Enquiries sayfasi 1.satir mesaj bilgileri(Enquiry Details) goruntulenebildigi dogrulanir");
        ReusableMethods.getScreenshot("Mesaj bilgileri (Enquiry Details) ekran goruntusu");
        extentTest.info("Mesaj bilgileri (Enquiry Details) ekran goruntusu fotografi cekilir");
        //Enquiry Details close (X) ikonuna tiklayin
        aDashboardPage.enquiriesDetailsClose.click();
        extentTest.info("Enquiry Details close (X) ikonuna  tiklanir");
        // Enquiries sayfasi tablodaki 1.satirdaki Delete (Çöp Kutusu) İkonu goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesDeleteIkon.isDisplayed());
        extentTest.pass("Enquiries sayfasi 1.satir Eye Ikonu  goruntulenebildigi dogrulanir");
        //Enquiries sayfasi tablodaki 1.satirdaki Delete (Çöp Kutusu) İkonu ikonuna tiklayin
        aDashboardPage.enquiriesDeleteIkon.click();
        extentTest.info("Enquiries sayfasi tablodaki 1.satirdaki Delete (Çöp Kutusu) ikonuna  tiklanir");
        ReusableMethods.wait(2);
        //Acilan pencerede Yes Delete Butonuna tiklanir
        aDashboardPage.enquiriesYesDeleteButton.click();
        extentTest.info("Acilan pencerede Yes Delete Butonuna tiklanir");
        //Yes Delete Butonuna bastiktan sonraki Deleted Yazisi goruntulenebildigi dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesDeleted.isDisplayed());
        extentTest.pass("Yes Delete Butonuna bastiktan sonraki acilan pencerede Deleted Yazisi goruntulenebildigi dogrulanir");
        ReusableMethods.wait(2);
        ReusableMethods.getScreenshot("Deleted ekran goruntusu");
        extentTest.info("Deleted ekran goruntusu fotografi cekilir");
    }
}