package tests.US_32_Emre;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.xml.stream.Location;
import java.time.LocalDateTime;

public class TC_01 {
/*Kayıtlı kullanıcı siteye ulaşıp bilgileri ile
 login olduğunda  ’Settings’ kısmı
  Tıklandığında  ‘Credentials’ bölümünün
Görüntülenebildiği doğrulanmalı.
 */

    @Test
    public void AddCouponCodeTest(){
       //1-Browser açılır
       //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
       //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

       //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickAndSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
       //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickAndSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
       //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
       //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickAndSendkeys(aDashboardPage.adminSearchTextbox,""+Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        aDashboardPage.adminCouponCodesLinki.click();
       //8-Coupon Codes sayfasında ‘Add Coupon Code’ click yapılır.
        aDashboardPage.adminAddCouponCodes.click();
       //9-’Status’  pasif bir Coupon Code ulusturulur.
     ReusableMethods.addPassiveAndFakeCouponCode(ConfigReader.getProperty("brFakeName"));

        //10-Save butonu click yapılır.
        aDashboardPage.adminAddCouponCodesSave.click();
        //11-Succes yazısı görünür olduğunu test et.
        Assert.assertTrue(aDashboardPage.adminAddCouponCodesSaveSuccess.isDisplayed());
        //12-Browser kapatılır
        Driver.closeDriver();

    }

}
