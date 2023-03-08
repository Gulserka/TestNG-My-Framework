package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners implements ITestListener
{
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context)
    {
        String dosyaKayitYeri = "ExtentReoprtsHtmlDosyaları";
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = "test-output/" + dosyaKayitYeri + "/" + date + "html_report.html";
        System.out.println("onStart-Tum testlerden once bir kere cagrilir: " + context.getName());
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(path);
        extentReports.setSystemInfo("Test Environment", "Smoke/Regression");
        extentReports.setSystemInfo("Application", "TechProEducation");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Takim", "TestNg19");
        extentReports.setSystemInfo("Sprint Numarasi", "TestNg-19");
        extentHtmlReporter.config().setDocumentTitle("TestNg19-Extent Reports");
        extentHtmlReporter.config().setReportName("Regression/Smoke Test Sonucu");
        extentReports.attachReporter(extentHtmlReporter);
        //Beforesuit gibi çalıştığı için tüm testlerden önce raporumun şablonunu oluşturdum
    }

    @Override
    public void onFinish(ITestContext context)
    {
        System.out.println("onFinish-Tum testlerden sonra tek bir kere cagrilir : " + context.getName());
        extentTest.info("testler bitti");//Aftersuit gibi çalışır.Tüm testlerden sonra çalışır.
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("onTestStart-Her bir @Testden once tek bir kez cagrilir : " + result.getName());
        ReusableMethods.waitFor(2);//benim bilgisayar yavaş olduğu için ekledim.
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("onTestSuccess-Sadece PASS olan testerden SONRA tek bir kez cagrilir : " + result.getName());
        extentTest = extentReports.createTest(result.getName());
        extentTest.pass("TEST GEÇTİ-" + result.getName());
        Driver.closeDriver();
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("onTestFailure-Sadece FAIL olan testlerden SONRA tek bir kez cagrilir : " + result.getName());
        extentTest = extentReports.createTest(result.getName());
        extentTest.fail("TEST KALDI-"+result.getName());
        extentTest.fail(result.getThrowable());//html raporumuza fail aldığımız yerde neden olan exceptionu ekler
        try
        {
            ReusableMethods.waitFor(1);
            ReusableMethods.getScreenshot("FAIL-" + result.getName());
            //Screen packetine fail olan sayfanın resmini tarih/saat/saniye/testismi uzantısıyla ekler
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Driver.closeDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("onTestSkipped-Sadece SKIP(atlanan) testlerden SONRA tek bir kez cagrilir : " + result.getName());
        extentTest = extentReports.createTest(result.getName());
        extentTest.skip("TEST ATLADI");
    }

}