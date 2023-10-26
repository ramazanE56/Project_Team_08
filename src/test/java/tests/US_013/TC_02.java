package tests.US_013;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    @Test
    public void test01() {
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        LoginPage loginPage = new LoginPage();
        ADashboardPage aDashboardPage = new ADashboardPage();
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
        //7- kullanıcı isminin yazdığı dropdown menu acılır
        aDashboardPage.profildropdownMenuButton1.click();
        //8-Account settings linkine click yapılır.
        aDashboardPage.accountSettingsLinki.click();
        //9-first name kutusuna "omer" yazılır
        //10-last name kutusuna "orak" yazılır
        //11-Email kutusuna "orakomer@gmail.com" yazılır
        //12- Contact number kutusuna"+905437894556" yazılır.
        Actions actions = new Actions(Driver.getDriver());
        WebElement firstNameKutusu = aDashboardPage.firstNameKutusu;

        actions.sendKeys(firstNameKutusu, "omer")
                .sendKeys(Keys.TAB)
                .sendKeys("orak")
                .sendKeys(Keys.TAB)
                .sendKeys("orakomer@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.CLEAR)
                .sendKeys("5437894556").perform();




        ReusableMethods.wait(2);

        //13- save butonuna click yapılır.
        aDashboardPage.saveButtonProfile.click();
        //14- profil bilgilerinin güncellendiği test edilir.


    }
}
