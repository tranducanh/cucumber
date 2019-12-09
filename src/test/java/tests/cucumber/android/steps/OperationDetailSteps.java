package tests.cucumber.android.steps;

import base.AndroidThreadLocalDriver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.cucumber.android.screens.LoginScreen;
import tests.cucumber.android.screens.NextLoginScreen;
import tests.cucumber.android.screens.OperationDetailScreen;
import tests.cucumber.android.screens.OperationScreen;
import tests.cucumber.android.utils.TypeChoose;
import tests.cucumber.app.dto.Article;
import tests.cucumber.app.dto.OrderedArticles;

import java.util.List;

import static tests.cucumber.android.steps.Constants.EURO;

public class OperationDetailSteps extends BaseSteps {

    public LoginScreen loginScreen;
    public NextLoginScreen nextLoginScreen;
    public OperationScreen operationScreen;
    public OperationDetailScreen operationDetailScreen;
    public static OrderedArticles orderedArticles;

    public OperationDetailSteps(){
        loginScreen = new LoginScreen(AndroidThreadLocalDriver.getTLDriver());
        nextLoginScreen = new NextLoginScreen(AndroidThreadLocalDriver.getTLDriver());
        operationScreen = new OperationScreen(AndroidThreadLocalDriver.getTLDriver());
        operationDetailScreen = new OperationDetailScreen(AndroidThreadLocalDriver.getTLDriver());

    }

    @Given("^I am in operation detail screen$")
    public void iAmInOperationDetailScreen() {
        operationDetailScreen.isDisplayed();
    }

    @When("^I navigated to \"([^\"]*)\" main group and \"([^\"]*)\" sub-group$")
    public void iNavigatedToMainGroupAndSubGroup(String main, String sub) throws Throwable {

        operationDetailScreen.clickMainMenu(main);
       operationDetailScreen.clickOnSubFood(sub);
    }

    @And("^I click on \"([^\"]*)\" article with price \"([^\"]*)\" €$")
    public void iClickOnArticleWithPrice€(String arg0, String arg1) throws Throwable {
         operationDetailScreen.clickOnArticleWithNameAndPrice(arg0,arg1);
    }


    @Then("^total amount of Operation added the same amount of latest booking$")
    public void totalAmountOfOperationAddedTheSameAmountOfLatestBooking() {
        //TODO will come back
        operationDetailScreen.verifySumOfArticlesIsAlwaysEqual("Age Portion");
    }


    @Then("^a pop-up to choose the portion for the article appear \\(Small: (\\d+)€, Normal: (\\d+)€, Large: (\\d+)€\\)$")
    public void aPopUpToChooseThePortionForTheArticleAppearSmall€Normal€Large€(int arg0, int arg1, int arg2) {
        operationDetailScreen.IsPopupDisplayed();
    }

    @And("^I select \"([^\"]*)\" portion$")
    public void iSelectPortion(String arg0) throws Throwable {
        operationDetailScreen.clickOnItemPopup(arg0);
    }

    @And("^click \"([^\"]*)\" button$")
    public void clickButton(String arg0) throws Throwable {
        operationDetailScreen.clickOnOKOrCancelPopup(arg0);
    }

    @Then("^A pop-up to fill weight of article appear with info \"([^\"]*)\"$")
    public void aPopUpToFillWeightOfArticleAppearWithInfo(String arg0) throws Throwable {
        //TODO Will com back why it null

        //operationDetailScreen.popup.getTextViewByText(arg0).isDisplayed();
    }

    @And("^I fill weight as (\\d+)$")
    public void iFillWeightAs(int arg0) {
        operationDetailScreen.fillWeight(arg0);
    }

    @And("^I fill weight as \"([^\"]*)\"$")
    public void iFillWeightAs(String arg0) {
        operationDetailScreen.fillWeightWith(arg0);
    }

    @Then("^price calculated as \"([^\"]*)\"$")
    public void priceCalculatedAs(String price) throws Throwable {
        String text = operationDetailScreen.getTotalOnPopup();
        operationDetailScreen.assertEquals(StringUtils.strip(text,EURO),StringUtils.strip(price,EURO));
    }


    @And("^I choose additional article \"([^\"]*)\"$")
    public void iChooseAdditionalArticle(String arg0) throws Throwable {
        operationDetailScreen.chooseAdditionalArticle(arg0);
    }

    @Then("^a pop-up to choose/fill additional text appear$")
    public void aPopUpToChooseFillAdditionalTextAppear() {
        operationDetailScreen.IsPopupDisplayed();
    }

    @And("^select \"([^\"]*)\"$")
    public void select(String arg0) throws Throwable {
       operationDetailScreen.selectItem(arg0);

    }

    @Then("^a pop-up to fill price of an article$")
    public void aPopUpToFillPriceOfAnArticle() {
        operationDetailScreen.thePopUpWithTitleIsDisplay("Price");
        operationDetailScreen.IsPopupDisplayed();
    }

    @And("^I fill price as \"([^\"]*)\" €$")
    public void iFillPriceAs€(String arg0) throws Throwable {
        operationDetailScreen.fillPrice(arg0);
    }

    @And("^click \"([^\"]*)\" price button$")
    public void clickPriceButton(String arg0) throws Throwable {
        operationDetailScreen.clickOnPriceButton(arg0);
    }

    @Then("^an additional article booking screen appear with \"([^\"]*)\" button disabled$")
    public void anAdditionalArticleBookingScreenAppearWithButtonDisabled(String arg0) throws Throwable {
        operationDetailScreen.verifyThatTheButtonOKOfAdditionalDisable(arg0);
    }

    @Then("^a new selected booking \\(of \"([^\"]*)\"\\) appears on top booking list with name and price are same as above$")
    public void aNewSelectedBookingOfAppearsOnTopBookingListWithNameAndPriceAreSameAsAbove(String arg0) throws Throwable {
        //TODO We are will come back
    }


    @And("^I click on \"([^\"]*)\" with price \"([^\"]*)\" €$")
    public void iClickOnWithPrice€(String arg0, String arg1) throws Throwable {
        operationDetailScreen.clickOnAdditionalArticle(arg0,arg1);
    }

    @Then("^\"([^\"]*)\" button enable$")
    public void buttonEnable(String arg0) throws Throwable {
        operationDetailScreen.verifyThatTheButtonOKOfAdditionalEnable(arg0);
    }

    @And("^I click \"([^\"]*)\" additional article$")
    public void iClickAdditionalArticle(String arg0) throws Throwable {
        operationDetailScreen.clickOKAdditionalButton(arg0);
    }


    @Then("^a new selected booking appears on top booking list with name \"([^\"]*)\" and price are same as above$")
    public void aNewSelectedBookingAppearsOnTopBookingListWithNameAndPriceAreSameAsAbove(String arg0) throws Throwable {
        operationDetailScreen.verifyThatArticleJustAdded(arg0);
    }

    @Then("^a new selected booking appears on top booking list with name \"([^\"]*)\" and price are same as above and additional text below as \"([^\"]*)\"$")
    public void aNewSelectedBookingAppearsOnTopBookingListWithNameAndPriceAreSameAsAboveAndAdditionalTextBelowAs(String arg0, String arg1) throws Throwable {
       operationDetailScreen.verifyThatAdditionArticleJustAdded(arg0);
       operationDetailScreen.verifyThatAdditionArticleJustAddedHasNote(arg1);
    }

    @Then("^a new selected booking together with \"([^\"]*)\" & \"([^\"]*)\" additional bookings appears on top booking list with name and price are same as above$")
    public void aNewSelectedBookingTogetherWithAdditionalBookingsAppearsOnTopBookingListWithNameAndPriceAreSameAsAbove(String arg0, String arg1) throws Throwable {
        operationDetailScreen.verifyThatNAdditionArticleJustAdded(arg0,arg1);
    }

    @Then("^additional article \"([^\"]*)\" appear on booking list right below \"([^\"]*)\" & Total amount/ \"([^\"]*)\" changes accordingly\\.$")
    public void additionalArticleAppearOnBookingListRightBelowTotalAmountChangesAccordingly(String arg0, String arg1, String arg2) throws Throwable {
        operationDetailScreen.verifyThatNAdditionArticleJustAdded(arg0);
    }

    @And("^I click on \"([^\"]*)\" article with price \"([^\"]*)\" € with (\\d+) times$")
    public void iClickOnArticleWithPrice€WithTimes(String arg0, String arg1, int arg2) throws Throwable {
        for (int i=0;i<arg2;i++){
            operationDetailScreen.clickOnArticleWithNameAndPrice(arg0, arg1);
        }
    }

    @Then("^The sum of added articles is equal total label$")
    public void theSumOfAddedArticlesIsEqualTotalLabel() {
        operationDetailScreen.verifySumOfArticlesIsAlwaysEqual("Age Portion");
    }

    //Booking for complexity case
    @And("^I book articles with the following data:$")
    public void iBookArticlesWithTheFollowingData(DataTable data) {
        orderedArticles = new OrderedArticles();
        orderedArticles.data  = data;
        List<Article> articles = orderedArticles.mapDataFromDataTable();
        for (Article a :articles) {
            if (StringUtils.isNotEmpty(a.name) && StringUtils.isEmpty(a.articleId)) {
                operationDetailScreen.clickOnArticleWithNameAndPrice(a.name, a.stringPrice);
            } else if (StringUtils.isNotEmpty(a.name) && !StringUtils.isEmpty(a.articleId)) {
                operationDetailScreen.chooseArticleFromNumpad(a.articleId, a.quantity);
            }
            if (a.ageRestriction == TypeChoose.CANCEL){
                continue;
            } else {
                if (operationDetailScreen.popup.isShowPopupWithTitle("Age restriction")) {
                    operationDetailScreen.clickOnCancelOrOkPopupIfShow(TypeChoose.OK, "Age restriction");
                }
                //If is Additional article but we do not input text
                if (a.isAdditional && StringUtils.isNotEmpty(a.isDeposit)) {
                    continue;
                }
                else if (a.isAdditional && a.noted.equals("") == true) {
                    operationDetailScreen.chooseAdditionalArticle(a.getArticleAdditional().name);
                    operationDetailScreen.clickOnOKOrCancelPopup("OK");
                    //If is Additional article but we input text
                    // 1> if inputting noted text is required
                    // Then will call selectItem
                } else if (a.isAdditional && StringUtils.isNotEmpty(a.noted)) {
                    operationDetailScreen.chooseAddTextArticle(a.getArticleAdditional().name);
                    //TODO refactor
                    if (StringUtils.isNotEmpty(a.noted) && a.noted.equalsIgnoreCase("Empty") == false) {
                        operationDetailScreen.selectItem(a.noted);
                        operationDetailScreen.clickOnOKOrCancelPopup("OK");
                    }
                }

            }
        }
    }

    @And("^I book a portion is disabled$")
    public void iBookAPortionIsDisabled() {
        operationDetailScreen.clickOnArticleWithNameAndPrice("Article portion", "");
        operationDetailScreen.clickOnPortion("Large");
    }

    @Then("^The disabled portion is not added$")
    public void theDisabledPortionIsNotAdded() {
        operationDetailScreen.popupWithTitleIsShow("Portions");
    }

    @Then("^I see a age checking popup is appeared$")
    public void iSeeAAgeCheckingPopupIsAppeared() {
        operationDetailScreen.popupWithTitleIsShow("Age restriction");
    }

    @Then("^Item \"([^\"]*)\" is not added$")
    public void itemIsNotAdded(String arg0) throws Throwable {
        operationDetailScreen.verifyThatArticleIsNotAdded(arg0);
    }

    @Then("^the displayed date is appeared on popup with (\\d+) old$")
    public void theDisplayedDateIsAppearedOnPopupWithOld(int arg0) {
        operationDetailScreen.verifyThatTheDateAppearedOnPopup(arg0,"dd.MM.yyyy");
    }

    @Then("^Item \"([^\"]*)\" is added$")
    public void itemIsAdded(String arg0) throws Throwable {
        operationDetailScreen.verifyThatArticleJustAdded(arg0);
    }

    @Then("^I see \"([^\"]*)\" is filled$")
    public void iSeeIsFilled(String arg0) throws Throwable {
        operationDetailScreen.verifyThatDataFilledOnEditor(arg0);
    }

    @And("^I click on erase button$")
    public void iClickOnEraseButton() {
        operationDetailScreen.clickOnEraseOnPopup();
    }

    @Then("^Text \"([^\"]*)\" is erased$")
    public void textIsErased(String arg0) throws Throwable {
       operationDetailScreen.verifyThatDataFilledOnEditorIsErased(arg0);
    }

    @Then("^a new selected booking appears on top booking list with name \"([^\"]*)\" and price are same as above and additional text below as empty$")
    public void aNewSelectedBookingAppearsOnTopBookingListWithNameAndPriceAreSameAsAboveAndAdditionalTextBelowAsEmpty(String arg0) throws Throwable {
        operationDetailScreen.verifyThatAdditionArticleJustAdded(arg0);
        operationDetailScreen.verifyThatAdditionArticleJustAddedAndDoesNotNote(2);
    }

    @Then("^A new selected booking appears on top booking list with name \"([^\"]*)\" with \"([^\"]*)\" price$")
    public void aNewSelectedBookingAppearsOnTopBookingListWithNameWithPrice(String arg0, String arg1) throws Throwable {
        operationDetailScreen.verifyThatAdditionArticleJustAdded(arg0);

    }

    @Then("^Additional text below as \"([^\"]*)\"$")
    public void additionalTextBelowAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        operationDetailScreen.verifyThatAdditionArticleJustAddedHasNote(arg0);
    }

    @Then("^(\\d+) items is added$")
    public void itemsIsAdded(int arg0) {
        operationDetailScreen.verifyThatNArticleAdded(arg0);
    }

    @And("^I choose add text article \"([^\"]*)\"$")
    public void iChooseAddTextArticle(String arg0) throws Throwable {
        operationDetailScreen.chooseAddTextArticle(arg0);
    }

    @And("^I click cancel additional with note article$")
    public void iClickCancelAdditionalWithNoteArticle() {
        operationDetailScreen.clickOnOKOrCancelPopup("CANCEL");
    }

    @Then("^I see main menu \"([^\"]*)\"$")
    public void iSeeMainMenu(String arg0) throws Throwable {
        operationDetailScreen.isDisPlayMainMenu(arg0);
    }

    @Then("^A new selected booking appears on top booking list with name \"([^\"]*)\" with \"([^\"]*)\" price with only add text$")
    public void aNewSelectedBookingAppearsOnTopBookingListWithNameWithPriceWithOnlyAddText(String arg0, String arg1) throws Throwable {
        operationDetailScreen.verifyThatAdditionArticleJustAddedOnlyWithAdditionalText(arg0);

    }

    @Then("^Only a additional text below as \"([^\"]*)\"$")
    public void onlyAAdditionalTextBelowAs(String arg0) throws Throwable {
        operationDetailScreen.verifyThatAdditionArticleJustAddedHasA_AdditionalText(arg0);
    }

    @And("^I click \"([^\"]*)\" button on bar popup$")
    public void iClickButtonOnBarPopup(String arg0) throws Throwable {
        operationDetailScreen.getIndexByTextOnPopupBar(arg0).click();
    }

    @And("^I click item at index (\\d+) in ordered items$")
    public void iClickItemAtIndexInOrderedItems(int arg0) {
        operationDetailScreen.getItemByNameAtIndex(arg0).click();
    }

    @And("^I click on set loss$")
    public void iClickOnSetLoss() {
        operationDetailScreen.clickOnSetLoss();
    }

    @Then("^I see a \"([^\"]*)\"  popup is appeared$")
    public void iSeeAPopupIsAppeared(String arg0) throws Throwable {
        operationDetailScreen.thePopUpWithTitleIsDisplay(arg0);
    }

    @Then("^Item at index (\\d+) is set \"([^\"]*)\" value$")
    public void itemAtIndexIsSetValue(int arg0, String arg1) throws Throwable {
        String expected =  arg1.replace(EURO,"");
        String found = operationDetailScreen.getItemByPriceAtIndex(arg0-1).getText();
        Assert.assertTrue(found.contains(expected));
    }

    @And("^I click on receipt$")
    public void iClickOnReceipt() {
        operationDetailScreen.clickOnReceipt();
    }

    @Then("^I see a \"([^\"]*)\"  bar popup is appeared$")
    public void iSeeAPopupBarIsAppeared(String arg0) throws Throwable {
        operationDetailScreen.theBarPopUpWithTitleIsDisplay(arg0);
    }

    @And("^I click yes button on popup$")
    public void iClickYesButtonOnPopup() {
        operationDetailScreen.clickYesButton();
    }

    @And("^I click on set voucher$")
    public void iClickOnSetVoucher() {
        operationDetailScreen.clickOnVoucher();
    }

    @And("^I discount item (\\d+) \"([^\"]*)\"$")
    public void iDiscountItem(int index, String discount) throws Throwable {
       operationDetailScreen.setDiscountAtItemWithPercentage( index,  discount);
    }

    @And("^I click on menu at (\\d+)$")
    public void iClickOnMenuAt(int index) {
        operationDetailScreen.clickOnMenuHeader(index);
    }

    @And("^I click on menu at (\\d+) with \"([^\"]*)\"$")
    public void iClickOnMenuAtWith(int index, String text) throws Throwable {
        operationDetailScreen.clickOnMenuHeaderWithName(index, text);
    }

    @And("^I discount all \"([^\"]*)\"$")
    public void iDiscountAll(String percent) throws Throwable {
      operationDetailScreen.setDiscountForAOperation(1,percent);
    }

    @Then("^The sum of prices is \"([^\"]*)\"$")
    public void theSumOfPricesIs(String sum) throws Throwable {
        operationDetailScreen.verifySumOrArticelIsEqual(sum);
    }

    @And("^I set price item (\\d+) \"([^\"]*)\"$")
    public void iSetPriceItem(int index, String price) throws Throwable {
        operationDetailScreen.setPriceAtItem( index,  price);
    }

    @And("^I cancel the item (\\d+)$")
    public void iCancelTheItem(int index) {
        operationDetailScreen.setCancelAtItem( index);
    }

    @And("^I click reset deposit$")
    public void iClickResetDeposit() {
        operationDetailScreen.clickResetDeposit();
    }

    @Then("^I return to Operation detail without \"([^\"]*)\" any new booking appear$")
    public void iReturnToOperationDetailWithoutAnyNewBookingAppear(String name) throws Throwable {
        operationDetailScreen.verifyThatArticleIsNotAdded(name);
    }


    @And("^select voucher \"([^\"]*)\"$")
    public void selectVoucher(String arg0) throws Throwable {
        operationDetailScreen.selectVoucher(arg0);
    }

    @And("^I click on splitting$")
    public void iClickOnSplitting() {
        operationDetailScreen.clickOnSplitting();
    }

    @And("^I choose \"([^\"]*)\" at index (\\d+) in (\\d+) items$")
    public void iChooseAtIndexInItems(String name, int index, int items) throws Throwable {
        operationDetailScreen.chooseAtIndexWithName(name,index,items);
    }

    @Then("^I see a split board$")
    public void iSeeASplitBoard() {
        operationDetailScreen.verifyThatASplitBoardIsExisted();
    }

    @Then("^I see that split board contains (\\d+) items$")
    public void iSeeThatSplitBoardContainsItems(int items) {
        operationDetailScreen.splitBoardContainsItems(items);
    }

    @And("^I choose \"([^\"]*)\" in main board$")
    public void iChooseInMainBoard(String name) throws Throwable {
        operationDetailScreen.chooseItemOnMainBoardWithName(name);
    }

    @Then("^The balance on main board will be \"([^\"]*)\"$")
    public void theBalanceOnMainBoardWillBe(String total) throws Throwable {
        operationDetailScreen.verifyThatBalanceOnLabelIsEqual(operationDetailScreen.balanceOfMain,total);
    }

    @Then("^The balance on split board will be \"([^\"]*)\"$")
    public void theBalanceOnSplitBoardWillBe(String total) throws Throwable {
        operationDetailScreen.verifyThatBalanceOnLabelIsEqual(operationDetailScreen.balanceOfSplit,total);
    }

    @And("^I click on bar$")
    public void iClickOnBar() {
        operationDetailScreen.clickOnBar();
    }

    @And("^I book articles \"([^\"]*)\" (\\d+) times$")
    public void iBookArticlesTimes(String name, int times) throws Throwable {
        operationDetailScreen.bookingNTimes(name, times);
    }

    @Then("^operation will increase (\\d+) times$")
    public void operationWillIncreaseTimes(int times) {
        operationDetailScreen.verifyThatIncreaseNTimes(times);
    }

    @And("^I fill the tip (\\d+) \"([^\"]*)\"$")
    public void iFillTheTip(int tip, String arg1) throws Throwable {
        operationDetailScreen.setTip(tip + "");
    }

    @And("^I create a voucher with (\\d+) \"([^\"]*)\"$")
    public void iCreateAVoucherWith(int price, String code) throws Throwable {
        operationDetailScreen.setPriceVoucher("" + price, code);
    }

    @And("^I create a redeem voucher \"([^\"]*)\"$")
    public void iCreateARedeemVoucher(String code) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        operationDetailScreen.setRedeemVoucher(code);
    }

    @And("^I create a guest expense \"([^\"]*)\" with the reason \"([^\"]*)\"$")
    public void iCreateAGuestExpenseWithTheReason(String amount, String reason) throws Throwable {
        operationDetailScreen.setGuestExpense(amount, reason);
    }

    @And("^I close out report$")
    public void iCloseOutReport() {
        operationDetailScreen.chooseCloseOutReport();
    }

    @And("^I choose manual report$")
    public void iChooseManualReport() {
        operationDetailScreen.chooseManualReport();
    }

    @And("^I choose invoice cancellation$")
    public void iChooseInvoiceCancellation() {
        operationDetailScreen.chooseInvoiceCancellation();
    }

    @And("^I click the first receipt$")
    public void iClickTheFirstReceipt() {
        operationDetailScreen.chooseReceiptToCancel();
    }

    @And("^I set the working date$")
    public void iSetTheWorkingDate() {
        operationDetailScreen.setWorkingDate();
    }

    @Then("^The working date increase (\\d+) date$")
    public void theWorkingDateIncreaseDate(int arg0) {
        operationDetailScreen.theWorkingDateIncreaseDate();
    }

    @Then("^I see report appeared$")
    public void iSeeReportAppeared() {

    }

    @And("^I choose invoice copying$")
    public void iChooseInvoiceCopying() {
        operationDetailScreen.chooseInvoiceCopy();
    }

    @Then("^I see the copied operation  appeared$")
    public void iSeeTheCopiedOperationAppeared() {
        operationDetailScreen.verifyThatTheOperationCopied("_Copy");
    }

    @And("^I select \"([^\"]*)\" printer$")
    public void iSelectPrinter(String printer) throws Throwable {
        operationDetailScreen.selectPrinter(printer);
    }

    @Then("^The name split will be \"([^\"]*)\"$")
    public void theNameSplitWillBe(String nameOperation) throws Throwable {
        operationDetailScreen.verifyThatTheSplitNameIsOrdered(nameOperation);
    }

    @And("^I click on receipt of split$")
    public void iClickOnReceiptOfSplit() {
        operationDetailScreen.clickOnReceiptSplit();
    }

    @And("^I wait progress bar is hidden$")
    public void iWaitProgressBarIsHidden() {
        operationScreen.progressBarIsHidden();

    }

    @And("^I create a voucher \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iCreateAVoucherWith(String code, String price) throws Throwable {
        operationDetailScreen.setPriceVoucher(price, code);
    }

    @And("^I redeem a voucher \"([^\"]*)\"$")
    public void iRedeemAVoucher(String code) throws Throwable {
        operationDetailScreen.setRedeemVoucher(code);
    }
}
