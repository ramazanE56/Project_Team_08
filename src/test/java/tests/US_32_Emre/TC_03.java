package tests.US_32_Emre;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_03 {
    /*Admin  ‘Coupon Codes’ sayfasında oluşturduğu
Coupon code ‘u aktif edebildiği doğrulanmalı.

     */

    @Test
    public void couponCodeActivationTest(){
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
        ReusableMethods.clickAndSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        aDashboardPage.adminCouponCodesLinki.click();
        //8-Olusturulan Coupon Name 'ini  Search textbox'ta aratılır.
        ReusableMethods.clickAndSendkeys(aDashboardPage.adminSearchTextbox,ConfigReader.getProperty("brFakeName"));
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu  olmalıdır.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();
        Assert.assertEquals(expectedCouponName,actualCouponName);
        //10-Oluşturulan Coupon 'un Status buttonu click yapılır.
        Boolean couponFirstStatus=aDashboardPage.adminFirstCouponStatusButton.isSelected();
        System.out.println(couponFirstStatus);
        //11-Oluşturulan Coupon 'un aktif edilebildiği doğrulanır.

        Boolean fistStatus=aDashboardPage.adminFirstCouponStatusButton.isSelected();

    }
}
