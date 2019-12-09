package tests.cucumber.android.screens;

import base.BaseActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class NextLoginScreen extends BaseActions {
    By inputNextPassword = By.className("android.widget.EditText");
    By btnLogin = MobileBy.AccessibilityId("lblbtnLogin");
    By chkRemember = MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"chkRemember\"]/android.widget.TextView[1]");
    By signOut = MobileBy.AccessibilityId("btnSignOut");
    By btnClickUserName = By.xpath("//android.widget.TextView[@content-desc='btnEnter']");
    By ddlPrinter = By.xpath("//android.view.ViewGroup[@content-desc='ddlWorkStation']");
    By okAlert = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");

    public NextLoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public void isDisplayed() {
        int i = 0;
        while (i < 15 && !isElementPresent(okAlert)) {
            i++;
        }
        if (isElementPresent(okAlert)) {
            click(okAlert);
        }
        Assert.assertEquals(isElementPresent(okAlert), false);

//        int i = 0;
//        System.out.println(isElementPresent(ddlPrinter)+"---");
//        while (i < 15 && !isElementPresent(ddlPrinter) ) {
//            i++;
//            System.out.println(isElementPresent(ddlPrinter)+"---"+i);
//        }
//        click(chkRemember);
//        Assert.assertEquals(isElementPresent(ddlPrinter),true);
    }

    public void clickLogin() {
        click(btnLogin);
    }

    public void selectPrinterNameBy(String nameWorkStation) {
        By item = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
        By item1 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");

        waitAndClick(ddlPrinter);
        List<WebElement> els = waitAndFindElement(item1).findElements(By.xpath("//android.widget.TextView[@text='" + nameWorkStation + "']"));
        tapByCoordinatesElement(els.get(0));
    }

    private void tapByCoordinatesElement(WebElement e) {
        tapByCoordinates(e.getLocation().getX() + e.getSize().getWidth() / 2,
                e.getLocation().getY() + e.getSize().getHeight() / 2);
        tapByCoordinates(e.getLocation().getX() + e.getSize().getWidth() / 2,
                e.getLocation().getY() + e.getSize().getHeight() / 2);
    }


    public void inputNextPassword(String arg0) {
        int i = 0;
        while (i < 5 && !isElementPresent(ddlPrinter)) {
            i++;
        }
        if (isElementPresent(inputNextPassword)) {
            sendText(inputNextPassword, arg0);
        }
    }

    public void setRemember(boolean b) {
        WebElement e = driver.findElement(chkRemember);
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
