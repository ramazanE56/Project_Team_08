package tests.US_021_bhdr;

import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_021_02 extends TestBaseRapor {
    @Test
    public void VCardsIstatistikTesti(){
        extentTest = extentReports.createTest(
                "Admin Giriş Testi",
                "Sisteme kayıtlı  Admin kullanıcı adı ve şifresiyle, sisteme giriş yapılabilmelidir.");
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ReusableMethods.wait(2);
        extentTest.info("");

        //3.Sıgn In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButonuElementi1.click();
        extentTest.info("Browser ile ilgili URL'e gidilir.");

        //4.eMail kutusuna kullanıcı email i yazılır
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));
        extentTest.info("email kutusuna kullanıcı emaili girilir.");

        //5.password kutusuna kullanıcı şifresi yazılır
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));
        extentTest.info(" kullanıcı şifresi girilir.");

        //6.login butonua basılır
        loginPage.loginElementi.click();
        extentTest.info(" login kutusuna tıklanır.");

        //7.Dashboard a click yapılır
        ADashboardPage aDashboardPage=new ADashboardPage();
        aDashboardPage.dashboardYaziElementi.click();
        extentTest.info(" Dashboard kutusuna tıklanır.");

        //7.VCards butonu click edilir.
        aDashboardPage.vCardsElementi.click();
        extentTest.info(" VCards butonu  tıklanır.");

        //8VCards butonu altındaki Search butnu click edildigi ve görüntüle
        aDashboardPage.vCardSearchButonuElementi.isDisplayed();
        aDashboardPage.vCardSearchButonuElementi.click();
        extentTest.info(" Search butonu tıklanır ve tıklama sonucu görüntülenir");

        //8.status altındaki buton click edildiğini görüntüle
        aDashboardPage.statsAltindakiButonElementi.isDisplayed();
        aDashboardPage.userNameButonuElementi.isDisplayed();
        extentTest.info(" status butonunun tıklandıgı görüntülenir.");

    }

}
