package tests.US_002_bhdr;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void girisSayfasiGorunumTesti(){
        extentTest = extentReports.createTest("giriş bölümündeki foksiyonları görüntüleme testi",
                " Kullanıcı home bölümündeki fonksiyonları görebilmeli");

        //1.Browser açılır
        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        //3.home butonun görünür oldugu test edilir.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        String actualHomeButonElementi= smartcardlinkPage.homeButonElementi.getText();
        String expectedIcerik="Home";
        Assert.assertEquals(actualHomeButonElementi,expectedIcerik);
        extentTest.info("home butonun görüntülenebilir");

        //4.Features menüsünün görünür oldugu test edilir
        String actualFeaturesButonElementi=smartcardlinkPage.featuresButonElementi.getText();
        String expectedIcerikFeatures="Features";
        Assert.assertEquals(actualFeaturesButonElementi,expectedIcerikFeatures);
        extentTest.info("Features menüsünün görüntülenir");


        //5.About menüsünün görünür oldugu test edilir
        String actualAboutButonElementi=smartcardlinkPage.aboutButonElementi.getText();
        String expectedAbout="About";
        Assert.assertEquals(actualAboutButonElementi,expectedAbout);
        extentTest.info("About menüsünün görüntülenir");

        //6.Pricing  menüsünün görünür oldugu test edilir
        String actualPricingButonElemnti=smartcardlinkPage.pricingButonElementi.getText();
        String expectedPricing="Pricing";
        Assert.assertEquals(actualPricingButonElemnti,expectedPricing);
        extentTest.info("Pricing menüsünün görüntülenir");

        //7.Contact  menüsünün görünür oldugu test edilir
        String actualContactButonElemnti=smartcardlinkPage.contactButonElementi.getText();
        String expectedContact="Contact";
        Assert.assertEquals(actualContactButonElemnti,expectedContact);
        extentTest.info("Contact  menüsünün görüntülenir");
    }

}
