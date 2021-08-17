

package br.com.driver;

import br.com.driver.local.LocalDriverManager;
import lombok.extern.java.Log;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


@Log
public class DriverFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver webdriver;
        webdriver = new LocalDriverManager().createInstance(browser);
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webdriver.manage().window().setSize(new Dimension(1200, 800));
        return webdriver;
    }
    
}
