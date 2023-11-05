package tests.US_025_Kahraman;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_03 extends TestBaseRapor {
        @Test
       public void planSilme() {
             extentTest=extentReports.createTest("Kayıtlı planı silme Testi",
                     "kayıtlı planı silinebilidiği doğrulanmalı");

             //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
             Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
             extentTest.info("Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç");

             ADashboardPage aDashboardPage = new ADashboardPage();

             //Sign In butonuna tıkla
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

            //Dashboard sayfasında "Plans" seçeneğini tıkla
            aDashboardPage.planlarElementi.click();
             extentTest.info("Dashboard sayfasında Plans seçeneğini tıkla");

            // Silme Öncesi mevcut tüm planların sayısını al
            WebElement planlarElementiSayisi= aDashboardPage.planlarinSayisiElementi;
            String ilkPlanSayisi=planlarElementiSayisi.getText();
             extentTest.info("Silme Öncesi mevcut tüm planların sayısını al");

            //plan sayısını kontrol için konsola yazdır
            System.out.println(ilkPlanSayisi);
            ReusableMethods.wait(3);
            //ilk plan sayısını kontrol için konsola yazdır

            //ilk sıradaki Planın silme tuşuna bas ve görmek için bekle
            aDashboardPage.planSil.click();
             extentTest.info("ilk sıradaki Planın silme tuşuna bas ve görmek için bekle");
            ReusableMethods.wait(2);

            //ilk sıradaki Planın silme onayla tuşuba bas ve görmek için bekle
            aDashboardPage.silmeOnay.click();
            extentTest.info("ilk sıradaki Planın silme onayla tuşuba bas ve görmek için bekle");
            ReusableMethods.wait(2);

            //silme sonrası tüm planların sayısı alıp konsola yazıdr.
            WebElement sonPlanlarSayisi = aDashboardPage.planlarinSayisiElementi;
            System.out.println(sonPlanlarSayisi.getText());
            extentTest.info("silme sonrası tüm planların sayısı alıp konsola yazdır.");

            //ilk plan sayısı ile sildikten sonraki plan sayıları eşit değilse test başarılıdır.
            Assert.assertNotEquals(sonPlanlarSayisi.getText(),ilkPlanSayisi);
             extentTest.pass("ilk plan sayısı ile sildikten sonraki plan sayıları eşit değilse test başarılı olduğu doğulandı");

            //sayfayı kapat
            Driver.closeDriver();

        }

}
