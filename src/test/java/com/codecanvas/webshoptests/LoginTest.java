package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private static LoginPom lp;
    private static HomePom hp;

    @BeforeEach
    public void init() {
        lp = new LoginPom();
        hp = new HomePom();
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

    @Test
    public void successfulLogin() {
        lp.goToPage();
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
        assertTrue(hp.loginSuccessul(lp.SELENIUM_USERNAME));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logindata.csv")
    public void unsuccessfulLogin(String username, String password) {
        lp.goToPage();
        lp.login(username, password);
        assertTrue(lp.failedLoginConfirmation());
    }

}
