package com.stepdefinations;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features",
        glue= {"com.stepdefinations"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true
)
public class testRunner {

}
