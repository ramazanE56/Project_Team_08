package tests.US_023_Cengiz;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_04 extends TestBaseRapor {

    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;

    @Test
    public void cashPaymentsPayableNumber() {

        extentTest=extentReports.createTest("Manuel odeme sayisi ",
                "Cash Payments sayfası varsa manuel odeme sayisinin goruntulenebilir oldugu dogrulanmali");

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

        //Yapılan manuel ödemelerin sayısının görüntülenebildiği test edilir

        Assert.assertTrue(aDashboardPage.cashPaymentsSayisi.isDisplayed());
        extentTest.info("Yapılan manuel ödemelerin sayısının görüntülenebildiği test edilir");
        System.out.println("Cash Payments Odeme Sayisi :\n "+ aDashboardPage.cashPaymentsSayisi.getText());

        //Sayfa kapatilir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");

    }


}
