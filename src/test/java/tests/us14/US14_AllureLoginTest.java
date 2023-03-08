package tests.us14;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.us14.US14_AllureLoginPages;
import pages.us14.US14_DropdownMenu;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;


public class US14_AllureLoginTest {

    US14_AllureLoginPages us14_allureLoginPages;
    US14_DropdownMenu us14_dropdownMenu;

    @BeforeTest
    public void ayniadimlar() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));

        Driver.getDriver().get(ConfigReader.getProperty("allure_url"));
        us14_allureLoginPages = new US14_AllureLoginPages();
        us14_dropdownMenu = new US14_DropdownMenu();
        us14_allureLoginPages.signInButton.click();
        us14_allureLoginPages.userName.sendKeys(ConfigReader.getProperty("allure_user_mail"));
        us14_allureLoginPages.password.sendKeys(ConfigReader.getProperty("allure_user_password"));
        us14_allureLoginPages.OK.click();
        ReusableMethods.waitFor(3);
        us14_allureLoginPages.myAccount.click();
        us14_allureLoginPages.storeManagerLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us14_allureLoginPages.productButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us14_allureLoginPages.addNewButton.click();
    }


    @Test
    public void simpleProduct(){

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        assert us14_dropdownMenu.ddmMenu.isDisplayed();
        Select select = new Select(us14_dropdownMenu.ddmMenu);
        select.selectByVisibleText("Simple Product");
        String sectigimOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(sectigimOption, "Simple Product");
        System.out.println(sectigimOption);


    }

    @Test
    public void variableProduct(){

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        assert us14_dropdownMenu.ddmMenu.isDisplayed();
        Select select = new Select(us14_dropdownMenu.ddmMenu);
        select.selectByVisibleText("Variable Product");
        String sectigimOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(sectigimOption, "Variable Product");
        System.out.println(sectigimOption);


    }

    @Test
    public void groupedProduct(){

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        assert us14_dropdownMenu.ddmMenu.isDisplayed();
        Select select = new Select(us14_dropdownMenu.ddmMenu);
        select.selectByVisibleText("Grouped Product");
        String sectigimOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(sectigimOption, "Grouped Product");
        System.out.println(sectigimOption);
    }

    @Test
    public void externalAffiliateProduct()  {

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        assert us14_dropdownMenu.ddmMenu.isDisplayed();
        Select select = new Select(us14_dropdownMenu.ddmMenu);
        select.selectByVisibleText("External/Affiliate Product");
        String sectigimOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(sectigimOption, "External/Affiliate Product");
        System.out.println(sectigimOption);
    }
}