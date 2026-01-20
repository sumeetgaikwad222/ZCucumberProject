package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/resources/Features/MouseHover.feature",
    glue = {"stepdef", "utiles"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true

)
public class Run extends AbstractTestNGCucumberTests {
}
