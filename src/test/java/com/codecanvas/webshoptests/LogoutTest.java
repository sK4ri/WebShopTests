package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.HomePom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest {

    private static HomePom hp;

    @BeforeAll
    public static void init() {
        hp = new HomePom();
        hp.login();
    }

    @Test
    public void successfulLogout() {
        hp.logout();
        assertTrue(hp.logoutSuccessful());
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

}
