package tests.US_021_bhdr;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_021_02 {
    @Test
    public void VCardsIstatistikTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        ReusableMethods.wait(2);
        //3.Sıgn In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButonuElementi1.click();

        //4.eMail kutusuna kullanıcı email i yazılır
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));

        //5.password kutusuna kullanıcı şifresi yazılır
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));

        //6.login butonua basılır
        loginPage.loginElementi.click();

        //7.Dasboard a click yapılır
        ADashboardPage aDashboardPage=new ADashboardPage();
        aDashboardPage.dashboardYaziElementi.click();

        //7.VCards butonu click edilir.
        aDashboardPage.vCardsElementi.click();
        //8VCards butonu altındaki Search butnu click edildigi ve görüntüle
        aDashboardPage.vCardSearchButonuElementi.isDisplayed();
        aDashboardPage.vCardSearchButonuElementi.click();

        //8.status altındaki buton click edildiğini görüntüle
        aDashboardPage.statsAltindakiButonElementi.isDisplayed();
        aDashboardPage.userNameButonuElementi.isDisplayed();

    }

}
