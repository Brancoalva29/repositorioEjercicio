package com.bdd.utils;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    // Constructor para inyectar el driver (si es necesario)
    public Hooks(WebDriver driver) {
        this.driver = driver;
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            // Toma captura de pantalla
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            // Adjunta la captura al escenario
            scenario.attach(screenshot, "image/png", "Captura de pantalla");
        } catch (Exception e) {
            System.err.println("Error al tomar la captura: " + e.getMessage());
        }

    }
}
