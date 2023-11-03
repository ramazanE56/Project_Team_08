package tests.US_035_bhdr;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_03 extends TestBaseRapor {

    @Test
    public void ViewTesti(){

        //1.Browser açılır
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


        //9.view butonu click edilir.
        aDashboardPage.viewButonuElementi.click();
        ReusableMethods.wait(2);
        extentTest.info("view butonu tıklanır");

        //10.view butonunun click edildigi görüntülenir.
        aDashboardPage.testimonialDetailsElementi.isDisplayed();
        extentTest.info("view butonu click edilip görüntülendigi test edilir");



    }
}
