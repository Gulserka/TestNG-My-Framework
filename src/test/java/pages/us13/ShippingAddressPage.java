package pages.us13;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShippingAddressPage {

    public ShippingAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@href='https://allure2you.com/my-account-2/edit-address/shipping/']")
    public WebElement shippingAddressAddButton;
    @FindBy(id = "shipping_first_name")
    public WebElement firstName;

    @FindBy(id = "shipping_last_name")
    public WebElement lastName;

    @FindBy(id = "shipping_company")
    public WebElement companyName;

    @FindBy(id = "select2-shipping_country-container")
    public WebElement countryRegion;

    @FindBy(xpath = "//*[@class='select2-search__field']")
    public WebElement dropdown;

    @FindBy(id = "shipping_address_1")
    public WebElement streetAddress;

    @FindBy(id = "shipping_address_2")
    public WebElement apartmentSuiteUnitEtc;

    @FindBy(id = "shipping_city")
    public WebElement townCity;

    @FindBy(id = "shipping_postcode")
    public WebElement post_Zip_Code;

    @FindBy(id = "select2-shipping_state-container")
    public WebElement state;


    @FindBy(id = "select2-shipping_state-container")
    public WebElement province;

    @FindBy(xpath = "//*[@class='select2-search__field']")
    public WebElement province2;
    @FindBy(name = "save_address")
    public WebElement saveAddressButton;





}
