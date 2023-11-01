package tests.US_030_Seref;

import com.github.javafaker.Faker;
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

import java.io.IOException;

public class TC_04 extends TestBaseRapor {

        /*
        URL= https://qa.smartcardlink.com
        Admin email1 = admin22@smartcardlink.com
        Admin email2 = admin23@smartcardlink.com
        Admin email3 = admin24@smartcardlink.com
        Admin password = 123123123
        */

    @Test
    public void ulkeEklemeTesti() throws IOException {

        extentTest = extentReports.createTest("Ulkeler Sayısını Gorme Testi", "Admin panelde kullanılan Ulkelerin Sayısını görmeli");

        //Browser'e açıp "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("Kullanici https://qa.smartcardlink.com anasayfaya gider");

        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        extentTest.info("Sign In buttonuna tıklar");

        //Admin email ve Password bilgilerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        loginPage.loginElementi.click();
        extentTest.info("Admin email ve Password bilgilerini girip Login butonuna tıklar");

        // Dashboard menu listesindeki ulkeler ögesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.countriesElementi.click();
        extentTest.info("Dashboard menu listesindeki Ulkeler sekmesini tıklar");

        // Ülkeler (Countries) sayfasında aşağıya ininiz.
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String expectedUlkeSayisi = aDashboardPage.ulkeSayisiYaziElementi.getText();
        System.out.println(expectedUlkeSayisi);
        Faker faker =new Faker();
        String isim = faker.name().fullName();
        System.out.println(isim);
        String yeniIsim = "";

        for (int i = 0; i < isim.length(); i++) {
            char karakter = isim.charAt(i);
            if (karakter == 'a' || karakter == 'e' || karakter == 'ı' || karakter == 'i' || karakter == 'o' || karakter == 'ö' || karakter == 'u' || karakter == 'ü') {
                // sesli harf, çıkar veya boşluğa dönüştür
                yeniIsim += " ";
            } else {
                // sessiz harf, ekle
                yeniIsim += karakter;
            }
        }

        System.out.println("Yeni isim: " + yeniIsim);
        String bosluksuzIsim = yeniIsim.replaceAll("\\s+","");
        String ikiharfKismi=bosluksuzIsim.substring(0,2);

        // Ülkeler (Countries) sayfasında Yeni Ülke (New Country) butonunu tıklayınız.
        aDashboardPage.newCountryButtonElementi.click();
        extentTest.info("Ülkeler (Countries) sayfasında Yeni Ülke (New Country) butonunu tıklar.");

        // Ülkeler (Countries) sayfasında Yeni Ülke (New Country) butonunu tıklayınız.
        aDashboardPage.countryNameBoxElementi.click();
        extentTest.info("Ülkeler (Countries) sayfasında Yeni Ülke (New Country) butonunu tıklar.");

        actions.sendKeys(isim).sendKeys(Keys.TAB).sendKeys(ikiharfKismi).perform();

        // Ülke Ekle bölümünde save butonuna tıklayınız
        aDashboardPage.saveCountryElementi.click();

        ReusableMethods.wait(2);

        String actualUlkeSayisi = aDashboardPage.ulkeSayisiYaziElementi.getText();

        ReusableMethods.wait(3);

        // Siteye yeni ülke eklenebildiğini test ediniz.
        System.out.println("Actual : "+ actualUlkeSayisi);
        Assert.assertNotEquals(actualUlkeSayisi,expectedUlkeSayisi);
        extentTest.pass("Siteye yeni ülke eklenebildiğini doğrulayınız");

        ReusableMethods.wait(3);

        extentTest.info("sayfayi kapatir");

    }

}