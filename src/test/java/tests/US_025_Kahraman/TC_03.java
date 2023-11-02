package tests.US_025_Kahraman;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_03 {
        @Test
       public void planSilme() {
            //Verilen URL sayfasına (https://qa.smartcardlink.com/login) git
            Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

             ADashboardPage aDashboardPage = new ADashboardPage();

            //giriş için Signin elementine tıkla
            aDashboardPage.signinButtonElementi.click();

            //login sayfasında Email textbox'ına Kayıtlı Admin email bilgisi gir
            aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

            //Password textbox'ına kayıtlı admin password bilgisi gir
            aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

            //Login butonuna tıkla.
            aDashboardPage.loginElementi.click();

            //Dashboard sayfasında "Plans" seçeneğini tıkla
            aDashboardPage.planlarElementi.click();

            // Silme Öncesi mevcut tüm planların sayısını al
            WebElement planlarElementiSayisi= aDashboardPage.planlarinSayisiElementi;
            String ilkPlanSayisi=planlarElementiSayisi.getText();

            //plan sayısını kontrol için konsola yazdır
            System.out.println(ilkPlanSayisi);
            ReusableMethods.wait(3);

            //ilk sıradaki Planın silme tuşuna bas ve görmek için bekle
            aDashboardPage.planSil.click();
            ReusableMethods.wait(2);

            //ilk sıradaki Planın silme onayla tuşuba bas ve görmek için bekle
            aDashboardPage.silmeOnay.click();
            ReusableMethods.wait(2);

            //silme sonrası tüm planların sayısı alıp konsola yazıdr.
            WebElement sonPlanlarSayisi = aDashboardPage.planlarinSayisiElementi;
            System.out.println(sonPlanlarSayisi.getText());

            //ilk plan sayısı ile sildikten sonraki plan sayıları eşit değilse test başarılıdır.
            Assert.assertNotEquals(sonPlanlarSayisi.getText(),ilkPlanSayisi);

            //sayfayı kapat
            Driver.closeDriver();

        }

}
