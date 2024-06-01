package API.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/API",
    glue = {"API.stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunnerAPI {
}
