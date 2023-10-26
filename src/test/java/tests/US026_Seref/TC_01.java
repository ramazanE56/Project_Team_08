package tests.US026_Seref;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01 {

    /*
         URL= https://qa.smartcardlink.com
         Admin email1 = admin22@smartcardlink.com
         Admin email2 = admin23@smartcardlink.com
         Admin email3 = admin24@smartcardlink.com
         Admin password = 123123123
     */

         @Test
        public void AdminDashboard(){
            //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
            Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

            //Sign In buttonuna tıklayınız
            SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
            smartcardlinkPage.signinButtonElementi.click();

            //email ve Password değerlerini girip Login butonuna tıklayınız
            Actions actions = new Actions(Driver.getDriver());
            LoginPage loginPage = new LoginPage();
            actions.click(loginPage.emailKutusuElementi);
            actions.sendKeys(ConfigReader.getProperty("semail"));
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
            loginPage.loginElementi.click();
            ReusableMethods.wait(2);

            //Admin Dashboard sayfasının görünür olduğunu test edin.
            ADashboardPage aDashboardPage = new ADashboardPage();
            Assert.assertTrue(aDashboardPage.dashboardYaziElementi.isDisplayed());
            Driver.closeDriver();

        }

    }