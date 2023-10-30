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
    //2-https://qa.smartcardlink.com/ adresine gidilir.
    Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

    //3-Sign In butonuna click yapılır.
    SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
    smartcardlinkPage.signinButtonElementi.click();
    //4-email ve Password değerlerini girip Login butonuna tıklanır.
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

    @Test(dependsOnMethods = {"userSignIn"},priority = 1)
    public void settingsIsDisplayed(){
      //1-Browser açılır.
      //2-https://qa.smartcardlink.com/ adresine gidilir.
      Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

      //3-Sign In butonuna click yapılır.
      SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
      smartcardlinkPage.signinButtonElementi.click();
      //4-email ve Password değerlerini girip Login butonuna tıklanır.
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
    @Test(dependsOnMethods = {"settingsIsDisplayed"},priority = 2)
    public void CredentialsIsDisplayed(){
      //1-Browser açılır
      //2-https://qa.smartcardlink.com/ adresine gidilir.
      Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

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
      //9- Browser kapatılır.
      Driver.closeDriver();

    }

}
