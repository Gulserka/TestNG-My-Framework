package pages.us14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_DropdownMenu {
    public US14_DropdownMenu() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "product_type")
    public WebElement ddmMenu;


}
