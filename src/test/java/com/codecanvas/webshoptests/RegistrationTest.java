package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import com.codecanvas.webshop.POM.RegistrationPom;
import com.codecanvas.webshop.POM.UserPagePom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    private static RegistrationPom registrationPom;
    private static HomePom homePom;
    private static LoginPom loginPom;
    private static UserPagePom userPagePom;


    @BeforeAll
    public static void init() {
        registrationPom = new RegistrationPom();
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerdata.csv")
    public void successfulRegister(String username, String password, String password2) {

        registrationPom.setUsername(username);
        registrationPom.setPassword(password);
        registrationPom.setPassword2(password2);
        registrationPom.clickSubmit();
        homePom = new HomePom();
        homePom.clickLoginButton();
        loginPom = new LoginPom();
        loginPom.login(username, password);
        assertEquals("http://127.0.0.1:5000/user_page/" + username, homePom.getLoggedInUsername());
    }
}
