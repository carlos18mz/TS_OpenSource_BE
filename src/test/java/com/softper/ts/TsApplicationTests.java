package com.softper.ts;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(strict=true, plugin = {"pretty"}, features = "src/test/java/featureFiles", glue = "stepDefinitions")
class TsApplicationTests {

    @Test
    void contextLoads() {
    }

}
