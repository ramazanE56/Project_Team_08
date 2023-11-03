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
import utilities.TestBaseRapor;

public class TC_01_02_03_04_05 extends TestBaseRapor {
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
    public void tc01_addCouponCodeTest() {
        extentTest=extentReports.createTest("Admin Coupon Code oluşturma","Admin kayıtlı bilgilerini girerek 'Coupon Codes' sayfasına ulaşıp 'Add Coupon Code' butonuna basıp gerekli bilgileri girerek bir Coupon Code oluşturabilmeli ");
        //1-Browser açılır.
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Admin verilen url adresine gider.");
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        ReusableMethods.clickAndSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna admin emaili yazılır");
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickAndSendkeys(loginPage.passwordKutusuElementi, ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna admin şifresi yazılır");
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage = new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox, "" + Keys.TAB + Keys.TAB + Keys.PAGE_DOWN);
        aDashboardPage.adminCouponCodesLinki.click();
        extentTest.info("Yan menüden ‘Coupon Codes’  kısmına click yapılır.");
        //8-Coupon Codes sayfasında ‘Add Coupon Code’ click yapılır.
        ReusableMethods.wait(1);
        aDashboardPage.adminAddCouponCodes.click();
        extentTest.info("Coupon Codes sayfasında ‘Add Coupon Code’ click yapılır.");
        //9-’Status’  pasif bir Coupon Code ulusturulur.
        ReusableMethods.wait(1);
        ReusableMethods.couponCodeCreate(ConfigReader.getProperty("brFakeName"), 52, aDashboardPage.adminAddCouponCodesCouponNameTextbox);
        ReusableMethods.buttonOnOff(aDashboardPage.adminAddCouponStatusButton, false);
        extentTest.info("’Status’  pasif bir Coupon Code ulusturulur.");
        //10-Save butonu click yapılır.
        aDashboardPage.adminAddCouponCodesSave.click();
        extentTest.info("Save butonu click yapılır.");
        //11-Succes yazısı görünür olduğunu test et.
        Assert.assertTrue(aDashboardPage.adminAddCouponCodesSaveSuccess.isDisplayed());
        extentTest.pass("Coupon Code oluşturularak Succes yazısı görünür olduğunu test edilir.");
        //12-Browser kapatılır
        Driver.closeDriver();
    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code ‘un bilgilerini görüntüleyebildiği Doğrulanmalı.
    @Test(priority = 1,dependsOnMethods = "tc01_addCouponCodeTest")
    public void tc02_couponCodeContainsVisibilityTest() {
        extentTest=extentReports.createTest("Oluşturulan Coupon Code bilgilerinin görüntülenebilir olması ","Oluşturulan Coupon Code bilgileri 'Coupon Codes' sayfasında görüntülenebilmeli.");
        //1-Browser açılır.
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Admin verilen url adresine gider.");
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna admin emaili yazılır");
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna admin password yazılır");
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        extentTest.info("Yan menüden ‘Coupon Codes’  kısmına click yapılır.");
        //8-Olusturulan Coupon Name  Search textbox'ta aratılır.
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminCouponSearchTextbox,ConfigReader.getProperty("brFakeName"));
        ReusableMethods.wait(1);
        extentTest.info("Olusturulan Coupon Name  Search textbox'ta aratılır.");
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu ve bilgilerinin görüntülenebildiğini test et.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();

        Assert.assertEquals(expectedCouponName,actualCouponName);
        extentTest.pass("ilk eşleşen kuponun 'Coupon Name' ile oluşturduğumuz kuponun 'Couponun Name' bilgilerinin aynı olduğu test edilir.");
        Assert.assertTrue(aDashboardPage.adminFirstCouponType.isDisplayed());
        extentTest.pass("Coupon Type bilgisinin görünür olduğu test edilir.");
        Assert.assertTrue(aDashboardPage.adminFirstCouponDiscount.isDisplayed());
        extentTest.pass("Coupon Discount bilgisinin görünür olduğu test edilir.");
        Assert.assertTrue(aDashboardPage.adminFirstCouponExpireAt.isDisplayed());
        extentTest.pass("Coupon Expire At bilgisinin görünür olduğu test edilir.");
        //10-browser kapatılır.
        Driver.closeDriver();
    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code ‘u aktif edebildiği doğrulanmalı.
    @Test(priority = 2,dependsOnMethods = "tc01_addCouponCodeTest")
    public void tc03_couponCodeActivationTest(){
        extentTest=extentReports.createTest("Oluşturulan Coupon Code'un aktif edilebilmesi ","Oluşturulan Coupon Code  'Coupon Codes' sayfasında aktif edilebilmeli.");
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Admin verilen url adresine gider.");
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna admin emaili yazılır");
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna admin password yazılır");
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        extentTest.info("Yan menüden ‘Coupon Codes’  kısmına click yapılır.");
        //8-Olusturulan Coupon Name 'ini  Search textbox'ta aratılır.
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminCouponSearchTextbox,ConfigReader.getProperty("brFakeName"));
        ReusableMethods.wait(1);
        extentTest.info("Olusturulan Coupon Name  Search textbox'ta aratılır.");
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu  olmalıdır.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();
        Assert.assertEquals(expectedCouponName,actualCouponName);
        extentTest.pass("ilk eşleşen kuponun 'Coupon Name' ile oluşturduğumuz kuponun 'Couponun Name' bilgilerinin aynı olduğu test edilir.");
        //10-Oluşturulan Coupon 'un Status buttonu click yapılır.
        ReusableMethods.buttonOnOff(aDashboardPage.adminFirstCouponStatusButton,true);
        extentTest.info("Oluşturulan Coupon 'un Status buttonu click yapılır.");
        //11-Oluşturulan Coupon 'un aktif edilebildiği ve 'Success' yazısı çıktığını test et.
        Assert.assertTrue(aDashboardPage.adminAddCouponCodesSaveSuccess.isDisplayed());
        extentTest.pass("Success yazısı çıktığı test edilir.");
        Assert.assertTrue(aDashboardPage.adminFirstCouponStatusButton.isSelected());
        extentTest.pass("Status butununun aktif olduğu test edilir.");
        //12- Browser kapatilir.
        Driver.closeDriver();


    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code ‘un bilgilerini düzenleyebildiği doğrulanmalı.
    @Test(priority = 3 , dependsOnMethods = "tc01_addCouponCodeTest")
    public void tc04_couponCodeEditionTest(){
        extentTest=extentReports.createTest("Oluşturulan Coupon Code'un aktif edilebilmesi ","Oluşturulan Coupon Code  'Coupon Codes' sayfasında aktif edilebilmeli.");
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Admin verilen url adresine gider.");
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna admin emaili yazılır");
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna admin password yazılır");
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        extentTest.info("Yan menüden ‘Coupon Codes’  kısmına click yapılır.");
        //8-Olusturulan Coupon Name 'ini  Search textbox'ta aratılır.
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminCouponSearchTextbox,ConfigReader.getProperty("brFakeName"));
        ReusableMethods.wait(1);
        extentTest.info("Olusturulan Coupon Name  Search textbox'ta aratılır.");
        //9-ilk sıradaki Coupon 'un oluşturulan Coupon olduğu  olmalıdır.
        String expectedCouponName = ConfigReader.getProperty("brFakeName");
        String actualCouponName=aDashboardPage.adminFirstCouponName.getText();
        Assert.assertEquals(expectedCouponName,actualCouponName);
        extentTest.pass("ilk eşleşen kuponun 'Coupon Name' ile oluşturduğumuz kuponun 'Couponun Name' bilgilerinin aynı olduğu test edilir.");
        //10-Oluşturulan Coupon 'un Edit buttonu click yapılır.
        aDashboardPage.adminFirstCouponEditButton.click();
        extentTest.info("Oluşturulan Coupon 'un Edit buttonu click yapılır.");
        //11-Coupon Code Edit edilir.
        ReusableMethods.couponCodeCreate(ConfigReader.getProperty("brFakeName")+"_EDIT"
                                        ,34,aDashboardPage.adminEditCouponNameTextbox);
        ReusableMethods.buttonOnOff(aDashboardPage.adminEditCouponStatusButton,false);
        extentTest.info("Coupon Code Edit edilir.");
        //12-edit de Save butonu click yapilir.
        aDashboardPage.adminEditCouponSaveButton.click();
        extentTest.info("edit de Save butonu click yapilir.");
        //13-success yazisi göründüğü test edilir.
        Assert.assertTrue(aDashboardPage.adminAddCouponCodesSaveSuccess.isDisplayed());
        extentTest.pass("Edit gerçekleştirilerek 'success' yazisi göründüğü test edilir.");
        //14-Browser kapatilir.
        Driver.closeDriver();
    }

    //Admin  ‘Coupon Codes’ sayfasında oluşturduğu Coupon code‘u silebildiği doğrulanmalı.
    @Test(priority = 4,dependsOnMethods = "tc04_couponCodeEditionTest")
    public void tc05_couponCodeDeleteTest(){
        extentTest=extentReports.createTest("Oluşturulan Coupon Code'un aktif edilebilmesi ","Oluşturulan Coupon Code  'Coupon Codes' sayfasında aktif edilebilmeli.");
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Admin verilen url adresine gider.");
        //3-Sign In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //4-Email textbox'ına Kayıtlı Admin email bilgisi girilir.
        LoginPage loginPage=new LoginPage();
        ReusableMethods.clickClearSendkeys(loginPage.emailKutusuElementi, ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna admin emaili yazılır");
        //5-Password textbox'ına geçerli adminpassword bilgisi girilir
        ReusableMethods.clickClearSendkeys(loginPage.passwordKutusuElementi,ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna admin password yazılır");
        //6-Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");
        //7- Yan menüden ‘Coupon Codes’  kısmına click yapılır.
        ADashboardPage aDashboardPage=new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox,""+ Keys.TAB+Keys.TAB+Keys.PAGE_DOWN);
        ReusableMethods.wait(1);
        aDashboardPage.adminCouponCodesLinki.click();
        extentTest.info("Yan menüden ‘Coupon Codes’  kısmına click yapılır.");
        //8-Oluşturulan Coupon Search textboxta aratılır.
        //9-listede varsa Delete butonu click yapilir.
        //10-gelen Delete alert de 'YES!DELETE' click yapilir.
        ReusableMethods.couponDelete(ConfigReader.getProperty("brFakeName")+"_EDIT",false);
        extentTest.info("Oluşturulan Coupon Search textboxta aratılır.");
        extentTest.info("listede varsa Delete butonu click yapilir.");
        extentTest.info("gelen Delete alert de 'YES!DELETE' click yapilir.");
        //11-'Deleted' alert göründüğü test edilir.
        Assert.assertTrue(aDashboardPage.adminCouponDeletedAlert.isDisplayed());
        extentTest.pass("Delete gerçekleştirilerek 'Deleted' alert göründüğü test edilir.");
        //12-Browser kapatilir.
        Driver.closeDriver();
    }

}
