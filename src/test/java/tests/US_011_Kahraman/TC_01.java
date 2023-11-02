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
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;
public class TC_01 {

    //normal kullanıcı olarak girilerek sanal kart oluşturma testi
    @Test
    public void sanalKart() throws AWTException {

        //Verilen URL sayfasını (https://qa.smartcardlink.com/login) aç
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ADashboardPage aDashboardPage = new ADashboardPage();

        //Sign In butonuna tıkla
        aDashboardPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı email bilgisi gir
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("MEmail2"));

        //Password textbox'ına geçerli password bilgisi gir
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("MPassword2"));

        //Login butonuna click yap
        aDashboardPage.loginElementi.click();

        //VirtualBackgraund tıklanır
        aDashboardPage.sanalArkaPlan.click();
        ReusableMethods.wait(2); //Sayfada alttaki 7 kartın yüklenmesi zaman aldığı için biraz bekle

        // sanal kartlardan 1-13 arasından birini seç
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(2); ////Sayfada alttaki 6 kartın yüklenmesi zaman aldığı için biraz bekle
        aDashboardPage.sanalKart13.click();

        //Vcard Name alanından (Select VCard) mevcut kartlardan birini seç
        WebElement selectElement= aDashboardPage.kayitliKartIsmi;
        Select dropdown=new Select(selectElement);
        dropdown.selectByIndex(4);
        ReusableMethods.wait(2); // ındexdeki bilgileri hemen getirmediği için bekle

        //First Name alanına bir isim gir
        Faker faker = new Faker();
        String fakeName = faker.name().name();
        aDashboardPage.VkartIsim.sendKeys(fakeName);

        //Last Name alanına soyad gir
        String soyad=faker.name().lastName();
        aDashboardPage.VkartSoyisim.sendKeys(soyad);

        //Email alnına geçerli bir email gir
        String email =faker.internet().emailAddress();
        aDashboardPage.VkartEmail.sendKeys(email);

        //meslek alanı dolu geldiği önce sil
        aDashboardPage.VkartMeslek.clear();

        //Enter Occupation alanına meslek gir
        String meslek =faker.job().field();
        aDashboardPage.VkartMeslek.sendKeys(meslek);

        //Location alanına bir şehir gir
        aDashboardPage.VkartSehir.sendKeys("colarada");

        ReusableMethods.wait(2);

        //Phone alanında, listedeki ülkelerden (Türkiyeyi ) birini seç
        aDashboardPage.UlkeKombosuElementi.click();
        aDashboardPage.TurkiyeElementi.click();
        //ReusableMethods.wait(3);

        //Ülkeler combosundan seçim yaparken indexten alma işi olmuyor

        // WebElement selectElementUlkeKod= getDriver().findElement(By.xpath("//*[@id='iti-0__country-listbox']"));
        // Select dropdown3=new Select(selectElementUlkeKod);
        // dropdown3.selectByIndex(5);

        //  List<WebElement> UlkelerListesi1 = getDriver().findElements(By.className("iti__flag-container"));
        //  int indexToPrint = 1; // 98. eleman (0'dan başlayarak indekslendiği için)
        //  String selectedElement = String.valueOf(UlkelerListesi1.get(indexToPrint));
        //  System.out.println("Seçilen Eleman: " + selectedElement);

        // Phone alanına telefon numarası gir
        aDashboardPage.Telefon.sendKeys("2122525");

        // Website alanına websitesi gir
        aDashboardPage.VkartUrl.sendKeys("www.aaaaaa.com");

        //Profil fotoyu değiştire tıkla
        aDashboardPage.ProfilLogo.click();

        // Add E-card alanına 150x150 piksel boyutunda logo dosyası yükle

        //bilgisayarda lokalde logonun seçileceği alana tıkla
        Point point1 = new Point(493,58);// C: araba çubuğu koordinatı
        Robot robot = new Robot();
        robot.mouseMove(point1.x, point1.y); // Farenin konumunu ayarla
        ReusableMethods.wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        ReusableMethods.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        ReusableMethods.wait(1);

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
        ReusableMethods.wait(2);

         //bilgisyara "virtual-backgrounds.zip" dosyasının indirildiğini doğrula
        String dosyaYolu = "/Users/KAHRAMAN/Downloads/virtual-backgrounds.zip";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        ReusableMethods.wait(2);


        //Sayfa kapat
        Driver.closeDriver();


    }
}
