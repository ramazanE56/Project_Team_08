package tests.US_003_Sadik;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    @Test(groups = "e2e")
    public void AnasayfaBodyfonsiyonlari(){
        extentTest = extentReports.createTest("Body bölümü  fonksiyonlarının aktiflik doğrulama  testi",
                " Kullanıcı anasayfa body bölümünündeki fonksiyonların aktifliğini doğrular");

      //  1- Browser açılır
       // 2- Adres çubuğuna URL girilir
      //  3- Enter tuşuna tıklanır
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

       // 4- Get Started butonunun aktif olduğu doğrulanır.
        SmartcardlinkPage smartcardlinkPage= new SmartcardlinkPage();
        Assert.assertTrue(smartcardlinkPage.getStartedButonu.isEnabled());
        extentTest.pass("get started butonunun aktif olduğu doğrulanır");

       // 5- Previus butonunun aktif olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.ChoosePreviousButonu.isEnabled());
        extentTest.pass("Previus butonunun aktif olduğudoğrulanır");

       // 6- Next  butonunun aktif olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.ChooseNextButonu.isEnabled());
        extentTest.pass("Next butonunun aktif olduğudoğrulanır");

       // 7- Standart choose Plan butonunun aktif olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.StandartChoosePlanButonu.isEnabled());
        extentTest.pass("Standart Choose PlanButonunun aktif olduğu doğrulanır");

        //  8- Silver Choose  Plan butonunun aktif olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.SilverChoosePlanButonu.isEnabled());
        extentTest.pass("Silver Choose PlanButonunun aktif olduğu doğrulanır");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",smartcardlinkPage.SilveragecisButonu );

      //  9- Gold Choose  Plan butonunun aktif olduğu doğrulanır.
         Assert.assertTrue(smartcardlinkPage.GoldChoosePlanButonu.isEnabled());
        extentTest.pass("Golden Choose PlanButonunun aktif olduğu doğrulanır");

      //  10- Unlimited Choose  Plan butonunun aktif  olduğu doğrulanır.
         Assert.assertTrue(smartcardlinkPage.UnlimitChoosePlanButonu.isEnabled());
         extentTest.pass("Unlimited Choose PlanButonunun aktif olduğu doğrulanır");

       // 11- Stories Fromdaki   butonunlarının aktif olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.StoriesFromButonu1.isEnabled());
        extentTest.pass("1.Stories From butonunun aktif olduğu doğrulanır");

        Assert.assertTrue(smartcardlinkPage.StoriesFromButonu2.isEnabled());
        extentTest.pass("2. Stories From butonunun aktif olduğu doğrulanır");

      //  12-Contact Us kısmındaki Send Messagebutonunun aktif  olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.SendMessageButonu.isEnabled());
        extentTest.pass("Send Message butonunun aktif olduğu doğrulanır ");

       // 13- Subscribe here  kısmındaki Subscribe  butonunun aktif olduğu doğrulanır.
        Assert.assertTrue(smartcardlinkPage.SubscribeButonu.isEnabled());
        extentTest.pass("Subscribe butonunun aktif olduğu doğrulanır");

        //14 -Browser kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }
}

