package runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@rerun/failed_scenario.txt"}, 
			glue = "stepDefinition",
			dryRun = false, 
			plugin = {"rerun:rerun/failed_scenario.txt"})
public class FailedRunner {
 
}
