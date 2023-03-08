package tests.us16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.us12.MyAccountPage;
import pages.us16.AddProductPage;
import pages.us16.StoreManagerPage;
import tests.us12.LoginPageTest;
import tests.us14.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
public class StoreManagerPageTest {

    LoginPageTest loginPageTest;
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    AddProductPage addProductPage;

    public static WebDriver driver;
    Actions actions;
    Select select;
    @Test
    public void productsButton() {
        actions = new Actions(Driver.getDriver());
        myAccountPage = new MyAccountPage();
        loginPageTest = new LoginPageTest();
        storeManagerPage = new StoreManagerPage();
        addProductPage = new AddProductPage();

        loginPageTest.login();
        ReusableMethods.waitFor(2);
        myAccountPage.myAccountLink.click();
        myAccountPage.storeManagerButton.click();
        ReusableMethods.waitFor(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        storeManagerPage.productsButton.click();
    }

    @Test
    public void addNew() {
        productsButton();
        ReusableMethods.waitFor(2);
        storeManagerPage.addNewButton.click();

    }

    @Test
    public void simpleProductTest() throws IOException {
        addProductPage = new AddProductPage();
        addNew();
        select = new Select(addProductPage.productTypeDropdown);
        String defaultOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(defaultOption, "Simple Product");
        ReusableMethods.waitFor(3);
        System.out.println(defaultOption);
    }

    @Test
    public void checkboxTest() throws IOException {

        addNew();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        //ReusableMethods.scrollDownActions();
        addProductPage.virtualCheckbox.click();
        Assert.assertTrue(addProductPage.virtualCheckbox.isSelected());
        addProductPage.downloadableCheckbox.click();
        Assert.assertTrue(addProductPage.downloadableCheckbox.isSelected());
        ReusableMethods.waitFor(3);

    }

    @Test
    public void priceTest() throws IOException {
        addProductPage = new AddProductPage();
        addNew();
        addProductPage.price.sendKeys(ConfigReader.getProperty("price"));
        ReusableMethods.waitFor(3);
    }

    @Test
    public void salePriceTest() throws IOException {
        addProductPage = new AddProductPage();
        addNew();
        addProductPage.salePrice.sendKeys(ConfigReader.getProperty("salePrice"));
        ReusableMethods.waitFor(3);
    }



    @Test
    public void addProductTest() throws IOException {

        productsButton();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerPage.addProductArea.isDisplayed());
        ReusableMethods.waitFor(3);

        //eklendikten sonraki tarihi al getir, sonra pcdeki tarihe esitle eger dogruysa pass olsun


    }


}
