package WEB.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/WEB",
        glue= {"stepDefinitions"},
        plugin ={"pretty","json:target/cucumber-reports/WEBReport.json"}
        )
public class TestRunnerWEB {
}