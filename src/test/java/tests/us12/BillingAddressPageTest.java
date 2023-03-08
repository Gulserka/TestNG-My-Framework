package tests.us12;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.us12.BillingAddressPage;
import pages.us12.HomePage;
import pages.us12.MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillingAddressPageTest {

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

        // ReusableMethods.scrollIntoViewJS(billingAddressPage.billingAddressAddButton);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        billingAddressPage.billingAddressAddButton.click();
    }

    @DataProvider
    public Object[][] billingAddressKayitBilgileri() {
        Object[][] bilgiler = {
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35140", "5555555555"}, //POSITIVE
                {"", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35140", "5555555555"}, //NEGATIVE
                {"Gulser", "", "Techpro", "Poligon", "Park", "Izmir", "35140", "5555555555"},
                {"Gulser", "Kayacan", "", "Poligon", "Park", "Izmir", "35140", "5555555555"},
                {"Gulser", "Kayacan", "Techpro", "", "Park", "Izmir", "35140", "5555555555"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "", "Izmir", "35140", "5555555555"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "", "35140", "5555555555"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "", "5555555555"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35140", ""},
        };
        return bilgiler;
    }

    @Test(dataProvider = "billingAddressKayitBilgileri")

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
        billingAddressPage.dropdown.sendKeys("Turkey", Keys.ENTER);

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
        billingAddressPage.province2.sendKeys("Adana", Keys.ENTER);

        ReusableMethods.waitFor(3);

        billingAddressPage.saveAddressButton.click();
        ReusableMethods.waitFor(4);
        Assert.assertTrue(myAccountPage.alert.isDisplayed());
        ReusableMethods.takeScreenshotOfElement(myAccountPage.alert);
        Driver.closeDriver();
//        homePage.signOut.click();
//        homePage.logOut.click();


    }



    @DataProvider
    public Object[][] kayitBilgileri2() {
        Object[][] bilgiler = {
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35000", "5555555555","lasean.eddrick@foundtoo.com"},
                {"Gulser", "Kayacan", "Techpro", "Poligon", "Park", "Izmir", "35000", "5555555555",""},

        };
        return bilgiler;
    }
    @Test(dataProvider = "kayitBilgileri2")

    public void emailTest(String firstName, String lastName, String companyName, String streetAddress,
                          String apartmentSuiteUnitEtc, String townCity, String post_Zip_Code, String phone, String email) throws IOException {

        loginPageTest = new LoginPageTest();
        billingAddressPage = new BillingAddressPage();
        myAccountPage = new MyAccountPage();
        actions = new Actions(Driver.getDriver());


        billingAddressTest();

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
        billingAddressPage.dropdown.sendKeys("Turkey", Keys.ENTER);


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
        billingAddressPage.province2.sendKeys("Adana", Keys.ENTER);
        ReusableMethods.waitFor(3);

//        String emailAttributeValue = billingAddressPage.email.getAttribute("placeholder");
//        System.out.println(emailAttributeValue);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String text = js.executeScript("return document.getElementById('billing_email').value").toString();
        //String text = js.executeScript("return document.getElementById('" + billingAddressPage.email + "').value").toString(); //getValueByJS methodu
        System.out.println("Kutudaki value: " + text);

        billingAddressPage.email.clear();
        billingAddressPage.email.sendKeys(email);
        billingAddressPage.saveAddressButton.click();
        ReusableMethods.waitFor(4);
        Assert.assertTrue(myAccountPage.alert.isDisplayed());
        ReusableMethods.takeScreenshotOfElement(myAccountPage.alert);









    }

}
