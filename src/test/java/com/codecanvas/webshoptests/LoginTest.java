package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private static LoginPom lp;

    @BeforeEach
    public void init() {
        lp = new LoginPom();
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

    @Test
    public void successfulLogin() {
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
    }

    @Test
    public void secondLogin() {
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
    }
}
