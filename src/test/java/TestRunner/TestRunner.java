package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin={"pretty","html:test-output.html"},
        features = "classpath:Features",
        glue={"StepDefinations","Base"},
        tags= "@smoke",
        dryRun = false,
        monochrome = true
        )
public class TestRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }
}

