package tests.US_035_bhdr;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_02 {
    @Test
    public void SoruEklemeTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
    }
}
