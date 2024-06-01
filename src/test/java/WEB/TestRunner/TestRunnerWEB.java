package WEB.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/WEB",
    glue = {"WEB.stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunnerWEB {
}