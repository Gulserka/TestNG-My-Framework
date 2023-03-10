package pages.us16;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreManagerPage {

    public StoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='https://allure2you.com/store-manager/products/']")
    public WebElement productsButton;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;


    @FindBy(id = "wcfm_products_manage_form_general_expander")
    public WebElement pageScreenShotLocate;


    @FindBy(xpath = "//*[@class='wcfm_product_title']")
    public WebElement addProductArea;

}
