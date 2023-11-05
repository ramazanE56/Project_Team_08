package tests.US_031_Mustafa;

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

public class TC01_US031 extends TestBaseRapor {


    @Test
    public void TC_01(){

        extentTest = extentReports.createTest("Dil sayısını görüntüleyebilme","Admin Bilgileriyle giriş yapıp dil sayısını görüntüleme" );
        SmartcardlinkPage smartcardLinkPage = new SmartcardlinkPage();
        LoginPage loginPage = new LoginPage();
        ADashboardPage aDashboardPage = new ADashboardPage();
        Actions action = new Actions(Driver.getDriver());


        // Browser açılır
        //URL'le (https://qa.smartcardlink.com/) gidilir
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sing in butonu tıklanır
        smartcardLinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");

        //Admin kullanıcı adı girilir
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna kullanıcı email i yazılır");

        //5-Admin password girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna şifre yazılır.");
        ReusableMethods.wait(1);

        //Login butonu tıklanır
        loginPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");
        ReusableMethods.wait(2);

        //Panodan diller seçeneği tıklanır
            // (//span[@class='aside-menu-title'])[14] (//*[text()='Languages'])[1]
        aDashboardPage.dashboardLanguages.click();
        //action.scrollByAmount(0,500).perform();

        //Dil sayısı test edilir

        String expetedYaziElementi = "9";
        String actualYazielementi = aDashboardPage.languagesYaziElementi.getText();
        System.out.println(actualYazielementi);

        String[] YaziElementi = actualYazielementi.split(" ");
        String actualYazielementiRakam= YaziElementi[1];
        Assert.assertEquals(actualYazielementiRakam,expetedYaziElementi);
        System.out.println(actualYazielementiRakam);
        Assert.assertTrue(aDashboardPage.languagesYaziElementi.isDisplayed());

    }

}
