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

public class TC_05 extends TestBaseRapor {

        /*
        URL= https://qa.smartcardlink.com
        Admin email1 = admin22@smartcardlink.com
        Admin email2 = admin23@smartcardlink.com
        Admin email3 = admin24@smartcardlink.com
        Admin password = 123123123
        */

    @Test
    public void yeniEyaletEklemeTesti() throws IOException {

        extentTest = extentReports.createTest("Siteye Yeni Eyalet (New State) eklenebildiğini Gorme Testi",
                "Admin panelde Yeni Eyalet eklenebildiğini görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider.");

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
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

        // Ülkeler (Countrie) sayfasında Eyaletler (States) sekmesini tıklayınız.
        aDashboardPage.statesSekmesiElementi.click();
        extentTest.info("Ülkeler (Countrie) sayfasında Eyaletler (States) sekmesini tıklar.");

        ReusableMethods.wait(5);

        // Eyaletler (States) sayfasında Yeni Euaylet (New State) butonunu tıklayınız.
        aDashboardPage.newStateButtonElementi.click();
        extentTest.info("Eyaletler (States) sayfasında Yeni Euaylet (New State) butonunu tıklar.");

        ReusableMethods.wait(5);

        // Yeni Eyalet (New State) adı kutusuna yeni bir Eyalet adı ekleyiniz.
        Faker faker = new Faker();
        String yeniState = faker.name().firstName();
        aDashboardPage.stateNameBoxElementi.sendKeys(yeniState);
        extentTest.info(" Yeni Eyalet (New State) adı kutusuna yeni bir Eyalet adını ekler.");

        // Ülke seç kısmından Ülke seçiniz.
        Select select = new Select(aDashboardPage.stateCountrySecmeElementi);
        select.selectByVisibleText("Belgium");
        extentTest.info("Ülke seç kısmından Ülke seçer.");

        // Kayıt butonunu tıklayınız.
        aDashboardPage.saveCountryButtonElementi.click();
        extentTest.info("Kayıt butonunu tıklar.");

        ReusableMethods.wait(2);

        aDashboardPage.statesSekmesiElementi.click();

        ReusableMethods.wait(2);

        String actualIlkState = aDashboardPage.sonEklenenStateElementi.getText();

        System.out.println("Eklenen Yeni Eyalet : " + yeniState);
        System.out.println("Görünen Yeni Eyalet : " + actualIlkState);

        // Siteye yeni Eyalet eklendiğini test ediniz.
        Assert.assertEquals(yeniState, actualIlkState);
        extentTest.pass("Siteye yeni Eyalet eklendiğini test eder.");

        ReusableMethods.getScreenshot("Eyaletlerin (States) görüldüğü sayfa");
        extentTest.info("Eyaletlerin (States) goruldugu sayfanın fotografini ceker");

        ReusableMethods.wait(3);

        // Browser'ı kapatımız.
        extentTest.info("Browser'ı kapatır.");


    }

}