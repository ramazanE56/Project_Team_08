package tests.US_32_Emre;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01_02_03_04_05 {
    @BeforeClass
    public static void setup(){
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
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        //8-Test couponlarımız temizlenir.
        ReusableMethods.couponDelete(ConfigReader.getProperty("brFakeName")+"_EDIT",true);
        ReusableMethods.couponDelete(ConfigReader.getProperty("brFakeName"),true);
        //9-Browser kapatılır.
        Driver.closeDriver();
    }

    //Kayıtlı kullanıcı siteye ulaşıp bilgileri ile login olduğunda’Settings’ kısmı Tıklandığında‘Credentials’ bölümünün Görüntülenebildiği doğrulanmalı.
    @Test
    public void addCouponCodeTest() {
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        ReusableMethods.clickAndSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickAndSendkeys(loginPage.passwordKutusuElementi, ConfigReader.getProperty("spassword"));
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage = new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox, "" + Keys.TAB + Keys.TAB + Keys.PAGE_DOWN);
        aDashboardPage.adminCouponCodesLinki.click();
        //8-Coupon Codes sayfasında ‘Add Coupon Code’ click yapılır.
        ReusableMethods.wait(1);
        aDashboardPage.adminAddCouponCodes.click();
        //9-’Status’  pasif bir Coupon Code ulusturulur.
        ReusableMethods.wait(1);
        ReusableMethods.couponCodeCreate(ConfigReader.getProperty("brFakeName"), 52, aDashboardPage.adminAddCouponCodesCouponNameTextbox);
        ReusableMethods.buttonOnOff(aDashboardPage.adminAddCouponStatusButton, false);
        //10-Save butonu click yapılır.
        aDashboardPage.adminAddCouponCodesSave.click();
        //11-Succes yazısı görünür olduğunu test et.
        Assert.assertTrue(aDashboardPage.adminAddCouponCodesSaveSuccess.isDisplayed());
        //12-Browser kapatılır
        Driver.closeDriver();
    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code ‘un bilgilerini görüntüleyebildiği Doğrulanmalı.
    @Test(priority = 1,dependsOnMethods = "addCouponCodeTest")
    public void couponCodeContainsVisibilityTest() {
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();

        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();

        //8-Olusturulan Coupon Name 'ini  Search textbox'ta aratılır.
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminCouponSearchTextbox,ConfigReader.getProperty("brFakeName"));
        ReusableMethods.wait(1);
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu ve bilgilerinin görüntülenebildiğini test et.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();

        Assert.assertEquals(expectedCouponName,actualCouponName);
        Assert.assertTrue(aDashboardPage.adminFirstCouponType.isDisplayed());
        Assert.assertTrue(aDashboardPage.adminFirstCouponDiscount.isDisplayed());
        Assert.assertTrue(aDashboardPage.adminFirstCouponExpireAt.isDisplayed());

        //10-browser kapatılır.
        Driver.closeDriver();
    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code ‘u aktif edebildiği doğrulanmalı.
    @Test(priority = 2,dependsOnMethods = "addCouponCodeTest")
    public void couponCodeActivationTest(){
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        //8-Olusturulan Coupon Name 'ini  Search textbox'ta aratılır.
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminCouponSearchTextbox,ConfigReader.getProperty("brFakeName"));
        ReusableMethods.wait(1);
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu  olmalıdır.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();
        Assert.assertEquals(expectedCouponName,actualCouponName);
        //10-Oluşturulan Coupon 'un Status buttonu click yapılır.
        ReusableMethods.buttonOnOff(aDashboardPage.adminFirstCouponStatusButton,true);
        //11-Oluşturulan Coupon 'un aktif edilebildiği test et.
        Assert.assertTrue(aDashboardPage.adminFirstCouponStatusButton.isSelected());
        //12- Browser kapatilir.
        Driver.closeDriver();


    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code ‘un bilgilerini düzenleyebildiği doğrulanmalı.
    @Test(priority = 3 , dependsOnMethods = "addCouponCodeTest")
    public void couponCodeEditionTest(){
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        //8-Olusturulan Coupon Name 'ini  Search textbox'ta aratılır.
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminCouponSearchTextbox,ConfigReader.getProperty("brFakeName"));
        ReusableMethods.wait(1);
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu  olmalıdır.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();

        Assert.assertEquals(expectedCouponName,actualCouponName);
        //10-Oluşturulan Coupon 'un Status buttonu click yapılır.
        aDashboardPage.adminFirstCouponEditButton.click();
        //11-Coupon Code Edit edilir
        ReusableMethods.couponCodeCreate(ConfigReader.getProperty("brFakeName")+"_EDIT"
                                        ,34,aDashboardPage.adminEditCouponNameTextbox);
        ReusableMethods.buttonOnOff(aDashboardPage.adminEditCouponStatusButton,false);
        //12-edit de Save butonu click yapilir.
        aDashboardPage.adminEditCouponSaveButton.click();

        //13-success yazisi göründüğü test edilir.
        Assert.assertTrue(aDashboardPage.adminAddCouponCodesSaveSuccess.isDisplayed());

        //14-Browser kapatilir.
        Driver.closeDriver();
    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code‘u silebildiği doğrulanmalı.
    @Test(priority = 4,dependsOnMethods = "couponCodeEditionTest")
    public void couponCodeDeleteTest(){
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        //8-Oluşturulan Coupon Search textboxta aratılır.
        //9-listede varsa Delete butonu click yapilir.
        //10-gelen Delete alert de 'YES!DELETE' click yapilir.
        ReusableMethods.couponDelete(ConfigReader.getProperty("brFakeName")+"_EDIT",false);
        //11-'Deleted' alert göründüğü test edilir.
        Assert.assertTrue(aDashboardPage.adminCouponDeletedAlert.isDisplayed());
        //12-Browser kapatilir.
        Driver.closeDriver();
    }

}
