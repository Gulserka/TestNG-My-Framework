package tests.us14;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.us14.US14_AllureLoginPages;
import pages.us14.US14_CategoriesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US14_Categories {

//    Vendor https://allure2you.com/ adresine gider
//    Vendor sign in butonuna tiklar
//    Vendor hesap bilgileriyle giriis yapar
//    My account butonuna tiklanir
//    Store Manager butonuna tiklanir
//    Product butonuna tiklanir
//    Add New butonuna tiklanir
//    Categories alani goruntulenir
//    Computer secenegi secilir
static US14_AllureLoginPages us14_allureLoginPages;
static US14_CategoriesPage us14_categoriesPage;

    @Test
    public static void Categories() {

        Driver.getDriver().get(ConfigReader.getProperty("allure_url"));
        us14_allureLoginPages = new US14_AllureLoginPages();
        us14_categoriesPage=new US14_CategoriesPage();
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
        actions.sendKeys(Keys.PAGE_DOWN,Keys.DOWN).perform();
        assert us14_categoriesPage.categoriesIsDisplayed.isDisplayed();
        System.out.println(us14_categoriesPage.categoriesIsDisplayed.getText());
        actions.moveToElement(us14_categoriesPage.categoriesIsDisplayed).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us14_categoriesPage.computers.click();


        Driver.closeDriver();

    }
    }

