package codeEnv.stepDefs;
import codeEnv.global.Global;
import codeEnv.utils.Enums;
import cucumber.api.Scenario;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.runtime.ScenarioImpl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.Logger;


public class Hooks {
    Global global;
    TakesScreenshot screenshot;
    public Hooks(Global global){
        this.global=global;
    }
    @Before()
    public void beforeScenario(Scenario scenario){
        global.getDriverManager().launchBrowser(Enums.Browser.Firefox);
        //System.out.println("Scenario start::" +scenario.getName() );
        //HI
    }
    @After()
    public void afterScenario(Scenario scenario){

        if(scenario.isFailed()){
            screenshot=((TakesScreenshot)global.getDriverManager().getDriver());
            byte[] screenShot=screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
            System.out.println("Captured");
        }
        global.getDriverManager().getDriver().quit();
        //System.out.println("Scenario End::" +scenario.getName() );
    }
    @BeforeStep()
    public void beforeStep(Scenario scenario){
    }

    @AfterStep()
    public void afterStep(Scenario scenario){
    }
}
