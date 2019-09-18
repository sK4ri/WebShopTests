package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest {

    private static HomePom hp;

    @BeforeEach
    public void init() {
        hp = new HomePom();
        LoginPom lp = new LoginPom();
        lp.goToPage();
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
    }

    @Test
    public void successfulLogout() {
        hp.logout();
        assertTrue(hp.logoutSuccessful());
    }

    @Test
    public void second() {
        hp.logout();
        assertTrue(hp.logoutSuccessful());
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

}
