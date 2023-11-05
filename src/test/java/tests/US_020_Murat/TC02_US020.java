package tests.US_020_Murat;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC02_US020 extends TestBaseRapor {

    @Test
    public void adminHesapGecisiTesti() {

        extentTest = extentReports.createTest
                ("Admin-Kullanıcı Hesap Geçiş Testi",
                        "Admin olarak kullanıcı hesabına geçiş yapılıp, tekrar admin hesabına dönüş yapılabilmelidir.");

        //Browser ile ilgili URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Browser ile ilgili URL'e gidilir.");

        //Sign in butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign in butonuna click yapılır.");

        //Email kutusuna kayıtlı admin email bilgisi girilir.
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email kutusuna kayıtlı admin email bilgisi girilir.");

        //Password kutusuna geçerli admin password bilgisi girilir.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password kutusuna geçerli admin password bilgisi girilir.");

        //Login butonuna click yapılır.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna click yapılır.");

        // User menusu click yapılır.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.userMenuElementi.click();
        extentTest.info("User menusu click yapılır.");

        //Admin hesabından kullanıcı hesabına geçiş yapılır.
        aDashboardPage.impersonateElementi.click();
        extentTest.info("Admin hesabından kullanıcı hesabına geçiş yapılır.");

        //Kullanıcı hesabına geçiş yapıldığı doğrulanır.
        String actuelKullaniciIsmiElementi = aDashboardPage.kullaniciProfilIsimElementi.getText();
        String unExpectedKullaniciIsmiElementi = "admin23 admin";
        Assert.assertNotEquals(actuelKullaniciIsmiElementi,unExpectedKullaniciIsmiElementi);
        extentTest.pass("Kullanıcı hesabına geçiş yapılabildiği test edilir.");

        //Kullanıcı hesabından admin hesaba geri dönüş yapılır.
        aDashboardPage.adminHesabaGecisElementi.click();
        extentTest.info("Kullanıcı hesabından admin hesaba geri dönüş yapılır.");

        //Admin hesabına geri dönüş yapıldığı doğrulanır.
        actuelKullaniciIsmiElementi = aDashboardPage.kullaniciProfilIsimElementi.getText();
        String expectedKullaniciIsmiElementi = "admin23 admin";
        Assert.assertEquals(actuelKullaniciIsmiElementi,expectedKullaniciIsmiElementi);
        extentTest.pass("Admin hesabına geri dönüş yapılabildiği test edilir.");

        extentTest.info("Sayfa kapatılır.");

        // the end

    }
}
