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

public class TC_01 {

  @Test
    public void userSignIn(){
    //1-Browser açılır
    //2-https://qa.smartcardlink.com/ adresine gidilir
    Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

    //3-Sign In butonuna click yapılır.
    SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
    smartcardlinkPage.signinButtonElementi.click();
    //4-email ve Password değerlerini girip Login butonuna tıklayınız
    LoginPage loginPage=new LoginPage();
    Actions actions=new Actions(Driver.getDriver());
    loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("brEmail")
            + Keys.TAB+Keys.TAB
            +ConfigReader.getProperty("brPassword")
            +Keys.ENTER);
    //4-User Dashboard sayfasının görünür olduğunu test edin.
    ADashboardPage aDashboardPage=new ADashboardPage();
    Assert.assertTrue(aDashboardPage.visitorDashboard.isDisplayed());
    //5-Sayfa kapatılır.
    Driver.closeDriver();




  }

    @Test
    public void settingsIsDisplayed(){
      //1-Browser açılır
      //2-https://qa.smartcardlink.com/ adresine gidilir
      Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

      //3-Sign In butonuna click yapılır.
      SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
      smartcardlinkPage.signinButtonElementi.click();
      //4-email ve Password değerlerini girip Login butonuna tıklayınız
      LoginPage loginPage=new LoginPage();
      Actions actions=new Actions(Driver.getDriver());
      loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("brEmail")
              + Keys.TAB+Keys.TAB
              +ConfigReader.getProperty("brPassword")
              +Keys.ENTER);
      //5-yan menudeki Settings linkinin  görünür olduğunu test et.
      ADashboardPage aDashboardPage=new ADashboardPage();
      Assert.assertTrue(aDashboardPage.userSettingsLinki.isDisplayed());
      //6- Brovser'ı kapat.
      Driver.closeDriver();

    }
    @Test
    public void CredentialsIsDisplayed(){
      //1-Browser açılır
      //2-https://qa.smartcardlink.com/ adresine gidilir
      Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

      //3-Sign In butonuna click yapılır.
      SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
      smartcardlinkPage.signinButtonElementi.click();
      //4-email ve Password değerlerini girip Login butonuna tıklayınız
      LoginPage loginPage=new LoginPage();
      Actions actions=new Actions(Driver.getDriver());
      loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("brEmail")
              + Keys.TAB+Keys.TAB
              +ConfigReader.getProperty("brPassword")
              +Keys.ENTER);
      //5-yan menudeki Settings linkine click yap.
      ADashboardPage aDashboardPage=new ADashboardPage();
      aDashboardPage.userSettingsLinki.click();
      //6-Credentials sayfasına gidildiğini test et.
Assert.assertTrue(aDashboardPage.userCredentialSayfasiYazisi.isDisplayed());
//7- Brovser'ı kapat.
      Driver.closeDriver();

    }
}
