package codeEnv.stepDefs;
import codeEnv.global.Global;
import cucumber.api.Scenario;
import cucumber.api.TestStep;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.After;
public class Hooks {

    @Before()
    public void beforeScenario(Scenario scenario){
        Global.push("Scenario start::" +scenario.getName());
        //System.out.println("Scenario start::" +scenario.getName() );
    }
    @After()
    public void afterScenario(Scenario scenario){
        Global.push("Scenario End::" +scenario.getName());
        //System.out.println("Scenario End::" +scenario.getName() );
    }
    @BeforeStep()
    public void beforeStep(){
        Global.push("Step Start");
       // System.out.println("Step Start");
    }

    @AfterStep()
    public void afterStep(){
        Global.push("Step End");
       // System.out.println("Step End");
    }
}
