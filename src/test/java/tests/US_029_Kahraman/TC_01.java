package tests.US_029_Kahraman;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void paraBirimleriTesti()  {
        extentTest=extentReports.createTest("Para birimleri sayfasının altındaki geçerli para birimlerinin sayısı görüntüleme Testi",
                "Para birimleri sayfasının altındaki geçerli para birimlerinin sayısı görüntülendiğini doğrulanmalı");

        //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç");

        //Sign In butonuna tıkla
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.signinButtonElementi.click();
        extentTest.info("Sign In butonuna tıkla");

        //Email textbox'ına Kayıtlı Admin email bilgisi gir
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email textbox'ına Kayıtlı Admin email bilgisi gir");

        //Password textbox'ına kayıtlı admin password bilgisi gir
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password textbox'ına kayıtlı admin password bilgisi gir");

        //Login butonuna tıkla
        aDashboardPage.loginElementi.click();
        extentTest.info("Login butonuna tıkla");

        //Dashboard sayfasında Currencies sekmesine tıkla
        aDashboardPage.paraBirimleri.click();
        extentTest.info("Dashboard sayfasında Currencies sekmesine tıkla");


        //Para birimleri sayfasının altındaki geçerli para birimlerinin sayısı görüldüğünü doğrula
        WebElement paraBirimleriSayisi= aDashboardPage.paraBirimleriSayisi;
        Assert.assertTrue(paraBirimleriSayisi.isDisplayed());
        extentTest.pass("Para birimleri sayfasının altındaki geçerli para birimlerinin sayısı görüldüğünü doğrula");

        //Para birimlerinin toplam sayısını konsola yazdır
        System.out.println(paraBirimleriSayisi.getText());

        //Sayfanın altında para birimleri sayısını görmek içşn bekle
        ReusableMethods.wait(5);

        //Sayfa Kapatılır
        Driver.closeDriver();


    }
}
