package tests.cucumber.android.screens;

import base.BaseActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import org.openqa.selenium.By;
import org.testng.Assert;
import tests.cucumber.android.steps.Constants;

import java.io.IOException;

public class LoginScreen extends BaseActions {
    By email =     MobileBy.AccessibilityId("txtEmail");
    By password = MobileBy.AccessibilityId("txtPassword");
    By loginButton = MobileBy.AccessibilityId("lblbtnLogin");
    By okAlert = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
    //Invalid Email,Required
    //Password : Too Short! show popup : Login fehlgeschlagen Bitte überprüfen Sie Ihre Login-Daten 40301: Not handle yet
    String wrongEmailMessage = "//android.widget.TextView[contains(@text,'*****')]";
    By alert = MobileBy.id("android:id/alertTitle");

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }
    public void clickLogin() throws IOException {
        click(loginButton);
        int i = 0;
        while (i < 5 && !isElementPresent(okAlert)) {
            i++;
        }
        if (isElementPresent(okAlert)) {
            click(okAlert);
        }

        //sleep(5000);
    }

    public void inputPassword(String arg0) {
        sendText(password,arg0);
    }

    public void inputEmail(String arg0) {
        sendText(email,arg0);
    }

    public void verifyLoginFormShowed() {
        int i = 0;
        while (i < 5 && waitAndFindElements(email).size() <= 0) {
            i++;
        }
        Assert.assertTrue(isElementPresent(email));
    }

    public void verifyErrorMessageShowed(String arg0) {
        int i = 0;
        while (i < 5 && waitAndFindElements(By.xpath(wrongEmailMessage.replace(Constants.REPLACE_STRING,arg0))).size() <= 0) {
            i++;
        }
        Assert.assertTrue(isElementPresent(By.xpath(wrongEmailMessage.replace(Constants.REPLACE_STRING,arg0))));
    }

    public void verifyAlertErrorMessageShowed() {
        int i = 0;
        while (i < 5 && waitAndFindElements(alert).size() <= 0) {
            i++;
        }
        Assert.assertTrue(isElementPresent(alert));
    }
}
