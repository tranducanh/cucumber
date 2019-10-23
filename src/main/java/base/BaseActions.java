package base;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;


public class BaseActions {
    public AppiumDriver driver;
    public WebDriverWait wait;

    public BaseActions (AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }

    public void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void click (By by) {
        waitVisibility(by);
        driver.findElement(by).click();
    }

    public void hideKeyboard(){
        driver.navigate().back();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public List<WebElement> waitAndFindElements (By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitAndFindElement (By by) {
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    public void sendText (By by, String text) {
        AndroidElement e = (AndroidElement)waitAndFindElement(by);
        if(e!=null) {
            e.click();
            e.setValue(text);
            driver.hideKeyboard();
       }
    }

    public void sendText (WebElement e,String text) {
        if(e!=null) {
            e.clear();
            e.sendKeys(text);
            driver.hideKeyboard();
        }
    }

    public void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }

    public void waitVisibility (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void sleep (long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test(By by) {
        try {
            MobileElement element = (MobileElement)driver.findElement(by);
        } catch (NoSuchElementException e) {

        }
    }
     //Mobile
     //Tap to an element for 250 milliseconds
     public void tapByElement (MobileElement mobileElement) {
         new TouchAction(driver)
                 .tap(tapOptions().withElement(element(mobileElement)))
                 .waitAction(waitOptions(Duration.ofMillis(250))).perform();
     }

    //Tap by coordinates
    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }

    //Press by element
    public void pressByElement (MobileElement element, long seconds) {
        new TouchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Press by coordinates
    public void pressByCoordinates (int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x,y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Swipe by elements
    public void swipeByElements (WebElement startElement, WebElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(driver)
                .press(point(startX,startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }

    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(2000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    //Multitouch action by using an mobile element
    public void multiTouchByElement (MobileElement mobileElement) {
        TouchAction press = new TouchAction(driver)
                .press(element(mobileElement))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();

        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }

    protected int[] getColorElement(By by) throws IOException {
        WebElement el = waitAndFindElement(by);
        int[] rgb = new int[3];
        if (el != null) {
            org.openqa.selenium.Point point = el.getLocation();
            int centerX = point.getX();
            int centerY = point.getY();

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(scrFile);
            // Getting pixel color by position x and y
            int clr = image.getRGB(centerX, centerY);
            int red = (clr & 0x00ff0000) >> 16;
            int green = (clr & 0x0000ff00) >> 8;
            int blue = clr & 0x000000ff;
            rgb[0] = red;
            rgb[1] = green;
            rgb[2] = blue;

        }
        return rgb;
    }
}
