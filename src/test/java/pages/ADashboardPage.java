package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ADashboardPage {
    public ADashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
