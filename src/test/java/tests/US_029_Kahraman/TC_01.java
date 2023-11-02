package tests.US_029_Kahraman;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01 {
    @Test
    public void paraBirimleriTesti()  {

        //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //Sign In butonuna tıkla
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı Admin email bilgisi gir
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

        //Password textbox'ına kayıtlı admin password bilgisi gir
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

        //Login butonuna tıkla
        aDashboardPage.loginElementi.click();

        //Dashboard sayfasında Currencies sekmesine tıkla
        aDashboardPage.paraBirimleri.click();


        //Para birimleri sayfasının altındaki geçerli para birimlerinin sayısı görüldüğünü doğrula
        WebElement paraBirimleriSayisi= aDashboardPage.paraBirimleriSayisi;
        Assert.assertTrue(paraBirimleriSayisi.isDisplayed());

        //Para birimlerinin toplam sayısını konsola yazdır
        System.out.println(paraBirimleriSayisi.getText());

        //Sayfanın altında para birimleri sayısını görmek içşn bekle
        ReusableMethods.wait(3);

        //Sayfa Kapatılır
        Driver.closeDriver();


    }
}
