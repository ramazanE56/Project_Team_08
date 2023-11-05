package tests.US_08_Ali;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import tests.US_010_Burhan.utilities.ConfigReader;
import tests.US_010_Burhan.utilities.Driver;
import tests.US_010_Burhan.utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {

    @Test
    public void TC_01 (){

        extentTest=extentReports.createTest("Yeni VCard Oluşturma Testi","Kullanıcı Kayıtlı Kulanıcı bilgilerini girerek yeni bir VCard oluşturabilmeli");
        //"https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Signin butonuna click yapılır.");

        //email ve Password değerlerini girip Login butonuna tıklayınız
        LoginPage loginPage = new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("yenimail"));
        extentTest.info("Email kutusuna email girilir.");

        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("yenipassword"));
        extentTest.info("Password kutusuna password girilir.");

        loginPage.loginElementi.click();
        extentTest.info("Login butonuna tıklanır.");

        // Dashboard sayfasından soldaki menuden VCards elementi tiklanir.
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.dashboardVCardsElementi.click();
        extentTest.info("Dashboard sayfasından soldaki menuden VCards elementi tiklanir ");

        // Acilan sayfada New Vcard butonu tiklanir.
        aDashboardPage.dashboardNewVcardButonu.click();
        extentTest.info("Dashboard sayfasından soldaki menuden VCards elementi tiklanir.");

        // Acilan New Vcard sayfasinda Url Alias, VCard Name, Occupation, Description bolumleri doldurulur.

        aDashboardPage.newVCardUrlAliasGenerateButonu.click();
        extentTest.info("Random Url Alias belirleyen buton tıklanır. ");

        aDashboardPage.newVCardNameKutusu.sendKeys(ConfigReader.getProperty("newVCardName"));
        extentTest.info("VCard Name kutusu doldurulur.");

        aDashboardPage.newVCardOccupationKutusu.sendKeys(ConfigReader.getProperty("occupation"));
        extentTest.info("Occupation kutusu doldurulur.");

        aDashboardPage.newVCardDescriptionKutusu.sendKeys(ConfigReader.getProperty("description"));
        extentTest.info("Description kutusu doldurulur.");

        aDashboardPage.newVCardSaveButonu.click();
        extentTest.info("New VCard bölümündeki Save butonu tıklanır.");

        Assert.assertTrue(aDashboardPage.vcardCreatedSuccesfullyAlerti.isDisplayed());
        extentTest.info("Yeni VCard oluşturulduğu doğrulanır.");
















    }



}
