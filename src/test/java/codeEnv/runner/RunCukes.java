package codeEnv.runner;
import codeEnv.global.Global;
import java.util.List;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/codeEnv/resource"
        ,glue={"codeEnv.stepDefs"},
        plugin = { "pretty", "json:target/Results/Cucumber.json",
                "html:target/Results/native-cucumberreport",
               "junit:target/Results/Cucumber.xml"
        },
        dryRun =false,
        monochrome = true
)


public class RunCukes {
    @AfterClass
    public static void showStack(){
        //Global.show();
        File reportOutputDirectory = new File("target/Results");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/Results/Cucumber.json");
        //jsonFiles.add("cucumber-report-2.json");

        String buildNumber = "1";
        String projectName = "cucumberProject";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");

// optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        //classificationFiles.add("properties-1.properties");
       // classificationFiles.add("properties-2.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();

        
    }
}
