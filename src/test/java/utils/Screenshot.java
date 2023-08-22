package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import java.io.File;
import java.io.IOException;

public class Screenshot implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver= BaseTest.getDriver();
        captureScreenshot(driver, result.getName());
    }
    private void captureScreenshot(WebDriver driver, String testName) {
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "src\\test\\java\\screenshots\\" + testName + ".png";
            try {
                org.apache.commons.io.FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Captura de pantalla guardada: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

