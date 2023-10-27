package tests.US026_Seref;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_01 extends TestBaseRapor {

         /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123
         */

    @Test
    public void AffiliateUsers() throws IOException {

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //Admin email ve Password bilgilerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        loginPage.loginElementi.click();

        // ADashboard menu listesindeki "ortaklık llanıcıları"(Affiliate Users) sekmesinin tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.bagliKullanicilarYaziElementi.click();

        // Ortaklığın kim tarafından yapıldığının görüldüğünü test ediniz
         Assert.assertTrue(aDashboardPage.sonuclariGormeYaziElementi.isDisplayed());

        ReusableMethods.wait(3);
        TestBaseRapor.extentHtmlReporter.getReporterName();
        ReusableMethods.getScreenshot("ortakYapanListesi");

        Driver.closeDriver();

    }

}