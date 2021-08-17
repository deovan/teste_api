
package br.com.driver.local;

import br.com.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;

@Log
public class LocalDriverManager implements IDriver {

    @Override
    public WebDriver createInstance(String browser) {
        WebDriver driver = null;

        try {
            DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
            Class<?> driverClass = Class.forName(driverManagerType.browserClass());
            WebDriverManager.getInstance(driverManagerType).setup();
            driver = (WebDriver) driverClass.newInstance();
        } catch (IllegalAccessException | ClassNotFoundException e) {
            log.warning("The class could not be found" + e);
        } catch (InstantiationException e) {
            log.warning("Problem during br.com.driver instantiation" + e);
        }
        return driver;
    }
}
