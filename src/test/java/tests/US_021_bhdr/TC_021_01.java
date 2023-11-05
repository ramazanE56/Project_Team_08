package tests.US_021_bhdr;

import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_021_01 extends TestBaseRapor {
    @Test
    public void VCardGorunumTesti(){
        extentTest = extentReports.createTest(
                "Admin Giriş Testi",
                "Sisteme kayıtlı  Admin kullanıcı adı ve şifresiyle, sisteme giriş yapılabilmelidir.");
        //1.Browser açılır
        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("");
        //3.Sıgn In butonuna click yapılır.

        ReusableMethods.wait(2);
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Browser ile ilgili URL'e gidilir.");

        //4.eMail kutusuna kullanıcı email i yazılır
        LoginPage loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));
        extentTest.info("Email kutusuna kayıtlı admin email bilgisi girilir.");

        //5.password kutusuna kullanıcı şifresi yazılır
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna geçerli admin password bilgisi girilir.");

        //6.login butonua basılır
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        //7.Dasboard a click yapılır
        ADashboardPage aDashboardPage=new ADashboardPage();
        aDashboardPage.dashboardYaziElementi.click();
        extentTest.info("Dasboard butonuna click yapılır.");

        //7.VCards butonu click edilir.
        aDashboardPage.vCardsElementi.click();
        ReusableMethods.wait(1);
        extentTest.info("VCards butonuna click yapılır.");

        //8.VCard name butonun click edildigi dörüntüle
        aDashboardPage.vCardSearchButonuElementi.isDisplayed();
        aDashboardPage.vCardSearchButonuElementi.click();
        ReusableMethods.wait(1);
        extentTest.info("VCards name butonuna click yapıldigi görüntülenir.");

        //9.VCard butonu altındaki user name butonun click edildigi görüntüle
        aDashboardPage.userNameButonuElementi.click();
        ReusableMethods.wait(1);
        aDashboardPage.userNameButonuElementi.isDisplayed();
        extentTest.info("VCards butonu altındaki name click yapıldigi görülür.");

    }
}
