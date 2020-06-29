package step_definitions;

import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.Driver;
import util.Screenshots;

public class Hooks {
    public static Scenario currentScenario;
    @Before
    public void beforeScenario(){
        Driver.getDriver();
    }
    @After
    public void afterScenario(){
        Screenshots.captureScreenShot("Failed");
       // Driver.quitDriver();
    }
}
