package tests.US_021_bhdr;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_021_01 {
    @Test
    public void VCardGorunumTesti(){
        //1.Browser açılır
        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3.Sıgn In butonuna click yapılır.
        ReusableMethods.wait(2);
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //4.eMail kutusuna kullanıcı email i yazılır
        LoginPage loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail2"));
        //5.password kutusuna kullanıcı şifresi yazılır
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        //6.login butonua basılır
        loginPage.loginElementi.click();
        //7.Dasboard a click yapılır
        ADashboardPage aDashboardPage=new ADashboardPage();
        aDashboardPage.dashboardYaziElementi.click();
        //7.VCards butonu click edilir.
        aDashboardPage.vCardsElementi.click();
        //8.VCard name butonun click edildigi dörüntüle
        aDashboardPage.vCardSearchButonuElementi.isDisplayed();
        aDashboardPage.vCardSearchButonuElementi.click();
        //9.VCard butonu altındaki user name butonun click edildigi görüntüle
        aDashboardPage.userNameButonuElementi.click();
        aDashboardPage.userNameButonuElementi.isDisplayed();

    }
}
