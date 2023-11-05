package tests.US_019_Omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.ReusableMethods;
import tests.US_010_Burhan.utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TC_03 extends TestBaseRapor {
    @Test
    public void test01() throws AWTException {

        ADashboardPage aDashboardPage = new ADashboardPage();
        LoginPage loginPage = new LoginPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        extentTest = extentReports.createTest("Kullanıcı ekleme Password değiştirme ve silme Testi",
                "Bilgileri girilerek kullanıcı eklenir, Şifre değiştirilir ve eklenen kullanıcı geri silinir.");
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
        //8-Add User butonuna click yapar
        aDashboardPage.addUserButonu.click();
        //9-User bilgileri doldurulur
        Actions actions = new Actions(Driver.getDriver());
        actions.click(aDashboardPage.firstNameKutusuAddUser)
                .sendKeys("omer")
                .sendKeys(Keys.TAB)
                .sendKeys("orak")
                .sendKeys(Keys.TAB)
                .sendKeys("omerorak25@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("5436628595")
                .sendKeys(Keys.TAB)
                .sendKeys("Password25.")
                .sendKeys(Keys.TAB)
                .sendKeys("Password25.").perform();
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
        //10-save butonuna click yapılır.
        aDashboardPage.saveButtonAddUser.click();
        //11-User created succesfully yazı elementinin göründüğü test edilir
        Assert.assertTrue(aDashboardPage.userCreatedSuccesfullyAddUser.isDisplayed());
        String sonEklenenUser = aDashboardPage.sonEklenenUser.getText();
        System.out.println(sonEklenenUser);

        String expectedUserIcerik = "omer";
        Assert.assertTrue(sonEklenenUser.contains(expectedUserIcerik));
        extentTest.info("Password değitirmek için anahtar simgesine tıklanır.");
        aDashboardPage.passwordAnahtarElementi.click();
        extentTest.info("New password ve Confirm password kutuları doldurulur");
        aDashboardPage.newPasswordkutusu.sendKeys("Password25.");
        aDashboardPage.confirmPasswordKutusu.sendKeys("Password25.");
        extentTest.info("Save butonuna tıklanır");
        aDashboardPage.saveButonuPassword.click();
        extentTest.pass("Password'un değişltirildiği test edilir.");
        Assert.assertTrue(aDashboardPage.passwordUpdatedSuccesfully.isDisplayed());
        ReusableMethods.wait(2);
        extentTest.info("Hesabı silmek için delete butonuna tıklanır");
        aDashboardPage.deleteUserButton.click();
        ReusableMethods.wait(2);
        extentTest.info("Yes delete butonu tıklanır");
        aDashboardPage.yesDeleteButton.click();
        ReusableMethods.wait(2);
        extentTest.pass("Hesabın silindiği test edilir.");
        sonEklenenUser = aDashboardPage.sonEklenenUser.getText();
        System.out.println(sonEklenenUser);
        Assert.assertTrue(!sonEklenenUser.contains(expectedUserIcerik));


    }
}
