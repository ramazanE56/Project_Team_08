package tests.US_012_Emre;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {


    @Test(dependsOnMethods = {"settingsIsDisplayed"},priority = 2)
    public void CredentialsIsDisplayed(){
      extentTest=extentReports.createTest("Kullanıcı Credentials sayfasına erişim","Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek Credentials sayfasına ulaşabilmeli");
      //1-Browser açılır
      //2-https://qa.smartcardlink.com/ adresine gidilir.
      Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
      extentTest.info("Kullanıcı verilen url adresine gider.");
      //3-Sign In butonuna click yapılır.
      SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
      smartcardlinkPage.signinButtonElementi.click();
      //4-Email textbox'ına Kayıtlı email bilgisi girilir.
      //5-Password textbox'ına geçerli password bilgisi girilir.
      //6-Login butonuna click yapılır.
      LoginPage loginPage=new LoginPage();
      Actions actions=new Actions(Driver.getDriver());
      loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("brEmail")
              + Keys.TAB+Keys.TAB
              +ConfigReader.getProperty("brPassword")
              +Keys.ENTER);
      //7-yan menudeki Settings linkine click yapılır.
      ADashboardPage aDashboardPage=new ADashboardPage();
      aDashboardPage.userSettingsLinki.click();
      //8-‘Credentials’  bölümünün görüntülenebildiğini test et.
      Assert.assertTrue(aDashboardPage.userCredentialSayfaBasligi.isDisplayed());
      extentTest.pass("Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek Credentials sayfasına ulaşabilmeli");
      //9- Browser kapatılır.
      Driver.closeDriver();

    }

}
