package tests.US_023_Cengiz;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class TC_02 extends TestBaseRapor {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;
    @Test
    public void cashPaymentsTableElements(){

        extentTest=extentReports.createTest("Cash Payments sayfasi odeme tablo bilgileri ",
                "Cash Payments sayfası tablo basliklarinin görünür oldugu dogrulanmali");

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
        extentTest.info("Giriş yapildigini dogrulanir");

        //Cash Payments butonun görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.cashPaymentsButton.isDisplayed());
        extentTest.info("Cash Payments butonun gorunur oldugu dogrulanir");

        //Cash Payments butonu  tıklanır
        aDashboardPage.cashPaymentsButton.click();
        extentTest.info("Cash Payments butonu  tiklanir");
        ReusableMethods.wait(1);

        //Cash Payments yazisi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.cashPaymentsYazisi.isDisplayed());
        extentTest.info("Cash Payments yazisi gorunur olduğu doğrulanir");

        //USER NAME basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.userNameYazisi.isDisplayed());
        extentTest.info("USER NAME basligi gorunur oldugu dogrulanir");

        //PLAN NAME basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.planNameYazisi.isDisplayed());
        extentTest.info("PLAN NAME basligi gorunur oldugu dogrulanir");

        //PLAN PRICE basligi görünür olduğu doğrulanır
       Assert.assertTrue(aDashboardPage.planPriceYazisi.isDisplayed());
        extentTest.info("PLAN PRICE basligi gorunur oldugu dogrulanir");

        //PAYABLE AMOUNT basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.payableAmountYazisi.isDisplayed());
        extentTest.info("PAYABLE AMOUNT basligi gorunur oldugu dogrulanir");

        //START DATE basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.startDateYazisi.isDisplayed());
        extentTest.info("START DATE basligi gorunur oldugu dogrulanir");

        //END DATE basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.endDateYazisi.isDisplayed());
        extentTest.info("END DATE basligi gorunur oldugu dogrulanir");

        //ATTACHMENT basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.attachmentYazisi.isDisplayed());
        extentTest.info("ATTACHMENT basligi gorunur oldugu dogrulanir");

        //NOTES basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.notesYazisi.isDisplayed());
        extentTest.info("NOTES basligi gorunur oldugu dogrulanir");

        //STATUS basligi görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.statusYazisi.isDisplayed());
        extentTest.info("STATUS basligi gorunur oldugu dogrulanir");

        //Sirala butonu(Asagi-yukari oklari) görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.siralamaButonu.isDisplayed());
        extentTest.info("Sirala butonu(Asagi-yukari oklari) gorunur oldugu dogrulanir");


        //Sayfa kapatilir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");


    }
}
