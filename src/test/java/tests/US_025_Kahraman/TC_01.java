package tests.US_025_Kahraman;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01 {
    @Test
    public void planlariKontrol() {

        //Plans sayfasındaki planların sayısının görüntelebildiği testi.

        //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ADashboardPage aDashboardPage = new ADashboardPage();

        //Sign in butonunu tıkla
        aDashboardPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

        //Password textbox'ına kayıtlı admin password bilgisi girilir.
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

        //Login butonuna click yapılır.
        aDashboardPage.loginElementi.click();

        //Dashboard sayfasında "Plans" seçeneğini tıklanır
        aDashboardPage.planlarElementi.click();

        //Planlar sayfasında kayıtlı planları görebildiğini doğrula


        //ReusableMethods.wait(3);

        WebElement planlarElementiSayisi= aDashboardPage.planlarinSayisiElementi;
        String ilkPlanSayisi=planlarElementiSayisi.getText();
        Assert.assertTrue(planlarElementiSayisi.isDisplayed());

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //plan sayısını konsolo yazdır
        System.out.println(ilkPlanSayisi);

        ReusableMethods.wait(3);

        //Sayfa Kapatılır
        Driver.closeDriver();



    }
}