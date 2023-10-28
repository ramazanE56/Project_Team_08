package tests.US_018_Ismail;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    @Test
    public void dashBoardSayfasi(){
        extentTest=extentReports.createTest("Admin Dashboard sayfasına erişim","Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek profil bilgileri sayfasına ulaşabilmeli");
        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //email ve Password değerlerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        extentTest.info("Email kutusuna kullanıcı emaili ve password kutusuna kullanıcı şifresi yazılır");
        loginPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");
        ReusableMethods.wait(2);
        ADashboardPage aDashboardPage = new ADashboardPage();
        //1-Toplam aktif kullanıcı sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalActiveUsersElementi.isDisplayed());
        extentTest.pass("Toplam aktif kullanıcı sayısının görünür olduğu test edilir");
        //2-Toplam aktif olmayan kullanıcı sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalDeActiveUsersElementi.isDisplayed());
        extentTest.pass("Toplam aktif olmayan kullanıcı sayısının görünür olduğu test edilir");
        //3-Toplam aktif Vcard sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalActiveVcardsElementi.isDisplayed());
        extentTest.pass("Toplam aktif Vcard sayısının görünür olduğu test edilir");
        //4-Toplam aktif olmayan Vcard sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalDeActiveVcardsElementi.isDisplayed());
        extentTest.pass("Toplam aktif olmayan Vcard sayısının görünür olduğu test edilir");
        //5-Kullanıcı plan oranları tablosunun görünür olduğu doğrulanır.
        Assert.assertTrue(aDashboardPage.plansbyUsersElementi.isDisplayed());
        extentTest.pass("Kullanıcı plan oranları tablosunun görünür olduğu test edilir");
        //6-Kullanıcı gelir grafiğinin görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.graficElementi.isDisplayed());
        extentTest.pass("Kullanıcı gelir grafiğinin görünür olduğu test edilir");
        //7-Günlük kullanıcı kayıtlarının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.gunlukElementi.isDisplayed());
        extentTest.pass("Günlük kullanıcı kayıtlarının görünür olduğu test edilir");
        //8-Haftalık kullanıcı kayıtlarının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.haftalikElementi.isDisplayed());
        extentTest.pass("Haftalık kullanıcı kayıtlarının görünür olduğu test edilir");
        //9-Aylık kullanıcı kayıtlarının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.aylikElementi.isDisplayed());
        extentTest.pass("Aylık kullanıcı kayıtlarının görünür olduğu test edilir");
        Driver.closeDriver();
    }
}
