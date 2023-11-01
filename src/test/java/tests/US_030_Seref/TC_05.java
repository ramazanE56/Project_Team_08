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

public class TC_05 extends TestBaseRapor {

        /*
        URL= https://qa.smartcardlink.com
        Admin email1 = admin22@smartcardlink.com
        Admin email2 = admin23@smartcardlink.com
        Admin email3 = admin24@smartcardlink.com
        Admin password = 123123123
        */

    @Test
    public void numberOfCountriesTesti() throws IOException {

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

        // Dashboard menu listesindeki ulkeler sekmesini tıklayınız
        ADashboardPage aDashboardPage = new ADashboardPage();
        aDashboardPage.countriesElementi.click();
        extentTest.info("Dashboard menu listesindeki Ulkeler sekmesini tıklar");

        // // Ulkelerin sayısının yanındaki oku tıklayınız
        // aDashboardPage.ulkelerListesiSayfa2YaziElementi.click();
        // extentTest.info("Ulkelerin sayısının yanındaki oku tıklar");
        //
        // // Ulkelerin sayısının yanındaki oku tıklayınız
        // aDashboardPage.ulkelerListesiSayfa3YaziElementi.click();
        // extentTest.info("Ulkelerin sayısının yanındaki oku tıklar");
        //
        // // Sitede kullanılan ulkelerin sayısının görüldüğünü test ediniz
        // Assert.assertTrue(aDashboardPage.ulkelerListesiSayfa3YaziElementi.isDisplayed());
        // extentTest.pass("Ulkelerin sayısının görüldüğünü test eder");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Assert.assertTrue(aDashboardPage.ulkelerSayisiYaziElementi.isDisplayed());

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

        aDashboardPage.newCountryButtonElementi.click();
        aDashboardPage.countryNameBoxElementi.click();


        actions.sendKeys(isim).sendKeys(Keys.TAB).sendKeys(ikiharfKismi).perform();
        aDashboardPage.saveCountryElementi.click();
        ReusableMethods.wait(2);
        String actualUlkeSayisi = aDashboardPage.ulkeSayisiYaziElementi.getText();

        ReusableMethods.wait(3);

        System.out.println("Actual : "+ actualUlkeSayisi);
        Assert.assertNotEquals(actualUlkeSayisi,expectedUlkeSayisi);

        ReusableMethods.wait(3);

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");

    }

}