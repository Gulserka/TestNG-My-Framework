package tests.us12;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.us12.BillingAddressPage;
import pages.us12.LoginPage;
import pages.us12.MyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoginPageTest {

    MyAccountPage myAccountPage;
    LoginPage loginPage;
    ReusableMethods reusableMethods;

    @Test
    public void login() {
        try {
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            myAccountPage = new MyAccountPage();
            loginPage = new LoginPage();
            loginPage.signInLink.click();
            loginPage.username.sendKeys(ConfigReader.getProperty("vendormail"));
            loginPage.password.sendKeys(ConfigReader.getProperty("vendorpassword"));
            loginPage.signInSubmit.click();

        }catch (Exception e){
            ReusableMethods.waitFor(2);
        }






    }
}
