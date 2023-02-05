package pages.us12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement myAccountLink;

    @FindBy(xpath = "(//*[@class='icon-box text-center'])[3]")
    public WebElement addressButton;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerButton;



//    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
//    public WebElement alert;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement alert;

    //*[@role='alert']


}
