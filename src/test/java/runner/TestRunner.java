package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", glue = "stepDefinition", dryRun = false, tags = "@accounts", plugin = {
		"rerun:rerun/failed_scenario.txt", "pretty", "html:target/cucumber-reports/cucumber-html",
		"json:target/cucumber-reports/cucumber.json" })
public class TestRunner {

}

// as a user I should be able to create account