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

public class US_009_TC_01 extends TestBaseRapor {

    @Test
    public void US_009_TC_01Testi() throws AWTException, IOException {
        ADashboardPage aDashboardPage = new ADashboardPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();

        extentTest = extentReports.createTest("Kayıtlı Vcard bilgilerinin düzenlenebilmesi.", "Kayıtlı kullanıcı olarak oluşturduğum vcard'ı düzenleyebildiğimi, ilgili tüm bilgileri girebildiğimi" +
                " ve bu bilgilerin kart sayfasında görüntülenebildiğini, fonksiyonların aktif olduğunu doğrulayabilme testi.");
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
        aDashboardPage.editIconElementi.click();
        ReusableMethods.wait(2);
        aDashboardPage.urlAliaselementi.click();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB).perform();
        aDashboardPage.vcardsEditFirstNameElementi.clear();
        actions.sendKeys("userEdit0202");
        actions.sendKeys("Project Manager");
        actions.sendKeys(Keys.TAB).perform();
        aDashboardPage.vcardsEditFirstNameElementi.click();
        actions.sendKeys("userEdit02");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB).perform();
        aDashboardPage.ulkeTlf1Elementi.click();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB).perform();
//        aDashboardPage.location_UrlElementi.click();
        actions.click(aDashboardPage.location_UrlElementi);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB).perform();
        aDashboardPage.defLanEngElementi.click();
        aDashboardPage.defLanTrElementi.click();
        aDashboardPage.languageEnableElementi.click();
        aDashboardPage.enableEnquiryFormElementi.click();
        aDashboardPage.enableDownloadQrCodeElementi.click();
        ReusableMethods.wait(1);
        aDashboardPage.qrCodeDownloadSizeElementi.click();
        ReusableMethods.wait(1);


        aDashboardPage.logoDegistirmeKalemElementi.click();
        //actions.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT).perform();
        Point point1 = new Point(660, 45);// C: arama çubuğu koordinatı
        Robot robot = new Robot();
        robot.mouseMove(point1.x, point1.y); // Farenin konumunu ayarla
        ReusableMethods.wait(2);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(2);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.ENTER).perform();


// Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır
        StringSelection stringSelection = new StringSelection("C:\\Users\\asus\\IdeaProjects\\Project_Team08\\src\\test\\java\\tests\\US_009_Kaan");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
// Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır

        // yandaki oka tıklama işlemi
        Point point2 = new Point(759, 51);// ileri oku koordinatı

        robot.mouseMove(point2.x, point2.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);


        // gelen logoya tıklama işlemi
        Point point3 = new Point(306, 160);// logo konumu koordinatı

        robot.mouseMove(point3.x, point3.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);


//aç butanuna tıklama işlemi
        Point point4 = new Point(848, 726);// aç butonu koordinatı

        robot.mouseMove(point4.x, point4.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak



        //Cover logo yükleme işlemi yapınız
        //cover değiştirme kalem simgesine tıklayınız
        aDashboardPage.coverLogoKalemElementi.click();
        Point point5 = new Point(660, 45);// C: arama çubuğu koordinatı
        robot.mouseMove(point5.x, point5.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.ENTER).perform();


// Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır
        StringSelection stringSelection2 = new StringSelection("C:\\Users\\asus\\IdeaProjects\\Calısma_Project_Team08 - Kopya\\src\\test\\java\\tests\\kaan2");
        Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
// Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır

        // yandaki oka tıklama işlemi
        Point point6 = new Point(759, 51);// ileri oku koordinatı

        robot.mouseMove(point6.x, point6.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);


        // gelen logoya tıklama işlemi
        Point point7 = new Point(437, 123);// cover logo konumu koordinatı

        robot.mouseMove(point7.x, point7.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);


//aç butanuna tıklama işlemi
        Point point8 = new Point(848, 726);// aç butonu koordinatı

        robot.mouseMove(point8.x, point8.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak


        ReusableMethods.wait(1);
        aDashboardPage.vcardSaveBtnElementi.click();                // Yapılan değişikliklerin kaydedilmesi için save butonuna tıklanır.
        Assert.assertTrue(aDashboardPage.vcardsEditSuccesfullSaveElementi.isDisplayed()); //"Basic Details Update succesfully." onay yazısının çıktığı test edilir.
        aDashboardPage.vcardsEditBackElementi.click();   //Back butonuna tıklanarak, Vcards bölümüne geçilir.
        Assert.assertTrue(aDashboardPage.editIconElementi.isDisplayed());
        Driver.closeDriver();


       extentTest.info("Sayfa kapatilir.");

    }


}