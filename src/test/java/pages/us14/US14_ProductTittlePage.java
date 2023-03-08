package pages.us14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_ProductTittlePage {
    public US14_ProductTittlePage() {PageFactory.initElements(Driver.getDriver(), this);}
@FindBy(id = "pro_title")
    public WebElement productTitle;

    @FindBy(xpath = "//*[@data-id='excerpt']")
    public WebElement shortDescription;

@FindBy(xpath = "//*[@data-id='description']")
    public WebElement description;

    }

