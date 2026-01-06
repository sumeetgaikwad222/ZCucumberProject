package cuCumber_Project;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features  = "src/test/resources/Features/Registration.feature",
        glue = "cuCumber_Project",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:target/CucumberReport.html"}
)
public class Runner_Class extends AbstractTestNGCucumberTests {
}