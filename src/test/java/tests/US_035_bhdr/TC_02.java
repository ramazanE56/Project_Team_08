package tests.US_035_bhdr;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.event.InputEvent;

public class TC_02 extends TestBaseRapor {
    @Test
    public void GorusAddTesti() throws AWTException {
        extentTest=extentReports.createTest("Admin Dashboard sayfasına erişim",
                "Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek testimonials sayfasına ulaşabilmeli");

        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ReusableMethods.wait(2);
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //3.Sıgn In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("signin butonu tıklanır");

        //4.eMail kutusuna kullanıcı email i yazılır
        LoginPage loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));
        extentTest.info("email kutusuna kullanıcı emaili girilir");

        //5.password kutusuna kullanıcı şifresi yazılır
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("kullanıcı şifresi girilir");

        //6.login butonua basılır
        loginPage.loginElementi.click();
        extentTest.info("login kutusu tıklanır");

        //7.Search arama butonu click edilir.Front cms click edilir.
        ADashboardPage aDashboardPage=new ADashboardPage();
        aDashboardPage.adminSearchTextbox.sendKeys("Front CMS");
        ReusableMethods.wait(3);
        aDashboardPage.frontCmsButonuElementi.click();
        ReusableMethods.wait(3);
        extentTest.info("search butonu tıklanır ve front Cms butonu tıklanır");

        //8.Testimonials butonu click edilir.
        aDashboardPage.testimonialsButonElementi.click();
        ReusableMethods.wait(2);
        extentTest.info("testimonials butonu tıklanır");

        //8.add Testimonials butonu click edilir.
        aDashboardPage.addTestimonialButonuElementi.click();
        extentTest.info(" add testimonials butonu tıklanır");

        //9.name butonu click edilir.isim girilir.
        aDashboardPage.nameTextKutusuElementi.click();
        aDashboardPage.nameTextKutusuElementi.sendKeys("abhdr");
        ReusableMethods.wait(3);
        extentTest.info("testimonials sayfasında name text kutusu tıklanır");

        //10.Description butonu click edilir.açıklama girilir.
        aDashboardPage.descriptionButonuElementi.click();
        aDashboardPage.descriptionButonuElementi.sendKeys("deneme1");
        extentTest.info("testimonials sayfasında açıklama kutusu tıklanır");

        //11.image.butonu tıklayıp resim yuklenmelidir733, 233
        aDashboardPage.imageKalemButonu.click();
        Point point1 = new Point(733, 233);
        // Farenin konumunu ayarla
        Robot robot = new Robot();
        robot.mouseMove(point1.x, point1.y);
        ReusableMethods.wait(3);
        // Sol tıklama yap
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(3);
        // Sol tıklama bırak
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(3);
        extentTest.info("testimonials sayfasında image kalem kutusu tıklanır");

        //12.save butonu tıklayıp kaydedilmelidir
        aDashboardPage.testtimonialSaveBUtonuElementi.click();
        Assert.assertTrue(aDashboardPage.successElementi.isDisplayed());
        extentTest.info("testimonials sayfasında asave butonun görünümü test edilir");
    }
}
