package tests.US_024_Sadik;

import org.openqa.selenium.JavascriptExecutor;
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
    public void kullaniciBilgileriKontrol(){
        extentTest =extentReports.createTest("Admin olarak kullanıcı üyelik bilgilerini görme testi","Admin kullanıcıların üyelik bilgilerini görebilmeli ");
        //  1- Browser açılır
        // 2- Adres çubuğuna URL girilir
        //  3- Enter tuşuna tıklanır
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        //4- Anasayfada Sing in butonu tıklanır
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",smartcardlinkPage.signinButtonElementi );
        ReusableMethods.wait(1);
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign in butonuna tıklanır");

       // 5- Admin olarak   Email ve şifre alanlarına doğru  bilgileri girilir
        LoginPage loginPage = new LoginPage();

        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("email kutusuna admin  e mail yazılır");

        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("password kutusuna admin password yazılır");

        //6- Log in butonuna basarak giriş yapılır
        loginPage.loginElementi.click();
        extentTest.info("login butonu tıklanır");

        //  7- Açılan sayfadan "Subscribed User Plans" butonu tıklanır
        ADashboardPage aDashboardPage = new ADashboardPage();

        aDashboardPage.subscribedUserPlansElementi.click();
        extentTest.info("Subscribed User Plans butonuna tıklanır");

        // 8- Açılan sayfadan "USER NAME" 'in görüntülendiği doğrulanır.
        Assert.assertTrue(aDashboardPage.userNameYazisi.isDisplayed());
        extentTest.pass(" Subscribed User Plans sayfasında USER NAME  görüntülendiği test edilir");

        // 9-  Açılan sayfada ,"PLAN NAME" 'in görüntülendiği doğrulanır.
        Assert.assertTrue(aDashboardPage.planNameYazisi.isDisplayed());
        extentTest.pass(" Subscribed User Plans sayfasında PLAN NAME  görüntülendiği test edilir");

        // 10- Açılan sayfada "START DATE " 'in  görüntülendiği doğrulanır.
        Assert.assertTrue(aDashboardPage.startDateYazisi.isDisplayed());
        extentTest.pass(" Subscribed User Plans sayfasında START DATE  görüntülendiği test edilir");

        // 11- Açılan sayfada "END DATE" 'in görüntülendiği doğrulanır.
        Assert.assertTrue(aDashboardPage.endDateYazisi.isDisplayed());
        extentTest.pass(" Subscribed User Plans sayfasında END DATE  görüntülendiği test edilir");

        //12- Kullanıcıların ACTION kısmındanki View butonu ( göz sembolü)  tıklanır
        aDashboardPage.SubscribedPlanssearchButonu.click();
        extentTest.info("search kutusuna tıklanır");

        aDashboardPage.SubscribedPlanssearchButonu.sendKeys(ConfigReader.getProperty("secilikullanici"));
        extentTest.info("search kutusuna istediğimiz kullanıcı girilir.");
        ReusableMethods.wait(2);

        aDashboardPage.seciliViewElementi.click();
       extentTest.info(" Subscribed User Plans sayfasında View butonu ( göz sembolü)  tıklanır");

        //13- Plan ayrıntılarının görüntülenebildiği doğrulanır.
        ReusableMethods.wait(2);
        Assert.assertTrue(aDashboardPage.SubscribedUserPlansTestElementi.isDisplayed());
        extentTest.pass("Subscribed User Plans sayfasında plan ayrıntılarının görüntülebildiği test edilir");

        //14-Browser kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }
}

