package tests.US_009_Kaan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;

public class US_009_TC_02 extends TestBaseRapor {
    @Test
    public void US_009_TC_02_Testi() throws AWTException, IOException {
        ADashboardPage aDashboardPage = new ADashboardPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();

        extentTest = extentReports.createTest("Kayıtlı Vcard bilgilerinin düzenlenmesi sonrasında görüntülenebilme testi..", "Kayıtlı kullanıcı olarak oluşturulan vcard'a ait düzenlenen bilgilerin " +
                "kart sayfasında görüntülenebildiği test edilir.");
        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        //Sign In buttonuna tıklayınız
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");
        //email ve Password değerlerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("userEditEmail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("userEditPass")).perform();
        extentTest.info("Email kutusuna kullanıcı emaili ve password kutusuna kullanıcı şifresi yazılır");
        loginPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");

        aDashboardPage.vcardsElementi.click();

        //İlgili  kartın değişiklik yapılan bilgilerinin görüntülenebildiği test edilir.
        ReusableMethods.wait(2);
        Assert.assertTrue(aDashboardPage.vcardNameElementi.isDisplayed());
        //vcardpreviewurl testi link aktif olduğu zaman test edileceğinden dolayı 178. satırdatest edilir

        Assert.assertTrue(aDashboardPage.vcardsEditStatsElementi.isDisplayed());
        Assert.assertTrue(aDashboardPage.vcardsEditQRCodeElementi.isDisplayed());
        Assert.assertTrue(aDashboardPage.vcardsEditDownloadElementi.isDisplayed());
        Assert.assertTrue(aDashboardPage.vcardsEnquiresElementi.isDisplayed());
        Assert.assertTrue(aDashboardPage.vcardsCopyCardElementi.isDisplayed());
        Assert.assertTrue(aDashboardPage.vcardsEditIconElementi.isDisplayed());
        Assert.assertTrue(aDashboardPage.vcardsTrashElementi.isDisplayed());

        extentTest.pass("Kayıtlı kullanıcı olarak oluşturulan vcard'a ait düzenlenen bilgiler, kart sayfasında görüntülenebilmektedir.");


      // robot.keyPress(KeyEvent.VK_ALT);
      // robot.keyPress(KeyEvent.VK_F4);
      // robot.keyRelease(KeyEvent.VK_F4);
      // robot.keyRelease(KeyEvent.VK_ALT);
        Driver.getDriver().quit();



        extentTest.info("Sayfa kapatilir.");

    }
}
