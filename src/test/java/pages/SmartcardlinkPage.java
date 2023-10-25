package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SmartcardlinkPage {
    public SmartcardlinkPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signinButtonElementi;
    @FindBy(name = "email")
    public WebElement emailKutusuElementi;
    @FindBy(name = "password")
    public WebElement passwordKutusuElementi;

    @FindBy (xpath = "//*[@class=\"btn btn-primary\"]")
    public WebElement loginButtonu;
    @FindBy (xpath = "//*[@id=\"dropdownMenuButton1\"]")
    public WebElement profildropdownMenuButton1;
    @FindBy(xpath = "(//a[@class=\"dropdown-item text-gray-900\"])[1]")
    public WebElement accountSettingsLinki;
    @FindBy (xpath = "//*[text()=\"Profile Details\"]")
    public WebElement profileDetailsLinki;


    /*
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/ramazanE56/Project_Team_08.git
git push -u origin main
     */
}
