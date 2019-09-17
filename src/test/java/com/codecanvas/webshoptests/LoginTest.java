package com.codecanvas.webshoptests;

import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private static LoginPom lp;

    @BeforeAll
    public static void init() {
        lp = new LoginPom();
    }

    @AfterEach
    public void quit() {
        lp.quitDriver();
    }

    @Test
    public void successfulLogin() {
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
    }
}
