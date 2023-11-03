package tests.US_005_Kaan;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SmartcardlinkPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_005_TC_01 extends TestBaseRapor {

    @Test(groups = "smoke")
    public void createAnAccountTesti() throws IOException {
        extentTest = extentReports.createTest("Yeni kullanici hesabı olusturma.",
                "Yeni kullanici hesabı olusturulabilindigini test eder");

        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage = new LoginPage();
        SmartcardlinkPage smartcardlinkPage = new SmartcardlinkPage();
        Faker faker=new Faker();


        //   1. Belirlenen site Url'li ile browserdan siteye erişilebilir olmalıdır.


        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("https://qa.smartcardlink.com/ adresine gidilmiştir");


        //  2. Sign In butonunu tıklanır.
        actions.click(smartcardlinkPage.signinButtonElementi).perform();
        extentTest.info("Sign In butonunu tıklanır.");
        //3. Açılan login sayfasında bulunan "Create an Account" linkine tıklanır.
        actions.click(loginPage.createAnAccountElementi).perform();
        extentTest.info("Açılan login sayfasında bulunan \"Create an Account\" linkine tıklanır.");
        //4. Açılan register sayfasında first name, last name, email, password, confir Password alanlarına geçerli bilgiler girilir.
        actions.click(loginPage.firstNameElementi);
        actions.sendKeys("team08Newusername");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("team08NewuserSurname");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.internet().emailAddress());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("passwordTeam08.");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("passwordTeam08.").perform();
        extentTest.info("Açılan register sayfasında first name, last name, email, password, confir Password alanlarına geçerli bilgiler girilir.");
ReusableMethods.wait(2);
        //5. Register sayfasındaki, "By signing up you agree to our Terms & Conditions & Privacy Policy" kısmına ait checkbox tıklanır.
        actions.click(loginPage.priPolCheckboxElementi).perform();
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        extentTest.info("Register sayfasındaki, \"By signing up you agree to our Terms & Conditions & Privacy Policy\" kısmına ait checkbox tıklanır.");
ReusableMethods.wait(2);
        //6. Submit butonuna tıklanır.
        actions.click(loginPage.NewUserSubmitElementi).perform();
        extentTest.info("Submit butonuna tıklanır.");
ReusableMethods.wait(2);

        //7. "You have succesfully registered." onay yazısının çıktığı test edilir.
        Assert.assertTrue(loginPage.succesedElementi.isDisplayed());
        extentTest.pass(" \"You have succesfully registered.\" onay yazısının çıktığı test edilir.");
        ReusableMethods.getScreenshot("createAnAccountTesti");
ReusableMethods.wait(2);

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Sayfa kapatilir.");

    }

}
