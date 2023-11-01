package tests.US_002_bhdr;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01 {
    @Test
    public void girisSayfasiGorunumTesti(){

        //1.Browser açılır
        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3.home butonun görünür oldugu test edilir.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        String actualHomeButonElementi= smartcardlinkPage.homeButonElementi.getText();
        String expectedIcerik="Home";
        Assert.assertEquals(actualHomeButonElementi,expectedIcerik);

        //4.Features menüsünün görünür oldugu test edilir
        String actualFeaturesButonElementi=smartcardlinkPage.featuresButonElementi.getText();
        String expectedIcerikFeatures="Features";
        Assert.assertEquals(actualFeaturesButonElementi,expectedIcerikFeatures);


        //5.About menüsünün görünür oldugu test edilir
        String actualAboutButonElementi=smartcardlinkPage.aboutButonElementi.getText();
        String expectedAbout="About";
        Assert.assertEquals(actualAboutButonElementi,expectedAbout);

        //6.Pricing  menüsünün görünür oldugu test edilir
        String actualPricingButonElemnti=smartcardlinkPage.pricingButonElementi.getText();
        String expectedPricing="Pricing";
        Assert.assertEquals(actualPricingButonElemnti,expectedPricing);

        //7.Contact  menüsünün görünür oldugu test edilir
        String actualContactButonElemnti=smartcardlinkPage.contactButonElementi.getText();
        String expectedContact="Contact";
        Assert.assertEquals(actualContactButonElemnti,expectedContact);
    }

}
