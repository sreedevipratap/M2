package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
				 glue= {"stepsDef"}, plugin= {"html:target/cucumber-html-report", "pretty","json:target/cucumber.json" },
				 tags = { "@Login" })



public class MRunner {
	
}
