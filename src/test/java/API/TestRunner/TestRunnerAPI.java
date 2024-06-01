package API.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/API",
        glue= {"stepDefinitions"},
        plugin ={"pretty","json:target/cucumber-reports/APIReport.json"}
        )
public class TestRunnerAPI {
}