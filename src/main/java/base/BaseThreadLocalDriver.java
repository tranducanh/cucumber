package base;

import base.configuration.BaseConfiguration;
import io.appium.java_client.AppiumDriver;

public class BaseThreadLocalDriver {

    private BaseConfiguration baseConfiguration;
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public synchronized static void setTLDriver(AppiumDriver driver) {
        BaseThreadLocalDriver.driver.set(driver);
    }

    public synchronized static AppiumDriver getTLDriver() {
        return driver.get();
    }

    public BaseThreadLocalDriver( BaseConfiguration baseConfiguration) {
        this.baseConfiguration = baseConfiguration;
    }

    public BaseConfiguration getBaseConfiguration() {
        return baseConfiguration;
    }




}
