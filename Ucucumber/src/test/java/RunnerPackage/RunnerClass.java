package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/CustomerRegistration.feature",
        glue = {"Steps", "Hooks"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
