package tests.cucumber.android.screens;

import base.BaseActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class NextLoginScreen extends BaseActions {
    By inputNextPassword = By.className("android.widget.EditText");
    By btnLogin = MobileBy.AccessibilityId("lblbtnLogin");
    By chkRemember = MobileBy.AccessibilityId("chkRemember");
    By signOut = MobileBy.AccessibilityId("btnSignOut");
    By btnClickUserName = By.xpath("//android.widget.TextView[@content-desc='btnEnter']");

    public NextLoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public void isDisplayed() {
        int i = 0;
        while (i < 5 && waitAndFindElements(chkRemember).size() <= 0 && waitAndFindElements(inputNextPassword).size() <= 0) {
            i++;
        }
        Assert.assertTrue(isElementPresent(chkRemember));
    }

    public void clickLogin() {
        click(btnLogin);
    }

    public void inputNextPassword(String arg0) {
        sendText(inputNextPassword,arg0);
    }

    public void setRemember(boolean b) {
        WebElement  e = driver.findElement(chkRemember);
        e.click();
        e.click();
    }

    public void verifyTheTheScreenRemember() {
        int i = 0;
        while (i < 5 && waitAndFindElements(btnClickUserName).size() <= 0) {
            i++;
        }
        Assert.assertTrue(isElementPresent(btnClickUserName));
    }

    public void clickHereToEnterUsername() {
        click(btnClickUserName);
    }

    public void closeApp() {
        //driver.closeApp();
        driver.resetApp();

    }
}
