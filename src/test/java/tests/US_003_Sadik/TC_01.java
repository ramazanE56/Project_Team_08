package tests.US_003_Sadik;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void AnasayfaBodyBolumu(){
        extentTest = extentReports.createTest("Anasayfada body bölümündeki foksiyonları görüntüleme testi"," Kullanıcı anasayfa body bölümündeki fonksiyonları görebilmeli");
        // 1- Browser açılır
        // 2- adres çubuğuna URL girilir
        // 3- Enter tuşuna tıklanır
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        SmartcardlinkPage smartcardlinkPage= new SmartcardlinkPage();

        // 4-Get Started butonunun görünür olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.getStartedButonu.isDisplayed());
        extentTest.pass("get started butonunu görüntülenebilir");

         //  5-Previus butonunun görünür olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.ChoosePreviousButonu.isDisplayed());
        extentTest.pass("Previus butonunu görüntülenebilir");

        // 6- Next butonunun görünür olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.ChooseNextButonu.isDisplayed());
        extentTest.pass("Next butonu görüntülenebilir");

        //7- Standart choose Plan butonunun görünür olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.StandartChoosePlanButonu.isDisplayed());
        extentTest.pass("Standart Choose PlanButonu görüntülenebilir");
        ReusableMethods.wait(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",smartcardlinkPage.SilveragecisButonu );

        //8- Silver Choose  Plan butonunun görünür olduğu doğrulanır.
         Assert.assertTrue(smartcardlinkPage.SilverChoosePlanButonu.isDisplayed());
        extentTest.pass("Silver Choose PlanButonu görüntülenebilir");

         ReusableMethods.wait(2);

       //9- Gold Choose  Plan butonunun görünür olduğu doğrulanır.
        smartcardlinkPage.GoldagecisButonu.click();
        ReusableMethods.wait(2);
       Assert.assertTrue(smartcardlinkPage.GoldChoosePlanButonu.isDisplayed());
       extentTest.pass("Golden Choose PlanButonu görüntülenebilir");

        //10- Unlimited  Choose  Plan butonunun görünür olduğu doğrulanır.
        smartcardlinkPage.UnlimiteGecisButonu.click();
        ReusableMethods.wait(2);
       Assert.assertTrue(smartcardlinkPage.UnlimitChoosePlanButonu.isDisplayed());
        extentTest.pass("Unlimited Choose PlanButonu görüntülenebilir");

        //11-Stories Fromdaki   butonlarının görünür olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.StoriesFromButonu1.isDisplayed());
        extentTest.pass("1.Stories From butonu görüntülenebilir");
        Assert.assertTrue(smartcardlinkPage.StoriesFromButonu2.isDisplayed());
        extentTest.pass("2. Stories From butonu görüntülenebilir");

        //12.Contact Us kısmındaki Send Message butonunun görünür olduğu doğrulanır."
        Assert.assertTrue(smartcardlinkPage.SendMessageButonu.isDisplayed());
        extentTest.pass("Send Message butonu görüntülenebilir ");

        //13-Subscribe here  kısmındaki Subscribe  butonunun görünür olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.SubscribeButonu.isDisplayed());
        extentTest.pass("Subscribe butonu görüntülenebilir");

        //14 -Browser kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }
}
