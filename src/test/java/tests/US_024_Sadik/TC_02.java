package tests.US_024_Sadik;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    @Test
    public void KullaniciUyelikBitisTarihi(){
        extentTest =extentReports.createTest("Admin olarak kullanıcıların üyelik bitiş tarihini değiştirme testi","Admin  kullanıcıların üyelik bitiş tarihini değiştirebilmeli ");

        //  1- Browser açılır
        // 2- Adres çubuğuna URL girilir
        //  3- Enter tuşuna tıklanır
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        //4- Anasayfada Sing in butonu tıklanır
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",smartcardlinkPage.signinButtonElementi );

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

      //  8- Kullanıcıların ACTION kısmındanki Edite  tıklanır
        aDashboardPage.SubscribedPlanssearchButonu.click();
        extentTest.info("search kutusuna tıklanır");

        aDashboardPage.SubscribedPlanssearchButonu.sendKeys(ConfigReader.getProperty("secilikullanici"));
        extentTest.info("search kutusuna istediğimiz kullanıcı girilir.");
        ReusableMethods.wait(1);
    //9-Üyelik bitiş tarihi bilgileri görüntülenir
        aDashboardPage.seciliEditElementi.click();
        extentTest.info("seçili kullanıcının edit ikonu tıklanır");
        ReusableMethods.wait(1);
    //10- END DATE texboxında istenen tarih girilir.
     aDashboardPage.EndDateKutusu.click();
     extentTest.info("End Date kutusu tıklanır");
     ReusableMethods.wait(2);

     aDashboardPage.EndDateYilArttir.click();
     extentTest.info("üyelik bitiş yılı değiştirilir");
     ReusableMethods.wait(2);

     Select select = new Select(aDashboardPage.EndDateAySEC);
     select.selectByVisibleText("November");
     extentTest.info("üyelik bitiş ayı November olarak değiştirildi");
     ReusableMethods.wait(2);

     aDashboardPage.EndDateGun.click();
     extentTest.info("yeni End Date için gün Seçilir");
     ReusableMethods.wait(2);

     //11- Girilen tarih kaydedelir
        aDashboardPage.EndDateSave.click();
        extentTest.info("Yeni üyelik bitiş tarihi kaydedildi");
      ReusableMethods.wait(2);

      //12 - Yeni End date basarılı bir şekilde kaydedildiği doğrulanır
        Assert.assertTrue(aDashboardPage.DateDegistiSuccesfullyYazisi.isDisplayed());
        extentTest.pass("Yeni End date'nin başarılı bir şekilde değiştiği doğrulanır.");

      //13-Browser kapatılır
      Driver.closeDriver();
      extentTest.info("Sayfa kapatilir.");



    }
}
