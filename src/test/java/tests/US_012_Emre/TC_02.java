package tests.US_012_Emre;


import com.github.javafaker.Faker;
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

public class TC_02 extends TestBaseRapor {
    /*Kayıtlı kullanıcı ‘Credentials’ bölümündeki
Ayarları  güncelleyebildiği doğrulanmalı.
     */
@Test
    public void credentialsUpdateTesti() {
    extentTest=extentReports.createTest("Kayıtlı kullanıcı ‘Credentials’ bölümündeki ayarları  güncelleme","Kayıtlı Kulanıcı bilgilerini girerek Credentials sayfasına ulaşıp kimlik bilgilerini güncelleyebilmeli");
    //1-Browser açılır
    //2-https://qa.smartcardlink.com/ adresine gidilir.
    Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
    extentTest.info("https://qa.smartcardlink.com/ adresine gidilir");
    //3-Sign In butonuna click yapılır.
    SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
    smartcardlinkPage.signinButtonElementi.click();
    extentTest.info("Signin butonuna click yapılır.");
    //4-Email textbox'ına Kayıtlı email bilgisi girilir.
    LoginPage loginPage=new LoginPage();
    loginPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("brEmail"));
    extentTest.info("Email textbox'ına Kayıtlı email bilgisi girilir.");
    //5-Password textbox'ına geçerli password bilgisi girilir.
    loginPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("brPassword"));
    extentTest.info("Password textbox'ına geçerli password bilgisi girilir.");
    //6-Login butonuna click yapılır.
    loginPage.loginElementi.click();
    extentTest.info("Login butonuna click yapılır.");
    //7-Yan menudeki Settings linkine click yapılır.
    ADashboardPage aDashboardPage=new ADashboardPage();
    aDashboardPage.userSettingsLinki.click();
    extentTest.info("Yan menüdeki Settings linkine click yapılır.");
    //8-‘Credentials’  bölümündeki ayarlar değiştirilir.
    Faker faker=new Faker();
    ReusableMethods.makeTheWebElementIsSelected(aDashboardPage.userCredential_paypalCheckbox);
    ReusableMethods.makeTheWebElementIsSelected(aDashboardPage.userCredential_stripeCheckbox);
    ReusableMethods.wait(2);
    extentTest.info("'stripe' ve 'paypal' butonları seçili konuma getirilir.");

    ReusableMethods.clickClearSendkeys(aDashboardPage.userCredential_stripeKeyTextbox,faker.name().firstName());
    ReusableMethods.clickClearSendkeys(aDashboardPage.userCredential_stripeSecretTextbox,faker.name().firstName());
    ReusableMethods.clickClearSendkeys(aDashboardPage.userCredential_paypalClientIdTextbox,faker.idNumber().valid());
    ReusableMethods.clickClearSendkeys(aDashboardPage.userCredential_paypalModeTextbox,faker.name().firstName());
    ReusableMethods.clickClearSendkeys(aDashboardPage.userCredential_paypalSecretTextbox,faker.name().firstName());
    extentTest.info("Tüm textbox'lardaki bilgiler değiştirilir.");

    String oldCurrencyText=aDashboardPage.userCredential_currencyList.getText();
    ReusableMethods.changeDropdownOption(aDashboardPage.userCredential_currencyList);
    String newCurrencyText=aDashboardPage.userCredential_currencyList.getText();
    Assert.assertFalse(newCurrencyText.equals(oldCurrencyText));
    extentTest.pass("Currency seçimi değiştirlebilmelidir");
    aDashboardPage.userCredential_paypalCheckbox.sendKeys(Keys.PAGE_DOWN);

    ReusableMethods.wait(1);

    ReusableMethods.clickAndSendkeys(aDashboardPage.userCredential_currencyList,""+Keys.TAB+Keys.TAB+Keys.ARROW_RIGHT);
    extentTest.info("'Time Format' seçimi değiştirilir.");
    aDashboardPage.userCredential_enableContactCheckbox.click();
    aDashboardPage.userCredential_hideStickybarCheckbox.click();
    aDashboardPage.userCredential_whatsappShareCheckbox.click();
    extentTest.info("'Enable Contact' , 'Hide Stickybar' , 'Whatsapp Share' checkbox seçimleri değiştirilir.");
    //9-Save butonu click yapılır
    aDashboardPage.userCredential_saveButton.click();
    extentTest.info("Save butonu click yapılır.");
    //10-"Settings updated successfully." yazısının çıktığını test et.
    Assert.assertTrue(aDashboardPage.userCredential_saveSuccesss.isDisplayed());
    extentTest.pass("Credentials güncellenerek kaydedilebildiği, 'Settings updated successfully.' yazısının çıktığı test edilir.");
    //11-Browser kapatılır.
    Driver.closeDriver();
}
}
