package tests.US_16_Ali;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
    public void TC_01() {

        extentTest=extentReports.createTest("Unlimited Plan Appointments Görüntüleme Testi",
                "Kullanıcı Unlimited Plan seçerek Appointmentsları görüntüleyebilmelidir.");
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

        // Ana Sayfaya geri dönülür.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Ana Sayfaya geri dönülür.");
        ReusableMethods.wait(3);

        // Pagedown tuşu ile body kısmındaki Choose A Plan bölümüne inilir.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN,
                Keys.PAGE_DOWN,
                Keys.PAGE_DOWN,
                Keys.PAGE_DOWN,
                Keys.PAGE_DOWN).perform();
        extentTest.info("Pagedown tuşuna beş kere basılarak Chose A Plan bölümüne inilir.");

        // Next butonuna üç kere tıklanarak Unlimited Plan seçeneği seçili hale getirilir.
        SmartcardlinkPage smartcardlinkPage1 = new SmartcardlinkPage();

        smartcardlinkPage1.choosePlanNextButonu.click();
        ReusableMethods.wait(1);
        smartcardlinkPage1.choosePlanNextButonu.click();
        ReusableMethods.wait(1);
        smartcardlinkPage1.choosePlanNextButonu.click();
        extentTest.info("Switch butonuna tıklanarak Unlimited Plan seçilir.");

        // Pagedown tuşuna bir kere ile Switch  butonuna inilir.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Switch butonuna tıklanarak Unlimited Plan seçilir.");

        // Switch butonuna tıklanarak Unlimited Plan seçilir.
        smartcardlinkPage1.unlimitedPlanSwitchButonu.click();
        extentTest.info("Switch butonuna tıklanarak Unlimited Plan seçilir.");

        // Dashboard sayfasından sol menüden Appointments elementi tıklanır.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.dashboardAppointmentsElementi.click();
        extentTest.info("Dashboard sayfasından sol menüden Appointments elementi tıklanır.");

        // Appointments Sayfasından mevcut randevuların görüntülendiği test edilir.
        Assert.assertTrue(aDashboardPage.dashboardAppointmentsSayfasi.isDisplayed());
        extentTest.pass("Appointments Sayfasından mevcut randevuların görüntülendiği test edilir.");



        ReusableMethods.wait(3);















    }
}