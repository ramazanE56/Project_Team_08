package tests.US_022_Ismail;

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
    @Test
    public void vcardtemplates(){
        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
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
        //Admin Dashboard sayfasında Vcard Templates sekmesinin tıklanır olduğunu test edin.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.vcardTemplatesElementi.click();

        String expectedSekmeBasligiYazisi = "Vcard Templates";
        String actualSekmeBasligiYazisi = aDashboardPage.sekmeBasligiYaziElementi.getText();
        Assert.assertEquals(actualSekmeBasligiYazisi,expectedSekmeBasligiYazisi);
        Driver.closeDriver();


    }
}
