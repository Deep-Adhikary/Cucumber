package codeEnv.stepDefs;
import codeEnv.managers.DriverManager;
import codeEnv.pom.LoginPage;
import codeEnv.utils.Enums;
import cucumber.api.java.en.*;
import codeEnv.global.Global;
import cucumber.api.PendingException;
import  codeEnv.utils.Enums.*;
import org.openqa.selenium.WebDriver;

public class StepDefinations {
    private Global global;
    private WebDriver driver;
    private LoginPage loginPage;
    public StepDefinations(Global o_global){
        this.global=o_global;
        driver= global.getDriverManager().getDriver();
    }
    @Given("User is in Facebook Login Page")
    public void user_is_in_Facebook_Login_Page() {
        // Write code here that turns the phrase above into concrete actions

       driver.get("https://www.facebook.com/");
        loginPage=new LoginPage(driver);

    }
    @When("User enter username as {string} and password for User")
    public void user_enter_username_as_and_password_for_User(String userName) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterCredential(userName,"C3inadtgs@62");
    }

    @When("Click on Login Button")
    public void click_on_Login_Button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginBtn();
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {
        // Write code here that turns the phrase above into concrete actions
       loginPage.verifyLogin();
    }
}
