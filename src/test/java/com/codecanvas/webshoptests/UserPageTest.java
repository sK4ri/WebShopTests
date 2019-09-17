package com.codecanvas.webshoptests;

import com.codecanvas.webshop.POM.UserPagePom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserPageTest {

    UserPagePom userPage = new UserPagePom("admin1");

    @Test
    void BrowseUserPage() {
        assertTrue(userPage.validateUserPage());
    }
}
