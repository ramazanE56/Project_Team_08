package tests.US_018;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_01 {


    @Test
    public void AdminDashboard(){
        //Admin olarak "https://qa.smartcardlink.com/" adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        //Sign In buttonuna tıklayınız
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        smartcardlinkPage.signinButtonElementi.click();
        //email ve Password değerlerini girip Login butonuna tıklayınız
        smartcardlinkPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("susername"));



    }

}
