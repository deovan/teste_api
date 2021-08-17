package br.com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

import static br.com.driver.DriverManager.getDriver;
import static br.com.report.ReporterUtils.addScreenshotToReport;
import static org.testng.Assert.fail;

public class GeralPage {

    public WebDriver driver = getDriver();
    private final int TIME_WAIT = 60;
    private final By labelSnackbar = By.className("alert-success");
    private final By labelTextMensagemBox = By.cssSelector("span[data-growl=message]");

    public void validaMensagemBox(String mensagemBox) {
        try {
            expectText(labelTextMensagemBox, mensagemBox);
            String textoSnackBar = getText(labelTextMensagemBox);
            Assert.assertEquals(textoSnackBar, mensagemBox);
            addScreenshotToReport("Validando mensagem box = " + mensagemBox);
        } catch (Exception e) {
            addScreenshotToReport("Esperava a mensagem : " + mensagemBox);
        }
    }

    public void waitTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void expectElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }

    }

    public void expectElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }
    }

    public void expectElementVisibleWithoutHighlight(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }
    }

    public void expectElementNotVisible(By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(TIME_WAIT))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(AssertionError.class, NoSuchElementException.class);

            wait.until(driver -> ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }
    }

    public boolean expectText(By by, String value) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(TIME_WAIT))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(AssertionError.class, NoSuchElementException.class);

            return wait.until(driver -> getText(by).trim().toLowerCase().contains(value.trim().toLowerCase()));
        } catch (Exception e) {
            addScreenshotToReport("");
            String textActual = driver.findElement(by).getText();
            fail("Expect: " + value + " Contains: " + textActual);
            return false;
        }
    }

    public void clickWithJavaScript(By by) {
        try {
            WebElement element = driver.findElement(by);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }
    }

    public void sendKeys(By by, String value) {
        try {
            expectElementVisible(by);
            clickWithJavaScript(by);
            WebElement element = driver.findElement(by);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }
    }

    public void clearForce(By by) {
        expectElementVisibleWithoutHighlight(by);
        driver.findElement(by).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public String getText(By by) {
        try {
            return getWebElement(by).getText();
        } catch (StaleElementReferenceException ae) {
            return getText(by);
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
            return null;
        }
    }

    public WebElement getWebElement(By by) {
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
            return null;
        }
    }

    public void click(By by) {
        try {
            expectElementVisibleWithoutHighlight(by);
            expectElementClickable(by);
            WebElement element = driver.findElement(by);
            element.click();
        } catch (Exception e) {
            addScreenshotToReport("");
            fail(e.getMessage());
        }
    }

    public void validaMensagemSnackBar(String msg) {
        try {
            expectText(labelSnackbar, msg);
            addScreenshotToReport("Validando mensagem snackBar.");
        } catch (Exception e) {
            addScreenshotToReport("Esperava a mensagem : " + msg);
            fail("Esperava a mensagem : " + msg);
        }

    }

    public void selectOptionByText(By select, String text) {
        Select select1 = new Select(getWebElement(select));
        select1.selectByVisibleText(text);
    }

}
