package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static steps.BaseSteps.getDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "steps")
public class TestRunner {


//
//    @AfterClass
//    public static void afterAll() {
//        getDriver().quit();
//    }

}