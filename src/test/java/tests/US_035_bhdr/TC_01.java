package tests.US_035_bhdr;

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

public class TC_01 {
    @Test
    public void TestimonialsGorusTest(){
        Actions actions=new Actions(Driver.getDriver());
        //1.Browser açılır
        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        ReusableMethods.wait(2);
        //3.Sıgn In butonuna click yapılır.
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //4.eMail kutusuna kullanıcı email i yazılır
        LoginPage loginPage=new LoginPage();
        loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("adminEmail3"));
        //5.password kutusuna kullanıcı şifresi yazılır
        loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("adminPassword"));
        //6.login butonua basılır
        loginPage.loginElementi.click();
        //7.Search arama butonu click edilir.Front cms click edilir.
       // ADashboardPage aDashboardPage=new ADashboardPage();
        //aDashboardPage.searchFrontButonu.click();
       // actions.click(aDashboardPage.searchFrontButonu).sendKeys(Keys.DOWN).perform();
       // ReusableMethods.wait(5);
       // aDashboardPage.frontCmsButonuElementi.click();
        //ReusableMethods.wait(5);
        ADashboardPage aDashboardPage = new ADashboardPage();
        ReusableMethods.clickClearSendkeys(aDashboardPage.adminSearchTextbox, "" + Keys.TAB + Keys.TAB + Keys.PAGE_DOWN);
        aDashboardPage.frontCmsButonuElementi.click();


        //8.Testimonials butonu click edilir.
        aDashboardPage.testimonialsButonElementi.click();
        ReusableMethods.wait(5);
        //9.add Testimonials butonun göründügü test edilir
        String actualActionElementi=aDashboardPage.actionButonElementi.getText();
        String expectedTestimonials="ACTION";
        Assert.assertEquals(actualActionElementi,expectedTestimonials);


    }
}
