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

import java.util.List;

import static utilities.Driver.getDriver;

public class TC_02 {

    @Test
    public void yeniPlanOlusturma(){
        //Verilen URL sayfasına (https://qa.smartcardlink.com/login) gidebilmeli
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ADashboardPage aDashboardPage = new ADashboardPage();

        //Sign in butonunu tıkla
        aDashboardPage.signinButtonElementi.click();

        //Email textbox'ına Kayıtlı Admin email adresini gir
        aDashboardPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("semail"));

        //Password textbox'ına kayıtlı admin password'u gir
        aDashboardPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("spassword"));

        //Login butonuna click yap
        aDashboardPage.loginElementi.click();

        //Dashboard sayfasında "Plans" seçeneğini tıkla
        aDashboardPage.planlarElementi.click();

        //Yeni plan eklemeden önce kontrol için mevcut planların sayısını gör.
        WebElement planlarElementiSayisi= aDashboardPage.planlarinSayisiElementi;
        String ilkPlanSayisi=planlarElementiSayisi.getText();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);

        //Planların toplam sayısını kontrol için konsola yazdır
        System.out.println(ilkPlanSayisi);

        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(3);


        // Yeni plan (New Plan) oluştura tıkla
        aDashboardPage.yeniPlanElementi.click();

        //Yeni Plana İsim gir
        Faker faker =new Faker();
        String fakeName = faker.name().fullName();
        aDashboardPage.yeniPlanIsim.sendKeys(fakeName);

        //Plan süresi seç
        WebElement selectElementSure= aDashboardPage.planSure;
        Select dropdown=new Select(selectElementSure);
        dropdown.selectByIndex(2);

        //Planın Kur bilgisini seç
        WebElement selectElementPara= aDashboardPage.paraSecimi;
        Select dropdown2=new Select(selectElementPara);
        dropdown2.selectByIndex(5);

        //Planın fiyatını gir
        aDashboardPage.fiyatGiris.sendKeys("200");

        //izin verilen sanal kart sayısını git
        aDashboardPage.vCardSayisi.sendKeys("4");

        //Ucretsiz deneme süresi gir
        aDashboardPage.denemeSuresi.sendKeys("30");

        // geçerli temletelerden birini seç
        WebElement templeteler = aDashboardPage.templeteElementi;
        List<WebElement> resimler = templeteler.findElements(By.tagName("value"));
        resimler.indexOf(3);

        // sayfasına altına in
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // yükleme geciktiği için bekle
        ReusableMethods.wait(3);

        // Sayfadaki tüm checkbox'ları bulun.
        // Tüm checkboxların tek tek locatlerini alıp seçtirmek yerine list yapıp isteneni seçtirme yöntemi tercih ettim.
        List<WebElement> checkboxlar = getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        // İstediğiniz özelliklerden birini indeksini burada belirleyin (örneğin, 25. checkbox).
        int checkboxIndeks = 11;

        //sayfada toplam 29 tane checbox var.
        // bunlardan 12. (index11) tüm özellikleri seçer. eğer tüm yerine başka özellik seçilecekse 11-28 arasında bir index seöçilir.
        if (checkboxIndeks >= 0 && checkboxIndeks < checkboxlar.size()) {
            WebElement secilenCheckbox = checkboxlar.get(checkboxIndeks);
            if (!secilenCheckbox.isSelected()) {
                secilenCheckbox.click();
            }
        } else {
            System.out.println("Geçersiz indeks: " + checkboxIndeks);
        }

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(3);

        //Seçilen kart bilgilerini kaydetmek için save botunonu tıkla
        aDashboardPage.kaydetbutonu.click();

        //Planlar sayfasında tüm planların sayısını görülebildiğini doğrulamak için aşağıya in
        WebElement sonPlanlarSayisi = aDashboardPage.planlarinSayisiElementi;
        Assert.assertTrue(sonPlanlarSayisi.isDisplayed());
        ReusableMethods.wait(3);

        //plan sayılarının son halini görmek için konsola yazıdr.
        System.out.println(sonPlanlarSayisi.getText());

        //plan kaydedildiğini test için ilk plan sayısı ile sonraki plan sayısının faklı olduğu doğrula
        Assert.assertNotEquals(sonPlanlarSayisi.getText(),ilkPlanSayisi);

        //Sayfayı kapat
       // Driver.closeDriver();
    }
}


