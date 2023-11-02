package tests.US_013_Omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TC_02 extends TestBaseRapor {
    @Test
    public void test01() throws AWTException {
        extentTest = extentReports.createTest("Profil Bilgilerini Güncelleme Testi", "Kullanıcı ilgili siteye \n" +
                "kayıtlı bir kullanıcı \n" +
                "bilgileri ile giriş yaparak \n" +
                "profil bilgilerini \n" +
                "güncelleyebilmelidir.");
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        LoginPage loginPage = new LoginPage();
        ADashboardPage aDashboardPage = new ADashboardPage();
        extentTest.info("1-https://qa.smartcardlink.com/ adresine gidilir");
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("2-Signin butonuna click yapılır.");
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("3-Email kutusuna kullanıcı email i yazılır");
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("4-Password kutusuna şifre yazılır.");
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("5-Login butonuna basılır.");
        loginPage.loginElementi.click();
        extentTest.info("6- Kullanıcı isminin yazdığı dropdown menu acılır");
        aDashboardPage.profildropdownMenuButton1.click();
        extentTest.info("7-Account settings linkine click yapılır.");
        aDashboardPage.accountSettingsLinki.click();
        extentTest.info("8-Kullanıcı bilgileri doldurulur");
        Actions actions = new Actions(Driver.getDriver());
        WebElement firstNameKutusu = aDashboardPage.firstNameKutusu;

        actions.sendKeys(firstNameKutusu, "omer")
                .sendKeys(Keys.TAB)
                .sendKeys("orak")
                .sendKeys(Keys.TAB)
                .sendKeys("orakomer@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        aDashboardPage.phoneNumberProfile.sendKeys(Keys.CLEAR + "5");
        //profile resmi iconuna tıklar
        aDashboardPage.profileImageIcon.click();
        // C: arama çubuğu koordinatı
        Point point1 = new Point(608, 218);
        // Farenin konumunu ayarla
        Robot robot = new Robot();
        robot.mouseMove(point1.x, point1.y);
        ReusableMethods.wait(1);
        // Sol tıklama yap
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);
        // Sol tıklama bırak
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);
        // Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır
        StringSelection stringSelection = new StringSelection("C:/Users/orako/IdeaProjects/Project_Team_08/target/generated-test-sources/test-annotations");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //klasör seçme sayfasındaki oka tıklar
        Point point2 = new Point(698, 218);// aç butonu koordinatı
        // Farenin konumunu ayarla
        robot.mouseMove(point2.x, point2.y);
        ReusableMethods.wait(1);
        // Sol tıklama yap
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);
        // Sol tıklama bırak
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);

        // Çıkan  logoya tıkla
        // aç butonu koordinatı
        Point point3 = new Point(407, 342);
        // Farenin konumunu ayarla
        robot.mouseMove(point3.x, point3.y);


        ReusableMethods.wait(1);
        // Sol tıklama yap
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);
        // Sol tıklama bırak
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);
        //aç butanuna tıklama işlemi
        // aç butonu koordinatı
        Point point4 = new Point(781, 607);
        // Farenin konumunu ayarla
        robot.mouseMove(point4.x, point4.y);
        ReusableMethods.wait(1);
        // Sol tıklama yap
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.wait(1);
        // Sol tıklama bırak
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        ReusableMethods.wait(2);

        extentTest.info("8- save butonuna click yapılır.");
        aDashboardPage.saveButtonProfile.click();
        //14- profil bilgilerinin güncellendiği test edilir.
        //Save butonu tıklanabilir olmadığı için diğer aşamalara geçilemedi.


    }
}
