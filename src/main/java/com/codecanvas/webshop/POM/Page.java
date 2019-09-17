package com.codecanvas.webshop.POM;

import com.codecanvas.webshop.DriverUtil;
import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public abstract class Page {

    protected WebDriver driver;

    Map<String, String> dotEnv = DotEnv.load();
    public final String USERNAME = dotEnv.get("USERNAME");
    public final String PASSWORD = dotEnv.get("PASSWORD");
    public final String BASE_URL = dotEnv.get("BASE_URL");
    public final String WEBDRIVER_PATH = dotEnv.get("WEBDRIVER_PATH");
    public final String WEBDRIVER_TYPE = dotEnv.get("WEBDRIVER_TYPE");


    public Page() {
        System.setProperty(WEBDRIVER_TYPE, WEBDRIVER_PATH);
    }

    public void goToPage (String path) {
        driver.get(BASE_URL + path);
    }

    public void login() {
        LoginPom lp = new LoginPom(DriverUtil.getDriver());
        lp.login(USERNAME, PASSWORD);
    }

}
