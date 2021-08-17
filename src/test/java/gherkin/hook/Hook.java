package gherkin.hook;

import br.com.driver.DriverFactory;
import br.com.driver.DriverManager;
import br.com.model.GeradorDeMassa;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;

@Log
public class Hook {

    @Before
    public void beforeScenario(Scenario scenario) {
        DriverManager.setScenario(scenario);
        log.info(String.format("TESTE INICIADO: %s", scenario.getName()));
    }

    @After
    public void afterScenario(Scenario scenario) {
        log.info(String.format("TESTE FINALIZADO: %s", scenario.getName()));
        log.info(String.format("TESTE STATUS: %s", scenario.getStatus()));
    }

    @Before("@WEB")
    public void init(Scenario scenario) {
        WebDriver driver = DriverFactory.createInstance(System.getProperty("browser"));
        DriverManager.setDriver(driver);
        new GeradorDeMassa();
    }

    @After("@WEB")
    public void cleanUp(Scenario scenario) {
        DriverManager.quit(scenario);
    }

}
