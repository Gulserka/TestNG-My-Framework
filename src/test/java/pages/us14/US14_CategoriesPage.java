package pages.us14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_CategoriesPage {
    public US14_CategoriesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
@FindBy(xpath = "//*[@id='product_cats_checklist']")
    public WebElement categoriesIsDisplayed;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/div[3]/ul/li[9]/input")
    public WebElement computers;
}
