package com.yahoo.loginfunctionality;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/yahoo.feature",
        format={"pretty","html:target/Reports"}
        )

public class Runnerclass {

	
}
