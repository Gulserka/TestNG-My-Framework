package pages.us16;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddProductPage {
    public AddProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "product_type")
    public WebElement productTypeDropdown;

    @FindBy(id = "is_virtual")
    public WebElement virtualCheckbox;


    @FindBy(id = "is_downloadable")
    public WebElement downloadableCheckbox;

    @FindBy(id = "pro_title")
    public WebElement productTitle;


    @FindBy(id = "regular_price")
    public WebElement price;


    @FindBy(id = "sale_price")
    public WebElement salePrice;


    @FindBy(name = "submit-data")
    public WebElement submitButton;
}


