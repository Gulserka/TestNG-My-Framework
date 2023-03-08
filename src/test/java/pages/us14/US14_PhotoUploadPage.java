package pages.us14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_PhotoUploadPage {
    public US14_PhotoUploadPage() { PageFactory.initElements(Driver.getDriver(), this);}
@FindBy(id = "featured_img_display")
public WebElement photoClick;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElement selectFiles;

    @FindBy(id = "menu-item-browse")
    public WebElement mediaLibrary;


    @FindBy(xpath = "//*[@class='thumbnail']")
    public WebElement mediaLibrary1;

    @FindBy(xpath = "//*[text()='Select']")
    public WebElement selectButton;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement photoclick2;


    @FindBy(xpath = "(//*[@data-id='16212'])[2]")
    public WebElement logo;


    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGallery;
}




