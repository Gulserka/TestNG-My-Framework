package tests.us14;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.us14.US14_AllureLoginPages;
import pages.us14.US14_ProductTittlePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US14_DescriptionTest {
    static US14_AllureLoginPages us14_allureLoginPages;
    static US14_ProductTittlePage us14_productTittlePage;
    @Test
    public static void descriptionTest() {

//    Vendor https://allure2you.com/ adresine gider
//    Vendor sign in butonuna tiklar
//    Vendor hesap bilgileriyle giriis yapar
//    My account butonuna tiklanir
//    Store Manager butonuna tiklanir
//    Product butonuna tiklanir
//    Add New butonuna tiklanir
//    Description alanina bilgi girilir
        Driver.getDriver().get(ConfigReader.getProperty("allure_url"));
        us14_allureLoginPages = new US14_AllureLoginPages();
        us14_productTittlePage = new US14_ProductTittlePage();
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Driver.getDriver().switchTo().frame(us14_productTittlePage.description);
        Driver.getDriver().switchTo().frame(1);
        assert us14_productTittlePage.description.isDisplayed();
        us14_productTittlePage.description.sendKeys("Laptop", Keys.ENTER);
        Assert.assertEquals(us14_productTittlePage.description.getText(), "Laptop");


    }
}
