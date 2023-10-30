package tests.US_019;

import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_02 {
    @Test
    public void test01() {
        ADashboardPage aDashboardPage = new ADashboardPage();
        LoginPage loginPage= new LoginPage();
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //3-Signin butonuna click yapılır.
        smartcardlinkPage.signinButtonElementi.click();
        //4-Email kutusuna kullanıcı email i yazılır
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        //5-Password kutusuna şifre yazılır.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        //6-login butonuna basılır.
        loginPage.loginElementi.click();
        //7-Users linkine click yapılır
        //8-edit butonuna basılır
        //9-kullanıcın yeni  bilgileri doldurulur
        //10-save butonuna click yapılır.
        //11-"user update succesfully." yazısının göründüğü test edilir
        //12-Safya kapatılır
    }
}
