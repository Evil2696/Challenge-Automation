package utils;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import tests.BaseTest;

public class TimeHelper {

    static WebDriver driver = BaseTest.getDriver();

    public static void waitUntilByVisible(WebElement elemento, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }
}
