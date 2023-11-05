package tests.US_023_Cengiz;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

import java.io.IOException;

public class TC_02 extends TestBaseRapor {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;
    @Test
    public void cashPayments() throws IOException {

        extentTest=extentReports.createTest("Manuel odeme  bilgileri ve manuel odeme sayilari ",
                "Cash Payments sayfası manuel odeme  bilgileri ve manuel odeme sayilarinin görünür oldugu dogrulanmali");

        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");

        //Email kutusuna admin email adresi giriniz
        loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));
        extentTest.info("Email kutusuna admin email adresi girilir");

        //Password kutusuna  admin password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna admin password girilir");

        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");

        //Admin Dashboard sayfasına giriş yapıldığı doğrulanır.

        aDashboardPage=new ADashboardPage();

        Assert.assertTrue(aDashboardPage.dashboardYaziElementi.isDisplayed());
        extentTest.pass("Giriş yapildigini dogrulanir");

        //Cash Payments butonun görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.cashPaymentsButton.isDisplayed());
        extentTest.pass("Cash Payments butonun gorunur oldugu dogrulanir");

        //Cash Payments butonu  tıklanır
        aDashboardPage.cashPaymentsButton.click();
        extentTest.pass("Cash Payments butonu  tiklanir");
        ReusableMethods.wait(1);

        //Cash Payments yazisi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.cashPaymentsYazisi.isDisplayed());
        extentTest.pass("Cash Payments yazisi gorunur olduğu doğrulanir");

        //USER NAME basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.userNameYazisi.isDisplayed());
        extentTest.pass("USER NAME basligi gorunur oldugu dogrulanir");

        //PLAN NAME basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.planNameYazisi.isDisplayed());
        extentTest.pass("PLAN NAME basligi gorunur oldugu dogrulanir");

        //PLAN PRICE basligi görünür olduğu doğrulanır
       Assert.assertTrue(aDashboardPage.planPriceYazisi.isDisplayed());
        extentTest.pass("PLAN PRICE basligi gorunur oldugu dogrulanir");

        //PAYABLE AMOUNT basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.payableAmountYazisi.isDisplayed());
        extentTest.pass("PAYABLE AMOUNT basligi gorunur oldugu dogrulanir");

        //START DATE basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.startDateYazisi.isDisplayed());
        extentTest.pass("START DATE basligi gorunur oldugu dogrulanir");

        //END DATE basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.endDateYazisi.isDisplayed());
        extentTest.pass("END DATE basligi gorunur oldugu dogrulanir");

        //ATTACHMENT basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.attachmentYazisi.isDisplayed());
        extentTest.pass("ATTACHMENT basligi gorunur oldugu dogrulanir");

        //NOTES basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.notesYazisi.isDisplayed());
        extentTest.pass("NOTES basligi gorunur oldugu dogrulanir");

        //STATUS basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.statusYazisi.isDisplayed());
        extentTest.pass("STATUS basligi gorunur oldugu dogrulanir");

        //Sirala butonu(Asagi-yukari oklari) görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.siralamaButonu.isDisplayed());
        extentTest.pass("Sirala butonu(Asagi-yukari oklari) gorunur oldugu dogrulanir");

        //Yapılan manuel ödemelerin görüntülenebildiği test edilir

        Assert.assertTrue(aDashboardPage.cashPaymentsListesi.isDisplayed());
        extentTest.pass("Yapılan manuel ödemelerin görüntülenebildiği test edilir");

        //Yapilan manuel odemelerin fotoğrafi cekilir
        ReusableMethods.getScreenshot("Manuel odeme bilgileri");
        extentTest.info("Yapilan manuel odemelerin fotoğrafi cekilir");

        //Yapılan manuel ödemelerin sayısının görüntülenebildiği test edilir

        Assert.assertTrue(aDashboardPage.cashPaymentsSayisi.isDisplayed());
        extentTest.pass("Yapılan manuel ödemelerin sayisinin görüntülenebildiği test edilir");


        //Yapilan manuel odemelerin sayisinin fotoğrafi cekilir
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(2);

        ReusableMethods.getScreenshot("Manuel odeme  sayisi");
        extentTest.info("Yapilan manuel odemele sayisinin fotoğrafi cekilir");


        //Sayfa kapatilir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");


    }
}
