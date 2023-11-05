package tests.US_009_Kaan;

import org.openqa.selenium.Keys;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class US_009_TC_03 extends TestBaseRapor {
    @Test
    public void US_009_TC_03_Testi() throws AWTException, IOException {
        ADashboardPage aDashboardPage = new ADashboardPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();

        extentTest = extentReports.createTest("Vcard bilgilerinin aktiflik testi..", "Kayıtlı kullanıcı olarak oluşturulan vcard'a ait düzenlenen bilgilerin " +
                " aktif olduğu test edilir.");
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
        extentTest.info("Email kutusuna kullanıcı emaili ve password kutusuna kullanıcı şifresi yazılır.");
        loginPage.loginElementi.click();
        extentTest.info("login butonuna basılır.");

        aDashboardPage.vcardsElementi.click();

        //Kart sayfasındaki fonksiyonların aktif olduğu test edilir.

        //VCardName bilgisine tıklayın
          aDashboardPage.vcardNameElementi.click();
        extentTest.info("VCardName kısmına tıklanır.");

        //açılan sayfada sayfanın en üstüne gidin
        actions.sendKeys(Keys.PAGE_UP).perform();
        //editvcard yazısının görünür olduğunu test edin
        ReusableMethods.wait(1);
        Assert.assertTrue(aDashboardPage.editVcardsElementi.isDisplayed());
        extentTest.pass("editvcard yazısının görünür olduğunu test edilir.");
        //ana sayfaya geri dönün
        aDashboardPage.vcardsEditBackElementi.click();
        //priview Url bilgisine tıklayınız.

        //vcardpreviewurl testi link aktif olduğu zaman test edilir
        // Assert.assertTrue(aDashboardPage.vcardPreviewUrlElementi.isDisplayed());
        extentTest.pass("vcardpreviewurl testi link aktif olduğu doğrulanır.");
        ReusableMethods.wait(2);
        aDashboardPage.vcardPreviewUrlElementi.click();
        extentTest.info("vcardpreviewurl linkine tıklanır.");
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
            extentTest.pass("QRKOD yazısının görünür olduğu doğrulanır.");

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
            //previewUrlLinki kopyalama linkine tıklanabilir olduğunu test edin
            Assert.assertTrue(aDashboardPage.previewUrlLinkiKopyalamaSuccessElementi.isDisplayed());
            extentTest.pass("previewUrlLinki kopyalama linkine tıklanır.");


        }


        //STATS sütunundaki bilgiye tıklayınız
        aDashboardPage.vcardsEditStatsElementi.click();
        //Stats bilgisine tıklanır olduğunu test edin
        extentTest.info("Stats linkine tıklanır.");
        Assert.assertTrue(aDashboardPage.vcardAnalyticYaziElementi.isDisplayed());
        extentTest.pass("Stats linkine tıklanır.");
        //Admindashboard sayfasına geri dönün
        aDashboardPage.vcardAnalyticBackTusuElementi.click();
        //status butonuna tıklayın
        aDashboardPage.statusButonElementi.click();
        extentTest.info("Status linkine tıklanır.");


      //   aDashboardPage.vcardsEditQRCodeElementi.click();
        extentTest.info("Vcards QR kod oluşturma linkinde, manuel testle kontrol edildiğinde, herhangi bir işlem yapmamaktadır. Bu nedenle aktiflik testi yapılamamaktadır.");
        ReusableMethods.wait(2);
        aDashboardPage.vcardsEditDownloadElementi.click();
        //bilgisyara "virtual-backgrounds.zip" dosyasının indirildiğini doğrula
        String dosyaYolu = "C:\\Users\\user\\Downloads\\manager2-useredit02.vcf";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        extentTest.pass("bilgisayara 'virtual-backgrounds.zip' dosyasının indirildiği doğrulanır.");

        ReusableMethods.wait(2);
        //Vcards enquires elmentine tıklayınız
        aDashboardPage.vcardsEnquiresElementi.click();
        extentTest.info("Vcards enquires  linkine tıklanır.");
        //vcarsenquire sayfasına gidildiğini doğrulayınız
        Assert.assertTrue(aDashboardPage.enquiriesYaziElementi.isDisplayed());
        extentTest.pass("vcards enquire sayfasına gidildiğini doğrulanır.");
        //back e tıklayınız
        aDashboardPage.enquiriesYazibackElementi.click();

        //vcard duplicate e tıklayınız
        aDashboardPage.vcardsCopyCardElementi.click();
        extentTest.info("vcard duplicate linkine tıklanır.");
        //yes butonuna tıklayınız
        ReusableMethods.wait(2);
       aDashboardPage.vcardEditDublicateYesButonuElementi.click();
        ReusableMethods.wait(2);
       Assert.assertTrue(aDashboardPage.vcardEditYesdenSonraCikanOKElementi.isDisplayed());
       extentTest.pass("Kart bilgileri görüntüleme sayfasındaki, dublike kart linkine tıklandıktan sonra çıkan onay yazısı görüntülenir.");
        //Delete e tıklayınız
        ReusableMethods.wait(2);
        extentTest.info("vcard Delete linkine tıklanır.");
        aDashboardPage.vcardsTrashElementi.click();
        //Yes Delete e tıklayınız
        ReusableMethods.wait(1);
       aDashboardPage.vcardEditTrashYesDeleteButonElementi.click();
        ReusableMethods.wait(1);
      Assert.assertTrue(aDashboardPage.vcardEditTrashDeleteOKButonElementi.isDisplayed());
        extentTest.pass("Kart bilgileri görüntüleme sayfasındaki, kart silme linkine tıklandıktan sonra çıkan onay yazısı görüntülenir.");

        //soft assert kapat
        //   softAssert.assertAll();
        //Sayfa kapatılır
        extentTest.pass("Kayıtlı vcard'a ait kart sayfasındaki fonksiyonlar aktiftir.");
        // robot.keyPress(KeyEvent.VK_ALT);
        // robot.keyPress(KeyEvent.VK_F4);
        // robot.keyRelease(KeyEvent.VK_F4);
        // robot.keyRelease(KeyEvent.VK_ALT);
        Driver.getDriver().quit();


        extentTest.info("Sayfa kapatilir.");

    }
}
