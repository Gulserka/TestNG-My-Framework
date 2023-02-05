package tests.us16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.us12.MyAccountPage;
import pages.us16.AddProductPage;
import pages.us16.StoreManagerPage;
import tests.us12.LoginPageTest;
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

    @Test
    public void addNew() {
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

        //pagedown yapilmali
        //actions.scrollToElement(storeManagerPage.productsButton).click().perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        storeManagerPage.productsButton.click();
        ReusableMethods.waitFor(2);
        storeManagerPage.addNewButton.click();

    }

    @Test
    public void simpleProductTest() {
        addProductPage = new AddProductPage();
        addNew();
        Assert.assertTrue(addProductPage.productTypeDropdown.getText().contains("Simple Product"));

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
        ReusableMethods.takeScreenshotOfElement(storeManagerPage.pageScreenShotLocate);

    }
}
