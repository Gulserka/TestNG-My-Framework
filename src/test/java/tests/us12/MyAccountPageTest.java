package tests.us12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.us12.BillingAddressPage;
import pages.us12.HomePage;
import pages.us12.MyAccountPage;
import tests.us12.LoginPageTest;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.security.Key;

public class MyAccountPageTest {

    MyAccountPage myAccountPage;
    BillingAddressPage billingAddressPage;
    LoginPageTest loginPageTest;
    HomePage homePage;
    protected static WebDriver driver;
    Actions actions;

    @Test
    public void billingAddressTest() {

        loginPageTest = new LoginPageTest();
        billingAddressPage = new BillingAddressPage();
        myAccountPage = new MyAccountPage();

        loginPageTest.login();
        ReusableMethods.waitFor(2);
        myAccountPage.myAccountLink.click();
        ReusableMethods.waitFor(1);
        myAccountPage.addressButton.click();
        ReusableMethods.waitFor(2);
        actions = new Actions(Driver.getDriver());

     ReusableMethods.scrollIntoViewJS(billingAddressPage.billingAddressAddButton);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        billingAddressPage.billingAddressAddButton.click();
    }

    @DataProvider
    public Object[][] kayitBilgileri() {
        Object[][] bilgiler = {
                {"aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "35000", "5555555555"},
                {"", "bbb", "ccc", "aaa", "bbb", "ccc", "35000", "5555555555"},
//                {"aaa", "", "ccc", "aaa", "bbb", "ccc", "35000", "5555555555"},
//                {"aaa", "bbb", "", "aaa", "bbb", "ccc", "35000", "5555555555"},
//                {"aaa", "bbb", "ccc", "", "bbb", "ccc", "35000", "5555555555"},
//                {"aaa", "bbb", "ccc", "aaa", "", "ccc", "35000", "5555555555"},
//                {"aaa", "bbb", "ccc", "aaa", "bbb", "", "35000", "5555555555"},
//                {"aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "", "35000", "5555555555"},
//                {"aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "", "5555555555"},
//                {"aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "35000", ""},
        };
        return bilgiler;
    }

    @Test(dataProvider = "kayitBilgileri")

    public void dataProviderSearch(String firstName, String lastName, String companyName, String streetAddress,
                                   String apartmentSuiteUnitEtc, String townCity, String post_Zip_Code, String phone) throws IOException {

        billingAddressPage = new BillingAddressPage();
        loginPageTest = new LoginPageTest();
        myAccountPage = new MyAccountPage();
        homePage = new HomePage();

        loginPageTest.login();
        ReusableMethods.waitFor(2);

        myAccountPage.myAccountLink.click();
        ReusableMethods.waitFor(2);

        myAccountPage.addressButton.click();
        ReusableMethods.waitFor(2);

        actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        billingAddressPage.billingAddressAddButton.click();
        ReusableMethods.waitFor(1);

        billingAddressPage.firstName.clear();
        billingAddressPage.firstName.sendKeys(firstName);
        ReusableMethods.waitFor(1);
        billingAddressPage.lastName.clear();
        billingAddressPage.lastName.sendKeys(lastName);
        ReusableMethods.waitFor(1);
        billingAddressPage.companyName.clear();
        billingAddressPage.companyName.sendKeys(companyName);
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);


        billingAddressPage.countryRegion.click();
        billingAddressPage.dropdown.click();
        billingAddressPage.dropdown.sendKeys("Turkey",Keys.ENTER);



       // billingAddressPage.countryRegion.sendKeys(countryRegion, Keys.ENTER);
        ReusableMethods.waitFor(1);
        billingAddressPage.streetAddress.clear();
        billingAddressPage.streetAddress.sendKeys(streetAddress);
        ReusableMethods.waitFor(1);
        billingAddressPage.apartmentSuiteUnitEtc.clear();
        billingAddressPage.apartmentSuiteUnitEtc.sendKeys(apartmentSuiteUnitEtc);
        ReusableMethods.waitFor(1);
        billingAddressPage.townCity.clear();
        billingAddressPage.townCity.sendKeys(townCity);
        ReusableMethods.waitFor(1);
        billingAddressPage.post_Zip_Code.clear();
        // billingAddressPage.state.sendKeys(state, Keys.ENTER);
        billingAddressPage.post_Zip_Code.sendKeys(post_Zip_Code);
        ReusableMethods.waitFor(1);
        billingAddressPage.phone.clear();
        billingAddressPage.phone.sendKeys(phone);
        ReusableMethods.waitFor(1);
       // billingAddressPage.province.sendKeys(province);
        billingAddressPage.province.click();
        billingAddressPage.province2.click();
        billingAddressPage.province2.sendKeys("Adana",Keys.ENTER);

        ReusableMethods.waitFor(3);

        billingAddressPage.saveAddressButton.click();
        ReusableMethods.waitFor(4);
        Assert.assertTrue(myAccountPage.alert.isDisplayed());
        ReusableMethods.takeScreenshotOfElement(myAccountPage.alert);
        //ReusableMethods.takeScreenShotOfPage();
        homePage.signOut.click();
        homePage.logOut.click();


    }

    @Test
    public void emailAreaIsEmpty() {

        billingAddressTest();







    }
}
