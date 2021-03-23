package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFiles/demoDataTable.feature",
	glue = "stepDefinitions",
	monochrome = true,
        format = {"json:target/cucumber.json"}
	)
public class RunnerClass {
	
}
