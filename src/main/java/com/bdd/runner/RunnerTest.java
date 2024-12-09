package com.bdd.runner;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.bdd.steps", "com.bdd.utils"},
        tags = "@Ejercicio2",
        plugin = {"pretty", "html:target/cucumber-report.html"}

)

public class RunnerTest {
}