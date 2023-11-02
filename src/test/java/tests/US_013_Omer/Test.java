package tests.US_013_Omer;

import org.openqa.selenium.By;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test {
    @org.testng.annotations.Test
    public void testName() {

        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        LoginPage loginPage=new LoginPage();
        ADashboardPage aDashboardPage=new ADashboardPage();
        //1-Browser açılır
        //2-https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //3-Signin butonuna click yapılır.
        smartcardlinkPage.signinButtonElementi.click();
        //4-Email kutusuna kullanıcı email i yazılır
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("ozelemail"));

        ReusableMethods.wait(1);
        //5-Password kutusuna şifre yazılır.
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("ozelpassword"));

        ReusableMethods.wait(1);
        //6-login butonuna basılır.
        loginPage.loginElementi.click();
        Driver.getDriver().findElement(By.xpath("(//*[@class=\"aside-menu-title\"])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//img[@src=\"https://qa.smartcardlink.com/assets/img/ecards/H-Vcard/H-1/Front.png\"]")).click();

        ReusableMethods.wait(1);
    }
}
