package tests.US_019_Omer;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        extentTest = extentReports.createTest("Kullanıcı bilgilerini ve şifrelerini değiştirme Testi",
                "Admin bilgilieri ile giriş yaptıktan sonra" +
                         " kullanıcılar bölümünde  " +
                         "kayıtlı kullanıcıların bilgilerini" +
                         " ve şifrelerini değiştrebilmelidir");

        ADashboardPage aDashboardPage = new ADashboardPage();
        LoginPage loginPage = new LoginPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        extentTest.info("Signin butonuna click yapılır.");
        smartcardlinkPage.signinButtonElementi.click();

        extentTest.info("Email kutusuna kullanıcı email i yazılır");
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

        extentTest.info("Password kutusuna şifre yazılır.");
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

        extentTest.info("login butonuna basılır.");
        loginPage.loginElementi.click();

        extentTest.info("Users linkine click yapılır");
        aDashboardPage.userMenuElementi.click();

        extentTest.info("Edit butonuna basılır");
        aDashboardPage.edit_kalem_elementi.click();
        extentTest.info("Kullanıcın yeni  bilgileri doldurulur");
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(aDashboardPage.firstNameKutusuUsers)
                .sendKeys(Keys.CLEAR)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();
        //profile image icon(kalem) elementine tıklanır.
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
        ReusableMethods.wait(3);


        extentTest.info("Save butonuna click yapılır.");
        aDashboardPage.usersSaveButtonu.click();
        extentTest.pass("'user update succesfully.' yazısının göründüğü test edilir");
        WebElement userUpdatedSuccesfullyElementi = aDashboardPage.userUpdatedSuccesfullyYaziElementi;
        Assert.assertTrue(userUpdatedSuccesfullyElementi.isDisplayed());


    }
}
