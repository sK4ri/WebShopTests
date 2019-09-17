package com.codecanvas.webshop.POM;

import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public abstract class Page {

    static WebDriver driver;

    Map<String, String> dotEnv = DotEnv.load();
    public final String SELENIUM_USERNAME = dotEnv.get("SELENIUM_USERNAME");
    public final String SELENIUM_PASSWORD = dotEnv.get("SELENIUM_PASSWORD");
    public final String BASE_URL = dotEnv.get("BASE_URL");
    public final String WEBDRIVER_PATH = dotEnv.get("WEBDRIVER_PATH");
    public final String WEBDRIVER_TYPE = dotEnv.get("WEBDRIVER_TYPE");


    public Page() {
        if (driver == null) driver = new ChromeDriver();
        System.setProperty(WEBDRIVER_TYPE, WEBDRIVER_PATH);
    }

    public void goToPage (String path) {
        driver.get(BASE_URL + path);
    }

    public void login() {
        LoginPom lp = new LoginPom();
        lp.login(SELENIUM_USERNAME, SELENIUM_PASSWORD);
    }

    public void quitDriver() {
        driver.quit();
    }
}
