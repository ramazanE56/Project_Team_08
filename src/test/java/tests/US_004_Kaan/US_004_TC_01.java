package tests.US_004_Kaan;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
        extentTest.pass("Belirlenen site Url'li ile browserdan siteye erişilebilir olmalıdır.");


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
        extentTest.pass("Home page sayfasında iken, footer bölümündeki fonksiyonların görünür olduğu test edilmiştir.");
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
        extentTest.pass( "FAQ linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Privacy Policy | Smart Card Link");
        String expectedPPTitle = "Privacy Policy | Smart Card Link";
        String actualPPTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualPPTitle, expectedPPTitle);
        System.out.println(expectedPPTitle + " linki dogru calısmaktadır.");
        extentTest.pass(" Privacy Policy linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Pinterest - Türkiye");
        ReusableMethods.wait(2);
        ReusableMethods.getScreenshot("X Linkine tıklanınca açılan sayfa bu.");
        ReusableMethods.wait(2);
        String expectedPiTitle = "Pinterest - Türkiye";
        String actualPiTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualPiTitle, expectedPiTitle);
        System.out.println(expectedPiTitle + " linki dogru calısmaktadır.");
        extentTest.pass( "Pinterest linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Facebook - Giriş Yap veya Kaydol");
        String expectedFBTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualFBTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualFBTitle, expectedFBTitle);
        System.out.println(" Facebook linki dogru calısmaktadır.");
        extentTest.pass( "Facebook linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Instagram");
        String expectedInsTitle = "Instagram";
        String actualInsTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualInsTitle, expectedInsTitle);
        System.out.println(expectedInsTitle + " linki dogru calısmaktadır.");
        extentTest.pass( " Instagram linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("Terms & Conditions | Smart Card Link");
        String expectedTCTitle = "Terms & Conditions | Smart Card Link";
        String actualTCTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTCTitle, expectedTCTitle);
        System.out.println(expectedTCTitle + " linki dogru calısmaktadır.");
        extentTest.pass( " Terms & Conditions linki dogru calısmaktadır.");
        ReusableMethods.switchToWindow("X. Olan biten burada / X");
        String expectedXTitle = "X. Olan biten burada / X";
        String actualXTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualXTitle,expectedXTitle,"X linki dogru calışmamaktadır. Linke tıklayınca Pinterest sayfası açılmaktadır");
        extentTest.fail("X linki dogru calışmamaktadır." );
        //Sayfa kapatılır
        extentTest.info("Sayfa kapatilir.");
        Driver.getDriver().quit();


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


