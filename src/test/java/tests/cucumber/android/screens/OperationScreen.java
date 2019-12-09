package tests.cucumber.android.screens;

import base.BaseActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static tests.cucumber.android.steps.Constants.REPLACE_STRING;

public class OperationScreen extends BaseActions {

    public static String totalPrice = "";
    //Logout
     By iconProfile = MobileBy.AccessibilityId("btnMenuProfile");
     By logOutButton = MobileBy.AccessibilityId("btnLogout");
    //Operation Screen
     By btnAddOperation = MobileBy.AccessibilityId("btnAddOperation");

    //Add Operation pop up
    By operationName =  MobileBy.AccessibilityId("txtOperationName");
    By cancelButtonOperationPopupXpath = MobileBy.AccessibilityId("btnCancel");
    By okButtonOperationPopup = MobileBy.AccessibilityId("btnOK");
    String textOnTabOperationXpath = "//android.view.ViewGroup[@content-desc='*****']";
    String tabOperation = "//android.widget.TextView[@content-desc='lblOperationName*****']";
    String strOperations = "//android.widget.TextView[contains(@content-desc,'lblOperationName') and contains(@text,'*****')]";
    //More action
    public String moreAction = "(//android.view.ViewGroup[contains(@content-desc,'*****')]/android.view.ViewGroup[2])[1]";
    String moreActionExactlyName = "(//android.view.ViewGroup[contains(@content-desc,'*****')]/android.view.ViewGroup[2])[1]";
    String menuAction = "//android.view.ViewGroup[contains(@content-desc,'btnOperation')]";
    //Menu item
    String menuContext = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]";
    By btnSearch = By.xpath("//android.view.ViewGroup[@content-desc='btnSearch']");
    By btnRefresh = By.xpath("//android.view.ViewGroup[@content-desc='btnRefresh']");
    By txtSearch = By.xpath("//android.widget.EditText[@content-desc='txtSearchMenuItems']");
    By progressBar = By.xpath("//android.widget.ProgressBar");
    public String operationNameStr = "";


    public OperationScreen(AppiumDriver driver) {
        super(driver);
    }

    public void isDisplayed() {
        int i = 0;
        while (i < 5 && waitAndFindElements(btnAddOperation).size() <= 0) {
            i++;
        }
        Assert.assertTrue(isElementPresent(btnAddOperation));
    }

    public void clickOnSearch() {
        waitAndClick(btnSearch);
    }

    public void clickOnRefresh() {
        waitAndClick(btnRefresh);
    }

    public void fillSearch(String operationName) {
        WebElement el = waitAndFindElement(txtSearch);
        sendText(el, operationName);
        sleep(1000);
    }


    public void clickPlusButton() {
        int i =0;
        while (i<5 && !isElementPresent(okButtonOperationPopup)) {
            sleep(1000);
            i++;
        }
        MobileElement el = (MobileElement) waitAndFindElement(btnAddOperation);
        tapByElement(el);
    }

    public void clickOkButtonOfPopup() {
        waitAndClick(okButtonOperationPopup);
    }

    public void verifyOperationIsGenerated(String text) {
        waitVisibility(MobileBy.AccessibilityId(tabOperation.replace("*****",text)));
    }

    public void clickOnTabWithValue(String arg0) {
       // click(By.xpath(textOnTabOperationXpath.replace("*****",arg0)));
        swipeToFindTab(arg0,20);
    }

    public void swipeToFindTab(String arg0,int tryTimes) {
        String tab = textOnTabOperationXpath.replace("*****",arg0);
        Boolean isFound = driver.findElements(By.xpath(tab)).size()>0;
        int i =0;
        while(isFound == false && i <tryTimes ){
            horizontalSwipeByPercentage(0.9,0.4,0.9);
            isFound = driver.findElements(By.xpath(tab)).size()>0;
            i++;
        }
        if (isFound){
            click(By.xpath(tab));
            return;
        }
    }

    public void barAOperation(String nameOperation,String nameMenu){
        clickOnMenuItemByExactlyName(nameOperation,nameMenu);

    }

    public void logOut() {
        click(iconProfile);
        waitAndClick(logOutButton);
    }

    public void clickCancelButtonOnPopup() {
        waitAndClick(cancelButtonOperationPopupXpath);
    }

    public void verifyThatNotOperationIsCreated(String arg0) {
        boolean isShow = isElementPresent(MobileBy.AccessibilityId(tabOperation.replace("*****",arg0)));
        Assert.assertEquals(isShow,false);
    }

    public void verifyThatNumberOfOperationIsEqual(String searchKey, int num) {
        List<WebElement> els = waitAndFindElements(By.xpath(strOperations.replace(REPLACE_STRING, searchKey)));
        Assert.assertEquals(els.size(), num);
    }

    public void getPriceOnTab(String arg0) {
        By el = By.xpath("//android.widget.TextView[@content-desc='lblOperationPrice"+arg0+"']");
        totalPrice = waitAndFindElement(el).getText();
    }

    public void clickOnMenuItemByName(String operation,String name){
        int i =0;
        while (i<10 && this.isElementPresent(By.xpath(moreAction.replace(REPLACE_STRING,operation))) ==false){
           i++;
        }
        waitAndClick(By.xpath(moreAction.replace(REPLACE_STRING,operation)));
        List<WebElement> els = waitAndFindElements(By.xpath(menuContext+"//android.widget.TextView"));

        for (WebElement e: els){
            if (e.getText().equalsIgnoreCase(name)){
                e.click();
                return;
            }
        }
    }

    public void clickOnMenuItemByExactlyName(String nameOperation, String nameMenu) {
        int i =0;
        By by = By.xpath(moreActionExactlyName.replace(REPLACE_STRING,nameOperation));
        while (i<10 && this.isElementPresent(by) ==false){
            i++;
        }
        waitAndClick(by);
        List<WebElement> els = waitAndFindElements(By.xpath(menuContext+"//android.widget.TextView"));

        for (WebElement e: els){
            if (e.getText().equalsIgnoreCase(nameMenu)){
                e.click();
                return;
            }
        }
    }

    public void fillOperationName(String arg0) {
        int i = 0;
        boolean isFound = isElementPresent(operationName);
        while (i < 5 && !isFound) {
            isFound = isElementPresent(operationName);
            i++;
        }
        if (isFound)
            sendText(operationName, arg0);
    }

    public WebElement getTabOperationByName(String name) {
        WebElement e = waitAndFindElement(By.xpath(tabOperation.replace(REPLACE_STRING, name)));
        return e;
    }

    public void progressBarIsHidden() {
        while (isElementPresent(progressBar)) {

        }
    }
}
