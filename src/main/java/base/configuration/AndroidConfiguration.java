package base.configuration;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidConfiguration extends BaseConfiguration {
    private String deviceName;
    private String udid;
    private String platformName;
    private String platformVersion;
    private boolean skipUnlock;
    private String appPackage;
    private String appActivity;
    private String app;

    private DesiredCapabilities desiredCapabilities;

    public AndroidConfiguration(DesiredCapabilities desiredCapabilities,String deviceName,String platformVersion,String platformName,String app,String remoteURL){
        this.desiredCapabilities = desiredCapabilities;
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.app = app;
        this.remoteAddress = remoteURL;
        this.desiredCapabilities.setCapability("deviceName",deviceName);
        this.desiredCapabilities.setCapability("deviceName",deviceName);
        this.desiredCapabilities.setCapability("platformVersion",platformVersion);
        this.desiredCapabilities.setCapability("app",app);
        this.desiredCapabilities.setCapability("noReset","false");
//        this.desiredCapabilities.setCapability("fullReset", false);
//        this.desiredCapabilities.setCapability("noReset", true);
    }

    public AndroidConfiguration(DesiredCapabilities desiredCapabilities,String deviceName,String platformVersion,String platformName,String appPackage,String appActivity,String remoteURL){
        this.desiredCapabilities = desiredCapabilities;
        this.deviceName = deviceName;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.remoteAddress = remoteURL;
        this.desiredCapabilities.setCapability("deviceName",deviceName);
        this.desiredCapabilities.setCapability("platformName",platformName);
        this.desiredCapabilities.setCapability("platformVersion",platformVersion);
        this.desiredCapabilities.setCapability("appPackage",appPackage);
        this.desiredCapabilities.setCapability("appActivity",appActivity);
        this.desiredCapabilities.setCapability("noReset",false);
//        this.desiredCapabilities.setCapability("ignoreUnimportantViews","true");
//        this.desiredCapabilities.setCapability("disableAndroidWatchers","true");
//        this.desiredCapabilities.setCapability("resetKeyboard", true);
//        this.desiredCapabilities.setCapability("unicodeKeyboard", true);
    }


    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.desiredCapabilities.setCapability("udid",udid);
        this.udid = udid;
    }

    public boolean isSkipUnlock() {
        return skipUnlock;
    }

    public void setSkipUnlock(boolean skipUnlock) {
        this.skipUnlock = skipUnlock;
        this.desiredCapabilities.setCapability("skipUnlock",skipUnlock);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public void setDesiredCapabilities(DesiredCapabilities desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;

    }
}
