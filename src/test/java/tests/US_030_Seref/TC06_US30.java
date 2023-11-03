package tests.US_030_Seref;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC06_US30 extends TestBaseRapor {

        /*
        URL= https://qa.smartcardlink.com
        Admin email1 = admin22@smartcardlink.com
        Admin email2 = admin23@smartcardlink.com
        Admin email3 = admin24@smartcardlink.com
        Admin password = 123123123
        */

    @Test
    public void yeniSehirEklemeTesti() throws IOException {

        extentTest = extentReports.createTest("Siteye Yeni Şehir (New City) eklenebildiğini Gorme Testi",
                "Admin panelde Yeni Eyalet eklenebildiğini görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider.");

        ReusableMethods.wait(3);

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signInButtonElementi.click();
        extentTest.info("Sign In buttonuna tıklar.");

        //Admin email ve Password bilgilerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        loginPage.loginElementi.click();
        extentTest.info("Admin email ve Password bilgilerini girip Login butonuna tıklar.");

        // Dashboard menu listesindeki ulkeler ögesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.countriesElementi.click();
        extentTest.info("Dashboard menu listesindeki Ulkeler ogesini tıklar");

        ReusableMethods.wait(5);

        // Ülkeler (Countrie) sayfasında Şehirler (Cities) sekmesini tıklayınız.
        aDashboardPage.citiesSekmesiElementi.click();
        extentTest.info("Ülkeler (Countrie) sayfasında Şehirler (Cities) sekmesini tıklar.");

        ReusableMethods.wait(5);

        // Şehirler (Cities) sayfasında Yeni Şehir (New City) butonunu tıklayınız.
        aDashboardPage.newCityButtonElementi.click();
        extentTest.info("Şehirler (Cities) sayfasında Yeni Şehir (New City) butonunu tıklar.");

        ReusableMethods.wait(5);

        // Yeni Şehir (New City) adı kutusuna yeni bir Şehir adı ekleyiniz.
        Faker faker = new Faker();
        String yeniCity = faker.name().firstName();
        aDashboardPage.stateNameBoxElementi.sendKeys(yeniCity);
        extentTest.info("Yeni Şehir (New City) adı kutusuna yeni bir Şehir adını ekler.");

        // Eyalet seç kısmından Eyalet seçiniz.
        Select select = new Select(aDashboardPage.cityStateSecmeElementi);
        select.selectByVisibleText("Amparo");
        extentTest.info("Eyalet seç kısmından Eyalet seçer.");

        // Kayıt butonunu tıklayınız.
        aDashboardPage.saveCityButtonElementi.click();
        extentTest.info("Kayıt butonunu tıklar.");

        ReusableMethods.wait(2);

        aDashboardPage.citiesSekmesiElementi.click();

        ReusableMethods.wait(2);

        String actualIlkCity = aDashboardPage.sonEklenenCityElementi.getText();

        System.out.println("Eklenen Yeni Şehir : " + yeniCity);
        System.out.println("Görünen Yeni Şehir : " + actualIlkCity);

        // Siteye yeni Şehir eklendiğini test ediniz.
        Assert.assertEquals(yeniCity, actualIlkCity);
        extentTest.pass("Siteye yeni Şehir eklendiğini test eder.");

        ReusableMethods.getScreenshot("Şehirlerin (Cities) görüldüğü sayfa");
        extentTest.info("Şehirlerin (Cities) goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(2);

        // Browser'ı kapatımız.
        extentTest.info("Browser'eı kapatır.");


    }

}