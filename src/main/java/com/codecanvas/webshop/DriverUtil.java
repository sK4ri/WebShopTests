package com.codecanvas.webshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) driver = new ChromeDriver();
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

}
