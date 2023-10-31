package tests.US_033_Osman;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_03 extends TestBaseRapor {
    @Test
    public void AboutUsSayfasi(){
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
        //Front CMS butonuna tiklayiniz
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.frontCmsElementi.click();
        //About Us butonuna tiklayiniz
        aDashboardPage = new ADashboardPage();
        aDashboardPage.frontCmsAboutUsElementi.click();

    }
}
