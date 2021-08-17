package br.com.report;

import br.com.driver.DriverManager;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import lombok.extern.java.Log;

import static br.com.driver.TakeScreenShot.getImageBytes;


@Log
public class ReporterUtils extends DriverManager {

    public ReporterUtils() {
        super();
    }

    /**
     * Add json to the cucumber extent-br.com.report listener for generating ExtentReports and Klov
     *
     * @param a Classe para ser convertida para JSON
     */
    public static void addJsonToReport(Object a) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = gson.toJsonTree(a);
        String prettyJsonString = gson.toJson(je);
        Markup m = MarkupHelper.createCodeBlock(prettyJsonString);
        getScenario().get().write(m.getMarkup().replace("class='code-block'", "class='code-block w-100 mh-100'"));
        log.info(prettyJsonString);
    }

    /**
     * Add comment to the cucumber-extent br.com.report listener for generating ExtentReports and Klov
     *
     * @param sMsg Text to be added to the br.com.report
     */
    public static synchronized void addLogToReport(String sMsg) {
        getScenario().get().write(sMsg);
        log.info(sMsg);
    }


    /**
     * Add comment and screenshot to the cucumber-extent br.com.report listener for generating ExtentReports and Klov
     *
     * @param sMsg Text to be added to the br.com.report
     */
    public static synchronized void addScreenshotToReport(String sMsg) {
        getScenario().get().write(sMsg);
        getScenario().get().embed(
                getImageBytes(getDriver()),
                "image/png");
        log.info(sMsg);
    }

    /**
     * Add screenshot to the cucumber-extent br.com.report listener for generating ExtentReports and Klov
     */
    public static synchronized void addScreenshotToReport() {
        getScenario().get().embed(getImageBytes(
                getDriver()),
                "image/png");
        log.info("Adicionado print.");
    }

    public static void logReport() {
        if (getScenario().get().isFailed()) {
            if (getDriver() != null) {
                addScreenshotToReport();
            } else {
                addLogToReport(getScenario().get().getStatus().toString());
            }
        }
    }

}
