package com.bddTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
                 strict = true,
                 dryRun = false,
                 tags =  "@FilterByRate",
                 //tags = "~@wip",
                 plugin = {"json:target/cucumber.json", "html:target/cucumber.html"})
public class RunCuckesTest {
}
