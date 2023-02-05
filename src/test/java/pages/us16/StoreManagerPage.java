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

}
