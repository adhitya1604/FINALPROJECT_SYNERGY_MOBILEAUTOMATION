package Setara.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDef","hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-json.json"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
