package tests.US_035_bhdr;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void TestimonialsGorusTest(){
        extentTest=extentReports.createTest("Admin Dashboard sayfasına erişim",
                "Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek testimonials sayfasına ulaşabilmeli");
        //1.Browser açılır
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

        //9.add Testimonials butonun göründügü test edilir
        String actualActionElementi=aDashboardPage.actionButonElementi.getText();
        String expectedTestimonials="ACTION";
        Assert.assertEquals(actualActionElementi,expectedTestimonials);
        extentTest.info("add testimonials butonunun görünür oldugu test edilir.");


    }
}
