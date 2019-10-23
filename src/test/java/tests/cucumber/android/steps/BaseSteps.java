package tests.cucumber.android.steps;

import base.AndroidThreadLocalDriver;
import base.configuration.AndroidConfiguration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSteps {
    protected WebDriverWait wait;
    protected void setupCucumber () {
        wait = new WebDriverWait(AndroidThreadLocalDriver.getTLDriver(), 10);
        AndroidThreadLocalDriver.getTLDriver().launchApp();
    }

    public void setupDriver(String deviceName,String platformVersion) throws MalformedURLException {
        if (AndroidThreadLocalDriver.getTLDriver()!=null){
            System.out.println("Driver is not null");
            wait = new WebDriverWait(AndroidThreadLocalDriver.getTLDriver(), 10);
        }
        else {
            System.out.println("Driver is null");
            AndroidThreadLocalDriver androidThreadLocalDriver = new AndroidThreadLocalDriver(new AndroidConfiguration(
                    new DesiredCapabilities(), deviceName, platformVersion, "Android", "com.app",
                    "com.app.MainActivity", "http://127.0.0.1:4723/wd/hub")
            );
            DesiredCapabilities caps = ((AndroidConfiguration) androidThreadLocalDriver.getBaseConfiguration()).getDesiredCapabilities();

            AndroidThreadLocalDriver.setTLDriver(new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps));
            wait = new WebDriverWait(AndroidThreadLocalDriver.getTLDriver(), 20);
        }
    }
    public BaseSteps(){

    }

}
