package pages.us14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_AllureLoginPages {


    public US14_AllureLoginPages() {PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement OK;

    @FindBy(id = "menu-item-1074")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement productButton;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement addNewButton;


}


