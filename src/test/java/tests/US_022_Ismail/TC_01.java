package tests.US_022_Ismail;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {


    @Test
    public void vcardtemplates(){

        extentTest=extentReports.createTest("Admin vcardtemplates sayfasına erişim","Admin Dashboard sayfasında Vcard Templates sayfasına ulaşılmalı ve template bilgilerinin görüntülenebilir olduğu doğrulanmalıdır");
        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //email ve Password değerlerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        extentTest.info("Email kutusuna kullanıcı emaili ve password kutusuna kullanıcı şifresi yazılır");
        loginPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");
        ReusableMethods.wait(2);
        //Admin Dashboard sayfasında Vcard Templates sekmesinin tıklanır olduğunu test edin.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.vcardTemplatesElementi.click();
        extentTest.info("Admin Dashboard sayfasında Vcard Templates sekmesinin tıklanır");
        SoftAssert softAssert = new SoftAssert();
        String expectedSekmeBasligiYazisi = "Vcard Templates";
        String actualSekmeBasligiYazisi = aDashboardPage.sekmeBasligiYaziElementi.getText();

        softAssert.assertEquals(actualSekmeBasligiYazisi,expectedSekmeBasligiYazisi,"Admin Dashboard sayfasında Vcard Templates sekmesi tıklanamamaktadır");
        extentTest.fail("Admin Dashboard sayfasında Vcard Templates sekmesi tıklanamamaktadır");

        Driver.closeDriver();


    }

}
