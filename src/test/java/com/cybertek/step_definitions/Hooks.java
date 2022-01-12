package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("BEFORE = setUp method is running before the scenario ");
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        /**
         * Scenario scenario: represents current running cucumber scenario
         * - cast webdriver to TakesScreenshot interface
         * - call getScreenShotAs method and output type as OutputType.BYTES
         * - save the result into byte [] array : byte[] image
         * = attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
         */
        if(scenario.isFailed()) {   //if scenario fails , it will take screenshot
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }
        System.out.println("AFTER - tearDown method is running after the scenario:" + scenario.getName());
        Driver.closeDriver();
    }


    /**
     * @AfterStep - runs after each scenario step
     * - normally not needed but your project might need it at some point
     * @param scenario
     */

    @AfterStep
    public void tearDownStep(Scenario scenario){
        byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", scenario.getName());

    }
}
