package tests.US_031_Mustafa;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01_US028 extends TestBaseRapor {

    @Test
    public void TC01(){

        extentTest = extentReports.createTest("Para çekme bölümünde yapılan işlemleri görüntüleyebilrme",
                "Admin bilgileriyle giriş yapıp withdraw transactions bölümüne giriş yapma");
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        LoginPage loginpage= new LoginPage();
        ADashboardPage aDashboardPage = new ADashboardPage();

        // Browser açılır
        //URL'le (https://qa.smartcardlink.com/) gidilir

        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sing in butonu tıklanır
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");

        //Admin kullanıcı adı girilir
        loginpage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna kullanıcı email i yazılır");

        //5-Admin password girilir.
        loginpage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna şifre yazılır.");
        ReusableMethods.wait(1);

        //Login butonu tıklanır
        loginpage.loginElementi.click();
        extentTest.info("login butonuna basılır.");

        //Panodan Withdraw Transactions butonuna tıklanır --(//span[text()='Withdraw Transactions'])[1]
        aDashboardPage.withdrawElementi.click();
        extentTest.info("Panodan Withdraw Transactions butonuna tıklanır");

        //Ödeme yapılan kullanıcı görüntülenir --(//div[@class='d-flex align-items-center'])[2]
        Assert.assertTrue(aDashboardPage.paidUsers.isDisplayed());
        extentTest.pass("Ödeme yapılan kullanıcının görüntülenir olduğu test edilir");
        ReusableMethods.wait(1);


        // Ödeme tutarı görüntülenir --(//span[@class='badge bg-success me-2'])[1]
        Assert.assertTrue(aDashboardPage.amountElementi.isDisplayed());
        extentTest.pass("ödemenin görüntülenir olduğu test edilir");
        ReusableMethods.wait(1);

        // Ödeme tipi görüntülenir -- (//td[@class='whitespace-nowrap px-3 py-2 md:px-6 md:py-4 text-sm leading-5 text-gray-900 dark:text-white'])[3]
        Assert.assertTrue(aDashboardPage.paymentElementi.isDisplayed());
        extentTest.pass("ödeme türünün görüntülenir olduğu test edilir");
        ReusableMethods.wait(1);

        // Ödeme tarihi görüntülenir -- (//td[@class='whitespace-nowrap px-3 py-2 md:px-6 md:py-4 text-sm leading-5 text-gray-900 dark:text-white'])[4]
        Assert.assertTrue(aDashboardPage.dateElementi.isDisplayed());
        extentTest.pass("ödeme tarihinin görüntülenir olduğu test edilir");
        ReusableMethods.wait(1);

        Assert.assertTrue(aDashboardPage.webTableIlkSatirElementi.isDisplayed());
        extentTest.pass("İlk satırın görüntülendiği test edilir");








    }
}
