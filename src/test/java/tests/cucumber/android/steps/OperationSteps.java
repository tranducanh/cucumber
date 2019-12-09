package tests.cucumber.android.steps;

import base.AndroidThreadLocalDriver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import tests.cucumber.android.screens.LoginScreen;
import tests.cucumber.android.screens.NextLoginScreen;
import tests.cucumber.android.screens.OperationScreen;
import tests.cucumber.android.screens.OperationDetailScreen;
import tests.cucumber.app.dto.Operation;
import tests.cucumber.app.utils.Utils;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import static tests.cucumber.android.steps.Constants.REPLACE_STRING;

public class OperationSteps extends BaseSteps {
    public LoginScreen loginScreen;
    public NextLoginScreen nextLoginScreen;
    public OperationScreen operationScreen;
    public OperationDetailScreen operationDetailScreen;
    public static Operation operation;

    public OperationSteps() {
        loginScreen = new LoginScreen(AndroidThreadLocalDriver.getTLDriver());
        nextLoginScreen = new NextLoginScreen(AndroidThreadLocalDriver.getTLDriver());
        operationScreen = new OperationScreen(AndroidThreadLocalDriver.getTLDriver());
        operationDetailScreen = new OperationDetailScreen(AndroidThreadLocalDriver.getTLDriver());

    }

    @Given("^Login with email \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void loginWithEmailAndPassword(String arg0, String arg1) throws Throwable {
        loginScreen.inputEmail(arg0);
        loginScreen.inputPassword(arg1);
        loginScreen.clickLogin();
    }

    @Given("^I am in operation screen$")
    public void iAmInOperationScreen() {
        operationScreen.isDisplayed();
    }

    @When("^I click on add operation button$")
    public void iClickOnAddOperationButton() {
        operationScreen.clickPlusButton();
    }

    @And("^I fill \"([^\"]*)\" for operation name$")
    public void iFillForOperationName(String arg0) throws Throwable {
        operationScreen.fillOperationName(arg0);
    }

    @And("^I click Ok button$")
    public void iClickOkButton() {
        operationScreen.clickOkButtonOfPopup();
    }

    @Then("^A new Operation is generated \"([^\"]*)\"$")
    public void aNewOperationIsGenerated(String arg0) throws Throwable {
        operationDetailScreen.isDisplayed();
    }


    @Then("^I will go to the waiter screen$")
    public void iWillGoToTheWaiterScreen() {
        operationDetailScreen.isDisplayed();
    }

    @And("^I swipe to find tab that just added with \"([^\"]*)\" value$")
    public void iSwipeToFindTabThatJustAddedWithValue(String arg0) throws Throwable {
        operationScreen.swipeToFindTab(arg0, 5);
    }

    @When("^I click on tab with \"([^\"]*)\" value$")
    public void iClickOnTabWithValue(String arg0) throws Throwable {
        operationScreen.clickOnTabWithValue(arg0);
    }

    @Given("^I am in operation list screen$")
    public void iAmInOperationListScreen() {
        operationScreen.isDisplayed();
    }

    @Then("^I am navigated to \"([^\"]*)\" Operation screen$")
    public void iAmNavigatedToOperationScreen(String arg0) throws Throwable {
        operationDetailScreen.isDisplayed();
    }

    @And("^I click Cancel button$")
    public void iClickCancelButton() {
        operationScreen.clickCancelButtonOnPopup();
    }

    @Then("^I am not navigated to \"([^\"]*)\" Operation screen$")
    public void iAmNotNavigatedToOperationScreen(String arg0) throws Throwable {
        operationScreen.verifyThatNotOperationIsCreated(arg0);
    }

    @And("^I go to back$")
    public void iGoToBack() {
        operationDetailScreen.clickToBack();
    }


    @Then("^The total on operation fits with header$")
    public void theTotalOnOperationFitsWithHeader() {
        operationDetailScreen.verifyTotalOnTabIsEqualToTalOnHeader(OperationScreen.totalPrice);
    }

    @And("^I get total on the \"([^\"]*)\" selected operation$")
    public void iGetTotalOnTheSelectedOperation(String arg0) throws Throwable {
        operationScreen.getPriceOnTab(arg0);
    }

    @And("^I Login with other user in other device$")
    public void iLoginWithOtherUserInOtherDevice() {
    }

    @And("^I go to operation list screen$")
    public void iGoToOperationListScreen() {
        operationScreen.isDisplayed();
    }

    @Then("^Alert error message show \"([^\"]*)\"This operation is currently opened by user: \"([^\"]*)\"$")
    public void alertErrorMessageShowThisOperationIsCurrentlyOpenedByUser(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I create new a operation with the following data:$")
    public void iCreateNewAOperationWithTheFollowingData(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        operation = new Operation(list.get(0).get("Name"));
        operationScreen.clickPlusButton();
        operationScreen.fillOperationName(operation.name);
        operationScreen.operationNameStr = operation.name;
        operationScreen.clickOkButtonOfPopup();
        operationDetailScreen.isDisplayed();
    }

    @When("^I press \"([^\"]*)\" item from menu$")
    public void iPressItemFromMenu(String arg0) throws Throwable {
        operationScreen.clickOnMenuItemByName("^",arg0);
    }

    @Then("^I see a bar popup appeared$")
    public void iSeeABarPopupAppeared() {
        operationDetailScreen.verifyThatPopupBarIsAppeared();
    }

//    @And("^I clear all operation with start \"([^\"]*)\"$")
//    public void iClearAllOperationWithStart(String arg0) throws Throwable {
//
//        int i =0;
//        while(i<200) {
//            this.operationScreen.isDisplayed();
//            operationScreen.clickOnMenuItemByName("BAR");
//            operationDetailScreen.getIndexByTextOnPopupBar("Print Invoice").click();
//            this.operationScreen.isDisplayed();
//            i++;
//
//        }
//    }

    @And("^I clear all operation with start \"([^\"]*)\"$")
    public void iClearAllOperationWithStart(String operation) throws Throwable {

        int i =0;
        while(i < 10 && operationScreen.isElementPresent(By.xpath(operationScreen.moreAction.replace(REPLACE_STRING,operation))) ==false) {

            i++;
        }

        while(operationScreen.isElementPresent(By.xpath(operationScreen.moreAction.replace(REPLACE_STRING,operation))) ==true){

            i =0;
            while(i < 10 && operationScreen.isElementPresent(By.xpath(operationScreen.moreAction.replace(REPLACE_STRING,operation))) ==false) {

                i++;
            }
            operationScreen.isDisplayed();
            operationScreen.clickOnMenuItemByName(operation,"BAR");
            operationDetailScreen.getIndexByTextOnPopupBar("Print Invoice").click();
            operationScreen.sleep(5000);

        }


    }

    @And("^I search with keyword \"([^\"]*)\"$")
    public void iSearchWithKeyword(String keyword) throws Throwable {
        operationScreen.clickOnSearch();
        operationScreen.fillSearch(keyword);
    }

    @Then("^The operation with keyword \"([^\"]*)\" is (\\d+)$")
    public void theOperationWithKeywordIs(String keyword, int numberOfOperation) throws Throwable {
        operationScreen.verifyThatNumberOfOperationIsEqual(keyword, numberOfOperation);
    }
}
