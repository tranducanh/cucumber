package tests.cucumber.android.steps;

import base.AndroidThreadLocalDriver;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.cucumber.android.screens.LoginScreen;
import tests.cucumber.android.screens.NextLoginScreen;
import tests.cucumber.android.screens.OperationScreen;
import tests.cucumber.app.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class LoginSteps extends BaseSteps{
    public LoginScreen loginScreen;
    public NextLoginScreen nextLoginScreen;
    public OperationScreen operationScreen;
    @Before
    public void setupLoginSteps () {
        setupCucumber();
        loginScreen = new LoginScreen(AndroidThreadLocalDriver.getTLDriver());
        nextLoginScreen = new NextLoginScreen(AndroidThreadLocalDriver.getTLDriver());
        operationScreen = new OperationScreen(AndroidThreadLocalDriver.getTLDriver());
        System.out.println("@Before: ");
    }

    @After
    public void exitScenario(Scenario scenario) throws InterruptedException, MalformedURLException {
        if (scenario.isFailed()) {
            System.out.println("@After Failed: ");
            TakesScreenshot ts = (TakesScreenshot) AndroidThreadLocalDriver.getTLDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        AndroidThreadLocalDriver.getTLDriver().closeApp();
    }


    @Given("^The UI of Login$")
    public void the_ui_of_login(){
        System.out.println("UI of login");
    }

    @When("^I fill \"([^\"]*)\" as email$")
    public void fill_email(String arg0) throws Throwable {
        loginScreen.inputEmail(arg0);
    }


    @And("^I fill \"([^\"]*)\" as password$")
    public void fill_password(String arg0) throws Throwable {
        loginScreen.inputPassword(arg0);
    }

    @And ("^I click on Login button$")
    public void click_login_button() throws IOException {
        loginScreen.clickLogin();

    }

    @Then ("^I see the next login screen")
    public void isShowNextLogin() {

        nextLoginScreen.isDisplayed();
    }

    @And("^I fill \"([^\"]*)\" as password for the next login$")
    public void iFillAsPasswordForTheNextLogin(String arg0) throws Throwable {

        nextLoginScreen.inputNextPassword(arg0);
    }

    @And("^I click on Login button of the next login$")
    public void iClickOnLoginButtonOfTheNextLogin() {
        nextLoginScreen.clickLogin();
    }

    @Then("^I see the operation screen$")
    public void iSeeTheOperationScreen() {
        operationScreen.isDisplayed();
    }

    @Then("^\"([^\"]*)\" error message show$")
    public void errorMessageShow(String arg0) throws Throwable {
        loginScreen.verifyErrorMessageShowed(arg0);
    }

    @Then("^Alert error message show$")
    public void alertErrorMessageShow() {
        loginScreen.verifyAlertErrorMessageShowed();
    }

    @And("^I check remember me as password for the next login$")
    public void iCheckRememberMeAsPasswordForTheNextLogin() {
        nextLoginScreen.setRemember(true);
    }

    @And("^I click on login$")
    public void iClickOnLogin() {
        nextLoginScreen.clickLogin();
    }

    @And("^I click logout$")
    public void iClickLogout() {
        operationScreen.logOut();
    }

    @Then("^I see the the screen remember$")
    public void iSeeTheTheScreenRemember() {
        nextLoginScreen.verifyTheTheScreenRemember();
    }

    @And("^i click here to enter username$")
    public void iClickHereToEnterUsername() {
        nextLoginScreen.clickHereToEnterUsername();
    }

    @And("^Close app$")
    public void closeApp() {
        nextLoginScreen.closeApp();
    }

    @And("^Launch app$")
    public void launchApp() {
        nextLoginScreen.driver.launchApp();
    }

    @Then("^I login form$")
    public void iLoginForm() {
        loginScreen.verifyLoginFormShowed();
    }

    @And("^I select \"([^\"]*)\" workstation$")
    public void iSelectWorkstation(String nameWorkStation) throws Throwable {
        nextLoginScreen.selectPrinterNameBy(nameWorkStation);
    }
}
