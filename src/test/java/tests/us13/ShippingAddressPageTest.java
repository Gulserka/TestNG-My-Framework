package tests.us13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.us12.HomePage;
import pages.us12.MyAccountPage;
import pages.us13.ShippingAddressPage;
import tests.us12.LoginPageTest;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class ShippingAddressPageTest {

    MyAccountPage myAccountPage;
    ShippingAddressPage shippingAddressPage;
    LoginPageTest loginPageTest;
    HomePage homePage;
    protected static WebDriver driver;
    Actions actions;

    @Test
    public void shippingAddressTest() {
        loginPageTest = new LoginPageTest();
        shippingAddressPage = new ShippingAddressPage();
        myAccountPage = new MyAccountPage();

        loginPageTest.login();
        ReusableMethods.waitFor(2);
        myAccountPage.myAccountLink.click();
        ReusableMethods.waitFor(2);
        myAccountPage.addressButton.click();
        ReusableMethods.waitFor(2);
        actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        shippingAddressPage.shippingAddressAddButton.click();

    }


    @DataProvider
    public Object[][] shippingAddressKayitBilgileri() {
        Object[][] bilgiler = {
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35140"}, //POSITIVE
                {"", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35140"}, //NEGATIVE
                {"Gulser", "", "Techpro", "Poligon", "Park", "Izmir", "35140"},
                {"Gulser", "Kayacan", "", "Poligon", "Park", "Izmir", "35140"},
                {"Gulser", "Kayacan", "Techpro", "", "Park", "Izmir", "35140"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "", "Izmir", "35140"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "", "35140"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", ""},

        };
        return bilgiler;
    }


    @Test(dataProvider = "shippingAddressKayitBilgileri")

    public void dataProviderSearch(String firstName, String lastName, String companyName, String streetAddress,
                                   String apartmentSuiteUnitEtc, String townCity, String post_Zip_Code) throws IOException {

        shippingAddressPage = new ShippingAddressPage();
        loginPageTest = new LoginPageTest();
        myAccountPage = new MyAccountPage();
        homePage = new HomePage();

        shippingAddressTest();

        shippingAddressPage.firstName.clear();
        shippingAddressPage.firstName.sendKeys(firstName);
        ReusableMethods.waitFor(1);
        shippingAddressPage.lastName.clear();
        shippingAddressPage.lastName.sendKeys(lastName);
        ReusableMethods.waitFor(1);
        shippingAddressPage.companyName.clear();
        shippingAddressPage.companyName.sendKeys(companyName);
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);


        shippingAddressPage.countryRegion.click(); //ilk basta isaretlenmemis halini dusunerek negatif testini yapmaliyim. Bunu hala yapmadım.
        shippingAddressPage.dropdown.click();
        shippingAddressPage.dropdown.sendKeys("Turkey", Keys.ENTER);


        // billingAddressPage.countryRegion.sendKeys(countryRegion, Keys.ENTER);
        ReusableMethods.waitFor(1);
        shippingAddressPage.streetAddress.clear();
        shippingAddressPage.streetAddress.sendKeys(streetAddress);
        ReusableMethods.waitFor(1);
        shippingAddressPage.apartmentSuiteUnitEtc.clear();
        shippingAddressPage.apartmentSuiteUnitEtc.sendKeys(apartmentSuiteUnitEtc);
        ReusableMethods.waitFor(1);
        shippingAddressPage.townCity.clear();
        shippingAddressPage.townCity.sendKeys(townCity);
        ReusableMethods.waitFor(1);
        shippingAddressPage.post_Zip_Code.clear();
        // billingAddressPage.state.sendKeys(state, Keys.ENTER);
        shippingAddressPage.post_Zip_Code.sendKeys(post_Zip_Code);

        ReusableMethods.waitFor(2);
        // billingAddressPage.province.sendKeys(province);
        shippingAddressPage.province.click();
        shippingAddressPage.province2.click();
        shippingAddressPage.province2.sendKeys("Adana", Keys.ENTER);

        ReusableMethods.waitFor(3);

        shippingAddressPage.saveAddressButton.click();
        ReusableMethods.waitFor(4);
        Assert.assertTrue(myAccountPage.alert.isDisplayed());
        ReusableMethods.takeScreenshotOfElement(myAccountPage.alert);
        //ReusableMethods.takeScreenShotOfPage();
        homePage.signOut.click();
        homePage.logOut.click();


    }
}