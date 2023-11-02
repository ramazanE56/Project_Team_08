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
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void planlariKontrol() {

        //Plans sayfasındaki planların sayısının görüntelebildiği testi.

        //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ADashboardPage aDashboardPage = new ADashboardPage();
        extentTest=extentReports.createTest("Admin bilgileri ile giriş yaptıktan sonra üyelik planlarını görüntüleme testi", "Admin bilgileri ile giriş yaptıktan sonra üyelik planlarını görüntüleyebilmeli");

        //Sign in butonunu tıkla
        aDashboardPage.signinButtonElementi.click();
        extentTest.info("Sign in butonunu tıkla");

        //Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email textbox'ına Kayıtlı Admin email bilgisi girilir.");

        //Password textbox'ına kayıtlı admin password bilgisi girilir.
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password textbox'ına kayıtlı admin password bilgisi girilir.");

        //Login butonuna click yapılır.
        aDashboardPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        //Dashboard sayfasında "Plans" seçeneğini tıklanır
        aDashboardPage.planlarElementi.click();
        extentTest.info("Dashboard sayfasında Plans seçeneğini tıklanır");

        //Planlar sayfasında kayıtlı planları görebildiğini doğrula
        WebElement planlarElementiSayisi= aDashboardPage.planlarinSayisiElementi;
        String ilkPlanSayisi=planlarElementiSayisi.getText();
        Assert.assertTrue(planlarElementiSayisi.isDisplayed());

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Planlar sayfasında kayıtlı planları görebildiğini doğrula");
        //plan sayısını konsolo yazdır
        System.out.println(ilkPlanSayisi);

        ReusableMethods.wait(3);

        //Sayfa Kapatılır
        Driver.closeDriver();

    }
}