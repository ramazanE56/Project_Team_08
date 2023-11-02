package tests.US_025_Kahraman;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import java.util.List;

import static utilities.Driver.getDriver;

public class TC_02 extends TestBaseRapor {

    @Test
    public void yeniPlanOlusturma(){

        extentTest=extentReports.createTest("Admin bilgileri ile giriş yaptıktan sonra yeni plan oluşturma testi",
                "Admin bilgileri ile giriş yaptıktan sonra yeni üyelik plannı kaydedebilmeli");

        //Verilen URL sayfasına (https://qa.smartcardlink.com/login) gidebilmeli
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ADashboardPage aDashboardPage = new ADashboardPage();


        //Sign in butonunu tıkla
        aDashboardPage.signinButtonElementi.click();
        extentTest.info("Sign in butonunu tıkla");

        //Email textbox'ına Kayıtlı Admin email adresini gir
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));
        extentTest.info("Email textbox'ına Kayıtlı Admin email adresini gir");

        //Password textbox'ına kayıtlı admin password'u gir
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));
        extentTest.info("Password textbox'ına kayıtlı admin password'u gir");

        //Login butonuna click yap
        aDashboardPage.loginElementi.click();
        extentTest.info("Login butonuna click yap");

        //Dashboard sayfasında "Plans" seçeneğini tıkla
        aDashboardPage.planlarElementi.click();
        extentTest.info("Dashboard sayfasında Plans seçeneğini tıkla");

        //Yeni plan eklemeden önce kontrol için mevcut planların sayısını gör.
        WebElement planlarElementiSayisi= aDashboardPage.planlarinSayisiElementi;
        String ilkPlanSayisi=planlarElementiSayisi.getText();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);
        extentTest.info("Yeni plan eklemeden önce kontrol için mevcut planların sayısını gör.");

        //Planların toplam sayısını kontrol için konsola yazdır
        System.out.println(ilkPlanSayisi);
        extentTest.info("Planların toplam sayısını kontrol için konsola yazdır");

        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(3);


        // Yeni plan (New Plan) oluştura tıkla
        aDashboardPage.yeniPlanElementi.click();
        extentTest.info("Yeni plan (New Plan) oluştura tıkla");

        //Yeni Plana İsim gir
        Faker faker =new Faker();
        String fakeName = faker.name().fullName();
        aDashboardPage.yeniPlanIsim.sendKeys(fakeName);
        extentTest.info("Yeni Plana İsim gir");

        //Plan süresi seç (aylık - 0), (Yıllık - 1), (süresiz - 2)
        WebElement selectElementSure= aDashboardPage.planSure;
        Select dropdown=new Select(selectElementSure);
        dropdown.selectByIndex(2);
        extentTest.info("Plan süresi seç (aylık - 0), (Yıllık - 1), (süresiz - 2) ");

        //Planın Kur bilgisini seç
        WebElement selectElementPara= aDashboardPage.paraSecimi;
        Select dropdown2=new Select(selectElementPara);
        dropdown2.selectByIndex(5);
        extentTest.info("Planın Kur bilgisini seç");

        //Planın fiyatını gir
        aDashboardPage.fiyatGiris.sendKeys("200");
        extentTest.info("Planın fiyatını gir");

        //izin verilen sanal kart sayısını git
        aDashboardPage.vCardSayisi.sendKeys("4");
        extentTest.info("izin verilen sanal kart sayısını git");

        //Ucretsiz deneme süresi gir
        aDashboardPage.denemeSuresi.sendKeys("30");
        extentTest.info("Ucretsiz deneme süresi gir");

        ReusableMethods.wait(3);

        //templetlerden 1 varsayılan olarak geldiği için bunu silmek için bir kere tıklanır
        aDashboardPage.templete1.click();
        extentTest.info("templetlerden 1 varsayılan olarak geldiği için bunu silmek için bir kere tıklanır");


        // 11 adet çoklu şablanlardan 2 - 3 ve 8  seç
        aDashboardPage.templete2.click();
        aDashboardPage.templete3.click();
        extentTest.info("11 adet çoklu şablanlardan seç");

        // sayfasına altına in
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // yükleme geciktiği için bekle
        ReusableMethods.wait(1);
        aDashboardPage.templete8.click();

        // yükleme geciktiği için bekle
        ReusableMethods.wait(1);

        // sayfasına altına in
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        // yükleme geciktiği için bekle
        ReusableMethods.wait(1);

        // Sayfadaki tüm checkbox'ları bulun.
        // Tüm checkboxların tek tek locatlerini alıp seçtirmek yerine list yapıp isteneni seçtirme yöntemi tercih ettim.
        // İstediğiniz özelliklerden birini indeksini burada belirleyin (örneğin, 25. checkbox).
        // sayfada toplam 29 tane checbox var.
        // bunlardan 12. (index11) tüm özellikleri seçer. eğer tüm yerine başka özellik seçilecekse 11-28 arasında bir index seöçilir.
        List<WebElement> checkboxlar = getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        int checkboxIndeks = 11;

         if (checkboxIndeks >= 0 && checkboxIndeks < checkboxlar.size()) {
          WebElement secilenCheckbox = checkboxlar.get(checkboxIndeks);
           if (!secilenCheckbox.isSelected()) {
              secilenCheckbox.click();
           }
          } else {
          System.out.println("Geçersiz indeks: " + checkboxIndeks);
          }

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        extentTest.info("İstediğiniz özelliklerden birini indeksini burada belirleyin");
        ReusableMethods.wait(1);

        //Seçilen kart bilgilerini kaydetmek için save botunonu tıkla
        aDashboardPage.kaydetbutonu.click();
        extentTest.info("Seçilen kart bilgilerini kaydetmek için save botunonu tıkla");

        //Planlar sayfasında kaydedilen planı görülebildiğini doğrulanmalı
        WebElement sonPlanlarSayisi = aDashboardPage.planlarinSayisiElementi;
        Assert.assertTrue(sonPlanlarSayisi.isDisplayed());
        ReusableMethods.wait(3);
        extentTest.pass("Planlar sayfasında kaydedilen planı görülebildiğini doğrulanmalı");

        //plan sayılarının son halini görmek için konsola yazıdr.
        System.out.println(sonPlanlarSayisi.getText());

        //plan kaydedildiğini test için ilk plan sayısı ile sonraki plan sayısının faklı olduğu doğrula
        Assert.assertNotEquals(sonPlanlarSayisi.getText(),ilkPlanSayisi);
        extentTest.pass("Planlar sayfasında yeni plan kaydedildiğini doğrulamak için için ilk plan sayısından farklı olduğunu doğrula");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);

        //Sayfayı kapat
         Driver.closeDriver();
    }
}


