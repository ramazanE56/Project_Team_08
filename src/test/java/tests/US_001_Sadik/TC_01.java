package tests.US_001_Sadik;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test(groups = "smoke")
    public void AnasayfaDogrulama (){
        extentTest =extentReports.createTest("Kullanıcı anasayfaya gitme ve anasayfanın açıldıgını dogrulama","kullanıcı anasayfaya gidebilmeli ve sayfanın açıldıgını dogrulayabilmeli");
        //Ziyaretçi olarak "https://qa.smartcardlink.com/" adresine gidiniz
        // 1- Browser açılır
        // 2- Adres çubuğuna URL girilir
        //3- Enter tuşuna tıklanır
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        //4-Sitenin ana sayfasının açıldığı doğrulanır
        String expectedUrl="https://qa.smartcardlink.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Ana sayfa açılmadı.");

        extentTest.pass("Anasayfaya  erişim sağlandığı test edilir");

        //5-Browser kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }

}
