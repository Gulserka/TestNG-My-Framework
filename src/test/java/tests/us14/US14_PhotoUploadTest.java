package tests.us14;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.us14.US14_AllureLoginPages;
import pages.us14.US14_PhotoUploadPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

/*
Vendor https://allure2you.com/ adresine gider
Vendor sign in butonuna tiklar
Vendor hesap bilgileriyle giriis yapar
My account butonuna tiklanir
Store Manager butonuna tiklanir
Product butonuna tiklanir
Add New butonuna tiklanir
resim ekleme alani tiklanir
select files butonuna tiklanir
dosya yolu eklenir
select butonuna tiklanir
Fotografin yuklendigi dogrulanir
 */
public class US14_PhotoUploadTest {
    static US14_AllureLoginPages us14_allureLoginPages;
    static US14_PhotoUploadPage us14_photoUploadPage;

    @Test
    public static void testPhotoUpload() {
        Driver.getDriver().get(ConfigReader.getProperty("allure_url"));
        us14_allureLoginPages = new US14_AllureLoginPages();
        us14_photoUploadPage=new US14_PhotoUploadPage();
        us14_allureLoginPages.signInButton.click();
        us14_allureLoginPages.userName.sendKeys(ConfigReader.getProperty("vendormail"));
        us14_allureLoginPages.password.sendKeys(ConfigReader.getProperty("vendorpassword"));
        us14_allureLoginPages.OK.click();
        ReusableMethods.waitFor(3);
        us14_allureLoginPages.myAccount.click();
        us14_allureLoginPages.storeManagerLink.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us14_allureLoginPages.productButton.click();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        us14_allureLoginPages.addNewButton.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        us14_photoUploadPage.photoClick.click();
        ReusableMethods.waitFor(3);
        //"C:\Users\Asus\OneDrive\Masaüstü\logo.jpeg"
        assert us14_photoUploadPage.selectFiles.isDisplayed();
        String userHome=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\logo.jpeg";
        ReusableMethods.waitFor(4);

        us14_photoUploadPage.selectFiles.sendKeys(userHome);

//        us14_photoUploadPage.mediaLibrary.click();
//        us14_photoUploadPage.mediaLibrary1.click();
//        us14_photoUploadPage.selectButton.click();
//
//        us14_photoUploadPage.photoclick2.click();



        us14_photoUploadPage.logo.click();
        us14_photoUploadPage.addToGallery.click();




        ReusableMethods.waitFor(6);

        //test passed oluyor ancak resim yuklenmiyor





        //SELECT FILE MANUEL BAKINCA GORUNUYOR ANCAK OTOMASYONDA NOSUCHELEMENTEXCEPTION ALINIYOR!!!


    }
}