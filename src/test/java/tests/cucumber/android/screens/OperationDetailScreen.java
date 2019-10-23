package tests.cucumber.android.screens;

import base.BaseActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.cucumber.android.utils.*;
import tests.cucumber.app.dto.Article;
import tests.cucumber.app.dto.OrderedArticles;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import static tests.cucumber.android.steps.Constants.REPLACE_STRING;

public class OperationDetailScreen extends BaseActions {
    //Waiter Screen
    String mainFoodMenuXpath = "//android.widget.TextView[@text= '*****']";
    By itemsOfMainFood = By.xpath("(//android.widget.HorizontalScrollView)[1]//android.widget.TextView");
    By mainFood = By.xpath("(//android.widget.HorizontalScrollView)[1]");

    String mainFoodMenu = "(//android.widget.HorizontalScrollView)[1]//android.widget.TextView[@text = '*****']";
    String subFoodMenuXpath = "//android.widget.TextView[@text = '*****']";
    String itemMenuXpath = "//android.widget.TextView[@text = '*****' and contains(@content-desc,'lblmenu*****')]";
    String strArticleXpath = "//android.view.ViewGroup[contains(@content-desc,'menu*****')]";

    //Item ScrollView

    By itemOrdered = MobileBy.xpath("(//android.widget.ScrollView[@content-desc='flatListBookingList'])[1]//android.view.ViewGroup[contains(@content-desc,'orderListItem')]");
    By itemOrderedWithName = MobileBy.xpath("//android.widget.TextView[contains(@content-desc,'orderListItem') and contains(@content-desc,'Name')]");
    String _strItemOrderedWithName = "//android.widget.TextView[contains(@content-desc,'orderListItem') and contains(@content-desc,'Name') and  @text = '*****']";
    By itemOrderedWithPrice = MobileBy.xpath("//android.widget.TextView[contains(@content-desc,'orderListItem') and contains(@content-desc,'Price')]");
    By itemOrderedWithNote = MobileBy.xpath("//android.widget.TextView[contains(@content-desc,'orderListItem') and contains(@content-desc,'Note')]");
    String strItemOrderedWithNote = "(//android.widget.TextView[contains(@content-desc,'orderListItem') and contains(@content-desc,'Note')])";
    String strItemOrderedWithName = "//android.widget.TextView[contains(@content-desc,'orderListItem') and  @text = '*****']";
    By itemAdditionalOrderedWithName = By.xpath("//android.widget.ScrollView[@content-desc='flatListBookingList']//android.widget.TextView[contains(@content-desc, 'Name')]");
    String itemArticleSearch = "//android.widget.TextView[contains(@content-desc,'orderListItem') and @text = '*****']";
    //Popup Portion
    By popUpPortion = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");

    String popUpString = "//android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]";
    String textViewInPopup = popUpString + "//android.widget.TextView[@text = '*****']";
    String editTextInPopup = popUpString + "//android.widget.EditText";
    String textViewtoFindInPopup = popUpString + "//android.widget.TextView";
    //Additional Article on Popup
    String additionalArticle = "//android.view.ViewGroup[contains(@content-desc,'portion')]//android.widget.TextView[@text = '*****']";
    String addTextlArticle = "//android.view.ViewGroup[contains(@content-desc,'*****')]";
    By buttonPrice = By.xpath("//android.widget.TextView[@content-desc='txtTotal']");
    //Additional Article not Popup
    By okAdditionalButton = By.xpath("//android.view.ViewGroup[@content-desc='btnOK']");
    By okAdditionalLabel = By.xpath("//android.widget.TextView[@content-desc='lblbtnOK']");
    By cancelAdditionalButton = MobileBy.AccessibilityId("btnCancel");
    By txtAdditionalText = MobileBy.AccessibilityId("txtAdditionalText");
    By btnClear = MobileBy.AccessibilityId("btnClear");
    String itemAdditionalArticle = "//android.view.ViewGroup[contains(@content-desc,'*****')]";
    By splitBoard = By.xpath("(//android.widget.ScrollView[@content-desc='flatListBookingList'])[2]");
    By itemOfSplitBoard = MobileBy.xpath("(//android.widget.ScrollView[@content-desc='flatListBookingList'])[2]//android.view.ViewGroup[contains(@content-desc,'orderListItem')]");

    //total Of Operarion
    By totalOfOperation = MobileBy.xpath("//android.widget.TextView[@content-desc=\"lblOperationTotal\"]");

    String portionArticle = "//android.view.ViewGroup[@content-desc='portion*****']";
    //noted item
    String notedItem = "//android.widget.TextView[@content-desc='txtSuggest*****']";
    String nameVoucherItem = "//android.widget.TextView[@content-desc='voucher_*****']";

    //pop up Bar
    By popupBar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
    String strPopupBar =   "//android.view.ViewGroup[2]";
    //Menu to resolve order
    By yesButton = By.xpath("//android.view.ViewGroup[@content-desc=\"btnYes\"]");
    By noButton = MobileBy.AccessibilityId("lblbtnNo");
    By setLoss = By.xpath("//android.widget.TextView[@content-desc='lblbtnSetLoss']");
    By receipt = By.xpath("//android.widget.TextView[@content-desc='lblbtnReceipt']");
    By voucher = By.xpath("//android.widget.TextView[@content-desc='lblbtnVoucher']");
    By discount = By.xpath("//android.widget.TextView[@content-desc='lblbtnDiscount']");
    By setPrice = By.xpath("//android.widget.TextView[@content-desc='lblbtnSetPrice']");
    By splitting = By.xpath("//android.widget.TextView[@content-desc='lblbtnSplitting']");
    By resetDeposit = By.xpath("//android.widget.TextView[@content-desc='lblbtnResetDeposit']");
    By cancelBooking = By.xpath("//android.widget.TextView[@content-desc='lblbtnCancelBooking']");
    By discountTxt = By.xpath("//android.widget.EditText[@content-desc='txtDiscount']");

    public By balanceOfMain = By.xpath("(//android.widget.TextView[@content-desc='lblundefined'])[1]");
    public By balanceOfSplit = By.xpath("(//android.widget.TextView[@content-desc='lblundefined'])[2]");

    By main = By.xpath("(//android.widget.ScrollView[@content-desc='flatListBookingList'])[1]");
    By split = By.xpath("(//android.widget.ScrollView[@content-desc='flatListBookingList'])[2]");

    public OrderedArticles orderedArticles = new OrderedArticles();
    public Popup popup;


    public OperationDetailScreen(AppiumDriver driver) {
        super(driver);
        popup = new Popup(driver);
        popup.textViewOfPopup = By.xpath(textViewtoFindInPopup);
        popup.editViewOfPopup = By.xpath(editTextInPopup);
    }



    /*****Click on item *****/
    public void swipeAndClickOnMainFood(String mainFood) {
        waitAndClick(By.xpath(mainFoodMenuXpath.replace(REPLACE_STRING, mainFood)));
    }

    public void clickOnSubFood(String nameSubFood) {
        waitAndClick(By.xpath(subFoodMenuXpath.replace(REPLACE_STRING, nameSubFood)));
    }

    public void clickOnArticleWithPrice(String arg0, String arg1) {
        waitAndClick((By.xpath(itemMenuXpath.replace(REPLACE_STRING, arg0))));
    }

    public void clickOnArticleWithNameAndPrice(String name, String price) {

        try {
            MobileElement e = (MobileElement) waitAndFindElement(By.xpath(strArticleXpath.replace(REPLACE_STRING, name)));

            if (e != null) {
//                List<MobileElement> els = e.findElementsByClassName("android.widget.TextView");
//                if (els.size() == 0) throw new Exception("android.widget.TextView is not found");
//                else if (els.get(0).getText().equals(name) && els.get(1).getText().contains(price)) {
//                    e.click();
//                }
                e.click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void clickOnItemPopup(String value) {
        waitAndClick(By.xpath(textViewInPopup.replace(REPLACE_STRING, value)));
    }


    /**** Is Displayed the screen ****/
    public void isDisplayed() {
        int i = 0;
        while ((isElementPresent(resetDeposit) == false )&& i<5) {
            sleep(2000);
            i++;
        }
        Assert.assertEquals(isElementPresent(resetDeposit), true);
    }

    public void isDisPlayMainMenu(String mainMenu) {
        int i = 0;
        while (i < 10 && waitAndFindElements(By.xpath(mainFoodMenuXpath.replace(REPLACE_STRING,mainMenu))).size() <= 0) {
            i++;
        }
        Assert.assertEquals(isElementPresent(By.xpath(mainFoodMenuXpath.replace(REPLACE_STRING,mainMenu))), true);
    }

    public void IsPopupDisplayed() {
        waitVisibility(popUpPortion);
    }

    public void verifyThatTheButtonOKOfAdditionalDisable(String arg0) {
        WebElement el = waitAndFindElement(okAdditionalButton);
        Assert.assertEquals(el.getText(), arg0);
        Assert.assertEquals(el.isEnabled(), false);
    }

    public void verifyThatBalanceOnLabelIsEqual(By label,String total) {
        String text =  waitAndFindElement(label).getText();
        Assert.assertTrue(text.contains(total),"Balance is equal:"+total + "---:"+text);
    }

    public void verifyThatTheButtonOKOfAdditionalEnable(String arg0) {
        WebElement el = waitAndFindElement(okAdditionalLabel);
        Assert.assertEquals(el.getText(), arg0);
        Assert.assertEquals(el.isEnabled(), true);
    }

    public void verifyThatAdditionArticleJustAdded(String name) {
        List<WebElement> els = waitAndFindElements(itemOrderedWithName);
        this.assertEquals(els.get(1).getText(), name);

    }

    public void verifyThatASplitBoard() {
        int i =0;
        while (i<5 &&  isElementPresent(splitBoard) == false){
            i++;
        }
        Assert.assertEquals(isElementPresent(splitBoard),true);
    }

    public void verifyThatAdditionArticleJustAddedOnlyAdditionalText(String name) {
        List<WebElement> els = waitAndFindElements(itemOrderedWithName);
        this.assertEquals(els.get(0).getText(), name);

    }

    public void verifyThatAdditionArticleJustAddedHasA_AdditionalText(String name) {
        List<WebElement> els = waitAndFindElements(itemOrderedWithNote);
        this.assertEquals(els.get(0).getText(), name);

    }

    public void verifyThatAdditionArticleJustAddedHasNote(String name) {
        List<WebElement> els = waitAndFindElements(itemOrderedWithNote);
        this.assertEquals(els.get(1).getText(), name);

    }

    public void verifyThatAdditionArticleJustAddedAndDoesNotNote(int index) {
        Assert.assertEquals(isElementPresent(By.xpath(strItemOrderedWithNote+"["+index+"]")), false);
    }

    public void verifyThatArticleJustAdded(String name) {
        List<WebElement> els = waitAndFindElements(itemOrderedWithName);
        this.assertEquals(els.get(0).getText(), name);
    }

    public void verifyThatArticleIsNotAdded(String name) {
        Assert.assertEquals(isElementPresent(By.xpath(strItemOrderedWithName.replace(REPLACE_STRING, name))), false);
    }

    public void verifyThatNAdditionArticleJustAdded(String... args) {
        List<WebElement> els = waitAndFindElements(itemAdditionalOrderedWithName);
        for (int i = 0; i < args.length; i++) {
            assertEquals(els.get(i + 1).getText(), args[i]);
        }

    }

    public void verifySumOfArticlesIsAlwaysEqual(String nameLastArticel) {
        BigDecimal value = CaculdateUtils.getValueDoubleWebElement(waitAndFindElement(totalOfOperation));
        Assert.assertEquals(Double.parseDouble(value.toString()), Double.parseDouble(getTotalOfPrices(nameLastArticel).toString()));
    }

    private void calculateItems(List<WebElement> els) {
        for (int i = 0; i < els.size(); i++) {
                List<WebElement> names = els.get(i).findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'Name')]"));
                List<WebElement> prices = els.get(i).findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'Price')]"));
                List<WebElement> quantities = els.get(i).findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'Quantity')]"));
                BigDecimal price = BigDecimal.valueOf(0);
                BigDecimal quantity = BigDecimal.valueOf(0);
                for (int j = 0; j < names.size(); j++) {
                    quantity = BigDecimal.valueOf(Double.parseDouble(quantities.get(j).getText()));
                    price = CaculdateUtils.getValueDoubleWebElement(prices.get(j));
                    orderedArticles.setArticles(new Article(names.get(j).getAttribute("content-desc"), names.get(j).getText(), quantity, price));
                }
        }

    }

    private void addItemToCount(List<WebElement> els) {
        for (int i = 0; i < els.size(); i++) {
            List<WebElement> names = els.get(i).findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'Name')]"));
            for (int j = 0; j < names.size(); j++) {
                orderedArticles.setArticles(new Article(names.get(j).getAttribute("content-desc"), names.get(j).getText(), BigDecimal.ZERO, BigDecimal.ZERO));
            }
        }
    }

    //Only for items is not adjust the prices
    private BigDecimal getTotalOfPrices(String nameOfArticleToFind) {
        BigDecimal sum = BigDecimal.ZERO;
        List<WebElement> els = waitAndFindElements(itemOrdered);
        boolean isFound = isElementPresent(By.xpath(itemArticleSearch.replace(REPLACE_STRING, nameOfArticleToFind)));
        while (isFound == false) {
            calculateItems(els);
            swipeByElements(els.get(els.size() - 1), els.get(0));
            isFound = isElementPresent(By.xpath(itemArticleSearch.replace(REPLACE_STRING, nameOfArticleToFind)));
        }
        els = waitAndFindElements(itemOrdered);
        calculateItems(els);
        sum = orderedArticles.sumOfOrder();
        return sum;
    }

    public boolean bringToViewVertical(WebElement parent, WebElement child){
        int startPY = parent.getLocation().getY() ;
        int pH = parent.getSize().getHeight();

        int startCY = child.getLocation().getY() ;

        if (startPY <=startCY   && startCY <= startPY + pH ) {
            return true;
        }
        return false;

    }

    public boolean bringToViewHorizontal(WebElement parent, WebElement child){

        try {
            int startPX = parent.getLocation().getX();
            int pW = parent.getSize().getWidth();

            int startCX = child.getLocation().getX();

            if (startPX <= startCX && startCX <= startPX + pW) {
                return true;
            }
            return false;
        }catch (Exception e ){
            return false;
        }

    }

    private void scrollByCondition(int tryTimes,boolean condition,By item,VerticalScroll verticalScroll){
        int i =0;
        List<WebElement> els = waitAndFindElements(item);
        while (i <tryTimes && condition) {
            switch (verticalScroll) {
                case UP:
                    swipeByElements(els.get(els.size() / 2), els.get(0));
                break;
                case DOWN:
                    swipeByElements(els.get(0), els.get(els.size() / 2));
                break;

            }
            els = waitAndFindElements(item);
            i++;
        }
    }

    private void swipeAndClickOnItemOrdered(String name,int tryTimes) {
        By item = MobileBy.xpath(_strItemOrderedWithName.replace(REPLACE_STRING,name));
        scrollByCondition(tryTimes, !isElementPresent(item),itemOrdered,VerticalScroll.UP) ;
        scrollByCondition(tryTimes, !bringToViewVertical(waitAndFindElement(main),waitAndFindElement(item)),itemOrdered,VerticalScroll.UP) ;

        if (bringToViewVertical(waitAndFindElement(main),waitAndFindElement(item))) {
            click(item);
            return;
        }
        scrollByCondition(tryTimes, !isElementPresent(item),itemOrdered,VerticalScroll.DOWN) ;
        scrollByCondition(tryTimes, !bringToViewVertical(waitAndFindElement(main),waitAndFindElement(item)),itemOrdered,VerticalScroll.DOWN) ;
        if (bringToViewVertical(waitAndFindElement(main),waitAndFindElement(item))) {
            click(item);
            return;
        }
    }

    public void loopAllOrderedArticles(int lenOfItems,int itemsInAPart){
        int i = 0;
        while (i<5 && waitAndFindElements(itemOrdered).size()<0){
            i++;
        }
        i = 0;
        List<WebElement> els = waitAndFindElements(itemOrdered);
        boolean isFound = els.get(els.size()-1).isDisplayed();
        while (i<(lenOfItems/itemsInAPart+1)){
            int j =0;
            while (j<5 && !isElementPresent(By.xpath("(//android.widget.ScrollView[@content-desc='flatListBookingList'])[1]//android.widget.TextView[contains(@content-desc,'Name')]")))
            {
                j++;
            }
            calculateItems(els);
            swipeByElements(els.get(els.size() - 2), els.get(0));
            els = waitAndFindElements(itemOrdered);
            i++;
        }
        calculateItems(els);
    }


    public void fillWeight(int arg0) {
        WebElement el = this.popup.getEditView(0);
        sendText(el, arg0 + "");
    }

    public void fillWeightWith(String value) {
        WebElement el = this.popup.getEditView(0);
        sendText(el, value);
    }

    public void fillDiscount(String arg0) {
        sendText(discountTxt, arg0);
    }

    public void fillPrice(String arg0) {
        WebElement el = this.popup.getEditView(0);
        sendText(el, arg0 + "");
    }

    public void chooseAdditionalArticle(String arg0) {
        waitAndClick(By.xpath(additionalArticle.replace(REPLACE_STRING, arg0)));
    }

    public void selectItem(String notedString) {
        this.waitAndClick(By.xpath(notedItem.replace(REPLACE_STRING, notedString)));
    }

    public void clickOnMenuHeader(int index){
        By menu = By.xpath("(//android.view.ViewGroup[3]/android.view.ViewGroup)["+index+"]");
        waitAndClick(menu);
    }

    public void clickOnMenuHeaderWithName(int index,String name){
        int i =0;
        clickOnMenuHeader(index);

        By menu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]");
        while(i<5 && waitAndFindElements(menu).size()<0){
            i++;
        }
        MobileElement mBy = (MobileElement) waitAndFindElement(menu);

        List<MobileElement> els = mBy.findElements(By.xpath("//android.widget.TextView"));
        for (WebElement e : els){
            if (e.getText().equalsIgnoreCase(name)){
                e.click();
                return;
            }
        }
    }

    public void clickOnOKOrCancelPopup(String arg0) {
        if (arg0.equals("OK") &&  waitAndFindElements(okAdditionalButton).size() > 0)
            waitAndClick(okAdditionalButton);
        else if (arg0.equals("CANCEL") &&  waitAndFindElements(cancelAdditionalButton).size() > 0)
            waitAndClick(cancelAdditionalButton);

    }

    public void clickOnCancelPopup(String arg0) {
        if (waitAndFindElements(cancelAdditionalButton).size() > 0)
            waitAndClick(cancelAdditionalButton);
    }

    public void clickOnPortion(String portionType) {
        By portion = By.xpath(portionArticle.replace(REPLACE_STRING, portionType));
        List<WebElement> els = waitAndFindElements(portion);
        if (els.size() > 0)
            waitAndClick(portion);

    }

    public void clickOnPriceButton(String arg0) {
        waitAndClick(buttonPrice);
    }


    public void clickOKAdditionalButton(String arg0) {
        if (waitAndFindElement(okAdditionalLabel).getText().contains(arg0)) {
            waitAndClick(okAdditionalButton);
        }
    }

    public void clickOnAdditionalArticle(String arg0, String arg1) {
        By by = By.xpath(itemAdditionalArticle.replace(REPLACE_STRING, arg0));
        waitAndClick(by);

    }


    public void thePopUpWithTitleIsDisplay(String title) {
        By by = By.xpath("//android.widget.TextView[@text='"+title+"']");
        int i = 0;
        while(i<5 && isElementPresent(by) == false) {
            i++;
        }
        Assert.assertEquals(isElementPresent(by),true);
    }

    public void theBarPopUpWithTitleIsDisplay(String title) {
        By by = By.xpath("//android.widget.TextView[@text='"+title+"']");
        int i = 0;
        while(i<5 && isElementPresent(by) == false) {
            i++;
        }
        Assert.assertEquals(waitAndFindElement(by).getText(),title);
    }

    public void clickToBack() {
        ((AppiumDriver) driver).navigate().back();
    }

    public void verifyTotalOnTabIsEqualToTalOnHeader(String arg0) {
        int i = 0;
        while (i < 10 && waitAndFindElements(totalOfOperation).size() <= 0) {
            i++;
        }
        WebElement el = waitAndFindElement(totalOfOperation);
        Assert.assertEquals(el.getText(), arg0);
    }

    public void clickOnCancelOrOkPopupIfShow(TypeChoose type,String data) {
        //if (popup.getTextViewByText(data) !=null) {
            clickOnOKOrCancelPopup(type.toString());
        //}
    }

    public void popupWithTitleIsShow(String title) {
        int i =0;
        while(i<5 && waitAndFindElements(By.xpath(textViewInPopup.replace(REPLACE_STRING, title))).size()<0){
            i++;
        }
        Assert.assertEquals(isElementPresent(By.xpath(textViewInPopup.replace(REPLACE_STRING, title))), true);
    }

    public void popupWithTitleIsNotShow(String title) {
        Assert.assertEquals(isElementPresent(By.xpath(textViewInPopup.replace(REPLACE_STRING, title))), false);
    }

    public void verifyThatTheDateAppearedOnPopup(int years, String s) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 0 - years);
        String strDate = DateUtils.convertDateToStringByFormat(cal.getTime(),s);

        Assert.assertEquals(waitAndFindElement(By.xpath("//android.view.ViewGroup[2]//android.widget.TextView[3]")).getText(), strDate);
    }

    public void verifyThatDataFilledOnEditor(String arg0) {
        MobileElement e = (MobileElement) waitAndFindElement(txtAdditionalText);
        assertEquals(arg0, e.getText());
    }

    public void verifyThatDataFilledOnEditorIsErased(String arg0) {
        MobileElement e = (MobileElement) waitAndFindElement(txtAdditionalText);
        Assert.assertNotEquals(arg0, e.getText());
    }

    public void clickOnEraseOnPopup() {
        waitAndClick(btnClear);
    }

    public void verifyThatNArticleAdded(int arg0) {
        Assert.assertEquals(countItemInListView(3), arg0);
    }

    public String getTotalOnPopup() {
        return waitAndFindElement(By.xpath("//android.widget.TextView[@content-desc='txtTotal']")).getText();
    }

    public void chooseAddTextArticle(String arg0) {
        waitAndClick(By.xpath(addTextlArticle.replace(REPLACE_STRING, arg0)));
    }

    public int countItemInListView(int tryTimes){
        int i =0;

        while (i<tryTimes ) {
            if(isElementPresent(itemOrdered) == true) {
                List<WebElement> els = waitAndFindElements(itemOrdered);
                addItemToCount(els);
                swipeByElements(els.get(els.size() - 1), els.get(0));
            }
            i++;
        }
        return orderedArticles.articles.size();
    }

    public WebElement getIndexByTextOnPopupBar(String text){
        int i =0;
        while(i<5 && isElementPresent(popupBar) == false){
            i++;
        }
        List<WebElement> els = waitAndFindElement(popupBar).findElements( By.className("android.widget.TextView"));
        for (WebElement e : els){
            if (e.getText().equalsIgnoreCase(text)){
                return e;
            }
        }
        return null;
    }

    public void verifyThatPopupBarIsAppeared() {
        int i = 0;
        while (i<5 && isElementPresent(popupBar) == false){
            i++;
        }
        Assert.assertEquals(true,isElementPresent(popupBar));
    }

    public WebElement getItemByNameAtIndex(int index) {
        int i =0;
        while(i<5 && isElementPresent(itemOrderedWithName) == false){
            i++;
        }
        List<WebElement> els = waitAndFindElements(itemOrderedWithName);
        if (els.size()>0){
            return  els.get(index-1);
        }
        return null;
    }

    public WebElement getItemByPriceAtIndex(int index) {
        int i =0;
        while(i<5 && isElementPresent(itemOrderedWithPrice) == false){
            i++;
        }
        List<WebElement> els = waitAndFindElements(itemOrderedWithPrice);
        if (els.size()>0){
            return  els.get(index);
        }
        return null;
    }

    public void clickOnSetLoss() {
        click(setLoss);
    }

    public void clickOnReceipt() {
        click(receipt);
    }

    public void clickYesButton() {
        int i =0;
        while (i<5 &&  isElementPresent(yesButton) == false){
            i++;
        }
        waitAndClick(yesButton);
    }

    public void clickNoButton() {
        int i =0;
        while (i<5 &&  isElementPresent(noButton) == false){
            i++;
        }
        waitAndClick(noButton);
    }

    public void clickOnVoucher() {
        click(voucher);
    }

    public void clickOnSplitting() {
        click(splitting);
    }

    public void setDiscountAtItemWithPercentage(int index, String percentage) {
       getItemByNameAtIndex(index).click();
       click(discount);
       fillDiscount(StringUtils.strip(percentage,"%"));
       clickOnOKOrCancelPopup("OK");
    }

    public void setPriceAtItem(int index, String price) {
        getItemByNameAtIndex(index).click();
        click(setPrice);
        fillPrice(price);
        clickOnOKOrCancelPopup("OK");
    }

    public void setDiscountForAOperation(int index, String percentage) {
        clickOnMenuHeaderWithName(1,"Operation discount (%)");
        fillDiscount(StringUtils.strip(percentage,"%"));
        clickOnOKOrCancelPopup("OK");
    }

    public void verifySumOrArticelIsEqual(String sum) {
       Assert.assertEquals(CaculdateUtils.getValueDoubleFromString(sum).toString(),CaculdateUtils.getValueDoubleWebElement(waitAndFindElement(totalOfOperation)).toString());
    }

    public void setCancelAtItem(int index) {
        getItemByNameAtIndex(index).click();
        click(cancelBooking);
    }

    public void clickResetDeposit() {
        click(resetDeposit);
    }

    public void selectVoucher(String nameVoucher) {
        this.waitAndClick(By.xpath(nameVoucherItem.replace(REPLACE_STRING, nameVoucher)));
    }


    public void chooseAtIndexWithName(String name, int index,int items) {
        swipeAndClickOnItemOrdered(name,3);

    }



    public void splitBoardContainsItems(int numberOfItems) {

        int i =0;
        while (i<10 && isElementPresent(itemOfSplitBoard) == false){
            i++;
        }

        List<WebElement>  els = waitAndFindElement(splitBoard).findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'orderListItem')]"));
        Assert.assertEquals(els.size()/2,numberOfItems);
    }

    public void chooseItemOnMainBoardWithName(String name) {
        swipeAndClickOnItemOrdered(name,5);
    }

    public void chooseMainFoodWithName(String name){
        swipeAndClickOnMainFoodTemp(name,5);
    }

    private void swipeAndClickOnMainFoodTemp(String name, int tryTimes) {
        int i =0;
        By item = MobileBy.xpath(mainFoodMenu.replace(REPLACE_STRING,name));
        while(i<5 && !isElementPresent(itemsOfMainFood)){
            i++;
        }
        i =0;
        List<WebElement> els = waitAndFindElements(itemsOfMainFood);


        while (i <tryTimes && !isElementPresent(item) ){
            swipeByElements(els.get(i+1), els.get(0));
            els = waitAndFindElements(itemsOfMainFood);
            i++;
        }
        i =0;
        while (i <tryTimes && !bringToViewHorizontal(waitAndFindElement(mainFood),waitAndFindElement(item)) ){
            swipeByElements(els.get(i+1), els.get(0));
            els = waitAndFindElements(itemsOfMainFood);
            i++;
        }
        if (bringToViewHorizontal(waitAndFindElement(mainFood),waitAndFindElement(item))) {
            click(item);
            return;
        }

    }

}
