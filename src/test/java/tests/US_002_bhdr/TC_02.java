package tests.US_002_bhdr;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
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

import static utilities.TestBaseRapor.extentTest;

public class TC_02 {

    @Test
    public void menuGorunumTesti() throws InterruptedException {

        Actions actions=new Actions(Driver.getDriver());
        //2.https://qa.smartcardlink.com/adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));

        //.Smart Card Link yazısının oldugu test edilmelidir
        SmartcardlinkPage smartcardlinkPage=new SmartcardlinkPage();
        String actualSmartCardLinkiElementi= smartcardlinkPage.smartCardLinkiElementi.getText();
        String expectedIcerik="Smart Card Link";
        Assert.assertEquals(expectedIcerik,actualSmartCardLinkiElementi);
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);

        //home butonun click yapıp aktif oldugu test edilir.

        smartcardlinkPage.homeButonElementi.click();
        Assert.assertTrue(smartcardlinkPage.homeResimElementi.isDisplayed());
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);

        //Features butonun click yapıp aktif oldugu test edilir.
        smartcardlinkPage.featuresButonElementi.click();
        Assert.assertTrue(smartcardlinkPage.featuresYaziElementi.isDisplayed());
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);


       // About butonun click yapıp aktif oldugu test edilir.
        smartcardlinkPage.aboutButonElementi.click();
        Assert.assertTrue(smartcardlinkPage.aboutSmartCardYaziElementi.isDisplayed());
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);

        //Pricing  butonun click yapıp aktif oldugu test edilir.
        smartcardlinkPage.pricingButonElementi.click();
        Assert.assertTrue(smartcardlinkPage.chooseYaziElementi.isDisplayed());
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);

        //Contact  butonun click yapıp aktif oldugu test edilir.
        smartcardlinkPage.contactButonElementi.click();
        Assert.assertTrue(smartcardlinkPage.concantYaziElementi.isDisplayed());




    }

}
