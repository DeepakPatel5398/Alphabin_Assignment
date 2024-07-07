package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\booking\\Pofile.feature"}
,glue = "stepdefinition"
,plugin = {"html:testoutput/cucumber.html","junit:testoutput/cucumber.xml","html:testoutput/cucumberjason.xml"}
)
public class Bookingfilerunner {
}
