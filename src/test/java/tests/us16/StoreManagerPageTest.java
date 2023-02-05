package tests.us16;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.us12.MyAccountPage;
import pages.us16.AddProductPage;
import pages.us16.StoreManagerPage;
import tests.us12.LoginPageTest;
import utilities.ReusableMethods;

public class StoreManagerPageTest {

    LoginPageTest loginPageTest;
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    AddProductPage addProductPage;


    @Test
    public void addNew() {
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
        storeManagerPage.productsButton.click();
        ReusableMethods.waitFor(2);
        storeManagerPage.addNewButton.click();



    }

    @Test
    public void simpleProductTest() {
       addProductPage = new AddProductPage();

        addNew();
        Assert.assertEquals("Simple Product",addProductPage.productTypeDropdown.getText());


//        myAccountPage = new MyAccountPage();
//        loginPageTest = new LoginPageTest();
//        storeManagerPage = new StoreManagerPage();
//        addProductPage = new AddProductPage();
//
//
//        loginPageTest.login();
//        myAccountPage.myAccountLink.click();
//        myAccountPage.storeManagerButton.click();
//        storeManagerPage.productsButton.click();
//        storeManagerPage.addNewButton.click();





    }

    @Test
    public void checkboxTest() {

//        myAccountPage = new MyAccountPage();
//        loginPageTest = new LoginPageTest();
//        storeManagerPage = new StoreManagerPage();
//        addProductPage = new AddProductPage();
//
//        loginPageTest.login();
//        myAccountPage.myAccountLink.click();
//        myAccountPage.storeManagerButton.click();
//        storeManagerPage.productsButton.click();
//        storeManagerPage.addNewButton.click();


        addNew();
        addProductPage.virtualCheckbox.click();
        Assert.assertTrue(addProductPage.virtualCheckbox.isSelected());
        addProductPage.downloadableCheckbox.click();
        Assert.assertTrue(addProductPage.downloadableCheckbox.isSelected());





    }
}
