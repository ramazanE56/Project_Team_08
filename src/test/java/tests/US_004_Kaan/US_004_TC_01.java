package tests.US_004_Kaan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.Set;


public class US_004_TC_01 extends TestBaseRapor {
/*
    1. Belirlenen site Url'li ile browserdan siteye erişilebilir olmalıdır.
    2. Home page sayfasında iken, footer bölümündeki fonksiyonların görünür olduğunu test eder.
    3. Home page sayfasında iken, footer bölümündeki fonksiyonların aktif olduğunu test eder.
 */


    @Test
    public void footerTesti() throws IOException {
        extentTest = extentReports.createTest("Footer bölümündeki fonksiyonların test edilmesi.",
                "Home page sayfasında iken, footer bölümündeki fonksiyonların görünür ve aktif olduğunu test eder");


        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();


        String windowHandle = Driver.getDriver().getWindowHandle();

        //   1. Belirlenen site Url'li ile browserdan siteye erişilebilir olmalıdır.


        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Belirlenen site Url'li ile browserdan siteye erişilebilir olmalıdır.");


        //    2. Home page sayfasında iken, footer bolumundeki fonksiyonların gorunur olduğunu test eder.


        smartcardlinkPage.footerCopyrightElementi.click();
        ReusableMethods.wait(1);
        ReusableMethods.getScreenshot("footer bolumu");


        Assert.assertTrue(smartcardlinkPage.footerCopyrightElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerFacebookElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerTwitterElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerInstagramElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerLinkedinElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerPinterestElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerTermsConditionsElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerPrivacyPolicyElementi.isDisplayed());
        Assert.assertTrue(smartcardlinkPage.footerFAQElementi.isDisplayed());
        extentTest.info("Home page sayfasında iken, footer bölümündeki fonksiyonların görünür olduğu test edilmiştir.");
        ReusableMethods.wait(1);


        //    3. Home page sayfasında iken, footer bolumundeki fonksiyonların aktif olduğunu test eder.


        smartcardlinkPage = new SmartcardlinkPage();

        smartcardlinkPage.footerFacebookElementi.click();
        smartcardlinkPage.footerTwitterElementi.click();
        smartcardlinkPage.footerInstagramElementi.click();
        smartcardlinkPage.footerLinkedinElementi.click();
        smartcardlinkPage.footerPinterestElementi.click();
        smartcardlinkPage.footerTermsConditionsElementi.click();
        smartcardlinkPage.footerPrivacyPolicyElementi.click();
        smartcardlinkPage.footerFAQElementi.click();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        System.out.println("Footer bolumundeki linklere tiklaninca acilan sayfalarin baslik bilgileri ; ");

        for (String handle : windowHandles) {

            if (!handle.equals(windowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                System.out.println(Driver.getDriver().getTitle());
            }
        }

        System.out.println("======================");

        ReusableMethods.switchToWindow("Frequently Asked Questions | Smart Card Link");
        String expectedFAQTitle = "Frequently Asked Questions | Smart Card Link";
        String actualFAQTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualFAQTitle, expectedFAQTitle);
        System.out.println(expectedFAQTitle + " linki dogru calısmaktadır.");
        extentTest.info(expectedFAQTitle + " linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Privacy Policy | Smart Card Link");
        String expectedPPTitle = "Privacy Policy | Smart Card Link";
        String actualPPTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualPPTitle, expectedPPTitle);
        System.out.println(expectedPPTitle + " linki dogru calısmaktadır.");
        extentTest.info(expectedPPTitle + " linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Pinterest - Türkiye");
        String expectedPiTitle = "Pinterest - Türkiye";
        String actualPiTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualPiTitle, expectedPiTitle);
        System.out.println(expectedPiTitle + " linki dogru calısmaktadır.");
        extentTest.info(expectedPiTitle + " linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Facebook - Giriş Yap veya Kaydol");
        String expectedFBTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualFBTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualFBTitle, expectedFBTitle);
        System.out.println(expectedFBTitle + " linki dogru calısmaktadır.");
        extentTest.info(expectedFBTitle + " linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Instagram");
        String expectedInsTitle = "Instagram";
        String actualInsTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualInsTitle, expectedInsTitle);
        System.out.println(expectedInsTitle + " linki dogru calısmaktadır.");
        extentTest.info(expectedInsTitle + " linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Terms & Conditions | Smart Card Link");
        String expectedTCTitle = "Terms & Conditions | Smart Card Link";
        String actualTCTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTCTitle, expectedTCTitle);
        System.out.println(expectedTCTitle + " linki dogru calısmaktadır.");
        extentTest.info(expectedTCTitle + " linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("X. Olan biten burada / X");
        String expectedXTitle = "X. Olan biten burada / X";
        String actualXTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualXTitle, expectedXTitle);
        System.out.println(expectedXTitle + " linki dogru calısmaktadır.");
       /*
        extentTest.info(expectedXTitle + " linki dogru calısmamaktadır."+ "Footer bolumundeki, X simgesine tıklayınca, acılan sayfanın baslıgı ; " +

                "'"+ actualInsTitle + "'dir."+" Olması gereken baslik ise ; "+  "'" +expectedXTitle +"'" +
                "oldugundan, X simgesine tanımlanan site bilgileri dogru degildir." );
*/

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");
    }
}


//FSmart Card Link | Smart Card Link
//Frequently Asked Questions | Smart Card Link
//Privacy Policy | Smart Card Link
//Pinterest - Türkiye
//LinkedIn: Oturum Açın veya Üye Olun
//Pinterest - Türkiye
//Facebook - Giriş Yap veya Kaydol
//Instagram
//Terms & Conditions | Smart Card Link


