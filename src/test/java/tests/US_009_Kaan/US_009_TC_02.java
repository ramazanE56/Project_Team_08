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


        //Kart sayfasındaki fonksiyonların aktif olduğu test edilir.


        //VCardName bilgisine tıklayın
        aDashboardPage.vcardNameElementi.click();
        //açılan sayfada sayfanın en üstüne gidin
        actions.sendKeys(Keys.PAGE_UP).perform();
        //editvcard yazısının görünür olduğunu test edin
        ReusableMethods.wait(1);
        Assert.assertTrue(aDashboardPage.editVcardsElementi.isDisplayed());
        //ana sayfaya geri dönün
        aDashboardPage.vcardsEditBackElementi.click();
        //priview Url bilgisine tıklayınız.


        //vcardpreviewurl testi link aktif olduğu zaman test edilir
        // Assert.assertTrue(aDashboardPage.vcardPreviewUrlElementi.isDisplayed());
        ReusableMethods.wait(2);
        aDashboardPage.vcardPreviewUrlElementi.click();
        ReusableMethods.wait(1);
        String ilkSayfaWhd = Driver.getDriver().getWindowHandle();
        Set<String> whdSeti = Driver.getDriver().getWindowHandles();

        System.out.println("ilk sayfa whd : " + ilkSayfaWhd);
        System.out.println("window handles seti : " + whdSeti);

        String ikinciSayfaWhd = "";

        for (String each : whdSeti
        ) {

            if (!each.equals(ilkSayfaWhd)) {
                ikinciSayfaWhd = each;
            }


            //ikinci sayfaya geçin
            Driver.getDriver().switchTo().window(ikinciSayfaWhd);
            ReusableMethods.wait(3);
            //QRKOD yazısının görünür olduğunu test edin

            //Assert.assertTrue(aDashboardPage.ikinciSayfaKartElementi.isDisplayed());

            ReusableMethods.getScreenshot("ikinci sayfa Vcardresmi");
            ReusableMethods.wait(2);

            //ilk sayfaya geri dönün
            Driver.getDriver().switchTo().window(ilkSayfaWhd);
            //Kopyalama linkine tıklayınız
            ReusableMethods.wait(5);
            ReusableMethods.buttonOnOff(aDashboardPage.statusButonElementi, true);
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            // // textbox locate edilmisti
            // wait.until(ExpectedConditions.elementToBeClickable(textBox));

            aDashboardPage.previewUrlLinkiKopyalamaElementi.click();
            //kopyalama linkinin tıklanabilir olduğunu test edin
            Assert.assertTrue(aDashboardPage.previewUrlLinkiKopyalamaSuccessElementi.isDisplayed());


        }


        //STATS sütunundaki bilgiye tıklayınız
        aDashboardPage.vcardsEditStatsElementi.click();
        //Stats bilgisine tıklanır olduğunu test edin
        Assert.assertTrue(aDashboardPage.vcardAnalyticYaziElementi.isDisplayed());
        //Admindashboard sayfasına geri dönün
        aDashboardPage.vcardAnalyticBackTusuElementi.click();
        //status butonuna tıklayın
        aDashboardPage.statusButonElementi.click();


        // aDashboardPage.vcardsEditQRCodeElementi.click();
      // SoftAssert softAssert = new SoftAssert();
      // softAssert.(aDashboardPage.vcardsEditQRCodeElementi.isEnabled(),"Vcards QR kod oluşturma linki aktif değildir.");
        Assert.assertTrue(aDashboardPage.vcardsEditQRCodeElementi.isEnabled(),"Vcards QR kod oluşturma linki aktif değildir.");
        ReusableMethods.wait(1);
        aDashboardPage.vcardsEditDownloadElementi.click();
        //bilgisyara "virtual-backgrounds.zip" dosyasının indirildiğini doğrula
        String dosyaYolu = "C:\\Users\\asus\\Downloads\\manager2-useredit02.vcf";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        ReusableMethods.wait(2);
        //Vcards enquires elmentine tıklayınız
        aDashboardPage.vcardsEnquiresElementi.click();
        //vcarsenquire sayfasına gidildiğini doğrulayınız
        Assert.assertTrue(aDashboardPage.enquiriesYaziElementi.isDisplayed());
        //back e tıklayınız
        aDashboardPage.enquiriesYazibackElementi.click();

        //vcard duplicate e tıklayınız
        aDashboardPage.vcardsCopyCardElementi.click();
        //yes butonuna tıklayınız
        ReusableMethods.wait(1);
        aDashboardPage.vcardEditDublicateYesButonuElementi.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(aDashboardPage.vcardEditYesdenSonraCikanOKElementi.isDisplayed());
        //Delete e tıklayınız
        ReusableMethods.wait(2);
        aDashboardPage.vcardsTrashElementi.click();
        //Yes Delete e tıklayınız
        ReusableMethods.wait(1);
        aDashboardPage.vcardEditTrashYesDeleteButonElementi.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(aDashboardPage.vcardEditTrashDeleteOKButonElementi.isDisplayed());
        //soft assert kapat
     //   softAssert.assertAll();
        //Sayfa kapatılır

      // robot.keyPress(KeyEvent.VK_ALT);
      // robot.keyPress(KeyEvent.VK_F4);
      // robot.keyRelease(KeyEvent.VK_F4);
      // robot.keyRelease(KeyEvent.VK_ALT);
        Driver.getDriver().quit();



        extentTest.info("Sayfa kapatilir.");

    }
}
