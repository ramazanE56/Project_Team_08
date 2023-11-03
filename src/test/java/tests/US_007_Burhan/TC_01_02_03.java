
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
import utilities.TestBaseRapor;
public class TC_01_02_03 extends TestBaseRapor {
    SmartcardlinkPage smartcardlinkPage;
    LoginPage loginPage;
    ADashboardPage aDashboardPage;
    @Test
    public void dashboardPageElements() {
        extentTest = extentReports.createTest("Dashboard sayfasina  giriş ve ogeleri goruntuleme",
                "Kayıtlı kullanıcı dasboard sayfasına ulaşabilir ve sayfadaki öğeleri görüntüleyebilir");
        //Bir ziyaretci olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
        //Sign In buttonuna tiklayiniz
        smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tiklanir");
        //Email kutusuna doğru email adresi giriniz
        loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("visitorEmail"));
        extentTest.info("Email kutusuna doğru email adresi girilir");
        //Password kutusuna doğru password giriniz
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("visitorPassword"));
        extentTest.info("Password kutusuna doğru password girilir");
        //Login butonuna tiklayiniz.
        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tiklanir");
        aDashboardPage = new ADashboardPage();
        //Dashboard sayfasi üstteki dashboard yazisi dogrulanir
        Assert.assertTrue(aDashboardPage.dashboardYazisi.isDisplayed());
        extentTest.pass("Dashboard sayfasi üstteki dashboard yazisi goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki dashboard butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dashboardButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki dashboard butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki dashboard ikonu dogrulanir
        Assert.assertTrue(aDashboardPage.dashboardButonIkon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki dashboard ikonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki VCards butonu dogrulanir
        Assert.assertTrue(aDashboardPage.vcardsButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki VCards butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki VCards Ikonu dogrulanir
        Assert.assertTrue(aDashboardPage.vcardsButonIkon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki VCards ikonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki Enquiries butonu dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki Enquiries butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki Enquiries ikonu dogrulanir
        Assert.assertTrue(aDashboardPage.enquiriesButonIkon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki Enquiries ikonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki Appointments butonu dogrulanir
        Assert.assertTrue(aDashboardPage.appointmentsButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki Appointments butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki Appointments ikonu dogrulanir
        Assert.assertTrue(aDashboardPage.appointmentsButonIkon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki Appointments ikonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki virtual Backgrounds butonu dogrulanir
        Assert.assertTrue(aDashboardPage.virtualBackgroundsButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi virtual Backgrounds butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki virtualBackgrounds ikonu dogrulanir
        Assert.assertTrue(aDashboardPage.virtualBackgroundsButonIkon.isDisplayed());
        extentTest.pass("Dashboard sayfasi virtualBackgrounds ikonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki settings butonu dogrulanir
        Assert.assertTrue(aDashboardPage.settingsButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki settings butonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi soldaki settings ikonu dogrulanir
        Assert.assertTrue(aDashboardPage.settingsButonIkon.isDisplayed());
        extentTest.pass("Dashboard sayfasi soldaki settings ikonu goruntulenebildigi dogrulanir");
        //Dashboard sayfasi  total Active Vcards butonu dogrulanir
        Assert.assertTrue(aDashboardPage.totalActiveVcardsElementi.isDisplayed());
        extentTest.pass("Dashboard sayfasi  total Active Vcards elementi goruntulenebildigi dogrulanir");
        //Dashboard sayfasi  total DeActive Vcards elementi dogrulanir
        Assert.assertTrue(aDashboardPage.totalDeActiveVcardsElementi.isDisplayed());
        extentTest.pass("Dashboard sayfasi  total DeActive Vcards elementi goruntulenebildigi dogrulanir");
        //Dashboard sayfasi  today Enquiries elementi dogrulanir
        Assert.assertTrue(aDashboardPage.todayEnquiries.isDisplayed());
        extentTest.pass("Dashboard sayfasi  today Enquiries elementi  goruntulenebildigi dogrulanir");
        //Dashboard sayfasi  today Appointments elementi dogrulanir
        Assert.assertTrue(aDashboardPage.todayAppointments.isDisplayed());
        extentTest.pass("Dashboard sayfasi  today Appointments elementi  goruntulenebildigi dogrulanir");
        //Dashboard sayfasi vcardAnalyticYazisi dogrulanir
        Assert.assertTrue(aDashboardPage.vcardAnalyticYazisi.isDisplayed());
        extentTest.pass("Dashboard sayfasi  vcardAnalytic Yazisi  goruntulenebildigi dogrulanir");
        //Dashboard sayfasi grafik butonu dogrulanir
        Assert.assertTrue(aDashboardPage.grafikButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi  grafik butonu  goruntulenebildigi dogrulanir");
        //Dashboard sayfasi tablo Grafik dogrulanir
        Assert.assertTrue(aDashboardPage.tabloGrafik.isDisplayed());
        extentTest.pass("Dashboard sayfasi   Grafik tablosunun  goruntulenebildigi dogrulanir");
        //Grafik butonu tıklanir
        aDashboardPage.grafikButon.click();
        extentTest.info("Grafik butonu tiklanir");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        //Dashboard sayfasi grafik butonu tiklandiktan sonraki tablo Grafik degisimi dogrulanir
        Assert.assertTrue(aDashboardPage.tabloGrafik.isDisplayed());
        extentTest.pass("Dashboard sayfasi   Grafik tablo turu degisikliginin  goruntulenebildigi dogrulanir");
        //Dashboard sayfasi tarih butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dateButon.isDisplayed());
        extentTest.pass("Dashboard sayfasi tarih butonu  goruntulenebildigi dogrulanir");
        //Tarih butonu tiklanir
        aDashboardPage.dateButon.click();
        extentTest.info("Tarih  butonu tiklanir");
        ReusableMethods.wait(1);
        //Custom butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dateCustomButon.isDisplayed());
        extentTest.pass("Tarih - Custom butonu   goruntulenebildigi dogrulanir");
        //Last Week butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dateLastWeekButon.isDisplayed());
        extentTest.pass("Tarih - Last Week butonu  goruntulenebildigi dogrulanir");
        //This Week butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dateThisWeekButon.isDisplayed());
        extentTest.pass("Tarih - This Week  butonu  goruntulenebildigi dogrulanir");
        //Apply butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dateApplyButon.isDisplayed());
        extentTest.pass("Tarih - Apply butonu  goruntulenebildigi dogrulanir");
        //Cancel butonu dogrulanir
        Assert.assertTrue(aDashboardPage.dateCancelButon.isDisplayed());
        extentTest.pass("Tarih - Cancel butonu  goruntulenebildigi dogrulanir");
        //Secilen tarih araligi dogrulanir
        Assert.assertTrue(aDashboardPage.dateSelected.isDisplayed());
        extentTest.pass("Secilen tarih araligi  goruntulenebildigi dogrulanir");
        //Takvim sol tablo dogrulanir
        Assert.assertTrue(aDashboardPage.dateTableLeft.isDisplayed());
        extentTest.pass("Takvim sol tablo  goruntulenebildigi dogrulanir");
        //Takvim sag tablo dogrulanir
        Assert.assertTrue(aDashboardPage.dateTableRight.isDisplayed());
        extentTest.pass("Takvim sag tablo  goruntulenebildigi dogrulanir");
        //today Appointments Yazisi dogrulanir
        Assert.assertTrue(aDashboardPage.todayAppointmentsYazisi.isDisplayed());
        extentTest.pass("Today Appointments Yazisi goruntulenebildigi dogrulanir");
        //vcard Name Yazisi dogrulanir
        Assert.assertTrue(aDashboardPage.vcardNameYazisi.isDisplayed());
        extentTest.pass("Vcard Name Yazisi goruntulenebildigi dogrulanir");
        //Name Yazisi dogrulanir
        Assert.assertTrue(aDashboardPage.nameYazisi.isDisplayed());
        extentTest.pass("Name Yazisi goruntulenebildigi dogrulanir");
        //Phone Yazisi dogrulanir
        Assert.assertTrue(aDashboardPage.phoneYazisi.isDisplayed());
        extentTest.pass("Phone Yazisi goruntulenebildigi dogrulanir");
        //Email Yazisi dogrulanir
        Assert.assertTrue(aDashboardPage.emailYazisi.isDisplayed());
        extentTest.pass("Email Yazisi goruntulenebildigi dogrulanir");
        //appointment Report tablosu dogrulanir
        Assert.assertTrue(aDashboardPage.appointmentReport.isDisplayed());
        extentTest.pass("Appointment Report tablosu goruntulenebildigi dogrulanir");
        //Sayfa kapatilir
        Driver.closeDriver();
    }
 }