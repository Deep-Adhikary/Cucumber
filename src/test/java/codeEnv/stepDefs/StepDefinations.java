package codeEnv.stepDefs;
import cucumber.api.java.en.*;
import codeEnv.global.Global;
import cucumber.api.PendingException;
public class StepDefinations {
    @Given("Steps needs to be perform before scenario")
    public void steps_needs_to_be_perform_before_scenario() {
        // Write code here that turns the phrase above into concrete actions
        Global.push("The Sky is crying");
       // System.out.println("The Sky is crying");
    }

    @Given("It is raining and user is outside")
    public void it_is_raining_and_user_is_outside() {
        // Write code here that turns the phrase above into concrete actions
        Global.push("Yeah It is Raining");
        //System.out.println("Yeah It is Raining");
    }

    @When("User un tie Knot")
    public void user_un_tie_nought() {
        // Write code here that turns the phrase above into concrete actions
        Global.push("Umbrella Knot Untied");
       // System.out.println("Umbrella Knot Untied");
    }

    @When("Press on open Switch")
    public void press_on_open_Switch() {
        // Write code here that turns the phrase above into concrete actions
        Global.push("Switch pressed successfully");
        //System.out.println("Switch pressed successfully");
    }

    @Then("Umbrella should open")
    public void umbrella_should_open() {
        // Write code here that turns the phrase above into concrete actions
        Global.push("Wow!! Umbrella opened");
        //System.out.println("Wow!! Umbrella opened");
    }

    @Then("The clothes of umbrella should not be torn")
    public static void the_clothes_of_umbrella_should_not_be_torn() {
        // Write code here that turns the phrase above into concrete actions
        Global.push("Thank God! It is not torn.");
       // System.out.println("Thank God! It is not torn.");
    }
}
