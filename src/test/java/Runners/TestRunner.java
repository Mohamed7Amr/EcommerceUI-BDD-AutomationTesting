package Runners;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
//import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\resources\\Features",
        glue = "tests.StepDefinitions",
        tags = "@regression",
        plugin = {"pretty",
                "html:target/cucumber/cucumber-html-report.html",
                "json:target/cucumber/cucumber-json-report.json",
               "junit:target/cucumber/cucumberXML.xml"}

        )

public class TestRunner extends AbstractTestNGCucumberTests {
}
