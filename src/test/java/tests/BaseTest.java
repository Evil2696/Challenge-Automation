package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverManager;

public class BaseTest {

    protected String url = "https://www.saucedemo.com/";
    private static WebDriver driver;

    @BeforeClass
    @Parameters({"Browser"})
    public void commonSetUp(String browser) {

        driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(this.url);
        System.out.println("Ejecutando configuración común antes de cada prueba...");
    }


    @AfterClass
    public void commonTearDown() {

        DriverManager.quitDriver();
        System.out.println("Ejecutando limpieza común después de cada prueba...");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
