package tests.cucumber.android.utils;

import base.BaseActions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static tests.cucumber.android.steps.Constants.REPLACE_STRING;

public class Popup extends BaseActions {
    public By textViewOfPopup;
    public By editViewOfPopup;
    public String titlePopup = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[@text='*****']";
    public Popup(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getTextViewByText(String text){
        List<WebElement> els =  waitAndFindElements(By.xpath("//android.widget.TextView"));
        if (els.size()>0) {

            for (int i = 0; i < els.size(); i++) {
                if (els.get(i).getText().equals(text)) {
                    return els.get(i);
                }
            }
        }
        return null;
    }

    public boolean isShowPopupWithTitle(String data) {
        int i =0;
        while (i<2 && !isElementPresent(By.xpath(titlePopup.replace(REPLACE_STRING,data)))){
            i++;
        }
        return isElementPresent(By.xpath(titlePopup.replace(REPLACE_STRING,data)));
    }


    public WebElement getEditView(int index){
        List<WebElement> els =  waitAndFindElements(editViewOfPopup);
        if (els.size()>0){
            return els.get(index);
        }
        return null;
    }


}
