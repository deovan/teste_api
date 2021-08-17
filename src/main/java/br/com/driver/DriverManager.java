
package br.com.driver;

import cucumber.api.Result;
import cucumber.api.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static br.com.report.ReporterUtils.addLogToReport;
import static br.com.report.ReporterUtils.addScreenshotToReport;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void resetDriver(String url) {
        getDriver().get(url);
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static ThreadLocal<Scenario> getScenario() {
        return scenario;

    }

    public static void setScenario(Scenario scenario) {
        DriverManager.scenario.set(scenario);
    }

    public static void quit(Scenario scenario) {
        if (scenario.getStatus().equals(Result.Type.FAILED)) {
            if (driver != null) {
                addScreenshotToReport();
            } else {
                addLogToReport(getScenario().get().getStatus().toString());
            }
        }
        DriverManager.driver.get().quit();
    }

    public static String getInfo() {
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatform().toString();
        String version = cap.getVersion();
        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
    }
}
