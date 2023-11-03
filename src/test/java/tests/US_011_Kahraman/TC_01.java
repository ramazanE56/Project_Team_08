package tests.US_011_Kahraman;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;



public class TC_01 extends TestBaseRapor {

    //normal kullanıcı olarak girilerek sanal kart oluşturma testi
    @Test
    public void sanalKart() throws AWTException {

        extentTest=extentReports.createTest("Kayıtlı Kullanıcı olarak Dashboard sayfasında sanal Kart oluşturma","Kayıtlı kullanıcı olarak sanal arka plan sayfasından kart arka planını belirleyip kart üzerindeki gerekli bilgileri girip kaydedebildiğimi doğrulayabilmeliyim");

        //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        ADashboardPage aDashboardPage = new ADashboardPage();

        //Sign In butonuna tıkla
        aDashboardPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");

        //Email textbox'ına Kayıtlı email bilgisi gir
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("MEmail2"));
        extentTest.info("Email textbox'ına Kayıtlı email bilgisi gir");

        //Password textbox'ına geçerli password bilgisi gir
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("MPassword2"));
        extentTest.info("Password textbox'ına geçerli password bilgisi gir");

        //Login butonuna click yap
        aDashboardPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");

        //VirtualBackgraund tıklanır
        aDashboardPage.sanalArkaPlan.click();
        extentTest.info("VirtualBackgraund tıklanır");
        ReusableMethods.wait(2); //Sayfada alttaki 7 kartın yüklenmesi zaman aldığı için biraz bekle

        // sanal kartlardan 1-13 arasından birini seç
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(2); ////Sayfada alttaki 6 kartın yüklenmesi zaman aldığı için biraz bekle
        aDashboardPage.sanalKart13.click();
        extentTest.info("sanal kartlardan 1-13 arasından birini seç");

        //Vcard Name alanından (Select VCard) mevcut kartlardan birini seç
        WebElement selectElement= aDashboardPage.kayitliKartIsmi;
        Select dropdown=new Select(selectElement);
        dropdown.selectByIndex(4);
        ReusableMethods.wait(2); // ındexdeki bilgileri hemen getirmediği için bekle
        extentTest.info("Vcard Name alanından (Select VCard) mevcut kartlardan birini seç");

        //First Name alanına bir isim gir
        Faker faker = new Faker();
        String fakeName = faker.name().name();
        aDashboardPage.VkartIsim.sendKeys(fakeName);
        extentTest.info("First Name alanına bir isim gir");

        //Last Name alanına soyad gir
        String soyad=faker.name().lastName();
        aDashboardPage.VkartSoyisim.sendKeys(soyad);
        extentTest.info("Last Name alanına soyad gir");

        //Email alnına geçerli bir email gir
        String email =faker.internet().emailAddress();
        aDashboardPage.VkartEmail.sendKeys(email);
        extentTest.info("Email alnına geçerli bir email gir");

        //meslek alanı dolu geldiği önce sil
        aDashboardPage.VkartMeslek.clear();

        //Enter Occupation alanına meslek gir
        String meslek =faker.job().field();
        aDashboardPage.VkartMeslek.sendKeys(meslek);
        extentTest.info("Enter Occupation alanına meslek gir");

        //Location alanına bir şehir gir
        aDashboardPage.VkartSehir.sendKeys("colarada");
        extentTest.info("Location alanına bir şehir gir");

        ReusableMethods.wait(2);

        //Phone alanında, listedeki ülkelerden (Türkiyeyi ) birini seç
        aDashboardPage.UlkeKombosuElementi.click();
        aDashboardPage.TurkiyeElementi.click();
        extentTest.info("hone alanında, listedeki ülkelerden (Türkiyeyi ) birini seç");

        // Phone alanına telefon numarası gir
        aDashboardPage.Telefon.sendKeys("2122525");
        extentTest.info("Phone alanına telefon numarası gir");

        // Website alanına websitesi gir
        aDashboardPage.VkartUrl.sendKeys("www.aaaaaa.com");
        extentTest.info("Website alanına websitesi gir");

        //Profil fotoyu değiştire tıkla
        aDashboardPage.ProfilLogo.click();
        extentTest.info("Profil fotoyu değiştire tıkla");

        // Add E-card alanına 150x150 piksel boyutunda logo dosyası yüklemek için
        //bilgisayarda lokalde logonun seçileceği alana tıkla
        Point point1 = new Point(493,58);// C: araba çubuğu koordinatı
        Robot robot = new Robot();
        robot.mouseMove(point1.x, point1.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);

        extentTest.info("bilgisayarda lokalde logonun seçileceği alana tıkla");

        // Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır
        StringSelection stringSelection = new StringSelection("C:/Users/KAHRAMAN/IdeaProjects/Project_Team_08/src/test/java/tests/US_011_Kahraman");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // adres satırının yanındaki enter işlemi gören yandaki oka tıkla
        Point point2 = new Point(578,58);// aç butonu koordinatı
        robot.mouseMove(point2.x, point2.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);

        //gelen logoya tıklama işlemi
        Point point3 = new Point(244,156);// aç butonu koordinatı
        robot.mouseMove(point3.x, point3.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);

        //aç butanuna tıklama işlemi

       Point point4 = new Point(670,624);// aç butonu koordinatı
       robot.mouseMove(point4.x, point4.y); // Farenin konumunu ayarla
       ReusableMethods.wait(1);
       robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
       ReusableMethods.wait(1);
       robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
       ReusableMethods.wait(1);

        //Save butonuna bas.
        aDashboardPage.kaydet.click();
        extentTest.info("bilgisayarda lokalde logonun seçileceği alana tıkla");
        ReusableMethods.wait(2);

         //bilgisyara "virtual-backgrounds.zip" dosyasının indirildiğini doğrula
        String dosyaYolu = "/Users/KAHRAMAN/Downloads/virtual-backgrounds.zip";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        extentTest.pass("bilgisyara virtual-backgrounds.zip dosyasının indirildiği doğrulandı");

        ReusableMethods.wait(2);

        //Sayfa kapat
        Driver.closeDriver();


    }
}
