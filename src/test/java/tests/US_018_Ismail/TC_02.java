package tests.US_018_Ismail;


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

public class TC_02 {
    @Test
    public void dashBoardSayfasi(){
        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //email ve Password değerlerini girip Login butonuna tıklayınız
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        actions.click(loginPage.emailKutusuElementi);
        actions.sendKeys(ConfigReader.getProperty("semail"));
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(ConfigReader.getProperty("spassword")).perform();
        loginPage.loginElementi.click();
        ReusableMethods.wait(2);
        ADashboardPage aDashboardPage = new ADashboardPage();
        //1-Toplam aktif kullanıcı sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalActiveUsersElementi.isDisplayed());
        //2-Toplam aktif olmayan kullanıcı sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalDeActiveUsersElementi.isDisplayed());
        //3-Toplam aktif Vcard sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalActiveVcardsElementi.isDisplayed());
        //4-Toplam aktif olmayan Vcard sayısının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.totalDeActiveVcardsElementi.isDisplayed());
        //5-Kullanıcı plan oranları tablosunun görünür olduğu doğrulanır.
        Assert.assertTrue(aDashboardPage.plansbyUsersElementi.isDisplayed());
        //6-Kullanıcı gelir grafiğinin görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.graficElementi.isDisplayed());
        //7-Günlük kullanıcı kayıtlarının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.gunlukElementi.isDisplayed());
        //8-Haftalık kullanıcı kayıtlarının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.haftalikElementi.isDisplayed());
        //9-Aylık kullanıcı kayıtlarının görünür olduğu doğrulanır
        Assert.assertTrue(aDashboardPage.aylikElementi.isDisplayed());
        Driver.closeDriver();
    }
}
