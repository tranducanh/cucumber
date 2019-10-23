package tests.cucumber.android.tests;

import base.AndroidThreadLocalDriver;
import base.configuration.AndroidConfiguration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import tests.cucumber.android.listener.TestListener;

import java.io.IOException;
import java.net.URL;
public class AndroidBaseTest {
    public WebDriverWait wait;

    @BeforeMethod(alwaysRun=true)
    @Parameters({"deviceName", "platformVersion"})
    public void setup (String deviceName, String platformVersion) throws IOException {

        //Unlock the device if it is locked.
        final Runtime rt = Runtime.getRuntime();
        rt.exec("adb shell input keyevent 224");


        AndroidThreadLocalDriver androidThreadLocalDriver = new AndroidThreadLocalDriver(new AndroidConfiguration(
                new DesiredCapabilities(), deviceName, platformVersion, "Android", "com.app",
                "com.app.MainActivity", "http://127.0.0.1:4723/wd/hub")
        );
        DesiredCapabilities caps = ((AndroidConfiguration) androidThreadLocalDriver.getBaseConfiguration()).getDesiredCapabilities();

        AndroidThreadLocalDriver.setTLDriver(new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps));
        wait = new WebDriverWait(AndroidThreadLocalDriver.getTLDriver(), 20);
    }

    @AfterMethod(alwaysRun=true)
    public synchronized void teardown(){
        System.out.println("AfterMethod: ");
        AndroidThreadLocalDriver.getTLDriver().quit();
    }

    @AfterTest(alwaysRun=true)
    public void afterTest(ITestContext iTestContext) throws Exception {
        System.out.println("AfterTest: ");
    }

    @AfterSuite(alwaysRun=true)
    @Parameters({"generateReport"})
    public void tearDown(ITestContext iTestContext, @Optional String generateReport) throws Exception{
        System.out.println("AfterSuite: ");
    }

}
