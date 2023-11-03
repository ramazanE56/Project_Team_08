package tests.US_015_Osman;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ADashboardPage;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void test01(){

    //-https://qa.smartcardlink.com/ adresine gidilir.
    Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
    //-Sign In butonuna click yapılır.
    SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
    smartcardlinkPage.signinButtonElementi.click();
    //Email textbox'ına Kayıtlı email bilgisi girilir.
    LoginPage loginPage=new LoginPage();
    loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("brEmail"));
    //Password textbox'ına geçerli password bilgisi girilir.
    loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("brPassword"));
    //Login butonuna click yapılır.
    loginPage.loginElementi.click();

}
}