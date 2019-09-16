package com.codecanvas.webshop;

import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class Base {

    private static WebDriver driver;

    Map<String, String> dotEnv = DotEnv.load();
    public final String USERNAME = dotEnv.get("USERNAME");
    public final String PASSWORD = dotEnv.get("PASSWORD");
    public final String BASE_URL = dotEnv.get("BASE_URL");
    public final String WEBDRIVER_PATH = dotEnv.get("WEBDRIVER_PATH");


    public static WebDriver getDriver() {

        if (driver == null) driver = new ChromeDriver();
        return driver;
    }
}
