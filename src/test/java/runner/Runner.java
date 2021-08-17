package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        tags = {"@ALL"},
        glue = "gherkin",
        plugin = {"json:target/json-cucumber-reports/cukejson.json",
                "testng:target/testng-cucumber-reports/cuketestng.xml"
        },
        features = "src/main/feature")
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
    }

    @AfterClass
    public void tearDown() {

    }
}
