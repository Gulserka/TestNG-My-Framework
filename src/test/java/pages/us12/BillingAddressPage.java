package pages.us12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BillingAddressPage {

    public BillingAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@class='select2-search__field']")
    public WebElement dropdown;

    @FindBy(xpath = "//a[@href='https://allure2you.com/my-account-2/edit-address/billing/']")
    public WebElement billingAddressAddButton;

    @FindBy(id = "billing_first_name")
    public WebElement firstName;

    @FindBy(id = "billing_last_name")
    public WebElement lastName;

    @FindBy(id = "billing_company")
    public WebElement companyName;

    @FindBy(id = "select2-billing_country-container")
    public WebElement countryRegion;

    @FindBy(id = "billing_address_1")
    public WebElement streetAddress;

    @FindBy(id = "billing_address_2")
    public WebElement apartmentSuiteUnitEtc;

    @FindBy(id = "billing_city")
    public WebElement townCity;

    @FindBy(id = "billing_postcode")
    public WebElement post_Zip_Code;

    @FindBy(id = "billing_phone")
    public WebElement phone;

    @FindBy(id = "select2-billing_state-container")
    public WebElement state;

    @FindBy(id = "billing_email")
    public WebElement email;

    @FindBy(xpath = "//*[.='Save address']")
    public WebElement saveAddressButton;

    @FindBy(id = "select2-billing_state-container")
    public WebElement province;

    @FindBy(className = "select2-search__field")
    public WebElement province2;


}
